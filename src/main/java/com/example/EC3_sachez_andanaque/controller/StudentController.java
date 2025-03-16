package com.example.EC3_sachez_andanaque.controller;

import com.example.EC3_sachez_andanaque.exception.StudentNotFoundException;
import com.example.EC3_sachez_andanaque.model.Student;
import com.example.EC3_sachez_andanaque.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/api/students")
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


}
