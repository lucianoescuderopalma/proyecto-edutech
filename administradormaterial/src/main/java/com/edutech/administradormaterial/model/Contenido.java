package com.edutech.administradormaterial.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Contenido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idCurso;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(length = 500)
    private String descripcion;

    @Column(nullable = false)
    private String urlArchivo;

    @Column(nullable = false, length = 50)
    private String tipoContenido; // PDF, VIDEO, DOCUMENTO, etc.

    @Column(nullable = false)
    private LocalDateTime fechaSubida = LocalDateTime.now();

    private LocalDateTime fechaUltimaActualizacion;

    @Column(nullable = false)
    private boolean activo = true;

    @ManyToOne
    @JoinColumn(name = "curso_id", referencedColumnName = "id")
    private Curso curso;

    @PreUpdate
    public void preUpdate() {
        this.fechaUltimaActualizacion = LocalDateTime.now();
    }
}