package com.edutech.administradormaterial.service;

import com.edutech.administradormaterial.model.InteraccionForo;
import com.edutech.administradormaterial.repository.InteraccionForoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InteraccionForoServicio {

    @Autowired
    private InteraccionForoRepositorio repositorio;

    public List<InteraccionForo> listarTodas() {
        return repositorio.findAll();
    }

    public List<InteraccionForo> listarPorCurso(Long idCurso) {
        return repositorio.findByIdCurso(idCurso);
    }

    public List<InteraccionForo> listarRespuestas(Long idMensajePadre) {
        return repositorio.findByIdMensajePadre(idMensajePadre);
    }

    public Optional<InteraccionForo> obtenerPorId(Long id) {
        return repositorio.findById(id);
    }

    public InteraccionForo guardar(InteraccionForo interaccion) {
        return repositorio.save(interaccion);
    }

    public InteraccionForo responderMensaje(Long idMensajePadre, InteraccionForo respuesta) {
        respuesta.setIdMensajePadre(idMensajePadre);
        respuesta.setEsRespuesta(true);
        return repositorio.save(respuesta);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}
