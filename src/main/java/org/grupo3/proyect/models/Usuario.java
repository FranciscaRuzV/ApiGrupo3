package org.grupo3.proyect.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data //Le puse el Data para hacerlo mas clean y no poner los getter setter y constructores.
@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @Column(name = "nombreUsuario")
    @NotNull
    private String usuarioNombre;

    @Min(value = 18, message = "La edad minima para el registro son 18 años")
    @NotNull
    private Integer usuarioEdad;

    @Email(message = "Introduce tu correo electronico")
    @NotNull
    private String email;

    @Column(name = "fechaDeNacimiento") // este puede ser borrado y solo quedamos con la edadUsuario
    @NotNull
    private String fechaDeNacimientoUsuario;

    @Column(name = "fechaDeCreacionUsuario")
    @NotNull
    private String fechaRegistroUsuario; //Lo puse como String por los caracteres tipo / , asi puede ser 09/sep/1990 x ejemplo.

    @Column(name = "Password")
    @NotNull
    private String contraseniaUsuario; //Aqui deberiamos ver si es passwordAunth en vez de String, me queda esa duda.

}
