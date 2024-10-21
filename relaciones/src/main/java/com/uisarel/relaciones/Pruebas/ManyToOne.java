package com.uisarel.relaciones.Pruebas;


import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.uisarel.relaciones.entities.Editor;
import com.uisarel.relaciones.entities.Revista;
import com.uisarel.relaciones.repositories.EditorRepository;
import com.uisarel.relaciones.repositories.RevistaRepository;

@Component
public class ManyToOne implements CommandLineRunner {
    @Autowired
    private EditorRepository editorRepository;
    @Autowired
    private RevistaRepository revistaRepository;
    @Override
    public void run(String... args) throws Exception {

        Editor editor = new Editor();
        editor.setNombre("Editorial XYZ");
        editorRepository.save(editor);
        Revista revista1 = new Revista();
        revista1.setNombre("Revista A");
        revista1.setEditor(editor);
        editor.getRevistas().add(revista1);
        Revista revista2 = new Revista();
        revista2.setNombre("Revista B");
        revista2.setEditor(editor);
        editor.getRevistas().add(revista2);
        editorRepository.save(editor);


        Optional<Editor> editorGuardado = editorRepository.findById(editor.getId());
        if (editorGuardado.isPresent()) {
            Editor editorObtenido = editorGuardado.get();
            System.out.println("Editor obtenido: " + editorObtenido.getNombre());
            editorObtenido.getRevistas().size();
            editorObtenido.setNombre("Editorial ABC");
            editorRepository.save(editorObtenido);
            System.out.println("Editor actualizado: " + editorObtenido.getNombre());


            Revista revista3 = new Revista();
            revista3.setNombre("Revista C");
            revista3.setEditor(editorObtenido);
            revistaRepository.save(revista3);
            System.out.println("Revista creada: " + revista3.getNombre());

            Optional<Revista> revistaOptional = revistaRepository.findById(revista1.getId());
            if (revistaOptional.isPresent()) {
                Revista revistaEliminar = revistaOptional.get();
                revistaRepository.delete(revistaEliminar);
                System.out.println("Revista eliminada: " + revistaEliminar.getNombre());
            } else {
                System.out.println("Revista no encontrada");
            }
        } else {
            System.out.println("Editor no encontrado");
        }
        List<Editor> editores = editorRepository.findAll();
        System.out.println("Lista de Editores:");
        for (Editor e : editores) {
            System.out.println("-" + e.getNombre());
        }
        editorRepository.delete(editor);
        System.out.println("Editor eliminado");
    }
}
