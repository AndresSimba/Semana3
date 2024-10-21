package com.uisarel.relaciones.repositories;

import com.uisarel.relaciones.entities.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {

    @Query("SELECT i FROM Inventario i WHERE i.cantidad < :cantidadMinima")
    List<Inventario> findInventariosByCantidadMenor(@Param("cantidadMinima") int cantidadMinima);
}