package net.zylk.liferay.portlet.newsletter.events;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import net.zylk.liferay.portal.impl.JournalFolderConstants;
import net.zylk.liferay.portal.impl.PropsValues;
import net.zylk.liferay.portal.model.NewsletterConstants;
import net.zylk.liferay.portal.util.CoreProps;

import org.apache.commons.io.IOUtils;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.dynamicdatamapping.NoSuchStructureException;
import com.liferay.portlet.dynamicdatamapping.NoSuchTemplateException;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructure;
import com.liferay.portlet.dynamicdatamapping.model.DDMStructureConstants;
import com.liferay.portlet.dynamicdatamapping.model.DDMTemplate;
import com.liferay.portlet.dynamicdatamapping.model.DDMTemplateConstants;
import com.liferay.portlet.dynamicdatamapping.service.DDMStructureLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.service.DDMTemplateLocalServiceUtil;
import com.liferay.portlet.journal.NoSuchArticleException;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleConstants;
import com.liferay.portlet.journal.model.JournalFolder;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalFolderLocalServiceUtil;



public class BasicEntitiesAction extends SimpleAction {

	private static Log _log = LogFactoryUtil.getLog(BasicEntitiesAction.class);
	
	public void run(String[] ids) throws ActionException {

		try {
			_log.info("executing newsletter startup event");
			
			long companyId = GetterUtil.getLong(ids[0]);
		
			boolean importDefaultResources = Boolean.valueOf(CoreProps.get(CoreProps.KEY_IMPORT_DEFAULT_RESOURCES_ENABLE));			
			if (importDefaultResources) {
				createJournalResources(companyId);
			}
			
		} catch (SystemException e) {
			_log.error(e);
		} catch (PortalException e) {
			_log.error(e);
		} catch (IOException e) {
			_log.error(e);
		}
	}
	
	
	private void createJournalResources(long companyId) throws SystemException, PortalException, IOException  {
		
		_log.info("checking newsletter default journal resources");
		
		Company company = CompanyLocalServiceUtil.getCompany(companyId);
		Locale locale = company.getLocale();
		
		_log.info("company.getLocale(): " + company.getLocale());
		_log.info("LocaleUtil.getDefault(): " + LocaleUtil.getDefault());
		_log.info("LocaleUtil.getSiteDefault(): " + LocaleUtil.getSiteDefault());
		
		
		long groupId = company.getGroupId(); // global groupId

		// user
		Role roleAdmin = RoleLocalServiceUtil.getRole(companyId, RoleConstants.ADMINISTRATOR);		
		List<User> userAdmins = UserLocalServiceUtil.getRoleUsers(roleAdmin.getRoleId());
		User userAdmin;
		if (userAdmins != null && userAdmins.size() > 0) {
			userAdmin = userAdmins.get(0);
		} else {
			throw new PortalException("no admin users");
		}
		long userId = userAdmin.getUserId();
		
		
		// JOURNAL FOLDER
		String name = "newsletters";
		JournalFolder journalFolder = createJournalFolder(name, companyId, groupId, userId);
		
		
		// ****************
		// BLOG - SUMMARY
		// ****************
		// structure
		String structureKey = "ZK-0001";
		Map<Locale, String> nameMap = new HashMap<Locale, String>();
		nameMap.put(locale, "Newsletter - Blog summary");
		String resourcePath = "/net/zylk/liferay/portlet/resources/journal/structures/blog.xml";
		
		DDMStructure dDMStructure = createJournalStructure(structureKey, nameMap, resourcePath, companyId, groupId, userId);
	
		// template
		String templateKey = "ZK-0001";
		long ddmStructureId = dDMStructure.getStructureId();
		nameMap = new HashMap<Locale, String>();
		nameMap.put(locale, "Newsletter - Blog summary");
		resourcePath = "/net/zylk/liferay/portlet/resources/journal/templates/blog.xml";
		
		DDMTemplate dDMTemplate = createJournalTemplate(templateKey, ddmStructureId, nameMap, resourcePath, companyId, groupId, userId);

		// journal
		String articleId = "ZK-0001";
		long folderId = journalFolder.getFolderId();
		Map<Locale, String> titleMap = new HashMap<Locale, String>();
		titleMap.put(locale, "Newsletter - Blog summary");
		String ddmStructureKey = dDMStructure.getStructureKey();
		String ddmTemplateKey = dDMTemplate.getTemplateKey();
		resourcePath = "/net/zylk/liferay/portlet/resources/journal/articles/blog.xml";
		
		createJournalContent(articleId, titleMap, folderId, ddmStructureKey, ddmTemplateKey, resourcePath, companyId, groupId, userId);
		
		
		// ****************
		// DARK - 1-2
		// ****************
		// structure
		structureKey = "ZK-0002";
		nameMap = new HashMap<Locale, String>();
		nameMap.put(locale, "Newsletter - Dark 1-2 columns");
		resourcePath = "/net/zylk/liferay/portlet/resources/journal/structures/dark-1-2.xml";
		
		dDMStructure = createJournalStructure(structureKey, nameMap, resourcePath, companyId, groupId, userId);
	
		// template
		templateKey = "ZK-0002";
		ddmStructureId = dDMStructure.getStructureId();
		nameMap = new HashMap<Locale, String>();
		nameMap.put(locale, "Newsletter - Dark 1-2 columns");
		resourcePath = "/net/zylk/liferay/portlet/resources/journal/templates/dark-1-2.xml";
		
		dDMTemplate = createJournalTemplate(templateKey, ddmStructureId, nameMap, resourcePath, companyId, groupId, userId);

		// journal
		articleId = "ZK-0002";
		folderId = journalFolder.getFolderId();
		titleMap = new HashMap<Locale, String>();
		titleMap.put(locale, "Newsletter - Dark 1-2 columns");
		ddmStructureKey = dDMStructure.getStructureKey();
		ddmTemplateKey = dDMTemplate.getTemplateKey();
		resourcePath = "/net/zylk/liferay/portlet/resources/journal/articles/dark-1-2.xml";
		
		createJournalContent(articleId, titleMap, folderId, ddmStructureKey, ddmTemplateKey, resourcePath, companyId, groupId, userId);
		
	}
	
	
	private DDMStructure createJournalStructure(String structureKey, Map<Locale, String> nameMap, String resourcePath, long companyId, long groupId, long userId)
			throws SystemException, PortalException, IOException {
		
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setCompanyId(companyId);
		serviceContext.setScopeGroupId(groupId);
		serviceContext.setUserId(userId);
	
		// STRUCTURES
		long classNameId = PortalUtil.getClassNameId(JournalArticle.class);
		boolean includeGlobalStructures = true;
		
		DDMStructure dDMStructure;
		try {
			dDMStructure = DDMStructureLocalServiceUtil.getStructure(groupId, classNameId, structureKey, includeGlobalStructures);
			
			_log.info("DDMStructure is already created, structureKey=" + dDMStructure.getStructureKey());
			
		} catch (NoSuchStructureException e) {
			
			InputStream is = BasicEntitiesAction.class.getResourceAsStream(resourcePath);
			StringWriter writer = new StringWriter();
			IOUtils.copy(is, writer, "UTF-8");
			String contentPre = writer.toString();
			contentPre = contentPre.replace("\"en_US\"", "\"" + LocaleUtil.getDefault().toString() + "\"");
			
			long parentStructureId = DDMStructureConstants.DEFAULT_PARENT_STRUCTURE_ID;
			Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
			String xsd = contentPre;
			String storageType = PropsValues.JOURNAL_ARTICLE_STORAGE_TYPE;
			int type = DDMStructureConstants.TYPE_DEFAULT;
			
			dDMStructure = DDMStructureLocalServiceUtil.addStructure(userId, groupId, parentStructureId, classNameId,
					structureKey, nameMap, descriptionMap, xsd, storageType, type, serviceContext);
			
			_log.info("DDMStructure created, structureKey=" + dDMStructure.getStructureKey());
		}
		
		return dDMStructure;
	}
	
