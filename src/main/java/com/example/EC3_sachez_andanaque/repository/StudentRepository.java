package com.example.EC3_sachez_andanaque.repository;

import com.example.EC3_sachez_andanaque.dto.StudentCourseCountDTO;
import com.example.EC3_sachez_andanaque.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT DISTINCT s FROM Student s " +
            "JOIN FETCH s.studentCourses sc " +
            "JOIN FETCH sc.course c " +
            "WHERE LOWER(c.nombre) LIKE LOWER(CONCAT('%', :courseName, '%'))")
    List<Student> findStudentsEnrolledInCourse(@Param("courseName") String courseName);

    // 3. Consulta JPQL: Conteo de Cursos Inscritos por Estudiante
    @Query("SELECT NEW com.example.EC3_sachez_andanaque.dto.StudentCourseCountDTO(s.id, s.nombre, COUNT(sc)) " +
            "FROM Student s " +
            "LEFT JOIN s.studentCourses sc " +
            "GROUP BY s.id, s.nombre")
    List<StudentCourseCountDTO> countCoursesPerStudent();

    // 5. Consulta JPQL: Filtrado de Estudiantes por Fecha de Nacimiento
    @Query("SELECT s FROM Student s WHERE s.dateOfBirth = :birthDate")
    List<Student> findStudentsByBirthDate(@Param("birthDate") LocalDate birthDate);
}
