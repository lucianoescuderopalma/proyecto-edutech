package com.edutech.administradormaterial.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idCurso;
    private String titulo;
    private String descripcion;
    private LocalDateTime fechaLimite;
    private Double puntajeMaximo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private boolean publicada;

    @ManyToOne
    private Curso curso;
}