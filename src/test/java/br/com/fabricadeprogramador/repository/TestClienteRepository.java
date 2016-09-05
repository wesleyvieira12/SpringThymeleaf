package br.com.fabricadeprogramador.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.escola.model.Aluno;
import br.com.escola.repository.AlunoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TestClienteRepository {
	
	@Autowired
	private AlunoRepository clienteRepository;
	
	@Test
	public void testSalvar(){
		
		Aluno c = new Aluno();
		c.setNome("joao");
		//c.setEmail("joao@gmail.com");
		Aluno cSalvo = clienteRepository.save(c);
		
		Assert.assertNotNull(cSalvo.getId());
		
	}
	
}
