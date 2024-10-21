package com.uisarel.relaciones.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomnbre;
    @OneToOne
    @JoinColumn(name = "dirrecion_id", referencedColumnName = "id")
    private Direccion direccion;
}