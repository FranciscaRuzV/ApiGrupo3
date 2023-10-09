package org.grupo3.proyect.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@Table
@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comentarioId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    //Creamos el atributo que corresponde a un objeto de clase Curso
    private Post post;

    //Creamos el atributo que corresponde a un objeto de clase Curso

    private String comentarioTexto;

    private String comentarioFecha;
}
