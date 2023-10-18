package org.grupo3.proyect.services;

import jakarta.transaction.Transactional;
import org.grupo3.proyect.DTO.comentarioDTO;
import org.grupo3.proyect.DTO.postDTO;
import org.grupo3.proyect.models.Comentario;
import org.grupo3.proyect.models.Post;
import org.grupo3.proyect.models.Usuario;
import org.grupo3.proyect.repositories.ComentarioRepository;
import org.grupo3.proyect.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    ComentarioRepository comentarioRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

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
    public Comentario guardarComentario(Comentario comentarioNuevo, Long id) {
        Usuario usuarioComentario = usuarioRepository.findById(id).get();
        comentarioNuevo.setUsuario(usuarioComentario);
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
            System.out.println("El post ha sido actualizado");
            return comentarioRepository.save(comentarioSeleccionado);
        } else {
            System.out.println("El post no existe o el id es inválido");
            return null;
        }
    }

    public List<comentarioDTO> getComentariosByFechaDesc() {
        List<Comentario> listaDeComentario = comentarioRepository.findAllByFechaDesc();
        List<comentarioDTO> listaDeComentarioParaMostrar = new ArrayList<>();
        for(int i = 0; i< listaDeComentario.size(); i++){
            comentarioDTO comentarioPublicar = new comentarioDTO();
            Comentario comentario = listaDeComentario.get(i);
            comentarioPublicar.setCreatedAt(comentario.getCreatedAt());
            comentarioPublicar.setComentarioTexto(comentario.getComentarioTexto());
            comentarioPublicar.setUsuarioNombre(comentario.getUsuario().getUsuarioNombre());
            listaDeComentarioParaMostrar.add(comentarioPublicar);
        }
        return listaDeComentarioParaMostrar;
    }
}
