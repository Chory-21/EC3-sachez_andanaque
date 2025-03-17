package com.example.EC3_sachez_andanaque.repository;

import org.springframework.stereotype.Repository;


@Repository
public interface StudentCourseRepository {
    void registrarEstudiante(String nombre, String dateOfBirth, String email, String cursoNombre, Integer credit, String descripcion,
                              Double nota1,
                             Double nota2, Double nota3, Double nota4);

    Object listarEstudiantesConCursosYPromedios();

    void actualizarEstudiante(Integer studentId, String nombre, String dateOfBirth, String email,
                              Integer courseId, String curso, Integer creditos, String descripcion,
                              Integer notaId, Double nota1, Double nota2, Double nota3, Double nota4);
}