package br.com.fabricadeprogramador.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório")
	@Size(message = "Nome só pode ter no maximo 50 caracteres")
	@Column(nullable=false, length=50)
	private String nome;
	
	@OneToMany(mappedBy="professor")
	private List<Materia> materias;
}
