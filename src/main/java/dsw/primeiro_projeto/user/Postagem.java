package dsw.primeiro_projeto.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Postagem {
	@Id
	@GeneratedValue
	private Integer id;
	private String mensagem;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private Usuario usuario;
	
	

	public Postagem(Integer id, String mensagem, Usuario usuario) {
		super();
		this.id = id;
		this.mensagem = mensagem;
		this.usuario = usuario;
	}

	
	
	public Postagem() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	@Override
	public String toString() {
		return "Postagem [id=" + id + ", mensagem=" + mensagem + ", usuario=" + usuario + "]";
	}
	
	

}
