package br.com.ykp.xp.model;

public class Conversa {

	private String pergunta;
	private String resposta;

	public Conversa(String pergunta, String resposta) {
		this.pergunta = pergunta;
		this.resposta = resposta;
	}
	public String getPergunta() {
		return pergunta;
	}
	public String getResposta() {
		return resposta;
	}

}
