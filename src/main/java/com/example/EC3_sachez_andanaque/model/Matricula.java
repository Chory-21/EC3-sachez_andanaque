package com.example.EC3_sachez_andanaque.model;
import jakarta.persistence.*;

@Entity
@Table(name = "Matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Estudiante
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // Curso
    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    // Docente
    @ManyToOne
    @JoinColumn(name = "docente_id", nullable = false)
    private Docente docente;

    // Grado
    @ManyToOne
    @JoinColumn(name = "grado_id", nullable = false)
    private Grado grado;

    // Sección
    @ManyToOne
    @JoinColumn(name = "seccion_id", nullable = false)
    private Seccion seccion;

    @Column(name = "fecha_matricula", nullable = false)
    private java.util.Date fechaMatricula;

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

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public java.util.Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(java.util.Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }
}
