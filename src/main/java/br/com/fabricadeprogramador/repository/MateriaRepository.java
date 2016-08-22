package br.com.fabricadeprogramador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fabricadeprogramador.model.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {

}
