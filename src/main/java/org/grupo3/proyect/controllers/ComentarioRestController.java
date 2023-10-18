package org.grupo3.proyect.controllers;

import org.grupo3.proyect.DTO.comentarioDTO;
import org.grupo3.proyect.models.Comentario;
import org.grupo3.proyect.models.Post;
import org.grupo3.proyect.models.Usuario;
import org.grupo3.proyect.repositories.UsuarioRepository;
import org.grupo3.proyect.services.ComentarioService;
import org.grupo3.proyect.services.ComentarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/comentario")
public class ComentarioRestController {

    @Autowired
    ComentarioServiceImpl comentarioService;


    @GetMapping("/lista")
    public List<Comentario> listadeComentarios() {
        List<Comentario> listaMostrar = comentarioService.listaDeComentarios();
        return listaMostrar;
    }
    @GetMapping("/lista/PorFecha")
    public List<comentarioDTO> getComentariosByFechaDesc(){
        List<comentarioDTO> listaPorFecha = comentarioService.getComentariosByFechaDesc();
        return listaPorFecha;
    }

    @GetMapping("/buscar/{id}")
    public Comentario comentarioPorId(@PathVariable Long id) {
        Comentario comentarioMostrar = comentarioService.buscarComentarioPorId(id);
        return comentarioMostrar;
    }

   /*@PostMapping("/nuevo")
    public Comentario guardarNuevoComentario(@RequestBody Comentario comentarioNuevo) {
        Usuario usuario = comentarioNuevo.getUsuario(); // Obtiene el usuario del comentario
        usuarioRepository.save(usuario); // Guarda el usuario en la base de datos
        Comentario comentarioParaGuardar = comentarioService.guardarComentario(comentarioNuevo);
        return comentarioParaGuardar;
    }*/

    @PostMapping("/{id}/nuevo")
    public Comentario guardarNuevoComentario(@RequestParam Long id, @RequestBody Comentario comentarioNuevo) {
        Comentario comentarioParaGuardar = comentarioService.guardarComentario(comentarioNuevo, id);
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
