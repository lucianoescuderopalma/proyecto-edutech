package com.edutech.course.manager.service;

import com.edutech.course.manager.model.Instructor;
import com.edutech.course.manager.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository repo;

    public Instructor guardar(Instructor i) {
        return repo.save(i);
    }

    public List<Instructor> listar() {
        return repo.findAll();
    }
}

