package com.edutech.course.manager.controller;

import com.edutech.course.manager.model.Curso;
import com.edutech.course.manager.service.CursoService; // Asegúrate de que este import exista

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping
    public ResponseEntity<Curso> crear(@RequestBody Curso c) {
        return ResponseEntity.ok(service.crear(c));
    }

    @GetMapping
    public ResponseEntity<List<Curso>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizar(@PathVariable Long id, @RequestBody Curso c) {
        c.setId(id);
        return ResponseEntity.ok(service.actualizar(c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/aprobar")
    public ResponseEntity<Curso> aprobar(@PathVariable Long id) {
        return ResponseEntity.ok(service.aprobarContenido(id));
    }
}
