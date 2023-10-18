package org.grupo3.proyect.repositories;

import org.grupo3.proyect.models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    @Query(value = "SELECT * FROM Comentario ORDER BY created_at DESC", nativeQuery = true)
    List<Comentario> findAllByFechaDesc();
}
