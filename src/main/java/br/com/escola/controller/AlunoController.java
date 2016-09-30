package br.com.escola.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.escola.model.Aluno;
import br.com.escola.repository.AlunoRepository;
import br.com.escola.repository.PermisaoRepository;
import br.com.escola.repository.SerieRepository;

@Controller
@RequestMapping("aluno/")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private SerieRepository serieRepository;
	
	@Autowired
	private PermisaoRepository permisao;
	
	@RequestMapping(value="listar",method=RequestMethod.GET)
	public String listar(Model model){		
		model.addAttribute("alunos",alunoRepository.findAll());
		return "aluno/ListarAlunos";
	}
	
	@RequestMapping(value="novo", method=RequestMethod.GET)
	public String novo(Aluno aluno,Model model){
		model.addAttribute("series",serieRepository.findAll());
		return "aluno/NovoAluno";
	}
	
	@RequestMapping(value="alterar/{id}", method=RequestMethod.GET)
	public String alterar(@PathVariable("id") Aluno aluno,Model model){
		model.addAttribute("series",serieRepository.findAll());
		model.addAttribute(aluno);
		return "aluno/EditarAluno";
	}
	
	@RequestMapping(value="alterar/",method=RequestMethod.POST)
	public String salvarAlteracao(@Valid Aluno aluno, BindingResult bindingResult, Model model,RedirectAttributes attributes){
		
		if (bindingResult.hasErrors()) {
				return alterar(aluno,model);
		}
		
		alunoRepository.save(aluno);
		attributes.addFlashAttribute("mensagem", "Aluno alterado com sucesso!");
		return "redirect:/aluno/listar";
		
	}
	
	
	@RequestMapping(value="novo",method=RequestMethod.POST)
	public String salvarNovo(@Valid Aluno aluno, BindingResult bindingResult, Model model,RedirectAttributes attributes){
		
		if (bindingResult.hasErrors()) {
				return novo(aluno,model);
		}
		
		alunoRepository.save(aluno);
		attributes.addFlashAttribute("mensagem", "Aluno salvo com sucesso!");
		return "redirect:/aluno/novo";
		
	}
	
	@RequestMapping(value="excluir/{id}", method=RequestMethod.GET)
	public String excluir(@PathVariable("id") Aluno aluno,RedirectAttributes attributes){
		
		alunoRepository.delete(aluno);
		attributes.addFlashAttribute("mensagem", aluno.getNome()+" excluido(a)!");
		return "redirect:/aluno/listar";
		
	}
	
	
}
