package br.com.escola.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório")
	@Size(max=50,message = "Nome só pode ter no maximo 50 caracteres")
	@Column(nullable=false,length=50)
	private String nome;
	
	@NotNull(message = "Idade é obrigatória")
	private Integer idade;
	
	@NotBlank(message = "Sexo é obrigatório")
	@Column(nullable=false, length=1)
	private String sexo;
	
	@ManyToOne
	@JoinColumn(name="serie_id")
	private Serie serie;
	
	@OneToMany(mappedBy = "aluno")
	private List<NotaAlunoMateria> notaAlunoMaterias;
	
	
	

	public List<NotaAlunoMateria> getNotaAlunoMaterias() {
		return notaAlunoMaterias;
	}

	public void setNotaAlunoMaterias(List<NotaAlunoMateria> notaAlunoMaterias) {
		this.notaAlunoMaterias = notaAlunoMaterias;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	
}
