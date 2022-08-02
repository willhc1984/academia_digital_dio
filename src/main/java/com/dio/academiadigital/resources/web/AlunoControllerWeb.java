package com.dio.academiadigital.resources.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dio.academiadigital.entities.Aluno;
import com.dio.academiadigital.entities.form.AlunoForm;
import com.dio.academiadigital.services.AlunoService;

@Controller
@RequestMapping("/web/alunos")
public class AlunoControllerWeb {

	@Autowired
	private AlunoService service;

	@GetMapping
	public String getAll(ModelMap model) {
		model.addAttribute("alunos", service.getAll());
		return "/lista-aluno";
	}

	@GetMapping(value = "/cadastro")
	public String save(AlunoForm alunoForm) {
		return "/cad-aluno";
	}

	@PostMapping
	public String create(@Valid AlunoForm form, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) { return "/cad-aluno"; }		 
		
		try {
			service.create(form);
			attr.addFlashAttribute("success", "Aluno cadastrado com sucesso!");
			return "redirect:/web/alunos/cadastro";
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Erro: Violação de chave.");
			return "redirect:/web/alunos/cadastro";
		}			
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes attr) {
		try {
			service.delete(id);
			attr.addFlashAttribute("success", "Aluno excluido com sucesso!");
			return "redirect:/web/alunos";
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Erro: Violação de chave.");
			return "redirect:/web/alunos/";
		}
	}
	
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable Long id, ModelMap model) {
		model.addAttribute("alunoForm", service.getById(id)); 
		return "/atualizar-aluno";
	}
	
	@PostMapping(value = "/update/{id}")
	public String update(@Valid AlunoForm form, @PathVariable Long id, Aluno aluno, BindingResult result, RedirectAttributes attr) {
		
		if(result.hasErrors()) { return "/atualizar-aluno";	}
		
		try {
			service.update(id, aluno);
			attr.addFlashAttribute("success", "Aluno atualizado com sucesso!");
			return "redirect:/web/alunos";
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Erro: Violação de chave.");
			return "redirect:/web/alunos/";
		}
		
	}
	

}
