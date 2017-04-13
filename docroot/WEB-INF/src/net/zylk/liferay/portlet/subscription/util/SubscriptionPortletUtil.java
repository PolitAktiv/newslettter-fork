package net.zylk.liferay.portlet.subscription.util;

import java.util.List;

import net.zylk.liferay.portal.model.CoreConstants;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.util.PortletKeys;

public class SubscriptionPortletUtil {

	public static Log _log = LogFactoryUtil.getLog(SubscriptionPortletUtil.class);
	
	
	public static Layout getPortletLayout(long companyId, long groupId) throws SystemException, PortalException {
		
		String portletId = CoreConstants.PORTLET_ID_SUBSCRIPTION;
		int ownerType = PortletKeys.PREFS_OWNER_TYPE_LAYOUT;
		long ownerId = 0;
		
		List<PortletPreferences> portletPreferencesList = PortletPreferencesLocalServiceUtil.getPortletPreferences(companyId,
				groupId, ownerId, ownerType, portletId, false);
		
		if (portletPreferencesList == null || portletPreferencesList.size() == 0) {
			// si no se encuentra en la publica buscamos en la privada
			portletPreferencesList = PortletPreferencesLocalServiceUtil.getPortletPreferences(companyId,
					groupId, ownerId, ownerType, portletId, true);
		}
		
		if (portletPreferencesList != null && portletPreferencesList.size() > 0) {
			
			// obtenemos el primero
			PortletPreferences portletPreferences = portletPreferencesList.get(0);
			Layout layout = LayoutLocalServiceUtil.getLayout(portletPreferences.getPlid());
			
			return layout;
			
		} else {
			
			throw new PortalException("There is not a subscription portlet in any page in this comunity");	
		}
		
	}
	
}




