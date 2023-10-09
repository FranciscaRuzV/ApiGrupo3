package org.grupo3.proyect.repositories;

import org.grupo3.proyect.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
