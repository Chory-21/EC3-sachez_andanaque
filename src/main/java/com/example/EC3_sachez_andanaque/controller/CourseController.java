package com.example.EC3_sachez_andanaque.controller;

import com.example.EC3_sachez_andanaque.exception.CourseNotFoundException;
import com.example.EC3_sachez_andanaque.model.Course;
import com.example.EC3_sachez_andanaque.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/courses")
@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


}
