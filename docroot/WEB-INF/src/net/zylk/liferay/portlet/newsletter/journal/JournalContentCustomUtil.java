package net.zylk.liferay.portlet.newsletter.journal;

import java.util.List;
import java.util.Map;

import net.zylk.liferay.portal.impl.JournalUtil;
import net.zylk.liferay.portal.impl.PropsValues;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.kernel.xml.XPath;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.dynamicdatamapping.NoSuchTemplateException;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.model.DDMTemplate;
import com.liferay.portlet.dynamicdatamapping.service.persistence.DDMTemplateUtil;
import com.liferay.portlet.dynamicdatamapping.util.DDMXMLUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

/**
 * Codigo equivalente a JournalArticleLocalServiceImpl - getArticleDisplay()
 * 
 * En vez de un JournalArticleDisplay se devuelve un String con el contenido, ya que la clase JournalArticleDisplayImpl no esta
 * accesible (y realmente solo nos hace falta el content).
 * 
 * Lo ideal seria replicar tambien la logica que hay en JournalContentImpl - getContent(). Pero para eso es necesario un objeto 
 * JournalArticleDisplay. En cualquier caso es poca logica, y no parece relevante en este caso.
 * 
 * Y ademas creo que usar directamente el JournalArticleLocalServiceUtil es correcto tambien.
 * 
 */
public class JournalContentCustomUtil {
	
	private static Log _log = LogFactoryUtil.getLog(JournalContentCustomUtil.class);
	
		
	public static String getArticleContent(long groupId, String articleId, String viewMode, String ddmTemplateKey, String languageId,
			ThemeDisplay themeDisplay, Map<String, String> extraTokens) throws PortalException, SystemException {
		
		JournalArticle article = JournalArticleLocalServiceUtil.getArticle(groupId, articleId);
		
		return getArticleDisplay(article, ddmTemplateKey, viewMode, languageId, 1, null, themeDisplay, extraTokens);
	}
	
	
	private static String getArticleDisplay(JournalArticle article, String ddmTemplateKey, String viewMode, String languageId,
			int page, String xmlRequest, ThemeDisplay themeDisplay, Map<String, String> extraTokens) throws PortalException, SystemException {

			String content = null;

			if (page < 1) {
				page = 1;
			}

			int numberOfPages = 1;
			boolean paginate = false;
			boolean pageFlow = false;

			boolean cacheable = true;

			if (Validator.isNull(xmlRequest)) {
				xmlRequest = "<request />";
			}

			Map<String, String> tokens = JournalUtil.getTokens(
				article.getGroupId(), themeDisplay, xmlRequest);
			
			// MOD: se incluyen los custom tokens
			for (String key : extraTokens.keySet()) {
				tokens.put(key, extraTokens.get(key));
			}
			//

			if ((themeDisplay == null) && xmlRequest.equals("<request />")) {
				tokens.put("company_id", String.valueOf(article.getCompanyId()));

				Group companyGroup = GroupLocalServiceUtil.getCompanyGroup(
					article.getCompanyId());

				tokens.put(
					"article_group_id", String.valueOf(article.getGroupId()));
				tokens.put(
					"company_group_id", String.valueOf(companyGroup.getGroupId()));

				// Deprecated tokens

				tokens.put("group_id", String.valueOf(article.getGroupId()));
			}

			tokens.put(
				"article_resource_pk",
				String.valueOf(article.getResourcePrimKey()));

			String defaultDDMTemplateKey = article.getTemplateId();

			if (article.isTemplateDriven()) {
				if (Validator.isNull(ddmTemplateKey)) {
					ddmTemplateKey = defaultDDMTemplateKey;
				}

				tokens.put("structure_id", article.getStructureId());
				tokens.put("template_id", ddmTemplateKey);
			}

			String xml = article.getContent();

			try {
				Document document = null;

				Element rootElement = null;

				if (article.isTemplateDriven()) {
					document = SAXReaderUtil.read(xml);

					rootElement = document.getRootElement();

					Document requestDocument = SAXReaderUtil.read(xmlRequest);

					List<Element> pages = rootElement.elements("page");

					if (!pages.isEmpty()) {
						pageFlow = true;

						String targetPage = requestDocument.valueOf(
							"/request/parameters/parameter[name='targetPage']/" +
								"value");

						Element pageElement = null;

						if (Validator.isNotNull(targetPage)) {
							targetPage = HtmlUtil.escapeXPathAttribute(targetPage);

							XPath xPathSelector = SAXReaderUtil.createXPath(
								"/root/page[@id = " + targetPage + "]");

							pageElement = (Element)xPathSelector.selectSingleNode(
								document);
						}

						if (pageElement != null) {
							document = SAXReaderUtil.createDocument(pageElement);

							rootElement = document.getRootElement();

							numberOfPages = pages.size();
						}
						else {
							if (page > pages.size()) {
								page = 1;
							}

							pageElement = pages.get(page - 1);

							document = SAXReaderUtil.createDocument(pageElement);

							rootElement = document.getRootElement();

							numberOfPages = pages.size();
							paginate = true;
						}
					}

					rootElement.add(requestDocument.getRootElement().createCopy());

					JournalUtil.addAllReservedEls(
						rootElement, tokens, article, languageId, themeDisplay);

					xml = DDMXMLUtil.formatXML(document);
				}
			}
			catch (DocumentException de) {
				throw new SystemException(de);
			}

			try {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"Transforming " + article.getArticleId() + " " +
							article.getVersion() + " " + languageId);
				}

