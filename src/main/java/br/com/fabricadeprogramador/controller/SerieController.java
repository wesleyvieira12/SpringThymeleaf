package br.com.fabricadeprogramador.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.fabricadeprogramador.model.Serie;
import br.com.fabricadeprogramador.repository.SerieRepository;

@Controller
@RequestMapping("serie/")
public class SerieController {
	
	@Autowired
	private SerieRepository serieRepository;
	
	
	@RequestMapping(value="listar",method=RequestMethod.GET)
	private String listar(Model model){
		
		model.addAttribute("series",serieRepository.findAll());
		return "serie/ListarSeries";
	}
	
	@RequestMapping(value="nova",method=RequestMethod.GET)
	private String nova(Serie serie){
		return "serie/NovaSerie";
	}
	
	@RequestMapping(value="nova",method=RequestMethod.POST)
	private String salvar(@Valid Serie serie,BindingResult results, RedirectAttributes attributes){
		
		if(results.hasErrors()){
			return nova(serie);
		}
		
		serieRepository.save(serie);
		attributes.addFlashAttribute("mensagem", "Serie salva com sucesso!");
		
		return "redirect:/serie/nova";
	}
	

}
