package org.grupo3.proyect.services;

import org.grupo3.proyect.models.Comentario;


import java.util.List;

public interface ComentarioService {

    List<Comentario> listaDeComentarios();

    Comentario buscarComentarioPorId(Long id);

    Comentario guardarComentario(Comentario comentarioNuevo, Long id);

    void borrarComentario(Long id);

    Comentario editarComentarioPorId(Long id, Comentario comentarioActualizado);
}
