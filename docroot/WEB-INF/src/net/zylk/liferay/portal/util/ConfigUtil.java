package net.zylk.liferay.portal.util;

import javax.portlet.PortletPreferences;

import net.zylk.liferay.portal.model.CoreConstants;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.util.ContentUtil;
import com.liferay.util.portlet.PortletProps;

public class ConfigUtil {

	public static final String KEY_EMAIL_FROM_NAME = "emailFromName";
	public static final String KEY_EMAIL_FROM_ADDRESS = "emailFromAddress";
	public static final String KEY_PORTAL_BASE_URL = "portalBaseUrl";
	public static final String KEY_TEMPLATE_SUBSCRIPTION_SUBJECT = "templateSubscriptionSubject";
	public static final String KEY_TEMPLATE_SUBSCRIPTION_BODY = "templateSubscriptionBody";

	
	private static PortletPreferences getPortletPreferences(long companyId, long groupId) throws SystemException {

		long ownerId = groupId;
		int ownerType = PortletKeys.PREFS_OWNER_TYPE_GROUP;
		long plid = 0;
		String portletId = CoreConstants.PORTLET_ID_ADMIN;
		PortletPreferences preferences = PortletPreferencesLocalServiceUtil.getPreferences(companyId, ownerId, ownerType, plid,
				portletId);

		return preferences;
	}
	
	public static String getValue(String key, long companyId, long groupId) throws SystemException {

		PortletPreferences preferences = getPortletPreferences(companyId, groupId);
	
		String value = preferences.getValue(key, "");

		if (value == null || value.equals("")) {
			
			value = getDefaultValue(key, companyId, groupId);
		}

		return value;
	}
	
	public static String getDefaultValue(String key, long companyId, long groupId) throws SystemException {
		
		String value = "";
		
		if (key != null && key.equals(KEY_EMAIL_FROM_NAME)) {
			
			value = PrefsPropsUtil.getString(companyId, PropsKeys.ADMIN_EMAIL_FROM_NAME);
			
		} else if (key != null && key.equals(KEY_EMAIL_FROM_ADDRESS)) {
			
			value = PrefsPropsUtil.getString(companyId, PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
			
		} else if (key != null && key.equals(KEY_PORTAL_BASE_URL)) {
			
			value = CoreProps.get(CoreProps.KEY_PORTAL_URL_DEFAULT);
			
		} else if (key != null && key.equals(KEY_TEMPLATE_SUBSCRIPTION_SUBJECT)) {
			
			value = ContentUtil.get(CoreConstants.EMAIL_TEMPLATE_SUBSCRIPTION_SUBJECT);
			
		} else if (key != null && key.equals(KEY_TEMPLATE_SUBSCRIPTION_BODY)) {
			
			value = ContentUtil.get(CoreConstants.EMAIL_TEMPLATE_SUBSCRIPTION_BODY);
		}
		
		return value;
		
	}

}


