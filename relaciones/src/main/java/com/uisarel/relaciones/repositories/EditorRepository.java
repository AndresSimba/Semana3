package com.uisarel.relaciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uisarel.relaciones.entities.Editor;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Long> {
}