package com.edutech.course.manager.service;

import com.edutech.course.manager.model.Curso;
import com.edutech.course.manager.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repo;

    public Curso crear(Curso curso) { return repo.save(curso); }
    public List<Curso> listar() { return repo.findAll(); }
    public Optional<Curso> obtener(Long id) { return repo.findById(id); }
    public void eliminar(Long id) { repo.deleteById(id); }
    public Curso actualizar(Curso c) { return repo.save(c); }
    public Curso aprobarContenido(Long id) {
        Curso c = repo.findById(id).orElseThrow();
        c.setAprobado(true);
        return repo.save(c);
    }
}
