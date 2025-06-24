package com.edutech.administradormaterial.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class InteraccionForo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idCurso;
    private Long idEstudiante;
    private Long idInstructor;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private boolean esRespuesta;
    private Long idMensajePadre;

    @ManyToOne
    private Curso curso;

    @ManyToOne
    private Estudiante estudiante;

    @ManyToOne
    private Instructor instructor;
}