	private DDMTemplate createJournalTemplate(String templateKey, long ddmStructureId, Map<Locale, String> nameMap, String resourcePath, long companyId, long groupId, long userId)
			throws SystemException, PortalException, IOException {
		
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setCompanyId(companyId);
		serviceContext.setScopeGroupId(groupId);
		serviceContext.setUserId(userId);
		
		// PLANTILLAS
		long classNameId = PortalUtil.getClassNameId(DDMStructure.class);
		boolean includeGlobalTemplates = true;
		
		DDMTemplate dDMTemplate;
		try {
			dDMTemplate = DDMTemplateLocalServiceUtil.getTemplate(groupId, classNameId, templateKey, includeGlobalTemplates);
			
			_log.info("DDMTemplate is already created, templateKey=" + dDMTemplate.getTemplateKey());
			
		} catch (NoSuchTemplateException e) {
			
			InputStream is = BasicEntitiesAction.class.getResourceAsStream(resourcePath);
			StringWriter writer = new StringWriter();
			IOUtils.copy(is, writer, "UTF-8");
		
			long classPK = ddmStructureId;
			Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
			String typeTemplate = DDMTemplateConstants.TEMPLATE_TYPE_DISPLAY;
			String mode = DDMTemplateConstants.TEMPLATE_MODE_CREATE; // TODO a null????
			String language = TemplateConstants.LANG_TYPE_VM;
			String script = writer.toString();
			boolean cacheable = false;
			boolean smallImage = false;
			String smallImageURL = null;
			File smallImageFile = null;
			
			dDMTemplate = DDMTemplateLocalServiceUtil.addTemplate(userId, groupId, classNameId, classPK, templateKey,
					nameMap, descriptionMap, typeTemplate, mode, language, script, cacheable, smallImage, smallImageURL, smallImageFile,
					serviceContext);
			
			_log.info("DDMTemplate created, templateKey=" + dDMTemplate.getTemplateKey());
		}
		
		return dDMTemplate;
	}
	
	
	private JournalFolder createJournalFolder(String name, long companyId, long groupId, long userId) throws SystemException,
			PortalException {
		
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setCompanyId(companyId);
		serviceContext.setScopeGroupId(groupId);
		serviceContext.setUserId(userId);
		
		List<JournalFolder> journalFolders = JournalFolderLocalServiceUtil.getFolders(groupId);
		
		JournalFolder journalFolder = null;
		for (JournalFolder jf : journalFolders) {
			if (jf.getName() != null && jf.getName().equals(name)) {
				journalFolder = jf;
				break;
			}
		}
		
		if (journalFolder == null) {
			long parentFolderId = JournalFolderConstants.DEFAULT_PARENT_FOLDER_ID;
			String description = "";
			journalFolder = JournalFolderLocalServiceUtil.addFolder(userId, groupId, parentFolderId, name, description, serviceContext);
			
			_log.info("JournalFolder created, name=" + journalFolder.getName());
			
		} else {
			_log.info("JournalFolder is already created, name=" + journalFolder.getName());
		}
		
		return journalFolder;
	}
	
	
	private JournalArticle createJournalContent(String articleId, Map<Locale, String> titleMap, long folderId, String ddmStructureKey,
			String ddmTemplateKey, String resourcePath, long companyId, long groupId, long userId) throws SystemException,
			PortalException, IOException {
		
		
		JournalArticle journalArticle;
		try {
			journalArticle = JournalArticleLocalServiceUtil.getArticle(groupId, articleId);
			
			_log.info("JournalArticle is already created, articleId=" + journalArticle.getArticleId());
		
		} catch (NoSuchArticleException e) {
			
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);
			serviceContext.setCompanyId(companyId);
			serviceContext.setScopeGroupId(groupId);
			serviceContext.setUserId(userId);
			String[] assetTagNames = {NewsletterConstants.JOURNAL_ARTICLE_TAG_NAME};
			serviceContext.setAssetTagNames(assetTagNames);
			
		
			InputStream is = BasicEntitiesAction.class.getResourceAsStream(resourcePath);
			StringWriter writer = new StringWriter();
			IOUtils.copy(is, writer, "UTF-8");
			String contentPre = writer.toString();
			contentPre = contentPre.replace("\"en_US\"", "\"" + LocaleUtil.getDefault().toString() + "\"");
			
			long classNameId = JournalArticleConstants.CLASSNAME_ID_DEFAULT;
			long classPK = 0;

			boolean autoArticleId = false;
			int version = 1;
			Map<Locale, String> descriptionMap = new HashMap<Locale, String>();
			String content = contentPre;
			String type = "general";
			String layoutUuid = null;
			Calendar calendar = CalendarFactoryUtil.getCalendar();
			int displayDateMonth = calendar.get(Calendar.MONTH);
			int displayDateDay = calendar.get(Calendar.DAY_OF_MONTH);
			int displayDateYear = calendar.get(Calendar.YEAR);
			int displayDateHour = calendar.get(Calendar.HOUR_OF_DAY);
			int displayDateMinute = calendar.get(Calendar.MINUTE);
			int expirationDateMonth = 0;
			int expirationDateDay = 0;
			int expirationDateYear = 0;
			int expirationDateHour = 0;
			int expirationDateMinute = 0;
			boolean neverExpire = true;
			int reviewDateMonth = 0;
			int reviewDateDay = 0;
			int reviewDateYear = 0;
			int reviewDateHour = 0;
			int reviewDateMinute = 0;
			boolean neverReview = true;
			boolean indexable = true;
			boolean smallImage = false;
			String smallImageURL = null;
			File smallImageFile = null;
			Map<String, byte[]>images = null;
			String articleURL = null;
			
			journalArticle = JournalArticleLocalServiceUtil.addArticle(userId, groupId, folderId, classNameId,
					classPK, articleId, autoArticleId, version, titleMap, descriptionMap, content, type, ddmStructureKey,
					ddmTemplateKey, layoutUuid, displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
					displayDateMinute, expirationDateMonth, expirationDateDay, expirationDateYear, expirationDateHour,
					expirationDateMinute, neverExpire, reviewDateMonth, reviewDateDay, reviewDateYear, reviewDateHour,
					reviewDateMinute, neverReview, indexable, smallImage, smallImageURL, smallImageFile, images, articleURL,
					serviceContext);

			_log.info("JournalArticle created, articleId=" + journalArticle.getArticleId());
		}
		
		return journalArticle;
		
	}
	
}

