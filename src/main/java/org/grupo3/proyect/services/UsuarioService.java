package org.grupo3.proyect.services;

import org.grupo3.proyect.models.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listaDeUsuarios();

    Usuario buscarUsuarioPorId(Long id);

    Usuario guardarUsuario(Usuario usuarioNuevo);

    void borrarUsuario(Long id);

    Usuario editarUsuarioPorId(Long id, Usuario usuarioActualizado);
}
