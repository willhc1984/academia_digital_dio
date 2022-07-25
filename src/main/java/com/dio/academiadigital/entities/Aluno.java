package com.dio.academiadigital.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
	
	private Long id;
	private String nome;
	private String cpf;
	private String bairro;
	private LocalDate dataDeNascimento;
	
	private AvaliacaoFisica avaliacaoFisica;
	
	
}
