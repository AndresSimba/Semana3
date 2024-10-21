package com.uisarel.relaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uisarel.relaciones.entities.Revista;

@Repository
public interface RevistaRepository extends JpaRepository<Revista, Long> {
}

