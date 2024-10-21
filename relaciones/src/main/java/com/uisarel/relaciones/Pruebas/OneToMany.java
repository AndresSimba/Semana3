package com.uisarel.relaciones.Pruebas;

import com.uisarel.relaciones.entities.Autor;
import com.uisarel.relaciones.entities.Libro;
import com.uisarel.relaciones.repositories.AutorRepository;
import com.uisarel.relaciones.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
@Component
public class OneToMany implements CommandLineRunner {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private LibroRepository libroRepository;
    @Override
    public void run(String... args) throws Exception {
        Autor autor = new Autor();
        autor.setNombre("Nombre 03");
        Libro libro1 = new Libro();
        libro1.setTitulo("Titulo 03");
        Libro libro2 = new Libro();
        libro2.setTitulo("Titulo 03");
        autor.getLibros().add(libro1);
        autor.getLibros().add(libro2);
        autorRepository.save(autor);

        Optional<Autor> autorGuardado = autorRepository.findById(autor.getId());

        autorGuardado.ifPresent(a -> {
            System.out.println("Autor Leído por ID: " + a.getNombre());
            a.setNombre("Nuevo nombre del autor");
            autorRepository.save(a);
            System.out.println("Autor Actualizado: " + a.getNombre());
        });

        List<Autor> autores = autorRepository.findAll();
        System.out.println("Lista de Autores");
        for (Autor a : autores) {
            System.out.println("-" + a.getNombre());
        }

        autorRepository.delete(autor);
        System.out.println("Autor Eliminado");
    }
}
