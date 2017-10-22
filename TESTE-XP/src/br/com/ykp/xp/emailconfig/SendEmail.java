package br.com.ykp.xp.emailconfig;

import java.text.Normalizer;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.ykp.xp.model.Email;

public class SendEmail {

	@SuppressWarnings("deprecation")
	public void sendEmail(String corpoEmail) {

		SimpleEmail email = new SimpleEmail();

		try {
			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
//			email.setAuthentication(emailConfig.getUsuario(), emailConfig.getSenha());
			email.setAuthenticator(new DefaultAuthenticator("teste.ykp@gmail.com", "Ykp@010203"));
			email.setSSL(true);
//			email.setTLS(true);
//			email.setStartTLSEnabled(true);
			email.addTo("solutions.bcf01@gmail.com");
			email.setFrom("teste.ykp@gmail.com");
			email.setSubject("Conversa do Chatbot investimentosXP");
			email.setCharset(org.apache.commons.mail.EmailConstants.UTF_8);
			email.setMsg(removerTags(corpoEmail));

			email.send();
		} catch (EmailException e) {
			System.out.println(e.getMessage());
		}
	}

	public String removerTags(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("\\<.*?>", "");
	}
}

//-----------------------------------------------------------------------------------
////E-mail TLS - TesteOK
//
//package br.com.ykp.xp.emailconfig;
//
//import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//import br.com.ykp.xp.model.Email;
//
//import java.text.Normalizer;
//
//public class SendEmail {
//
//	public void sendEmail(Email emailConfig, String corpoEmail) {
//
//		final String username = emailConfig.getUsuario();// Usuario 
//		final String password = emailConfig.getSenha(); // Senha
//
//		Properties props = new Properties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", emailConfig.getSmtp());
//		props.put("mail.smtp.port", Integer.parseInt(emailConfig.getPorta()));//porta - ???
//
//		Session session = Session.getInstance(props,
//		  new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(username, password);
//			}
//		  });
//
//		try {
//
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress(emailConfig.getDe()));
//			message.setRecipients(Message.RecipientType.TO,
//				InternetAddress.parse(emailConfig.getPara()));//e-mail de destino SalesForce
//			message.setSubject(emailConfig.getTitulo());
//			message.setText(removerTags(corpoEmail));
//
//			Transport.send(message);
//
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}
//		
//	}
//	public String removerTags(String str) {
//		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("\\<.*?>", "");
//	}
//}

//-----------------------------------------------------------------------------------
// E-mail SSL
//
//package br.com.ykp.xp.emailconfig;
//
//import java.util.Properties;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//import br.com.ykp.xp.model.Email;
//
//import java.text.Normalizer;
//
//public class SendEmail {
//	
//	public void sendEmail(Email emailConfig, String corpoEmail) {
//		
//		Properties props = new Properties();
//		props.put("mail.smtp.host", emailConfig.getSmtp());    //Configuração Host, porta, e-mail e senha
//		props.put("mail.smtp.socketFactory.port", Integer.parseInt(emailConfig.getSmtp()));  
//		props.put("mail.smtp.socketFactory.class",
//				"javax.net.ssl.SSLSocketFactory");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.port", Integer.parseInt(emailConfig.getSmtp()));
//
//		Session session = Session.getDefaultInstance(props,
//			new javax.mail.Authenticator() {
//				protected PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication(emailConfig.getUsuario(), emailConfig.getSenha()); 
//				}
//			});
//
//		try {
//
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress(emailConfig.getUsuario()));
//			message.setRecipients(Message.RecipientType.TO,
//					InternetAddress.parse(emailConfig.getPara()));//e-mail do SalesForce
//			message.setSubject(emailConfig.getTitulo());
//			message.setText(removerTags(corpoEmail));
//
//			Transport.send(message);
//
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}
//	}
//	public String removerTags(String str) {
//	return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("\\<.*?>", "");
//	}
//}

