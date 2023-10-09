package org.grupo3.proyect.controllers;

import org.grupo3.proyect.models.Comentario;
import org.grupo3.proyect.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentario")
public class ComentarioRestController {

    @Autowired
    ComentarioService comentarioService;

    @GetMapping("/lista")
    public List<Comentario> listadeComentarios() {
        List<Comentario> listaMostrar = comentarioService.listaDeComentarios();
        return listaMostrar;
    }
    @GetMapping("/buscar/{id}")
    public Comentario comentarioPorId(@PathVariable Long id) {
        Comentario comentarioMostrar = comentarioService.buscarComentarioPorId(id);
        return comentarioMostrar;
    }
    @PostMapping("/nuevo")
    public Comentario guardarNuevoComentario(@RequestBody Comentario comentarioNuevo) {
        Comentario comentarioParaGuardar = comentarioService.guardarComentario(comentarioNuevo);
        return comentarioParaGuardar;
    }
    @DeleteMapping("/borrar")
    public String borrarComentarioPorId(@RequestParam Long id) {
        comentarioService.borrarComentario(id);
        return "El comentario ha sido borrado";
    }
    @PutMapping("/editar/{id}")
    public Comentario editarComentarioPorId(@PathVariable Long id,
                                      @RequestBody Comentario comentarioActualizado) {
        Comentario comentarioEditado = comentarioService.editarComentarioPorId(id, comentarioActualizado);

        return comentarioEditado;
    }





}
