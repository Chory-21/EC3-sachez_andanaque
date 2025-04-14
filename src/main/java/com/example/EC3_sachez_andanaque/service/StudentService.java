package com.example.EC3_sachez_andanaque.service;


import com.example.EC3_sachez_andanaque.dto.CourseDto;
import com.example.EC3_sachez_andanaque.dto.StudentCourseCountDTO;
import com.example.EC3_sachez_andanaque.dto.StudentDto;
import com.example.EC3_sachez_andanaque.model.Student;
import com.example.EC3_sachez_andanaque.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> findStudentsEnrolledInCourse(String courseName) {
        List<Student> students = studentRepository.findStudentsEnrolledInCourse(courseName);

        return students.stream().map(student -> new StudentDto(
                student.getId(),
                student.getNombre(),
                student.getDateOfBirth(),
                student.getEmail(),
                student.getStudentCourses().stream()
                        .map(sc -> new CourseDto(
                                sc.getCourse().getId(),
                                sc.getCourse().getNombre(),
                                sc.getCourse().getCredit(),
                                sc.getCourse().getDescripcion()
                        ))
                        .collect(Collectors.toList())
        )).collect(Collectors.toList());
    }
    public List<StudentCourseCountDTO> countCoursesPerStudent() {
        return studentRepository.countCoursesPerStudent();
    }

    public List<StudentDto> findStudentsByBirthDate(LocalDate birthDate) {
        List<Student> students = studentRepository.findStudentsByBirthDate(birthDate);

        return students.stream().map(student -> new StudentDto(
                student.getId(),
                student.getNombre(),
                student.getDateOfBirth(),
                student.getEmail(),
                student.getStudentCourses().stream()
                        .map(sc -> new CourseDto(
                                sc.getCourse().getId(),
                                sc.getCourse().getNombre(),
                                sc.getCourse().getCredit(),
                                sc.getCourse().getDescripcion()
                        ))
                        .collect(Collectors.toList())
        )).collect(Collectors.toList());
    }

}