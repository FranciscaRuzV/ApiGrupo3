package org.grupo3.proyect.controllers;

import org.grupo3.proyect.models.Post;
import org.grupo3.proyect.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostRestController {
    @Autowired
    PostService postService;

    @GetMapping("/lista")
    public List<Post> listaDePosts( ){
    List<Post> listaMostrar = postService.listaDePosts();
    return listaMostrar; }

    @GetMapping("/buscar/{id}")
    public Post postPorId(@PathVariable Long id) {
        Post postMostrar = postService.buscarPostPorId(id);
        return postMostrar;
    }

    @PostMapping("/nuevo")
    public Post guardarNuevoPost(@RequestBody Post postNuevo) {
        Post postParaGuardar = postService.guardarPost(postNuevo);
        return postParaGuardar;
    }


    @DeleteMapping("/borrar")
    public String borrarPostPorId(@RequestParam Long id) {
        postService.borrarPost(id);
        return "El comentario ha sido borrado";
    }
    @PutMapping("/editar/{id}")
    public Post editarPostPorId(@PathVariable Long id,
                                            @RequestBody Post postActualizado) {
        Post postEditado = postService.editarPostPorId(id, postActualizado);

        return postEditado;
    }











}
