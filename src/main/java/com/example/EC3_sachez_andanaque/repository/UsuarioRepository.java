package com.example.EC3_sachez_andanaque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.EC3_sachez_andanaque.model.Usuario;

@Repository
public interface UsuarioRepository extends
        JpaRepository<Usuario, Integer> {
    //select * from usuario where nomusuario = :nomusuario;
    Usuario findByNomusuario(String nomusuario);
}