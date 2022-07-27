package com.dio.academiadigital.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "/home";
	}
	
	@GetMapping("/cadAluno")
	public String cadAluno() {
		return "/cad-aluno";
	}
	
	@GetMapping("/listaAluno")
	public String listaAluno() {
		return "/lista-aluno";
	}
	
	@GetMapping("/cadMatricula")
	public String cadMatricula() {
		return "/cad-matricula";
	}
	
	@GetMapping("/listaMatricula")
	public String listaMatricula() {
		return "/lista-matricula";
	}
	
	@GetMapping("/cadAvaliacao")
	public String cadAvaliacao() {
		return "/cad-avaliacao";
	}
	
	@GetMapping("/listaAvaliacao")
	public String listaAvaliacao() {
		return "/lista-avaliacao";
	}

}
