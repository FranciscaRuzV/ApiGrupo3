package org.grupo3.proyect.repositories;

import org.grupo3.proyect.models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
