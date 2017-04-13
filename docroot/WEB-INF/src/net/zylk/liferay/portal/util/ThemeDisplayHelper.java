package net.zylk.liferay.portal.util;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.TimeZone;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.zylk.liferay.portal.service.impl.NewsletterLocalServiceImpl;
import net.zylk.liferay.portlet.subscription.util.SubscriptionPortletUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mobile.device.Device;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.staging.StagingUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.SessionParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Account;
import com.liferay.portal.model.ColorScheme;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.Theme;
import com.liferay.portal.model.ThemeSetting;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.mobiledevicerules.model.MDRRuleGroupInstance;


public class ThemeDisplayHelper  {
	
	private static final Log _log = LogFactoryUtil.getLog(ThemeDisplayHelper.class);
	
	
	/**
	 * 
	 * Pruebas para generar ThemeDisplay desde la request de los Servlets (delegate).
	 * 
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public static ThemeDisplay create(HttpServletRequest request) throws Exception {
		
		ThemeDisplay themeDisplay = new ThemeDisplay();

		HttpSession session = request.getSession();

		// Company

		Company company = PortalUtil.getCompany(request);

		long companyId = company.getCompanyId();

		// CDN host

		String cdnHost = PortalUtil.getCDNHost(request);

		String dynamicResourcesCDNHost = StringPool.BLANK;

		boolean cdnDynamicResourceEnabled =
			PortalUtil.isCDNDynamicResourcesEnabled(request);

		if (cdnDynamicResourceEnabled) {
			dynamicResourcesCDNHost = cdnHost;
		}

		// Portal URL

		String portalURL = PortalUtil.getPortalURL(request);

		// Paths

		String contextPath = PortalUtil.getPathContext();
		String friendlyURLPrivateGroupPath =
			PortalUtil.getPathFriendlyURLPrivateGroup();
		String friendlyURLPrivateUserPath =
			PortalUtil.getPathFriendlyURLPrivateUser();
		String friendlyURLPublicPath = PortalUtil.getPathFriendlyURLPublic();
		String imagePath = dynamicResourcesCDNHost.concat(
			PortalUtil.getPathImage());
		String mainPath = PortalUtil.getPathMain();

		String i18nPath = (String)request.getAttribute("I18N_PATH");

		if (Validator.isNotNull(i18nPath)) {
			if (Validator.isNotNull(contextPath)) {
				String i18nContextPath = contextPath.concat(i18nPath);

				friendlyURLPrivateGroupPath = StringUtil.replaceFirst(
					friendlyURLPrivateGroupPath, contextPath, i18nContextPath);
				friendlyURLPrivateUserPath = StringUtil.replaceFirst(
					friendlyURLPrivateUserPath, contextPath, i18nContextPath);
				friendlyURLPublicPath = StringUtil.replaceFirst(
					friendlyURLPublicPath, contextPath, i18nContextPath);
				mainPath = StringUtil.replaceFirst(
					mainPath, contextPath, i18nContextPath);
			}
			else {
				friendlyURLPrivateGroupPath = i18nPath.concat(
					friendlyURLPrivateGroupPath);
				friendlyURLPrivateUserPath = i18nPath.concat(
					friendlyURLPrivateUserPath);
				friendlyURLPublicPath = i18nPath.concat(friendlyURLPublicPath);
				mainPath = i18nPath.concat(mainPath);
			}
		}

		
		// User

		User user = null;


		boolean signedIn = false;

		if (user == null) {
			user = company.getDefaultUser();
		}

		User realUser = user;

		Long realUserId = (Long)session.getAttribute(WebKeys.USER_ID);

		if (realUserId != null) {
			if (user.getUserId() != realUserId.longValue()) {
				realUser = UserLocalServiceUtil.getUserById(
					realUserId.longValue());
			}
		}

		String doAsUserId = ParamUtil.getString(request, "doAsUserId");
		String doAsUserLanguageId = ParamUtil.getString(
			request, "doAsUserLanguageId");
		long doAsGroupId = ParamUtil.getLong(request, "doAsGroupId");

		long refererPlid = ParamUtil.getLong(request, "refererPlid");

		if (LayoutLocalServiceUtil.fetchLayout(refererPlid) == null) {
			refererPlid = 0;
		}

		String controlPanelCategory = ParamUtil.getString(
			request, "controlPanelCategory");

		// Permission checker

		PermissionChecker permissionChecker =
			PermissionCheckerFactoryUtil.create(user);

		PermissionThreadLocal.setPermissionChecker(permissionChecker);

		// Locale

		Locale locale = (Locale)session.getAttribute("org.apache.struts.action.LOCALE");

		if (Validator.isNotNull(doAsUserLanguageId)) {
			locale = LocaleUtil.fromLanguageId(doAsUserLanguageId);
		}

		String i18nLanguageId = (String)request.getAttribute("I18N_LANGUAGE_ID");

		boolean hasCustomizeLayoutPermission = false;
		boolean hasUpdateLayoutPermission = false;

		boolean customizedView = SessionParamUtil.getBoolean(
			request, "customized_view", true);

		

		// Scope

		long scopeGroupId = PortalUtil.getScopeGroupId(request);

		if ((scopeGroupId <= 0) && (doAsGroupId > 0)) {
			scopeGroupId = doAsGroupId;
		}

		long parentGroupId = PortalUtil.getParentGroupId(scopeGroupId);




		themeDisplay.setCDNHost(cdnHost);
		themeDisplay.setCDNDynamicResourcesHost(dynamicResourcesCDNHost);
		themeDisplay.setPortalURL(portalURL);
		themeDisplay.setCompany(company);
		themeDisplay.setUser(user);
		themeDisplay.setRealUser(realUser);
		themeDisplay.setDoAsUserId(doAsUserId);
		themeDisplay.setDoAsUserLanguageId(doAsUserLanguageId);
		themeDisplay.setDoAsGroupId(doAsGroupId);
		themeDisplay.setRefererPlid(refererPlid);
		themeDisplay.setControlPanelCategory(controlPanelCategory);
//		themeDisplay.setLayoutSet(layoutSet);
//		themeDisplay.setLayout(layout);
//		themeDisplay.setPlid(plid);
		themeDisplay.setScopeGroupId(scopeGroupId);
		themeDisplay.setParentGroupId(parentGroupId);
		themeDisplay.setSignedIn(signedIn);
		themeDisplay.setPermissionChecker(permissionChecker);
		themeDisplay.setLocale(locale);
		themeDisplay.setLanguageId(LocaleUtil.toLanguageId(locale));
		themeDisplay.setI18nLanguageId(i18nLanguageId);
		themeDisplay.setI18nPath(i18nPath);
//		themeDisplay.setTimeZone(timeZone);
		themeDisplay.setServerName(request.getServerName());
		themeDisplay.setServerPort(request.getServerPort());
		themeDisplay.setSecure(request.isSecure());
		themeDisplay.setStateExclusive(LiferayWindowState.isExclusive(request));
		themeDisplay.setStateMaximized(LiferayWindowState.isMaximized(request));
		themeDisplay.setStatePopUp(LiferayWindowState.isPopUp(request));
		
		
		
		themeDisplay.setPathContext(contextPath);
		
		themeDisplay.setPathFriendlyURLPrivateGroup(
			friendlyURLPrivateGroupPath);
		themeDisplay.setPathFriendlyURLPrivateUser(friendlyURLPrivateUserPath);
		themeDisplay.setPathFriendlyURLPublic(friendlyURLPublicPath);
		themeDisplay.setPathImage(imagePath);
		themeDisplay.setPathMain(mainPath);


		return themeDisplay;
	}
	
	
	/**
	 * 
	 * Para el procesado de la newsletter
	 * 
	 * @param companyId
	 * @param groupId
	 * @param languageId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static ThemeDisplay create(long companyId, long groupId, String languageId) throws PortalException, SystemException {
		
		Company company = CompanyLocalServiceUtil.getCompany(companyId);
		Locale locale = LocaleUtil.fromLanguageId(languageId);
		User user = UserLocalServiceUtil.getDefaultUser(companyId);
		Layout layout = SubscriptionPortletUtil.getPortletLayout(companyId, groupId);
		
		
		ThemeDisplay themeDisplay = new ThemeDisplay();
		themeDisplay.setCompany(company);
		themeDisplay.setUser(user);
		themeDisplay.setRealUser(user);
		themeDisplay.setLayoutSet(layout.getLayoutSet());
		themeDisplay.setLayout(layout);
		themeDisplay.setPlid(layout.getPlid());
		
		themeDisplay.setScopeGroupId(groupId);
		themeDisplay.setSignedIn(false);
		themeDisplay.setLocale(locale);
		themeDisplay.setLanguageId(languageId);
		
		return themeDisplay;
	}
	
	
	public static void print(ThemeDisplay themeDisplay) throws PortalException, SystemException {
		
		_log.info("ThemeDisplay");
		_log.info("getAccount: " + themeDisplay.getAccount());
		_log.info("getCDNDynamicResourcesHost: " + themeDisplay.getCDNDynamicResourcesHost());
		_log.info("getCDNHost: " + themeDisplay.getCDNHost());
//		_log.info("getColorScheme: " + themeDisplay.getColorScheme());
//		_log.info("getColorSchemeId: " + themeDisplay.getColorSchemeId());
		_log.info("getCompany: " + themeDisplay.getCompany());
		_log.info("getCompanyGroupId: " + themeDisplay.getCompanyGroupId());
		_log.info("getCompanyId: " + themeDisplay.getCompanyId());
		_log.info("getCompanyLogo: " + themeDisplay.getCompanyLogo());
		_log.info("getCompanyLogoHeight: " + themeDisplay.getCompanyLogoHeight());
		_log.info("getCompanyLogoWidth: " + themeDisplay.getCompanyLogoWidth());
		_log.info("getContact: " + themeDisplay.getContact());
		_log.info("getControlPanelCategory: " + themeDisplay.getControlPanelCategory());
		_log.info("getDefaultUser: " + themeDisplay.getDefaultUser());		
		_log.info("getDefaultUserId: " + themeDisplay.getDefaultUserId());
		_log.info("getDevice: " + themeDisplay.getDevice());
		_log.info("getDoAsGroupId: " + themeDisplay.getDoAsGroupId());
		_log.info("getDoAsUserId: " + themeDisplay.getDoAsUserId());
		_log.info("getDoAsUserLanguageId: " + themeDisplay.getDoAsUserLanguageId());
		_log.info("getFacebookCanvasPageURL: " + themeDisplay.getFacebookCanvasPageURL());
		_log.info("getI18nLanguageId: " + themeDisplay.getI18nLanguageId());
		_log.info("getI18nPath: " + themeDisplay.getI18nPath());
		_log.info("getLanguageId: " + themeDisplay.getLanguageId());
		_log.info("getLayout: " + themeDisplay.getLayout());
		_log.info("getLayouts: " + themeDisplay.getLayouts());
		_log.info("getLayoutSet: " + themeDisplay.getLayoutSet());
		_log.info("getLayoutSetLogo: " + themeDisplay.getLayoutSetLogo());
		_log.info("getLayoutTypePortlet: " + themeDisplay.getLayoutTypePortlet());
		_log.info("getLifecycle: " + themeDisplay.getLifecycle());
		_log.info("getLocale: " + themeDisplay.getLocale());
		_log.info("getMDRRuleGroupInstance: " + themeDisplay.getMDRRuleGroupInstance());
		_log.info("getParentGroup: " + themeDisplay.getParentGroup());
		_log.info("getParentGroupId: " + themeDisplay.getParentGroupId());
		_log.info("getParentGroupName: " + themeDisplay.getParentGroupName());
		_log.info("getPathApplet: " + themeDisplay.getPathApplet());
		_log.info("getPathCms: " + themeDisplay.getPathCms());
		_log.info("getPathColorSchemeImages: " + themeDisplay.getPathColorSchemeImages());
		_log.info("getPathContext: " + themeDisplay.getPathContext());
		_log.info("getPathFlash: " + themeDisplay.getPathFlash());
		_log.info("getPathFriendlyURLPrivateGroup: " + themeDisplay.getPathFriendlyURLPrivateGroup());
		_log.info("getPathFriendlyURLPrivateUser: " + themeDisplay.getPathFriendlyURLPrivateUser());
		_log.info("getPathFriendlyURLPublic: " + themeDisplay.getPathFriendlyURLPublic());
		_log.info("getPathImage: " + themeDisplay.getPathImage());
		_log.info("getPathJavaScript: " + themeDisplay.getPathJavaScript());
		_log.info("getPathMain: " + themeDisplay.getPathMain());
		_log.info("getPathSound: " + themeDisplay.getPathSound());
		_log.info("getPathThemeCss: " + themeDisplay.getPathThemeCss());
		/**
		 * @deprecated Use <code>getPathThemeImages</code>.
		 */
		_log.info("getPathThemeImage: " + themeDisplay.getPathThemeImage());
		_log.info("getPathThemeImages: " + themeDisplay.getPathThemeImages());
		_log.info("getPathThemeJavaScript: " + themeDisplay.getPathThemeJavaScript());
		_log.info("getPathThemeRoot: " + themeDisplay.getPathThemeRoot());
		_log.info("getPathThemeTemplates: " + themeDisplay.getPathThemeTemplates());
		_log.info("getPermissionChecker: " + themeDisplay.getPermissionChecker());
		_log.info("getPlid: " + themeDisplay.getPlid());
		_log.info("getPortalURL: " + themeDisplay.getPortalURL());
		_log.info("getPortletDisplay: " + themeDisplay.getPortletDisplay());
		/**
		 * @deprecated Use <code>getScopeGroupId</code>.
		 */
		_log.info("getPortletGroupId: " + themeDisplay.getPortletGroupId());
		_log.info("getRealCompanyLogo: " + themeDisplay.getRealCompanyLogo());
		_log.info("getRealCompanyLogoHeight: " +themeDisplay.getRealCompanyLogoHeight());
		_log.info("getRealCompanyLogoWidth: " +themeDisplay.getRealCompanyLogoWidth());
		_log.info("getRealUser: " + themeDisplay.getRealUser());
		_log.info("getRealUserId: " + themeDisplay.getRealUserId());
		_log.info("getRefererPlid: " + themeDisplay.getRefererPlid());
		_log.info("getScopeGroup: " + themeDisplay.getScopeGroup());
		_log.info("getScopeGroupId: " + themeDisplay.getScopeGroupId());
		_log.info("getScopeGroupIdOrLiveGroupId: " + themeDisplay.getScopeGroupIdOrLiveGroupId());		
		_log.info("getScopeGroupName: " + themeDisplay.getScopeGroupName());
		_log.info("getScopeLayout: " + themeDisplay.getScopeLayout());
		_log.info("getServerName: " + themeDisplay.getServerName());
		_log.info("getServerPort: " +themeDisplay.getServerPort());
		_log.info("getSessionId: " + themeDisplay.getSessionId());
		_log.info("getTheme: " + themeDisplay.getTheme());
//		_log.info("getThemeId: " + themeDisplay.getThemeId());
//		_log.info("getThemeSetting: " + themeDisplay.getThemeSetting(String key));		
//		_log.info("getThemeSettings: " + themeDisplay.getThemeSettings());
		_log.info("getTilesContent: " + themeDisplay.getTilesContent());
		_log.info("getTilesTitle: " + themeDisplay.getTilesTitle());
		_log.info("getTimeZone: " + themeDisplay.getTimeZone());
		_log.info("getUnfilteredLayouts: " + themeDisplay.getUnfilteredLayouts());
		_log.info("getURLAddContent: " + themeDisplay.getURLAddContent());
		_log.info("getURLControlPanel: " + themeDisplay.getURLControlPanel());
		_log.info("getURLCurrent: " + themeDisplay.getURLCurrent());
		_log.info("getURLHome: " + themeDisplay.getURLHome());
		_log.info("getURLLayoutTemplates: " + themeDisplay.getURLLayoutTemplates());
		_log.info("getURLManageSiteMemberships: " + themeDisplay.getURLManageSiteMemberships());
		_log.info("getURLMyAccount: " + themeDisplay.getURLMyAccount());
		_log.info("getURLPageSettings: " + themeDisplay.getURLPageSettings());
		_log.info("getURLPortal: " + themeDisplay.getURLPortal());
		_log.info("getURLPublishToLive: " + themeDisplay.getURLPublishToLive());
		_log.info("getURLSignIn: " + themeDisplay.getURLSignIn());
		_log.info("getURLSignOut: " + themeDisplay.getURLSignOut());
		_log.info("getURLSiteContent: " + themeDisplay.getURLSiteContent());
		_log.info("getURLSiteMapSettings: " + themeDisplay.getURLSiteMapSettings());
		_log.info("getURLSiteSettings: " + themeDisplay.getURLSiteSettings());
		_log.info("getURLUpdateManager: " + themeDisplay.getURLUpdateManager());
		_log.info("getUser: " + themeDisplay.getUser());
		_log.info("getUserId: " + themeDisplay.getUserId());
		_log.info("isAddSessionIdToURL: " + themeDisplay.isAddSessionIdToURL());
		_log.info("isAjax: " + themeDisplay.isAjax());
		_log.info("isFacebook: " + themeDisplay.isFacebook());
		_log.info("isFreeformLayout: " + themeDisplay.isFreeformLayout());
		_log.info("isI18n: " + themeDisplay.isI18n());
		_log.info("isImpersonated: " + themeDisplay.isImpersonated());
//		_log.info("isIncludedJs: " + themeDisplay.isIncludedJs(String js));
		_log.info("isIncludePortletCssJs: " + themeDisplay.isIncludePortletCssJs());
//		_log.info("isIncludeServiceJs: " + themeDisplay.isIncludeServiceJs());
		_log.info("isIsolated: " + themeDisplay.isIsolated());
		_log.info("isLifecycleAction: " + themeDisplay.isLifecycleAction());
		_log.info("isLifecycleRender: " + themeDisplay.isLifecycleRender());
		_log.info("isLifecycleResource: " + themeDisplay.isLifecycleResource());
		_log.info("isSecure: " + themeDisplay.isSecure());
		_log.info("isShowAddContentIcon: " + themeDisplay.isShowAddContentIcon());
		_log.info("isShowAddContentIconPermission: " + themeDisplay.isShowAddContentIconPermission());
		_log.info("isShowControlPanelIcon: " + themeDisplay.isShowControlPanelIcon());
		_log.info("isShowHomeIcon: " + themeDisplay.isShowHomeIcon());
		_log.info("isShowLayoutTemplatesIcon: " + themeDisplay.isShowLayoutTemplatesIcon());
		_log.info("isShowManageSiteMembershipsIcon: " + themeDisplay.isShowManageSiteMembershipsIcon());
		_log.info("isShowMyAccountIcon: " + themeDisplay.isShowMyAccountIcon());
		_log.info("isShowPageCustomizationIcon: " + themeDisplay.isShowPageCustomizationIcon());
		_log.info("isShowPageSettingsIcon: " + themeDisplay.isShowPageSettingsIcon());
		_log.info("isShowPortalIcon: " + themeDisplay.isShowPortalIcon());
		_log.info("isShowSignInIcon: " + themeDisplay.isShowSignInIcon());
		_log.info("isShowSignOutIcon: " + themeDisplay.isShowSignOutIcon());
		_log.info("isShowSiteContentIcon: " + themeDisplay.isShowSiteContentIcon());
		_log.info("isShowSiteMapSettingsIcon: " + themeDisplay.isShowSiteMapSettingsIcon());
		_log.info("isShowSiteSettingsIcon: " + themeDisplay.isShowSiteSettingsIcon());
		_log.info("isShowStagingIcon: " + themeDisplay.isShowStagingIcon());
		_log.info("isSignedIn: " + themeDisplay.isSignedIn());
		_log.info("isStateExclusive: " + themeDisplay.isStateExclusive());
		_log.info("isStateMaximized: " + themeDisplay.isStateMaximized());
		_log.info("isStatePopUp: " + themeDisplay.isStatePopUp());
		_log.info("isThemeCssFastLoad: " + themeDisplay.isThemeCssFastLoad());
		_log.info("isThemeImagesFastLoad: " + themeDisplay.isThemeImagesFastLoad());
		_log.info("isThemeJsBarebone: " + themeDisplay.isThemeJsBarebone());
		_log.info("isThemeJsFastLoad: " + themeDisplay.isThemeJsFastLoad());
		_log.info("isTilesSelectable: " + themeDisplay.isTilesSelectable());
//		_log.info("isWapTheme: " + themeDisplay.isWapTheme());
		_log.info("isWidget: " + themeDisplay.isWidget());
		
	
		// copy
//		public Account themeDisplay.getAccount()
//		public String themeDisplay.getCDNDynamicResourcesHost()
//		public String themeDisplay.getCDNHost()
//		public ColorScheme themeDisplay.getColorScheme()
//		public String themeDisplay.getColorSchemeId()
//		public Company themeDisplay.getCompany()
//		public long themeDisplay.getCompanyGroupId()
//		public long themeDisplay.getCompanyId()
//		public String themeDisplay.getCompanyLogo()
//		public int themeDisplay.getCompanyLogoHeight()
//		public int themeDisplay.getCompanyLogoWidth()
//		public Contact themeDisplay.getContact()
//		public String themeDisplay.getControlPanelCategory()
//		public User themeDisplay.getDefaultUser()		
//		public long themeDisplay.getDefaultUserId()
//		public Device themeDisplay.getDevice()
//		public long themeDisplay.getDoAsGroupId()
//		public String themeDisplay.getDoAsUserId()
//		public String themeDisplay.getDoAsUserLanguageId()
//		public String themeDisplay.getFacebookCanvasPageURL()
//		public String themeDisplay.getI18nLanguageId()
//		public String themeDisplay.getI18nPath()
//		public String themeDisplay.getLanguageId()
//		public Layout themeDisplay.getLayout()
//		public List<Layout> themeDisplay.getLayouts()
//		public LayoutSet themeDisplay.getLayoutSet()
//		public String themeDisplay.getLayoutSetLogo()
//		public LayoutTypePortlet themeDisplay.getLayoutTypePortlet()
//		public String themeDisplay.getLifecycle()
//		public Locale themeDisplay.getLocale()
//		public MDRRuleGroupInstance themeDisplay.getMDRRuleGroupInstance()
//		public Group themeDisplay.getParentGroup()
//		public long themeDisplay.getParentGroupId()
//		public String themeDisplay.getParentGroupName()
//		public String themeDisplay.getPathApplet()
//		public String themeDisplay.getPathCms()
//		public String themeDisplay.getPathColorSchemeImages()
//		public String themeDisplay.getPathContext()
//		public String themeDisplay.getPathFlash()
//		public String themeDisplay.getPathFriendlyURLPrivateGroup()
//		public String themeDisplay.getPathFriendlyURLPrivateUser()
//		public String themeDisplay.getPathFriendlyURLPublic()
//		public String themeDisplay.getPathImage()
//		public String themeDisplay.getPathJavaScript()
//		public String themeDisplay.getPathMain()
//		public String themeDisplay.getPathSound()
//		public String themeDisplay.getPathThemeCss()
//		/**
//		 * @deprecated Use <code>getPathThemeImages</code>.
//		 */
//		public String themeDisplay.getPathThemeImage()
//		public String themeDisplay.getPathThemeImages()
//		public String themeDisplay.getPathThemeJavaScript()
//		public String themeDisplay.getPathThemeRoot()
//		public String themeDisplay.getPathThemeTemplates()
//		public PermissionChecker themeDisplay.getPermissionChecker()
//		public long themeDisplay.getPlid()
//		public String themeDisplay.getPortalURL()
//		public PortletDisplay themeDisplay.getPortletDisplay()
//		/**
//		 * @deprecated Use <code>getScopeGroupId</code>.
//		 */
//		public long themeDisplay.getPortletGroupId()
//		public String themeDisplay.getRealCompanyLogo()
//		public int themeDisplay.getRealCompanyLogoHeight()
//		public int themeDisplay.getRealCompanyLogoWidth()
//		public User themeDisplay.getRealUser()
//		public long themeDisplay.getRealUserId()
//		public long themeDisplay.getRefererPlid()
//		public Group themeDisplay.getScopeGroup()
//		public long themeDisplay.getScopeGroupId()
//		public long themeDisplay.getScopeGroupIdOrLiveGroupId()		
//		public String themeDisplay.getScopeGroupName()
//		public Layout themeDisplay.getScopeLayout()
//		public String themeDisplay.getServerName()
//		public int themeDisplay.getServerPort()
//		public String themeDisplay.getSessionId()
//		public Theme themeDisplay.getTheme()
//		public String themeDisplay.getThemeId()
//		public String themeDisplay.getThemeSetting(String key)
//		
//		public Properties themeDisplay.getThemeSettings()
//		public String themeDisplay.getTilesContent()
//		public String themeDisplay.getTilesTitle()
//		public TimeZone themeDisplay.getTimeZone()
//		public List<Layout> themeDisplay.getUnfilteredLayouts()
//		public String themeDisplay.getURLAddContent()
//		public String themeDisplay.getURLControlPanel()
//		public String themeDisplay.getURLCurrent()
//		public String themeDisplay.getURLHome()
//		public String themeDisplay.getURLLayoutTemplates()
//		public PortletURL themeDisplay.getURLManageSiteMemberships()
//		public PortletURL themeDisplay.getURLMyAccount()
//		public PortletURL themeDisplay.getURLPageSettings()
//		public String themeDisplay.getURLPortal()
//		public PortletURL themeDisplay.getURLPublishToLive()
//		public String themeDisplay.getURLSignIn()
//		public String themeDisplay.getURLSignOut()
//		public String themeDisplay.getURLSiteContent()
//		public PortletURL themeDisplay.getURLSiteMapSettings()
//		public PortletURL themeDisplay.getURLSiteSettings()
//		public PortletURL themeDisplay.getURLUpdateManager()
//		public User themeDisplay.getUser()
//		public long themeDisplay.getUserId()
//		public boolean themeDisplay.isAddSessionIdToURL()
//		public boolean themeDisplay.isAjax()
//		public boolean themeDisplay.isFacebook()
//		public boolean themeDisplay.isFreeformLayout()
//		public boolean themeDisplay.isI18n()
//		public boolean themeDisplay.isImpersonated()
//		public boolean themeDisplay.isIncludedJs(String js)
//
//		public boolean themeDisplay.isIncludePortletCssJs()
//		public boolean themeDisplay.isIncludeServiceJs()
//		public boolean themeDisplay.isIsolated()
//		public boolean themeDisplay.isLifecycleAction()
//		public boolean themeDisplay.isLifecycleRender()
//		public boolean themeDisplay.isLifecycleResource()
//		public boolean themeDisplay.isSecure()
//		public boolean themeDisplay.isShowAddContentIcon()
//		public boolean themeDisplay.isShowAddContentIconPermission()
//		public boolean themeDisplay.isShowControlPanelIcon()
//		public boolean themeDisplay.isShowHomeIcon()
//		public boolean themeDisplay.isShowLayoutTemplatesIcon()
//		public boolean themeDisplay.isShowManageSiteMembershipsIcon()
//		public boolean themeDisplay.isShowMyAccountIcon()
//		public boolean themeDisplay.isShowPageCustomizationIcon()
//		public boolean themeDisplay.isShowPageSettingsIcon()
//		public boolean themeDisplay.isShowPortalIcon()
//		public boolean themeDisplay.isShowSignInIcon()
//		public boolean themeDisplay.isShowSignOutIcon()
//		public boolean themeDisplay.isShowSiteContentIcon()
//		public boolean themeDisplay.isShowSiteMapSettingsIcon()
//		public boolean themeDisplay.isShowSiteSettingsIcon()
//		public boolean themeDisplay.isShowStagingIcon()
//		public boolean themeDisplay.isSignedIn()
//		public boolean themeDisplay.isStateExclusive()
//		public boolean themeDisplay.isStateMaximized()
//		public boolean themeDisplay.isStatePopUp()
//		public boolean themeDisplay.isThemeCssFastLoad()
//		public boolean themeDisplay.isThemeImagesFastLoad()
//		public boolean themeDisplay.isThemeJsBarebone()
//		public boolean themeDisplay.isThemeJsFastLoad()
//		public boolean themeDisplay.isTilesSelectable()
//		public boolean themeDisplay.isWapTheme()
//		public boolean themeDisplay.isWidget()
		
	}
	
}







