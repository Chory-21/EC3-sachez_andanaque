package com.example.EC3_sachez_andanaque.repository;

import com.example.EC3_sachez_andanaque.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


}
