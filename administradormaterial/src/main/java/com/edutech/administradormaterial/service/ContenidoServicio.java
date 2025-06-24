package com.edutech.administradormaterial.service;

import com.edutech.administradormaterial.model.Contenido;
import com.edutech.administradormaterial.repository.ContenidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContenidoServicio {

    @Autowired
    private ContenidoRepositorio repositorio;

    public List<Contenido> listarTodos() {
        return repositorio.findAll();
    }

    public List<Contenido> listarPorCurso(Long idCurso) {
        return repositorio.findByIdCurso(idCurso);
    }

    public List<Contenido> listarContenidosActivosPorCurso(Long idCurso) {
        return repositorio.buscarContenidosActivosPorCurso(idCurso);
    }

    public Optional<Contenido> obtenerPorId(Long id) {
        return repositorio.findById(id);
    }

    public Contenido guardar(Contenido contenido) {
        contenido.setFechaSubida(LocalDateTime.now());
        return repositorio.save(contenido);
    }

    public Contenido actualizar(Contenido contenido) {
        contenido.setFechaUltimaActualizacion(LocalDateTime.now());
        return repositorio.save(contenido);
    }

    @Transactional
    public void desactivarContenido(Long id) {
        repositorio.actualizarEstado(id, false);
    }

    @Transactional
    public void activarContenido(Long id) {
        repositorio.actualizarEstado(id, true);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }

    public List<Contenido> buscarPorTipo(String tipoContenido) {
        return repositorio.findByTipoContenido(tipoContenido);
    }
}