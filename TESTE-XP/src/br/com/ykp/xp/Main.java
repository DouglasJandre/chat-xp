package br.com.ykp.xp;

import org.apache.log4j.*;

import br.com.ykp.xp.emailconfig.SendEmail;

public class Main {

	public static void main(String[] args) {

		SendEmail sd = new SendEmail();

		sd.sendEmail("Segundo Teste de envio de Email");
	}

}