				String script = null;
				String langType = null;

				if (article.isTemplateDriven()) {

					// Try with specified template first (in the current group and
					// the global group). If a template is not specified, use the
					// default one. If the specified template does not exist, use
					// the default one. If the default one does not exist, throw an
					// exception.

					DDMTemplate ddmTemplate = null;
					
					// MOD: ddmTemplatePersistence --> DDMTemplateUtil
					try {
						ddmTemplate = DDMTemplateUtil.findByG_C_T(
							PortalUtil.getSiteGroupId(article.getGroupId()),
							PortalUtil.getClassNameId(DDMStructure.class),
							ddmTemplateKey);
					}
					catch (NoSuchTemplateException nste1) {
						try {
							Group companyGroup = GroupLocalServiceUtil.getCompanyGroup(
								article.getCompanyId());

							ddmTemplate = DDMTemplateUtil.findByG_C_T(
								companyGroup.getGroupId(),
								PortalUtil.getClassNameId(DDMStructure.class),
								ddmTemplateKey);

							tokens.put(
								"company_group_id",
								String.valueOf(companyGroup.getGroupId()));
						}
						catch (NoSuchTemplateException nste2) {
							if (!defaultDDMTemplateKey.equals(ddmTemplateKey)) {
								ddmTemplate = DDMTemplateUtil.findByG_C_T(
									PortalUtil.getSiteGroupId(article.getGroupId()),
									PortalUtil.getClassNameId(DDMStructure.class),
									defaultDDMTemplateKey);
							}
							else {
								throw nste1;
							}
						}
					}

					script = ddmTemplate.getScript();
					langType = ddmTemplate.getLanguage();
					cacheable = ddmTemplate.isCacheable();
				}

				content = JournalUtil.transform(
					themeDisplay, tokens, viewMode, languageId, xml, script,
					langType);

				if (!pageFlow) {
					String[] pieces = StringUtil.split(
						content, PropsValues.JOURNAL_ARTICLE_TOKEN_PAGE_BREAK);

					if (pieces.length > 1) {
						if (page > pieces.length) {
							page = 1;
						}

						content = pieces[page - 1];
						numberOfPages = pieces.length;
						paginate = true;
					}
				}
			}
			catch (Exception e) {
				throw new SystemException(e);
			}

			// En vez de devolver un JournalArticleDisplay se devuelve directamente el contenido (ya que la clase
			// JournalArticleDisplayImpl no esta accesible).
			return content;
		}
	 
	 
}