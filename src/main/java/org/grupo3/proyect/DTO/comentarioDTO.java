package org.grupo3.proyect.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class comentarioDTO {

    private String usuarioNombre;
    @JsonFormat(pattern = "dd.MM.YYYY")
    @CreationTimestamp //Indica que el atributo siguiente es una fecha de creación
    private LocalDateTime createdAt;
    private String comentarioTexto;
}
