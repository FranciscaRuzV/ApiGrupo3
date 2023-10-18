package org.grupo3.proyect.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.grupo3.proyect.models.Comentario;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class postDTO {

    private String postTitulo;
    @JsonFormat(pattern = "dd.MM.YYYY")
    @CreationTimestamp //Indica que el atributo siguiente es una fecha de creación
    private LocalDateTime createdAt;
    private String postTexto;
    private String postImagen;
    private String postVideo;
    private String usuarioNombre;

}
