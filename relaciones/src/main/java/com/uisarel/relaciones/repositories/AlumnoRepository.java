package com.uisarel.relaciones.repositories;

import com.uisarel.relaciones.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository
        extends JpaRepository<Alumno, Long> {
}