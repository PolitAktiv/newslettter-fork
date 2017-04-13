package net.zylk.liferay.portal.util;

import com.liferay.util.portlet.PortletProps;

public class CoreProps {

	public static final String KEY_PORTAL_URL_DEFAULT = "zn.portal.url.default";
	
	public static final String KEY_EMAIL_SYSTEM_SESSION_HANDLER_ENABLE = "zn.email.system.session.handler.enable";
	public static final String KEY_EMAIL_SYSTEM_SESSION_EMAIL_LIMIT = "zn.email.system.session.email.limit";
	public static final String KEY_EMAIL_SYSTEM_SESSION_WAIT_TIME = "zn.email.system.session.wait.time";
	
	public static final String KEY_SCHEDULER_SEND_TIME = "zn.scheduler.send.time";
	
	public static final String KEY_IMPORT_DEFAULT_RESOURCES_ENABLE = "zn.import.default.resources.enable";
	
	
	public static String get(String key) {
		
		// TODO carga por jerarquia? buscar primero en el portal-ext, y sino existe pillarlo del portlet. De esta forma al
		// redesplegar no se restaura la config.
		
		return PortletProps.get(key);
	}

}
