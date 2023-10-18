package org.grupo3.proyect.repositories;

import org.grupo3.proyect.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT * FROM Post ORDER BY created_at DESC", nativeQuery = true)
    List<Post> findAllByFechaDesc();
}
