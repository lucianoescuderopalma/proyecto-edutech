package com.edutech.administradormaterial.service;

import com.edutech.administradormaterial.model.Evaluacion;
import com.edutech.administradormaterial.repository.EvaluacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvaluacionServicio {

    @Autowired
    private EvaluacionRepositorio repositorio;

    public List<Evaluacion> listarTodas() {
        return repositorio.findAll();
    }

    public List<Evaluacion> listarPorCurso(Long idCurso) {
        return repositorio.findByIdCurso(idCurso);
    }

    public Optional<Evaluacion> obtenerPorId(Long id) {
        return repositorio.findById(id);
    }

    public Evaluacion guardar(Evaluacion evaluacion) {
        return repositorio.save(evaluacion);
    }

    public Evaluacion actualizar(Evaluacion evaluacion) {
        return repositorio.save(evaluacion);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

    public Evaluacion publicarEvaluacion(Long id) {
        Evaluacion evaluacion = repositorio.findById(id).orElseThrow();
        evaluacion.setPublicada(true);
        return repositorio.save(evaluacion);
    }
}
