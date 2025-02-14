package com.uisarel.relaciones.repositories;

import com.uisarel.relaciones.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query("SELECT p FROM Producto p WHERE p.categoria.nombre = :nombreCategoria AND p.proveedor.nombre = :nombreProveedor")
    List<Producto> findProductosByCategoriaAndProveedor(@Param("nombreCategoria") String nombreCategoria,
                                                        @Param("nombreProveedor") String nombreProveedor);
}