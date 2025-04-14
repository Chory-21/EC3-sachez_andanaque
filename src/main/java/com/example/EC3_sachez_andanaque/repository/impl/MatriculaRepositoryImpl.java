package com.example.EC3_sachez_andanaque.repository.impl;

import com.example.EC3_sachez_andanaque.repository.MatriculaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class MatriculaRepositoryImpl implements MatriculaRepository {

    private final EntityManager entityManager;

    public MatriculaRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public void crearMatricula(String nombre, String dateOfBirth, String email,
                               Integer docenteId, Integer seccionId, Integer courseId, Integer gradoId,
                               Date fechaMatricula) {
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_CrearMatricula");

            query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN); // Cambiar a String
            query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(4, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(5, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(6, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(7, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(8, String.class, ParameterMode.IN); // Cambiar a String

            query.setParameter(1, nombre);
            query.setParameter(2, dateOfBirth); // Aquí pasamos el String tal cual
            query.setParameter(3, email);
            query.setParameter(4, docenteId);
            query.setParameter(5, seccionId);
            query.setParameter(6, courseId);
            query.setParameter(7, gradoId);
            query.setParameter(8, new java.text.SimpleDateFormat("yyyy-MM-dd").format(fechaMatricula)); // Formatear fecha a String

            query.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear la matrícula: " + e.getMessage());
        }
    }


    @Transactional
    @Override
    public void actualizarMatricula(Integer matriculaId, String nombre, String dateOfBirth, String email,
                                    Integer docenteId, Integer seccionId, Integer courseId, Integer gradoId,
                                    Date fechaMatricula) {
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_ActualizarMatricula");

            query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(5, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(6, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(7, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(8, Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter(9, Date.class, ParameterMode.IN);

            query.setParameter(1, matriculaId);
            query.setParameter(2, nombre);
            query.setParameter(3, dateOfBirth);
            query.setParameter(4, email);
            query.setParameter(5, docenteId);
            query.setParameter(6, seccionId);
            query.setParameter(7, courseId);
            query.setParameter(8, gradoId);
            query.setParameter(9, fechaMatricula);

            query.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar la matrícula: " + e.getMessage());
        }
    }
}
