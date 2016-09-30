package br.com.escola.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Usuario é obrigatório")
	@Size(max=50,message = "Usuario só pode ter no maximo 50 caracteres")
	@Column(nullable=false,length=50)
	private String usuario;
	
	@NotBlank(message = "Senha é obrigatório")
	@Size(min=8,message = "Senha deve ter entre 8 e 255 caracteres")
	@Column(nullable=false,length=255)
	private String senha;
	
	@Column(nullable=false)
	private Boolean habilitado;
	
	@ManyToMany
	@JoinTable(name="permisao_usuario",
			joinColumns =@JoinColumn(name="usuario_id"),
			inverseJoinColumns=@JoinColumn(name="permisao_id"))
	private List<Permisao> permisoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}

	public List<Permisao> getPermisoes() {
		return permisoes;
	}

	public void setPermisoes(List<Permisao> permisoes) {
		this.permisoes = permisoes;
	}
	
	
	
}
