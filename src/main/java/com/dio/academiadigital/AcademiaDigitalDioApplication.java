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
		aluno1.setNome("Maria Maromba");
		aluno1.setCpf("33225487598");
		aluno1.setDataDeNascimento(LocalDate.of(1999, 6, 7));
		aluno1.setBairro("Vila dos Ingleses");
		
		Aluno aluno2 = new Aluno();
		aluno2.setId(2L);
		aluno2.setNome("João da Bomba");
		aluno2.setCpf("14785632547");
		aluno2.setDataDeNascimento(LocalDate.of(1998, 8, 12));
		aluno2.setBairro("Vila Carol");
		
		Aluno aluno3 = new Aluno();
		aluno3.setId(3L);
		aluno3.setNome("Felipe Frango");
		aluno3.setCpf("33654125896");
		aluno3.setDataDeNascimento(LocalDate.of(2002, 9, 15));
		aluno3.setBairro("Vila Jardini");
		
		Aluno aluno4 = new Aluno();
		aluno4.setId(4L);
		aluno4.setNome("Graciane Barbosa");
		aluno4.setCpf("32587456932");
		aluno4.setDataDeNascimento(LocalDate.of(1996, 12, 15));
		aluno4.setBairro("Mineirão");
		
		alunoRepository.saveAll(Arrays.asList(aluno1, aluno2, aluno3, aluno4));
		
		Matricula matricula1 = new Matricula();
		matricula1.setId(1L);
		matricula1.setDataDaMatricula(LocalDate.now());
		matricula1.setAluno(aluno1);
		
		Matricula matricula2 = new Matricula();
		matricula2.setId(2L);
		matricula2.setDataDaMatricula(LocalDate.now());
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
