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

import com.dio.academiadigital.entities.Matricula;
import com.dio.academiadigital.entities.form.MatriculaForm;
import com.dio.academiadigital.services.AlunoService;
import com.dio.academiadigital.services.MatriculaService;

@Controller
@RequestMapping("/web/matriculas")
public class MatriculaControllerWeb {

	@Autowired
	private MatriculaService matriculaService;
	
	@Autowired
	private AlunoService alunoService;

	@GetMapping
	public String getAll(ModelMap model) {
		model.addAttribute("matriculas", matriculaService.getAll());
		return "/lista-matricula";
	}

	@GetMapping(value = "/cadastro")
	public String save(MatriculaForm matriculaForm, ModelMap model) {
		model.addAttribute("alunos", alunoService.getAll());
		return "/cad-matricula";
	}

	@PostMapping
	public String create(@Valid MatriculaForm form, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) { 
			System.out.println(form);
			return "/cad-matricula"; 
		}		 
		try {
			matriculaService.create(form);
			attr.addFlashAttribute("success", "Aluno matriculado!");
			return "redirect:/web/matriculas/cadastro";
		} catch (DataIntegrityViolationException e) {
			attr.addFlashAttribute("fail", "Aluno já matriculado!");
			return "redirect:/web/matriculas/cadastro";
		}			
	}
	
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes attr) {
		try {
			matriculaService.delete(id);
			attr.addFlashAttribute("success", "Matricula excluida com sucesso!");
			return "redirect:/web/matriculas";
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Erro: Violação de chave.");
			return "redirect:/web/matriculas/";
		}
	}
	
	@GetMapping(value = "/update/{id}")
	public String update(@PathVariable Long id, ModelMap model) {
		model.addAttribute("matriculaForm", matriculaService.getById(id)); 
		return "/atualizar-matricula";
	}
	
	@PostMapping(value = "/update/{id}")
	public String update(@Valid MatriculaForm matriculaForm, BindingResult result, ModelMap model, @PathVariable Long id, Matricula matricula, RedirectAttributes attr) {
		
		if (result.hasErrors()) { 
			model.addAttribute("matriculaForm", matriculaService.getById(id)); 
			attr.addFlashAttribute("fail", "Erro: Preencha os dados corretamente.");
			return "redirect:/web/matriculas/update/{id}"; 
		}
		
		try {
			matriculaService.update(id, matricula);
			attr.addFlashAttribute("success", "Matricula atualizado com sucesso!");
			return "redirect:/web/matriculas";
		} catch (Exception e) {
			attr.addFlashAttribute("fail", "Erro: Violação de chave.");
			return "redirect:/web/matriculas/";
		}
		
	}
}
