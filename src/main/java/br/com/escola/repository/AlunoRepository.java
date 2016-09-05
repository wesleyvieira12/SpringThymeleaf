package br.com.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.escola.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	//@Query("select c from Cliente c where c.email=:email")
	//public Aluno buscarPorEmail(@Param("email") String email);
	
}
