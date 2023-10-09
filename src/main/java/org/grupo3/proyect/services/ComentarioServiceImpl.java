package org.grupo3.proyect.services;

import jakarta.transaction.Transactional;
import org.grupo3.proyect.models.Comentario;
import org.grupo3.proyect.repositories.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    ComentarioRepository comentarioRepository;

    @Override
    public List<Comentario> listaDeComentarios() {
        return comentarioRepository.findAll();
    }

    @Override
    public Comentario buscarComentarioPorId(Long id){
        Boolean existe = comentarioRepository.existsById(id);

        if (existe) {
            Comentario comentarioEscogido = comentarioRepository.findById(id).get();
            return comentarioEscogido;
        } else {
            System.out.println("El id es inválido o no existe");
            return null;
        }
    }


    @Override
    public Comentario guardarComentario(Comentario comentarioNuevo) {

        return comentarioRepository.save(comentarioNuevo);
    }

    @Override
    public void borrarComentario(Long id) {
        comentarioRepository.deleteById(id);

    }

    @Override
    public Comentario editarComentarioPorId(Long id, Comentario comentarioActualizado){
        Boolean existe = comentarioRepository.existsById(id);

        if (existe) {
            Comentario comentarioSeleccionado = comentarioRepository.findById(id).get();
            comentarioSeleccionado.setComentarioId(comentarioActualizado.getComentarioId());
            comentarioSeleccionado.setComentarioTexto(comentarioActualizado.getComentarioTexto());
            comentarioSeleccionado.setComentarioFecha(comentarioActualizado.getComentarioFecha());
            System.out.println("El post ha sido actualizado");
            return comentarioRepository.save(comentarioSeleccionado);
        } else {
            System.out.println("El post no existe o el id es inválido");
            return null;
        }
    }
}
