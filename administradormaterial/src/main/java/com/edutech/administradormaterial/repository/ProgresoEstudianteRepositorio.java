package com.edutech.administradormaterial.repository;

import com.edutech.administradormaterial.model.ProgresoEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProgresoEstudianteRepositorio extends JpaRepository<ProgresoEstudiante, Long> {
    List<ProgresoEstudiante> findByIdEstudiante(Long idEstudiante);
    List<ProgresoEstudiante> findByIdCurso(Long idCurso);
}