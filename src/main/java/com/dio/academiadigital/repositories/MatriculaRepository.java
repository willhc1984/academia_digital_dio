package com.dio.academiadigital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.academiadigital.entities.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long>{

}
