package com.edutech.course.manager.repository;

import com.edutech.course.manager.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {}
