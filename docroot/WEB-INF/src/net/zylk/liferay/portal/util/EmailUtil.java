package net.zylk.liferay.portal.util;

import net.zylk.liferay.portal.InvalidEmailException;


public class EmailUtil  {
	

	public static void validateEmail(String emailAddress) throws InvalidEmailException {
		
		// TODO añadir validacion real de email
		if (emailAddress == null || emailAddress.equals("") || !emailAddress.contains("@")) {
			throw new InvalidEmailException("email=" + emailAddress);
		}
	}
	
}
		