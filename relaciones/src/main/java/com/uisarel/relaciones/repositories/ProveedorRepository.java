package com.uisarel.relaciones.repositories;

import com.uisarel.relaciones.entities.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    @Query("SELECT DISTINCT p.proveedor FROM Producto p WHERE p.categoria.nombre = :nombreCategoria")
    List<Proveedor> findProveedoresByCategoriaProducto(@Param("nombreCategoria") String nombreCategoria);
}