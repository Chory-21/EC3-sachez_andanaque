package com.example.EC3_sachez_andanaque.controller;

import com.example.EC3_sachez_andanaque.dto.CourseDto;
import com.example.EC3_sachez_andanaque.dto.StudentCourseDetailDTO;
import com.example.EC3_sachez_andanaque.exception.CourseNotFoundException;
import com.example.EC3_sachez_andanaque.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/courses")
@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/by-credit/{minCredit}")
    public ResponseEntity<List<CourseDto>> getCoursesByMinimumCredit(@PathVariable int minCredit) {
        List<CourseDto> courses = courseService.findCoursesWithCreditGreaterThanOrEqual(minCredit);
        if (courses.isEmpty()) {
            throw new CourseNotFoundException("No se encontraron cursos con al menos \" + minCredit + \" créditos.");
        }
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/detailed-list")
    public ResponseEntity<List<StudentCourseDetailDTO>> getDetailedStudentCourseList() {
        List<StudentCourseDetailDTO> details = courseService.getDetailedStudentCourseList();
        if (details.isEmpty()) {
            throw new CourseNotFoundException("No se encontraron datos detallados de cursos y estudiantes.");
        }
        return ResponseEntity.ok(details);
    }

    @GetMapping("/total-credits/{studentId}")
    public ResponseEntity<Integer> getTotalCreditsForStudent(@PathVariable int studentId) {
        Integer totalCredits = courseService.calculateTotalCreditsForStudent(studentId);
        if (totalCredits == null || totalCredits == 0) {
            throw new CourseNotFoundException("No se encontraron cursos para el estudiante con ID: " + studentId);
        }
        return ResponseEntity.ok(totalCredits);
    }
}
