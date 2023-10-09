package org.grupo3.proyect.models;


import java.util.HashSet;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comentario> comentarioPost;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    //Creamos el atributo que corresponde a un objeto de clase Curso
    private Usuario usuario;

    private String postTitulo;
    private String postTexto;
    private String postFecha;
    private String postImagen;
    private String postVideo;


}