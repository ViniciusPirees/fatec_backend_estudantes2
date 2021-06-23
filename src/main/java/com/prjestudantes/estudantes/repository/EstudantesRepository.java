package com.prjestudantes.estudantes.repository;

import com.prjestudantes.estudantes.entities.Estudantes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudantesRepository extends JpaRepository <Estudantes,Long>{
    
}
