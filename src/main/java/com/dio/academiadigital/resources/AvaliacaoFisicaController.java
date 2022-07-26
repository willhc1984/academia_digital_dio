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

import com.dio.academiadigital.entities.AvaliacaoFisica;
import com.dio.academiadigital.entities.form.AvaliacaoFisicaForm;
import com.dio.academiadigital.services.AvaliacaoFisicaService;

@RestController
@RequestMapping(value = "/avaliacoes")
public class AvaliacaoFisicaController {
	
	@Autowired
	private AvaliacaoFisicaService service;
	
	@GetMapping
	public List<AvaliacaoFisica> getAll(){
		List<AvaliacaoFisica> avaliacoes = service.getAll();
		return avaliacoes;
	}
	
	@GetMapping(value = "/{id}")
	public AvaliacaoFisica getById(@PathVariable Long id) {
		AvaliacaoFisica avaliacaoFisica = service.getById(id);
		return avaliacaoFisica;
	}
	
	@PostMapping
	public AvaliacaoFisica create(@Valid @RequestBody AvaliacaoFisicaForm form) {
		return service.create(form);
	}
	
	@PutMapping(value = "/{id}")
	public AvaliacaoFisica update(@RequestBody AvaliacaoFisica avaliacaoFisica, @PathVariable Long id) {
		service.update(id, avaliacaoFisica);
		return avaliacaoFisica;
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteById(@PathVariable Long id) {
		service.delete(id);
	}
	
}
