package com.dio.academiadigital.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisica {
	
	private Long id;
	private Aluno aluno;
	private LocalDateTime dataDaAvaliacao;
	private Double peso;
	private Double altura;

}
