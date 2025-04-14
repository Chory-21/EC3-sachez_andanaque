package com.example.EC3_sachez_andanaque.dto;

import java.time.LocalDate;

public class StudentCourseDetailDTO {
    private String studentName;
    private LocalDate dateOfBirth;
    private String email;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    private String courseName;

    public StudentCourseDetailDTO(String studentName, LocalDate dateOfBirth, String email, String courseName) {
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.courseName = courseName;
    }
}