package com.edutech.support.service;

import com.edutech.support.model.Solicitud;
import com.edutech.support.model.SoporteTecnico;
import com.edutech.support.repository.SolicitudRepository;
import com.edutech.support.repository.SoporteTecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogisticaService {
    @Autowired
    private SolicitudRepository solicitudRepo;

    @Autowired
    private SoporteTecnicoRepository tecnicoRepo;

    // Solicitud
    public Solicitud crearSolicitud(Solicitud s) { return solicitudRepo.save(s); }
    public List<Solicitud> listarSolicitudes() { return solicitudRepo.findAll(); }
    public Optional<Solicitud> obtenerSolicitud(Long id) { return solicitudRepo.findById(id); }
    public Solicitud actualizarSolicitud(Solicitud s) { return solicitudRepo.save(s); }
    public void eliminarSolicitud(Long id) { solicitudRepo.deleteById(id); }

    // Soporte Técnico
    public SoporteTecnico crearTecnico(SoporteTecnico t) { return tecnicoRepo.save(t); }
    public List<SoporteTecnico> listarTecnicos() { return tecnicoRepo.findAll(); }
    public Optional<SoporteTecnico> obtenerTecnico(Long id) { return tecnicoRepo.findById(id); }
    public void eliminarTecnico(Long id) { tecnicoRepo.deleteById(id); }
}