package com.edutech.administradormaterial.controller;

import com.edutech.administradormaterial.model.*;
import com.edutech.administradormaterial.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gestor-cursos")
public class GestorCursosControlador {

    // Servicios
    @Autowired private ContenidoServicio contenidoServicio;
    @Autowired private EvaluacionServicio evaluacionServicio;
    @Autowired private ProgresoEstudianteServicio progresoServicio;
    @Autowired private InteraccionForoServicio foroServicio;

    // Endpoints para Contenido
    @GetMapping("/contenidos")
    public ResponseEntity<List<Contenido>> listarContenidos() {
        return ResponseEntity.ok(contenidoServicio.listarTodos());
    }

    @GetMapping("/contenidos/{id}")
    public ResponseEntity<Contenido> obtenerContenido(@PathVariable Long id) {
        return contenidoServicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/contenidos")
    public ResponseEntity<Contenido> crearContenido(@RequestBody Contenido contenido) {
        return ResponseEntity.ok(contenidoServicio.guardar(contenido));
    }

    @PutMapping("/contenidos/{id}")
    public ResponseEntity<Contenido> actualizarContenido(@PathVariable Long id, @RequestBody Contenido contenido) {
        contenido.setId(id);
        return ResponseEntity.ok(contenidoServicio.actualizar(contenido));
    }

    @DeleteMapping("/contenidos/{id}")
    public ResponseEntity<Void> eliminarContenido(@PathVariable Long id) {
        contenidoServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints para Evaluaciones
    @GetMapping("/evaluaciones")
    public ResponseEntity<List<Evaluacion>> listarEvaluaciones() {
        return ResponseEntity.ok(evaluacionServicio.listarTodas());
    }

    @GetMapping("/cursos/{idCurso}/evaluaciones")
    public ResponseEntity<List<Evaluacion>> listarEvaluacionesPorCurso(@PathVariable Long idCurso) {
        return ResponseEntity.ok(evaluacionServicio.listarPorCurso(idCurso));
    }

    @PostMapping("/evaluaciones")
    public ResponseEntity<Evaluacion> crearEvaluacion(@RequestBody Evaluacion evaluacion) {
        return ResponseEntity.ok(evaluacionServicio.guardar(evaluacion));
    }

    @PutMapping("/evaluaciones/{id}/publicar")
    public ResponseEntity<Evaluacion> publicarEvaluacion(@PathVariable Long id) {
        return ResponseEntity.ok(evaluacionServicio.publicarEvaluacion(id));
    }

    @DeleteMapping("/evaluaciones/{id}")
    public ResponseEntity<Void> eliminarEvaluacion(@PathVariable Long id) {
        evaluacionServicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoints para Progreso de Estudiantes
    @GetMapping("/progreso")
    public ResponseEntity<List<ProgresoEstudiante>> listarProgreso() {
        return ResponseEntity.ok(progresoServicio.listarTodos());
    }

    @GetMapping("/estudiantes/{idEstudiante}/progreso")
    public ResponseEntity<List<ProgresoEstudiante>> listarProgresoPorEstudiante(@PathVariable Long idEstudiante) {
        return ResponseEntity.ok(progresoServicio.listarPorEstudiante(idEstudiante));
    }

    @PutMapping("/progreso/{id}")
    public ResponseEntity<ProgresoEstudiante> actualizarProgreso(
            @PathVariable Long id,
            @RequestParam Double porcentaje) {
        return ResponseEntity.ok(progresoServicio.actualizarProgreso(id, porcentaje));
    }

    // Endpoints para Interacciones en Foro
    @GetMapping("/foro")
    public ResponseEntity<List<InteraccionForo>> listarInteraccionesForo() {
        return ResponseEntity.ok(foroServicio.listarTodas());
    }

    @PostMapping("/foro")
    public ResponseEntity<InteraccionForo> crearInteraccionForo(@RequestBody InteraccionForo interaccion) {
        return ResponseEntity.ok(foroServicio.guardar(interaccion));
    }

    @PostMapping("/foro/{id}/responder")
    public ResponseEntity<InteraccionForo> responderInteraccion(
            @PathVariable Long id,
            @RequestBody InteraccionForo respuesta) {
        return ResponseEntity.ok(foroServicio.responderMensaje(id, respuesta));
    }
}
