package com.uisarel.relaciones.Pruebas;

import com.uisarel.relaciones.entities.Direccion;
import com.uisarel.relaciones.entities.Estudiante;
import com.uisarel.relaciones.repositories.DireccionRepository;
import com.uisarel.relaciones.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class Prueba01 implements CommandLineRunner {
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private DireccionRepository direccionRepository;
    @Override
    public void run(String... arg)throws Exception{
        Direccion direccion = new Direccion();
        direccion.setCalle("El Inca");
        direccion.setCiudad("Quito");
        direccion.setCodigoPostal("123");
        direccionRepository.save(direccion);
        Estudiante estudiante = new Estudiante();
        estudiante.setNomnbre("William");
        estudiante.setDireccion(direccion);
        estudianteRepository.save(estudiante);
    }
    }
