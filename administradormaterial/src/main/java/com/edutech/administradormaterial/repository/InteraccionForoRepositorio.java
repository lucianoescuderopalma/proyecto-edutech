package com.edutech.administradormaterial.repository;

import com.edutech.administradormaterial.model.InteraccionForo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InteraccionForoRepositorio extends JpaRepository<InteraccionForo, Long> {
    List<InteraccionForo> findByIdCurso(Long idCurso);
    List<InteraccionForo> findByIdMensajePadre(Long idMensajePadre);
}