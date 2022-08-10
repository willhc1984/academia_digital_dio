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

import com.dio.academiadigital.entities.Matricula;
import com.dio.academiadigital.entities.form.MatriculaForm;
import com.dio.academiadigital.services.MatriculaService;

@RestController
@RequestMapping(value = "/matriculas")
public class MatriculaController {
	
	@Autowired
	private MatriculaService service;
	
	@GetMapping
	public List<Matricula> getAll(){
		List<Matricula> matriculas = service.getAll();
		return matriculas;
	}
	
	@GetMapping(value = "/{id}")
	public Matricula getById(@PathVariable Long id) {
		Matricula matricula = service.getById(id);
		return matricula;
	}
	
	@PostMapping
	public Matricula create(@Valid @RequestBody MatriculaForm form) {
		return service.create(form);
	}
	
	@PutMapping(value = "/{id}")
		public Matricula update(@RequestBody Matricula matricula, @PathVariable Long id) {
			service.update(id, matricula);
			return matricula;
		}
	
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Long id) {
		service.delete(id);
	}
}
