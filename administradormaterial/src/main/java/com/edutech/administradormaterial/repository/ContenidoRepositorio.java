package com.edutech.administradormaterial.repository;

import com.edutech.administradormaterial.model.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ContenidoRepositorio extends JpaRepository<Contenido, Long> {

    List<Contenido> findByIdCurso(Long idCurso);

    List<Contenido> findByTipoContenido(String tipoContenido);

    List<Contenido> findByActivo(boolean activo);

    @Modifying
    @Query("UPDATE Contenido c SET c.activo = :estado WHERE c.id = :id")
    void actualizarEstado(@Param("id") Long id, @Param("estado") boolean estado);

    @Query("SELECT c FROM Contenido c WHERE c.idCurso = :idCurso AND c.activo = true")
    List<Contenido> buscarContenidosActivosPorCurso(@Param("idCurso") Long idCurso);
}