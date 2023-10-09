package org.grupo3.proyect.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Table
@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comentarioId;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    //Creamos el atributo que corresponde a un objeto de clase Curso
    private Post post;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    //Creamos el atributo que corresponde a un objeto de clase Curso
    private Usuario usuario;

    private String comentarioTexto;

    private String comentarioFecha;
}
