package org.grupo3.proyect.services;

import jakarta.persistence.Id;
import org.grupo3.proyect.models.Comentario;
import org.grupo3.proyect.models.Post;
import org.grupo3.proyect.models.Usuario;

import java.util.List;

public interface PostService {
    List<Post> listaDePosts();

    Post buscarPostPorId(Long Id);

    Post guardarPost(Post postNuevo);

    void borrarPost(Long id);

    Post editarPostPorId(Long id, Post postActualizado);
}
