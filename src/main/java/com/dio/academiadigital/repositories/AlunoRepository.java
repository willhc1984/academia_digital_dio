package com.dio.academiadigital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.academiadigital.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
