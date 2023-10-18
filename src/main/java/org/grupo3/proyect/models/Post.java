package org.grupo3.proyect.models;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Data
@Table

public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @JsonFormat(pattern = "dd.MM.YYYY")
    @CreationTimestamp //Indica que el atributo siguiente es una fecha de creación
    private LocalDateTime createdAt;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    //Creamos el atributo que corresponde a un objeto de clase Curso
    private Usuario usuario;

    private String postTitulo;
    private String postTexto;
    private String postImagen;
    private String postVideo;

    @JsonManagedReference
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comentario> postComentario;

}