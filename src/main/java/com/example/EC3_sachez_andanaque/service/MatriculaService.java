package com.example.EC3_sachez_andanaque.service;

import com.example.EC3_sachez_andanaque.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    public void crearMatricula(String nombre, String dateOfBirth, String email,
                               Integer docenteId, Integer seccionId, Integer courseId, Integer gradoId,
                               Date fechaMatricula) {
        matriculaRepository.crearMatricula(nombre, dateOfBirth, email, docenteId, seccionId, courseId, gradoId, fechaMatricula);
    }

    public void actualizarMatricula(Integer matriculaId, String nombre, String dateOfBirth, String email,
                                    Integer docenteId, Integer seccionId, Integer courseId, Integer gradoId,
                                    Date fechaMatricula) {
        matriculaRepository.actualizarMatricula(matriculaId, nombre, dateOfBirth, email, docenteId, seccionId, courseId, gradoId, fechaMatricula);
    }
}
