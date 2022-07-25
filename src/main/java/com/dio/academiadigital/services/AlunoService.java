package com.dio.academiadigital.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.academiadigital.entities.Aluno;
import com.dio.academiadigital.entities.form.AlunoForm;
import com.dio.academiadigital.repositories.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repository;
	
	public List<Aluno> getAll(){
		List<Aluno> alunos = repository.findAll();
		return alunos;
	}
	
	public Aluno getById(Long id) {
		Optional<Aluno> aluno = repository.findById(id);
		return aluno.get();
	}
	
	public Aluno create(AlunoForm form) {
		Aluno aluno = new Aluno();
		aluno.setNome(form.getNome());
		aluno.setCpf(form.getCpf());
		aluno.setBairro(form.getBairro());
		aluno.setDataDeNascimento(form.getDataDeNasciemnto());
		return repository.save(aluno);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Aluno update(Long id, Aluno aluno) {
		@SuppressWarnings("deprecation")
		Aluno obj = repository.getOne(id);
		updateData(obj, aluno);
		return repository.save(obj);
	}

	private void updateData(Aluno obj, Aluno aluno) {
		obj.setNome(aluno.getNome());
		obj.setDataDeNascimento(aluno.getDataDeNascimento());
		obj.setBairro(aluno.getBairro());
		obj.setCpf(aluno.getCpf());
	}

}
