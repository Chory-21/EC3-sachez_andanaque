package com.example.EC3_sachez_andanaque.dto;

public class StudentCourseCountDTO {
        private Integer studentId;
        private String studentName;
        private Long courseCount;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(Long courseCount) {
        this.courseCount = courseCount;
    }

    public StudentCourseCountDTO(Integer studentId, String studentName, Long courseCount) {
            this.studentId = studentId;
            this.studentName = studentName;
            this.courseCount = courseCount;
        }
    }