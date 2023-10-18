package org.grupo3.proyect.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Table
@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comentarioId;

    @JsonFormat(pattern = "dd.MM.YYYY")
    @CreationTimestamp //Indica que el atributo siguiente es una fecha de creación
    private LocalDateTime createdAt;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    //Creamos el atributo que corresponde a un objeto de clase Curso
    private Post post;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;


    private String comentarioTexto;


}
