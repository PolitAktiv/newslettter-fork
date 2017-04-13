package net.zylk.liferay.portal.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import net.zylk.liferay.portal.MailHandlerException;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.Account;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.mail.MailEngine;
import com.liferay.util.portlet.PortletProps;

/**
 * Gestiona el envio de los correos, manteniendo el estado de la session.
 * 
 * Esta basada en la clase MailEngine de liferay para la lectura de propiedades...
 *
 */
public class MailHandler {

	private static Log _log = LogFactoryUtil.getLog(MailHandler.class);
	
	private static final String _TEXT_HTML = "text/html;charset=\"UTF-8\"";
	private static final String _TEXT_PLAIN = "text/plain;charset=\"UTF-8\"";
	
	//props
	private boolean customSystemEnabled;
	private int sessionEmailLimit;
	private int sessionWaitTime;
	
	// util
	private int sessionEmailCount;
	
	// mail
	private Session session;
	private Transport transport;
	private String protocol;
	private String smtpHost;
	private int smtpPort;
	private String user;
	private String password;
	
	
	public MailHandler() throws MailHandlerException {
		
		customSystemEnabled = Boolean.valueOf(CoreProps.get(CoreProps.KEY_EMAIL_SYSTEM_SESSION_HANDLER_ENABLE));
		
		if (customSystemEnabled) {
			
			_log.info("email session handler enabled");
			
			sessionEmailLimit = Integer.valueOf(CoreProps.get(CoreProps.KEY_EMAIL_SYSTEM_SESSION_EMAIL_LIMIT));
			sessionWaitTime = Integer.valueOf(CoreProps.get(CoreProps.KEY_EMAIL_SYSTEM_SESSION_WAIT_TIME));

			session = MailEngine.getSession();
	
			boolean smtpAuth = GetterUtil.getBoolean(_getSMTPProperty(session, "auth"), false);
			smtpHost = _getSMTPProperty(session, "host");
			smtpPort = GetterUtil.getInteger(_getSMTPProperty(session, "port"), Account.PORT_SMTP);
			user = _getSMTPProperty(session, "user");
			password = _getSMTPProperty(session, "password");
	
			if (smtpAuth && Validator.isNotNull(user) && Validator.isNotNull(password)) {
	
				protocol = GetterUtil.getString(session.getProperty("mail.transport.protocol"), Account.PROTOCOL_SMTP);
	
			} else {
				// En la clase "MailEngine" de Liferay se hace esta comprobacion y dependiendo de esto se utiliza la funcion
				// "Transport.send(message, portion)" con lo cual no se abre ni cierra la conexion. Supongo que al no tener
				// autenticacion no se puede mantener la session así que lanzo una excepcion.
				throw new MailHandlerException("Este modelo de envio de emails solo esta disponible para smtp con autenticacion");
			}	
		}
		
	}
	
	public void openConnection() throws MailHandlerException {

		if (customSystemEnabled) {
			
			_log.info("openConnection");
			
			try {
				transport = session.getTransport(protocol);
				transport.connect(smtpHost, smtpPort, user, password);
				sessionEmailCount = 0;

			} catch (NoSuchProviderException e) {
				throw new MailHandlerException(e);
			} catch (MessagingException e) {
				throw new MailHandlerException(e);
			}
		}
	}

	private void reopenConnection() throws MailHandlerException {
		
		if (customSystemEnabled) {
		
			try {
				closeConnection();
				Thread.sleep(sessionWaitTime);
				openConnection();
				
			} catch (InterruptedException e) {
				throw new MailHandlerException(e);
			}
		}
	}
	
	public void closeConnection() throws MailHandlerException {
		
		if (customSystemEnabled) {
			
			_log.info("closeConnection");
			
			try {
				transport.close();
				
			} catch (MessagingException e) {
				throw new MailHandlerException(e);
			}	
		}
	}
	
	
	public void send(String subject, String body, String mailFromAddress, String mailFromName, String mailToAddress,
			String mailToName) throws MailHandlerException {
	
		if (customSystemEnabled) {
			
			try {
				// check email por sesion
				if (sessionEmailCount >= sessionEmailLimit) {
					reopenConnection();
				}
				
				sendCustom(subject, body, mailFromAddress, mailFromName, mailToAddress, mailToName, true);
				
				sessionEmailCount++;
				
				_log.info("email sended");
				
			} catch (UnsupportedEncodingException e) {
				throw new MailHandlerException(e);
			} catch (MessagingException e) {
				throw new MailHandlerException(e);
			}	
			
		} else {
			
			try {
				sendLiferay(subject, body, mailFromAddress, mailFromName, mailToAddress, mailToName, true);
				
			} catch (UnsupportedEncodingException e) {
				throw new MailHandlerException(e);
			}
		}
		
	}
	
	private void sendCustom(String subject, String body, String fromAddress, String fromName, String toAddress,
			String toName, boolean htmlFormat) throws UnsupportedEncodingException, MessagingException {
		
		InternetAddress[] to = new InternetAddress[] {new InternetAddress(toAddress, toName)};
		
		// utiliza el LiferayMimeMessage de liferay?? la unica diferencia es el update del "Message-ID"
		Message message = new MimeMessage(session);
//		Message message = new LiferayMimeMessage(session);

		message.setFrom(new InternetAddress(fromAddress, fromName));
		message.setRecipients(Message.RecipientType.TO, to);

		subject = GetterUtil.getString(subject);

		message.setSubject(subject);

		if (htmlFormat) {
			message.setContent(body, _TEXT_HTML);
		}
		else {
			message.setContent(body, _TEXT_PLAIN);
		}

		message.setSentDate(new Date());

//		if (messageId != null) {
//			message.setHeader("Message-ID", messageId);
//		}
		
		// envio del email
		transport.sendMessage(message, to);
		
	}
	
	private void sendLiferay(String subject, String body, String mailFromAddress, String mailFromName, String mailToAddress,
			String mailToName, boolean htmlFormat) throws UnsupportedEncodingException {

		// envio a traves del API de liferay
		MailMessage mailMessage = new MailMessage();
		mailMessage.setSubject(subject);
		mailMessage.setBody(body);
		mailMessage.setFrom(new InternetAddress(mailFromAddress, mailFromName));
        mailMessage.setTo(new InternetAddress(mailToAddress, mailToName));
        mailMessage.setHTMLFormat(true);
		
		MailServiceUtil.sendEmail(mailMessage);
	}
	

	private static String _getSMTPProperty(Session session, String suffix) {
		
		String protocol = GetterUtil.getString(session.getProperty("mail.transport.protocol"));

		if (protocol.equals(Account.PROTOCOL_SMTPS)) {
			return session.getProperty("mail.smtps." + suffix);
		} else {
			return session.getProperty("mail.smtp." + suffix);
		}
	}

}
