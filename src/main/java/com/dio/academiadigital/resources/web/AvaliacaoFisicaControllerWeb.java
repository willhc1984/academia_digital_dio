package com.dio.academiadigital.resources.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dio.academiadigital.entities.AvaliacaoFisica;
import com.dio.academiadigital.entities.Matricula;
import com.dio.academiadigital.entities.form.AvaliacaoFisicaForm;
import com.dio.academiadigital.services.AlunoService;
import com.dio.academiadigital.services.AvaliacaoFisicaService;

@Controller
@RequestMapping("/web/avaliacoes")
public class AvaliacaoFisicaControllerWeb {

	@Autowired
	private AvaliacaoFisicaService avaliacaoFisicaService;
	
	@Autowired
	private AlunoService alunoService;

	@GetMapping
	public String getAll(ModelMap model) {
		model.addAttribute("avaliacoes", avaliacaoFisicaService.getAll());
		//model.addAttribute("alunos", alunoService.getAll());
		return "lista-avaliacao";
	}

	@GetMapping(value = "/cadastro")
	public String save(AvaliacaoFisicaForm form, ModelMap model) {
		model.addAttribute("alunos", alunoService.getAll());
		return "cad-avaliacao";
	}

	@PostMapping
	public String create(@Valid AvaliacaoFisicaForm form, BindingResult result, RedirectAttributes attr, ModelMap model) {
		if (result.hasErrors()) { 
			model.addAttribute("alunos", alunoService.getAll());
			System.out.println(form);
			return "cad-avaliacao"; 
		}		 
		try {
			avaliacaoFisicaService.create(form);
			attr.addFlashAttribute("success", "Avaliação física registrada!");
			return "redirect:/web/avaliacoes/cadastro";
		} catch (DataIntegrityViolationException e) {
			attr.addFlashAttribute("fail", "Erro: violação de chave.");
			return "redirect:/web/avaliacoes/cadastro";
		}			
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes attr) {
		try {
			avaliacaoFisicaService.delete(id);
			attr.addFlashAttribute("success", "Avaliação física excluida!");
			return "redirect:/web/avaliacoes";
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Erro: Violação de chave.");
			return "redirect:/web/avaliacoes";
		}
	}
	
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable Long id, ModelMap model) {
		model.addAttribute("matriculaForm", avaliacaoFisicaService.getById(id)); 
		return "atualizar-matricula";
	}
	
	@PostMapping(value = "/update/{id}")
	public String update(@Valid AvaliacaoFisica avaliacao, BindingResult result, ModelMap model, @PathVariable Long id, Matricula matricula, RedirectAttributes attr) {
		
		if (result.hasErrors()) { 
			model.addAttribute("form", avaliacaoFisicaService.getById(id)); 
			attr.addFlashAttribute("fail", "Erro: Preencha os dados corretamente.");
			return "redirect:/web/avaliacaoFisica/update/{id}"; 
		}
		
		try {
			avaliacaoFisicaService.update(id, avaliacao);
			attr.addFlashAttribute("success", "Matricula atualizado com sucesso!");
			return "redirect:web/avaliacaoFisica";
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Erro: Violação de chave.");
			return "redirect:/web/avaliacaoFisica/";
		}
		
	}
}
