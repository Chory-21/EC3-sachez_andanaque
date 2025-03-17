package com.example.EC3_sachez_andanaque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.EC3_sachez_andanaque.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol,
        Integer> {
    //select * from rol where nomrol = :nomrol
    Rol findByNomrol(String nomrol);
}