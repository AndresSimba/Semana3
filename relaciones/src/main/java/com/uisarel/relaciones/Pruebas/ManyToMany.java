package com.uisarel.relaciones.Pruebas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.uisarel.relaciones.entities.Alumno;
import com.uisarel.relaciones.entities.Curso;
import com.uisarel.relaciones.repositories.AlumnoRepository;
import com.uisarel.relaciones.repositories.CursoRepository;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class ManyToMany implements CommandLineRunner {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Override
    public void run(String... args) throws Exception {
        Alumno alumno1 = new Alumno();
        alumno1.setNombre("Alumno 1");
        Alumno alumno2 = new Alumno();
        alumno2.setNombre("Alumno 2");
        Curso curso1 = new Curso();
        curso1.setNombre("Curso1");
        Curso curso2 = new Curso();
        curso2.setNombre("Curso2");
        alumno1.getCursos().add(curso1);
        alumno2.getCursos().add(curso2);
        alumno2.getCursos().add(curso1);
        alumnoRepository.save(alumno1);
        alumnoRepository.save(alumno2);
        Alumno alumnoRecuperado = alumnoRepository.findById(1L).orElse(null);
        System.out.println("Alumno recuperado: " + alumnoRecuperado.getNombre());

        Curso cursoRecuperado = cursoRepository.findById(1L).orElse(null);
        System.out.println("Curso recuperado: " + cursoRecuperado.getNombre());

        alumnoRepository.deleteById(1L);
        cursoRepository.deleteById(1L);
    }
}