package com.edutech.course.manager.service;

import com.edutech.course.manager.model.Instructor;
import com.edutech.course.manager.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Instructor buscarPorId(Long id) {
        Optional<Instructor> resultado = repo.findById(id);
        return resultado.orElse(null);  // devuelve null si no existe
    }

    public Instructor actualizar(Long id, Instructor nuevoDatos) {
        Optional<Instructor> existente = repo.findById(id);
        if (existente.isPresent()) {
            Instructor inst = existente.get();
            inst.setNombre(nuevoDatos.getNombre());
            inst.setEspecialidad(nuevoDatos.getEspecialidad());
            // Agrega aquí más campos si tienes
            return repo.save(inst);
        } else {
            return null;
        }
    }

    public boolean eliminar(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
