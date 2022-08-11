package com.dio.academiadigital.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.academiadigital.entities.Aluno;
import com.dio.academiadigital.entities.AvaliacaoFisica;
import com.dio.academiadigital.entities.form.AvaliacaoFisicaForm;
import com.dio.academiadigital.repositories.AlunoRepository;
import com.dio.academiadigital.repositories.AvaliacaoFisicaRepository;

@Service
public class AvaliacaoFisicaService {
	
	@Autowired
	private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<AvaliacaoFisica> getAll(){
		List<AvaliacaoFisica> avaliacoes = avaliacaoFisicaRepository.findAll();
		return avaliacoes;
	}
	
	public AvaliacaoFisica getById(Long id) {
		Optional<AvaliacaoFisica> avaliacaoFisica = avaliacaoFisicaRepository.findById(id);
		return avaliacaoFisica.get();
	}
	
	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
		AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
		
		avaliacaoFisica.setAluno(aluno);
		avaliacaoFisica.setAltura(form.getPeso());
		avaliacaoFisica.setPeso(form.getAltura());
		
		return avaliacaoFisicaRepository.save(avaliacaoFisica);
	}
	
	public void delete(Long id) {
		avaliacaoFisicaRepository.deleteById(id);
	}
	
	public AvaliacaoFisica update(Long id, AvaliacaoFisica avaliacaoFisica) {
		@SuppressWarnings("deprecation")
		AvaliacaoFisica obj = avaliacaoFisicaRepository.getOne(id);
		updateData(obj, avaliacaoFisica);
		return avaliacaoFisicaRepository.save(obj);
	}

	private void updateData(AvaliacaoFisica obj, AvaliacaoFisica avaliacaoFisica) {
		obj.setPeso(avaliacaoFisica.getPeso());
		obj.setAltura(avaliacaoFisica.getAltura());
		obj.setDataDaAvaliacao(avaliacaoFisica.getDataDaAvaliacao());
	}

}
