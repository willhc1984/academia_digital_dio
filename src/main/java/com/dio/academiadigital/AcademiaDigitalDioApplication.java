package com.dio.academiadigital;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dio.academiadigital.entities.Aluno;
import com.dio.academiadigital.entities.AvaliacaoFisica;
import com.dio.academiadigital.entities.Matricula;
import com.dio.academiadigital.repositories.AlunoRepository;
import com.dio.academiadigital.repositories.AvaliacaoFisicaRepository;
import com.dio.academiadigital.repositories.MatriculaRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SpringBootApplication
public class AcademiaDigitalDioApplication implements CommandLineRunner{
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

	public static void main(String[] args) {
		SpringApplication.run(AcademiaDigitalDioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Aluno aluno1 = new Aluno();
		aluno1.setId(1L);
		aluno1.setNome("William Henrique");
		aluno1.setCpf("34536456789");
		aluno1.setDataDeNascimento(LocalDate.now());
		aluno1.setBairro("Vila dos Ingleses");
		
		Aluno aluno2 = new Aluno();
		aluno2.setId(2L);
		aluno2.setNome("Camila Rezende");
		aluno2.setCpf("34265476892");
		aluno2.setDataDeNascimento(LocalDate.now());
		aluno2.setBairro("Vila Carol");
		
		alunoRepository.saveAll(Arrays.asList(aluno1, aluno2));
		
		Matricula matricula1 = new Matricula();
		matricula1.setId(1L);
		matricula1.setAluno(aluno1);
		
		Matricula matricula2 = new Matricula();
		matricula2.setId(2L);
		matricula2.setAluno(aluno2);
		
		matriculaRepository.saveAll(Arrays.asList(matricula1, matricula2));
		
		AvaliacaoFisica av1 = new AvaliacaoFisica();
		av1.setId(1L);
		av1.setAluno(aluno1);
		av1.setAltura(1.87);
		av1.setDataDaAvaliacao(LocalDateTime.now());
		av1.setPeso(88.0);
		
		AvaliacaoFisica av2 = new AvaliacaoFisica();
		av2.setId(2L);
		av2.setAluno(aluno2);
		av2.setAltura(1.68);
		av2.setDataDaAvaliacao(LocalDateTime.now());
		av2.setPeso(79.0);
		
		AvaliacaoFisica av3 = new AvaliacaoFisica();
		av3.setId(3L);
		av3.setAluno(aluno2);
		av3.setAltura(1.68);
		av3.setDataDaAvaliacao(LocalDateTime.now());
		av3.setPeso(75.0);
		
		avaliacaoFisicaRepository.saveAll(Arrays.asList(av1, av2, av3));
		
	}

}
