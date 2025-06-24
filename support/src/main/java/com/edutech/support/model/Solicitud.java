package com.edutech.support.model;


import jakarta.persistence.*;

@Entity
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private String estado; // pendiente, en_proceso, resuelto

    @ManyToOne
    private SoporteTecnico tecnicoAsignado;

    // === Getters y Setters ===

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public SoporteTecnico getTecnicoAsignado() {
        return tecnicoAsignado;
    }

    public void setTecnicoAsignado(SoporteTecnico tecnicoAsignado) {
        this.tecnicoAsignado = tecnicoAsignado;
    }
}
