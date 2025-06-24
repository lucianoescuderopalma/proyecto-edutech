package com.edutech.administradormaterial.repository;

import com.edutech.administradormaterial.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EvaluacionRepositorio extends JpaRepository<Evaluacion, Long> {
    List<Evaluacion> findByIdCurso(Long idCurso);
}