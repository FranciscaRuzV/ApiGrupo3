package org.grupo3.proyect.repositories;


import org.grupo3.proyect.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}