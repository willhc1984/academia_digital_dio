package com.dio.academiadigital.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matricula {
	
	private Long id;
	private Aluno aluno;
	private LocalDateTime dataDaMatricula;
	
	

}
