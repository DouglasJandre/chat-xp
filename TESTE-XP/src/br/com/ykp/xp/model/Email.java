package br.com.ykp.xp.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.*;

import br.com.ykp.xp.servico.Conversation;

public class Email {

	final static Logger logger = Logger.getLogger(Email.class);
	
	
	private String smtp;
	private String porta;
	private String usuario;
	private String senha;
	private String de;
	private String para;
	private String titulo;

	public Email() {
		logger.info("iniciando o Log de Email");
		if(smtp == null) {
			logger.info("smtp == null"+smtp);
			logger.error("smtp == null"+smtp);
			Properties props = new Properties();

			try {
				FileInputStream file = new FileInputStream("/etc/opt/wildfly-10.1.0.Final/arquivo-config/email.properties");//("/etc/opt/wildfly-10.1.0.Final/arquivo-config/email.properties");
				props.load(file);
			} catch (IOException e) {
				logger.info(e);
				logger.error(e);
				e.printStackTrace();
			}

			smtp = props.getProperty("email.smtp");
			porta = props.getProperty("email.porta");
			usuario = props.getProperty("email.usuario");
			senha = props.getProperty("email.senha");
			de = props.getProperty("email.de");
			para = props.getProperty("email.para");
			titulo = props.getProperty("email.titulo");
		}
		logger.info("smtp "+smtp);
		logger.info("porta "+porta);
		logger.info("usuario "+usuario);
		logger.info("senha "+ senha);
		logger.info("de "+de);
		logger.info("para "+para);
		logger.info("titulo "+titulo);
		
		logger.error("smtp "+smtp);
		logger.error("porta "+porta);
		logger.error("usuario "+usuario);
		logger.error("senha "+ senha);
		logger.error("de "+de);
		logger.error("para "+para);
		logger.error("titulo "+titulo);

	}
	
	public String getSmtp() {
		return smtp;
	}

	public void setSmtp(String smtp) {
		this.smtp = smtp;
	}

	public String getPorta() {
		return porta;
	}

	public void setPorta(String porta) {
		this.porta = porta;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDe() {
		return de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
