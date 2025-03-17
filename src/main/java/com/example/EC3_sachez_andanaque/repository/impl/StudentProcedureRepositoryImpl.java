package com.example.EC3_sachez_andanaque.repository.impl;

import com.example.EC3_sachez_andanaque.repository.StudentCourseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class StudentProcedureRepositoryImpl implements StudentCourseRepository {

    private final EntityManager entityManager;

    public StudentProcedureRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Transactional
    @Override
    public void registrarEstudiante(String nombre, String dateOfBirth, String email,
                                    String curso, Integer creditos, String descripcion,
                                    Double nota1, Double nota2, Double nota3, Double nota4) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_RegistrarEstudianteConCursoYNotas");
        query.registerStoredProcedureParameter(1, String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(2, String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(3, String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(4, String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(5, Integer.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(6, String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(7, Double.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(8, Double.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(9, Double.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(10, Double.class, jakarta.persistence.ParameterMode.IN);

        query.setParameter(1, nombre);
        query.setParameter(2, dateOfBirth);
        query.setParameter(3, email);
        query.setParameter(4, curso);
        query.setParameter(5, creditos);
        query.setParameter(6, descripcion);
        query.setParameter(7, nota1);
        query.setParameter(8, nota2);
        query.setParameter(9, nota3);
        query.setParameter(10, nota4);

        query.execute();
    }
    @Transactional
    @Override
    public Object listarEstudiantesConCursosYPromedios() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_ListarEstudiantesConCursosYPromedios");
        return query.getResultList();
    }
    @Transactional
    @Override
    public void actualizarEstudiante(Integer studentId, String nombre, String dateOfBirth, String email,
                                     Integer courseId, String curso, Integer creditos, String descripcion,
                                     Integer notaId, Double nota1, Double nota2, Double nota3, Double nota4) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("sp_ActualizarEstudianteCursoYNotas");
        query.registerStoredProcedureParameter(1, Integer.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(2, String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(3, String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(4, String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(5, Integer.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(6, String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(7, Integer.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(8, String.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(9, Integer.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(10, Double.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(11, Double.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(12, Double.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(13, Double.class, jakarta.persistence.ParameterMode.IN);

        query.setParameter(1, studentId);
        query.setParameter(2, nombre);
        query.setParameter(3, dateOfBirth);
        query.setParameter(4, email);
        query.setParameter(5, courseId);
        query.setParameter(6, curso);
        query.setParameter(7, creditos);
        query.setParameter(8, descripcion);
        query.setParameter(9, notaId);
        query.setParameter(10, nota1);
        query.setParameter(11, nota2);
        query.setParameter(12, nota3);
        query.setParameter(13, nota4);

        query.execute();
    }
}