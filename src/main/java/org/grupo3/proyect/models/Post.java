package org.grupo3.proyect.models;


import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;



    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    //Creamos el atributo que corresponde a un objeto de clase Curso
    private Usuario usuario;

    private String postTitulo;
    private String postTexto;
    private String postFecha;
    private String postImagen;
    private String postVideo;

    @JsonManagedReference
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comentario> postComentario;

}