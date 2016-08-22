package br.com.fabricadeprogramador.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import br.com.fabricadeprogramador.model.Aluno;
import br.com.fabricadeprogramador.repository.AlunoRepository;

@Controller
@RequestMapping("aluno/")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@RequestMapping(value="inicio",method=RequestMethod.GET)
	public String index(Aluno aluno, Model model){
		model.addAttribute("alunos",alunoRepository.findAll());
		return "aluno/ListarAlunos";
	}
	
	@RequestMapping(value="inicio",method=RequestMethod.POST)
	public String salvar(@Valid Aluno cliente, BindingResult bindingResult, Model model){
		
		if (bindingResult.hasErrors()) {
			return "index";
		}
		model.addAttribute("nome", cliente.getNome());
		//model.addAttribute("email",cliente.getEmail());
		alunoRepository.save(cliente);
		
		return "result";
	}
	
}
