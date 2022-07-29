package com.dio.academiadigital.resources.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dio.academiadigital.entities.Aluno;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "/home";
	}
	
	/*
	 * @GetMapping("/web/cadAluno") public String cadAluno(Aluno aluno) { return
	 * "/cad-aluno"; }
	 * 
	 * @GetMapping("/web/listaAluno") public String listaAluno() { return
	 * "/lista-aluno"; }
	 * 
	 * @GetMapping("/web/cadMatricula") public String cadMatricula() { return
	 * "/cad-matricula"; }
	 * 
	 * @GetMapping("/web/listaMatricula") public String listaMatricula() { return
	 * "/lista-matricula"; }
	 * 
	 * @GetMapping("/web/cadAvaliacao") public String cadAvaliacao() { return
	 * "/cad-avaliacao"; }
	 * 
	 * @GetMapping("/web/listaAvaliacao") public String listaAvaliacao() { return
	 * "/lista-avaliacao"; }
	 */

}
