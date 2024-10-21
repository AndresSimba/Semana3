package com.uisarel.relaciones.repositories;

import com.uisarel.relaciones.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    @Query("SELECT c FROM Compra c WHERE c.proveedor.nombre = :nombreProveedor AND c.fecha BETWEEN :fechaInicio AND :fechaFin")
    List<Compra> findComprasByProveedorAndFecha(@Param("nombreProveedor") String nombreProveedor, @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);
}