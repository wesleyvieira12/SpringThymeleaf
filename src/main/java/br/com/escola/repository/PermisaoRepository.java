package br.com.escola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.escola.model.Permisao;

public interface PermisaoRepository extends JpaRepository<Permisao, Long>{

	@Query("SELECT p.nome FROM Permisao p JOIN p.usuarios u WHERE u.usuario = ?1")
	public List<Long> findPermisaoByUsuario(String usuario);
}
