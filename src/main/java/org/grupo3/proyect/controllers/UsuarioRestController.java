package org.grupo3.proyect.controllers;

import org.grupo3.proyect.models.Usuario;
import org.grupo3.proyect.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/lista")
    public List<Usuario> listadeUsuarios() {
        List<Usuario> listaMostrar = usuarioService.listaDeUsuarios();
        return listaMostrar;
    }

    @GetMapping("/buscar/{id}")
    public Usuario usuarioPorId(@PathVariable Long id) {
        Usuario usuarioMostrar = usuarioService.buscarUsuarioPorId(id);
        return usuarioMostrar;
    }

    @PostMapping("/nuevo")
    public Usuario guardarNuevoUsuario(@RequestBody Usuario usuarioNuevo) {
        Usuario usuarioParaGuardar = usuarioService.guardarUsuario(usuarioNuevo);
        return usuarioParaGuardar;
    }

    //Para borrar
    @DeleteMapping("/borrar")
    public String borrarUsuarioPorId(@RequestParam Long id) {
        usuarioService.borrarUsuario(id);
        return "El usuario ha sido borrado";
    }

    //Para editar
    @PutMapping("/editar/{id}")
    public Usuario editarUsuarioPorId(@PathVariable Long id,
                                      @RequestBody Usuario usuarioActualizado) {
        Usuario usuarioEditado = usuarioService.editarUsuarioPorId(id,
                usuarioActualizado);

        return usuarioEditado;
    }
}
