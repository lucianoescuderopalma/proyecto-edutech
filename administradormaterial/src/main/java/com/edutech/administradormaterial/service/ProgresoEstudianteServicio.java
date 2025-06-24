package com.edutech.administradormaterial.service;

import com.edutech.administradormaterial.model.ProgresoEstudiante;
import com.edutech.administradormaterial.repository.ProgresoEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgresoEstudianteServicio {

    @Autowired
    private ProgresoEstudianteRepositorio repositorio;

    public List<ProgresoEstudiante> listarTodos() {
        return repositorio.findAll();
    }

    public List<ProgresoEstudiante> listarPorEstudiante(Long idEstudiante) {
        return repositorio.findByIdEstudiante(idEstudiante);
    }

    public List<ProgresoEstudiante> listarPorCurso(Long idCurso) {
        return repositorio.findByIdCurso(idCurso);
    }

    public Optional<ProgresoEstudiante> obtenerPorId(Long id) {
        return repositorio.findById(id);
    }

    public ProgresoEstudiante guardar(ProgresoEstudiante progreso) {
        return repositorio.save(progreso);
    }

    public ProgresoEstudiante actualizar(ProgresoEstudiante progreso) {
        return repositorio.save(progreso);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

    public ProgresoEstudiante actualizarProgreso(Long id, Double porcentaje) {
        ProgresoEstudiante progreso = repositorio.findById(id).orElseThrow();
        progreso.setPorcentajeCompletado(porcentaje);
        return repositorio.save(progreso);
    }
}