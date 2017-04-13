package net.zylk.liferay.portal.model.util;

import java.util.Map;

import com.liferay.portal.kernel.json.JSON;


public class TokensData {
	
	// newsletter (pre-procesado)
	public static final String KEY_START_DATE_MS = "start_date_ms";
	public static final String KEY_FROM_DATE_MS = "from_date_ms";

	// subscriptor (post-procesado)
	public static final String KEY_SUBSCRIPTOR_NAME = "subscriptor_name";
	public static final String KEY_SUBSCRIPTOR_SURNAME = "subscriptor_surname";
	public static final String KEY_SUBSCRIPTOR_FULLNAME = "subscriptor_fullname";
	public static final String KEY_SUBSCRIPTOR_EMAIL = "subscriptor_email";
	
	public static final String KEY_UNSUBSCRIBE_URL = "unsubscribe_url";
	
	
	// ESPECIALES: las declaro aqui para que este centralizadas pero no son tokes de sustitucion
	public static final String KEY_CANCEL_MAILING = "cancel_mailing";
	
//	
//	
//	// especiales
//	public static final String KEY_CANCEL_MAILING = "cancel_mailing"; // para cancelar el envio de la newsletter
	
	
	private Map<String, String> tokens;

	@JSON
	public Map<String, String> getTokens() {
		return tokens;
	}

	@JSON
	public void setTokens(Map<String, String> tokens) {
		this.tokens = tokens;
	}
	
}