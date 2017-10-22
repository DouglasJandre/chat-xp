package br.com.ykp.xp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.ykp.xp.servico.Conversation;

import org.apache.log4j.*;

@RestController
public class ConversationFacade {
	
	final static Logger logger = Logger.getLogger(ConversationFacade.class);
	
	@Autowired
	private Conversation conversation;
	
	@CrossOrigin(origins = "*")
	@GetMapping("/conversa/{frase}")
	public String conversar(@PathVariable String frase) {
		
		logger.info("conversationFacade "+frase);
		logger.error("conversationFacade "+frase);
		
		logger.error("conversationFacade(.) "+conversation.conversar(frase));
		return conversation.conversar(frase);

	}

	@CrossOrigin(origins = "*")
	@GetMapping("/avaliacao/{avaliacao}")
	public void avaliar(@PathVariable String avaliacao) {
		
		
		conversation.setAvaliacao(avaliacao);
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/fecharConversa/{codSF}")
	public void fecharConversa(@PathVariable String codSF) {
		
		logger.info("conversationFacade codSF"+codSF);
		logger.error("conversationFacade codSF"+codSF);
		
		conversation.fecharConversa(codSF);
	}

}
