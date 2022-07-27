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
		return "/cad-alunos";
	}
	
	@GetMapping("/listAluno")
	public String listAluno() {
		return "/lista-alunos";
	}

}
