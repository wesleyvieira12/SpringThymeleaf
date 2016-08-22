package br.com.fabricadeprogramador.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Materia {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="professor_id")
	private Professor professor;
	
	@ManyToMany
	@JoinTable(name="materia_serie",
			joinColumns =@JoinColumn(name="materia_id"),
			inverseJoinColumns=@JoinColumn(name="serie_id"))
	private List<Serie> series;
	
	@OneToMany(mappedBy = "materia")
	private List<NotaAlunoMateria> notaAlunoMaterias;

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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}

	public List<NotaAlunoMateria> getNotaAlunoMaterias() {
		return notaAlunoMaterias;
	}

	public void setNotaAlunoMaterias(List<NotaAlunoMateria> notaAlunoMaterias) {
		this.notaAlunoMaterias = notaAlunoMaterias;
	}
	
	
}
