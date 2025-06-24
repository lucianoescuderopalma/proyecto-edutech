package com.edutech.support.controller;

import com.edutech.support.model.Solicitud;
import com.edutech.support.model.SoporteTecnico;
import com.edutech.support.service.LogisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logistica")
public class LogisticaController {
    @Autowired
    private LogisticaService service;

    // Solicitudes
    @PostMapping("/solicitudes")
    public ResponseEntity<Solicitud> crearSolicitud(@RequestBody Solicitud s) {
        return ResponseEntity.ok(service.crearSolicitud(s));
    }

    @GetMapping("/solicitudes")
    public ResponseEntity<List<Solicitud>> listarSolicitudes() {
        return ResponseEntity.ok(service.listarSolicitudes());
    }

    @PutMapping("/solicitudes/{id}")
    public ResponseEntity<Solicitud> actualizarSolicitud(@PathVariable Long id, @RequestBody Solicitud s) {
        s.setId(id);
        return ResponseEntity.ok(service.actualizarSolicitud(s));
    }

    @DeleteMapping("/solicitudes/{id}")
    public ResponseEntity<Void> eliminarSolicitud(@PathVariable Long id) {
        service.eliminarSolicitud(id);
        return ResponseEntity.noContent().build();
    }

    // Técnicos
    @PostMapping("/tecnicos")
    public ResponseEntity<SoporteTecnico> crearTecnico(@RequestBody SoporteTecnico t) {
        return ResponseEntity.ok(service.crearTecnico(t));
    }

    @GetMapping("/tecnicos")
    public ResponseEntity<List<SoporteTecnico>> listarTecnicos() {
        return ResponseEntity.ok(service.listarTecnicos());
    }

    @DeleteMapping("/tecnicos/{id}")
    public ResponseEntity<Void> eliminarTecnico(@PathVariable Long id) {
        service.eliminarTecnico(id);
        return ResponseEntity.noContent().build();
    }
}
