package com.edutech.course.manager.repository;

import com.edutech.course.manager.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {}
