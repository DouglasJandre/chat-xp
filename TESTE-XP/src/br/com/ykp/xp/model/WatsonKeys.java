package br.com.ykp.xp.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import br.com.ykp.xp.servico.Conversation;

public class WatsonKeys {
	
	final static Logger logger = Logger.getLogger(WatsonKeys.class);

	private String usuarioKey;
	private String senhaKey;
	private String keyWorkspaceID;

	public WatsonKeys() {
		logger.info("WatsonKeys");
		logger.error("WatsonKeys ");
		if (usuarioKey == null) {
			Properties props = new Properties();

			try {
				FileInputStream file = new FileInputStream("etc/opt/wildfly-10.1.0.Final/chatbot-config/watsonKeys.properties");//("/etc/opt/wildfly-10.1.0.Final/arquivo-config/watsonKeys.properties");
				props.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			usuarioKey = props.getProperty("watsonKeys.usuarioKey");
			senhaKey = props.getProperty("watsonKeys.senhaKey");
			keyWorkspaceID = props.getProperty("watsonKeys.keyWorkspaceID");
			
		}
		
		logger.info("WatsonKeys usuarioKey " + usuarioKey);
		logger.error("WatsonKeys usuarioKey " + usuarioKey);
		
		logger.info("WatsonKeys senhaKey " + senhaKey);
		logger.error("WatsonKeys senhaKey " + senhaKey);
		
		logger.info("WatsonKeys keyWorkspaceID " + keyWorkspaceID);
		logger.error("WatsonKeys keyWorkspaceID " + keyWorkspaceID);
		
	}

	public String getUsuarioKey() {
		return usuarioKey;
	}

	public void setUsuarioKey(String usuarioKey) {
		this.usuarioKey = usuarioKey;
	}

	public String getSenhaKey() {
		return senhaKey;
	}

	public void setSenhaKey(String senhaKey) {
		this.senhaKey = senhaKey;
	}

	public String getKeyWorkspaceID() {
		return keyWorkspaceID;
	}

	public void setKeyWorkspaceID(String keyWorkspaceID) {
		this.keyWorkspaceID = keyWorkspaceID;
	}

}
