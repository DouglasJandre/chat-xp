package br.com.ykp.xp.servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

import br.com.ykp.xp.emailconfig.SendEmail;
import br.com.ykp.xp.model.Conversa;
import br.com.ykp.xp.model.Email;
import br.com.ykp.xp.model.WatsonKeys;

import org.apache.log4j.*;

@SuppressWarnings("deprecation")
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Conversation {
	
	final static Logger logger = Logger.getLogger(Conversation.class);

	private ConversationService service;
	private Map<String, Object> context;
	private List<Conversa> listaConversa;
	private Email email;
	private WatsonKeys watsonConfig;

	public Conversation() {
		
		logger.info("iniciando o Log");
		logger.error("iniciando o Log");
		
		if (email == null) {
			email = new Email();
		}
		if (listaConversa == null) {
			listaConversa = new ArrayList<Conversa>();
		}
		if(watsonConfig == null){
			watsonConfig = new WatsonKeys();
		};
		init();
	}

	public void init() {
		service = new ConversationService(ConversationService.VERSION_DATE_2016_09_20,
				"af4f73a7-cf6b-4363-8ee5-96b3a19dc623", "IZp4svTRAK47");

		context = null;
	}

	public String conversar(String frase) {
		logger.info("frase "+ frase);
		logger.error("frase "+ frase);
		
		MessageRequest request = new MessageRequest.Builder().context(context).inputText(frase).build();
		MessageResponse resp = service.message("d60b68c3-3e93-4cfb-9630-cba94b7dac48", request).execute();

		context = resp.getContext();
		
		Conversa conversa = new Conversa(frase, resp.getTextConcatenated(""));
		listaConversa.add(conversa);

		String resolucao = null;
		resolucao =  (String) resp.getContext().get("resolucao");
		String jsonRetorno = null;
		
		if (resolucao != null && resolucao.equals("verdadeiro")) {
			jsonRetorno = "true|" + resp.getTextConcatenated("");

		}else{

			jsonRetorno = "false|" + resp.getTextConcatenated("");
			
		}
		
		return jsonRetorno;
	}

	public void fecharConversa(String codSF) {
		StringBuffer corpoEmail = new StringBuffer();
		
		for (Conversa conversaTemp : listaConversa) {
			if(conversaTemp.getPergunta().equals("Avaliação")){
				corpoEmail.append("\n" + conversaTemp.getPergunta() + " = " + conversaTemp.getResposta() + "\n");
			} else {
				corpoEmail.append("\nPergunta: " + conversaTemp.getPergunta() + "\nResposta: " + conversaTemp.getResposta());					
			}
		}

		SendEmail se = new SendEmail();

		String tempCorpoEmail = "Cod." + codSF + ")" + "\n\n" + corpoEmail.toString();
		
		se.sendEmail(tempCorpoEmail);
		listaConversa.clear();
	}

	public void setAvaliacao(String avaliacao) {
		
		this.listaConversa.add(new Conversa("Avaliação", avaliacao));
	}

}
