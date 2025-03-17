package com.example.EC3_sachez_andanaque.controller;

import com.example.EC3_sachez_andanaque.service.StudentCourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students/procedures")
public class StudentCourseController {

    private final StudentCourseService studentCourseService;

    public StudentCourseController(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/register")
    public ResponseEntity<String> registrarEstudiante(@RequestParam String nombre, @RequestParam String dateOfBirth,
                                                      @RequestParam String email, @RequestParam String cursoNombre,
                                                      @RequestParam Integer credit, @RequestParam String descripcion,
                                                      @RequestParam Double nota1, @RequestParam Double nota2,
                                                      @RequestParam Double nota3, @RequestParam Double nota4) {
        studentCourseService.registrarEstudiante(nombre, dateOfBirth, email, cursoNombre, credit, descripcion, nota1, nota2, nota3, nota4);
        return ResponseEntity.ok("Estudiante registrado con éxito.");
    }

    @PreAuthorize("hasAnyRole('SUPERVISOR')")
    @GetMapping("/list")
    public Object listarEstudiantesConCursosYPromedios() {
        return studentCourseService.listarEstudiantesConCursosYPromedios();
    }

    @PreAuthorize("hasAnyRole('JEFE')")
    @PutMapping("/update")
    public ResponseEntity<String> actualizarEstudiante(@RequestParam Integer studentId,
                                                       @RequestParam String nombre,
                                                       @RequestParam String dateOfBirth,
                                                       @RequestParam String email,
                                                       @RequestParam Integer courseId,
                                                       @RequestParam String curso,
                                                       @RequestParam Integer creditos,
                                                       @RequestParam String descripcion,
                                                       @RequestParam Integer notaId,
                                                       @RequestParam Double nota1,
                                                       @RequestParam Double nota2,
                                                       @RequestParam Double nota3,
                                                       @RequestParam Double nota4) {

        studentCourseService.actualizarEstudiante(studentId, nombre, dateOfBirth, email,
                courseId, curso, creditos, descripcion,
                notaId, nota1, nota2, nota3, nota4);

        return ResponseEntity.ok("Datos actualizados correctamente.");
    }
}
