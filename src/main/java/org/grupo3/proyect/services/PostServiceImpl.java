package org.grupo3.proyect.services;

import jakarta.transaction.Transactional;
import org.grupo3.proyect.models.Post;
import org.grupo3.proyect.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;


    @Override
    public List<Post> listaDePosts() {
        return postRepository.findAll();
    }

    @Override
    public Post buscarPostPorId(Long id) {
        Boolean existe = postRepository.existsById(id);

        if (existe) {
            Post postEscogido = postRepository.findById(id).get();
            return postEscogido;
        } else {
            System.out.println("El id es inválido o no existe");
            return null;
        }
    }

    @Override
    public Post guardarPost(Post postNuevo) {

        return postRepository.save(postNuevo);
    }

    @Override
    public void borrarPost(Long id) {
        postRepository.deleteById(id);

    }

    @Override
    public Post editarPostPorId(Long id, Post postActualizado) {
        Boolean existe = postRepository.existsById(id);

        if (existe) {
            Post postSeleccionado = postRepository.findById(id).get();
            postSeleccionado.setPostTitulo(postActualizado.getPostTitulo());
            postSeleccionado.setPostTexto(postActualizado.getPostTexto());
            postSeleccionado.setPostImagen(postActualizado.getPostImagen());
            postSeleccionado.setPostVideo(postActualizado.getPostVideo());
            System.out.println("El post ha sido actualizado");
            return postRepository.save(postSeleccionado);
        } else {
            System.out.println("El post no existe o el id es inválido");
            return null;
        }
    }

    public List<Post> getPostsByFechaDesc() {
        return postRepository.findAllByFechaDesc();
    }

}
