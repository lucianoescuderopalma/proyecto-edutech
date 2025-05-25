package com.edutech.course.manager.controller;

import com.edutech.course.manager.model.Instructor;
import com.edutech.course.manager.service.InstructorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructores")
public class InstructorController {

    @Autowired
    private InstructorService service;

    @PostMapping
    public ResponseEntity<Instructor> guardar(@RequestBody Instructor i) {
        return ResponseEntity.ok(service.guardar(i));
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> obtenerPorId(@PathVariable Long id) {
        Instructor instructor = service.buscarPorId(id);
        if (instructor != null) {
            return ResponseEntity.ok(instructor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> actualizar(@PathVariable Long id, @RequestBody Instructor datos) {
        Instructor instructorActualizado = service.actualizar(id, datos);
        if (instructorActualizado != null) {
            return ResponseEntity.ok(instructorActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = service.eliminar(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

