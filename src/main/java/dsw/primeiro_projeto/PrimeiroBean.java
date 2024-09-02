package dsw.primeiro_projeto;

public class PrimeiroBean {
	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public PrimeiroBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrimeiroBean(String mensagem) {
		super();
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return "PrimeiroBean [mensagem=" + mensagem + "]";
	}
	
	

}
