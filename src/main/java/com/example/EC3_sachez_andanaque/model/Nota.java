package com.example.EC3_sachez_andanaque.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Nota")
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Double nota1;

    @Column(nullable = false)
    private Double nota2;

    @Column(nullable = false)
    private Double nota3;

    @Column(nullable = false)
    private Double nota4;

    @Column(nullable = false)
    private Double promedio;

    @OneToMany(mappedBy = "nota")
    @JsonManagedReference
    private Set<StudentCourse> studentCourses;

    @ManyToOne
    @JoinColumn(name = "StudentId", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "CourseId", nullable = false)
    private Course course;

    @PrePersist
    @PreUpdate
    private void calcularPromedio() {
        this.promedio = (nota1 + nota2 + nota3 + nota4) / 4;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public Double getNota4() {
        return nota4;
    }

    public void setNota4(Double nota4) {
        this.nota4 = nota4;
    }

    public Double getNota3() {
        return nota3;
    }

    public void setNota3(Double nota3) {
        this.nota3 = nota3;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
