package com.example.EC3_sachez_andanaque.repository;

import com.example.EC3_sachez_andanaque.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query(value = "SELECT DISTINCT id, nombre, credit, descripcion FROM course WHERE credit >= :minCredit", nativeQuery = true)
    List<Object[]> findCoursesWithCreditGreaterThanOrEqual(@Param("minCredit") int minCredit);

    @Query(value = "SELECT s.nombre, CAST(s.date_of_birth AS CHAR), s.email, c.nombre " +
            "FROM Student s " +
            "JOIN Student_Course sc ON s.id = sc.student_id " +
            "JOIN Course c ON sc.course_id = c.id",
            nativeQuery = true)
    List<Object[]> getDetailedStudentCourseList();

    @Query(value = "SELECT COALESCE(SUM(c.credit), 0) " +
            "FROM Course c " +
            "JOIN Student_Course sc ON c.id = sc.course_id " +
            "WHERE sc.student_id = :studentId", nativeQuery = true)
    Integer calculateTotalCreditsForStudent(@Param("studentId") int studentId);
}
