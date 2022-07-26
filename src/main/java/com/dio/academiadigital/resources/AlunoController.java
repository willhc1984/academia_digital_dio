package com.dio.academiadigital.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.academiadigital.entities.Aluno;
import com.dio.academiadigital.entities.form.AlunoForm;
import com.dio.academiadigital.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService service;
	
	@GetMapping
	public List<Aluno> getAll(){
		List<Aluno> alunos = service.getAll();
		return alunos;
	}
	
	@GetMapping(value = "/{id}")
	public Aluno getById(@PathVariable Long id) {
		Aluno aluno = service.getById(id);
		return aluno;
	}
	
	@PostMapping
	public Aluno create(@Valid @RequestBody AlunoForm form) {
		return service.create(form);
	}
	
	@PutMapping(value = "/{id}")
		public Aluno update(@RequestBody Aluno aluno, @PathVariable Long id) {
			service.update(id, aluno);
			return aluno;
		}
	
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Long id) {
		service.delete(id);
	}
}
