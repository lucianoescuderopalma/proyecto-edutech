package com.edutech.administradormaterial.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProgresoEstudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idEstudiante;
    private Long idCurso;
    private Double porcentajeCompletado;
    private Double calificacionFinal;
    private boolean cursoCompletado;
    private LocalDateTime fechaUltimoAcceso;

    @ManyToOne
    private Curso curso;

    @ManyToOne
    private Estudiante estudiante;
}