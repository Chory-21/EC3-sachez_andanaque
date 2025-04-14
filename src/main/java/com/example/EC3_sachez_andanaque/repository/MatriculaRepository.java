package com.example.EC3_sachez_andanaque.repository;

import java.util.Date;

public interface MatriculaRepository {
    void crearMatricula(String nombre, String dateOfBirth, String email,
                        Integer docenteId, Integer seccionId, Integer courseId, Integer gradoId,
                        Date fechaMatricula);

    void actualizarMatricula(Integer matriculaId, String nombre, String dateOfBirth, String email,
                             Integer docenteId, Integer seccionId, Integer courseId, Integer gradoId,
                             Date fechaMatricula);
}
