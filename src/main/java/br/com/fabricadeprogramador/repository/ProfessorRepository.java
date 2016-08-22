package br.com.fabricadeprogramador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabricadeprogramador.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
