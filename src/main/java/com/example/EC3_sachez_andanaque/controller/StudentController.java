package com.example.EC3_sachez_andanaque.controller;

import com.example.EC3_sachez_andanaque.dto.StudentCourseCountDTO;
import com.example.EC3_sachez_andanaque.dto.StudentDto;
import com.example.EC3_sachez_andanaque.exception.StudentNotFoundException;
import com.example.EC3_sachez_andanaque.service.StudentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/api/students")
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/enrolled/{courseName}")
    public ResponseEntity<List<StudentDto>> getStudentsEnrolledInCourse(@PathVariable String courseName) {
        List<StudentDto> students = studentService.findStudentsEnrolledInCourse(courseName);
        if (students.isEmpty()) {
            throw new StudentNotFoundException("No se encontraron estudiantes inscripto en el curso: " + courseName);
        }
        return ResponseEntity.ok(students);
    }

    @GetMapping("/course-count")
    public ResponseEntity<List<StudentCourseCountDTO>> getStudentCourseCount() {
        List<StudentCourseCountDTO> counts = studentService.countCoursesPerStudent();
        if (counts.isEmpty()) {
            throw new StudentNotFoundException("No se encontraron estudiante con cursos registrado.");
        }
        return ResponseEntity.ok(counts);
    }

    @GetMapping("/by-birthdate/{birthDate}")
    public ResponseEntity<List<StudentDto>> getStudentsByBirthDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDate) {
        List<StudentDto> students = studentService.findStudentsByBirthDate(birthDate);
        if (students.isEmpty()) {
            throw new StudentNotFoundException("no se esncontro estudiantes nacidos en: " + birthDate);
        }
        return ResponseEntity.ok(students);
    }
}
