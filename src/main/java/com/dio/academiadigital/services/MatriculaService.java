package com.dio.academiadigital.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dio.academiadigital.entities.Aluno;
import com.dio.academiadigital.entities.AvaliacaoFisica;
import com.dio.academiadigital.entities.Matricula;
import com.dio.academiadigital.entities.form.MatriculaForm;
import com.dio.academiadigital.repositories.AlunoRepository;
import com.dio.academiadigital.repositories.MatriculaRepository;

@Service
public class MatriculaService {
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<Matricula> getAll(){
		List<Matricula> matriculas = matriculaRepository.findAll();
		return matriculas;
	}
	
	public Matricula getById(Long id) {
		Optional<Matricula> matricula = matriculaRepository.findById(id);
		return matricula.get();
	}
	
	public Matricula create(MatriculaForm form){
		Matricula matricula = new Matricula();
		matricula.setDataDaMatricula(form.getDataDaMatricula());
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();		
		matricula.setAluno(aluno);
		
		return matriculaRepository.save(matricula);
	}
	
	public void delete(Long id) {
		matriculaRepository.deleteById(id);
	}
	
	public Matricula update(Long id, Matricula matricula) {
		@SuppressWarnings("deprecation")
		Matricula obj = matriculaRepository.getOne(id);
		updateData(obj, matricula);
		return matriculaRepository.save(obj);
	}

	private void updateData(Matricula obj, Matricula matricula) {
		obj.setDataDaMatricula(matricula.getDataDaMatricula());
	}
}
