package com.example.EC3_sachez_andanaque.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "StudentCourse")
public class StudentCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JsonBackReference
    @JoinColumn(name = "student_id", nullable = false) // Asegurar que el nombre de la columna es correcto
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", nullable = false) // Se asegura que course_id es correcto
    private Course course;

    @ManyToOne(optional = false)
    @JoinColumn(name = "nota_id", nullable = false) // Ajustado a la convención
    private Nota nota;

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }
}
