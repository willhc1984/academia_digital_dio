package com.dio.academiadigital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoFisica extends JpaRepository<AvaliacaoFisica, Long>{

}
