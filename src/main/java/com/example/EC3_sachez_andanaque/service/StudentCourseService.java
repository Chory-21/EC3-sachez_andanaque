package com.example.EC3_sachez_andanaque.service;

import com.example.EC3_sachez_andanaque.repository.StudentCourseRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseService {

    private final StudentCourseRepository studentCourseRepository;

    public StudentCourseService(StudentCourseRepository studentCourseRepository) {
        this.studentCourseRepository = studentCourseRepository;
    }

    // Método para registrar un estudiante con su curso y notas
    public void registrarEstudiante(String nombre, String dateOfBirth, String email,
                                    String curso,
                                    Integer credit, String descripcion, Double nota1, Double nota2, Double nota3, Double nota4) {
        studentCourseRepository.registrarEstudiante(nombre, dateOfBirth, email, curso,credit,descripcion, nota1, nota2, nota3, nota4);
    }

    // Método para listar estudiantes con cursos y promedios
    public Object listarEstudiantesConCursosYPromedios() {
        return studentCourseRepository.listarEstudiantesConCursosYPromedios();
    }

    // Método para actualizar estudiante, curso y notas
    public void actualizarEstudiante(Integer studentId, String nombre, String dateOfBirth, String email,
                                     Integer courseId, String curso, Integer creditos, String descripcion,
                                     Integer notaId, Double nota1, Double nota2, Double nota3, Double nota4) {
        studentCourseRepository.actualizarEstudiante(studentId, nombre, dateOfBirth, email, courseId, curso, creditos, descripcion, notaId, nota1, nota2, nota3, nota4);
    }
}