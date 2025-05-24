package com.edutech.course.manager.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private boolean aprobado;

    @ManyToOne
    private Instructor instructor;
}
