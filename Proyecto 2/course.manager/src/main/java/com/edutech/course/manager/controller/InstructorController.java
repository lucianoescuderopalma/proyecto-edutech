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
}
