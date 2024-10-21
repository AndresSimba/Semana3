package com.uisarel.relaciones.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private BigDecimal total;
    @ManyToOne
    private Proveedor proveedor;

}