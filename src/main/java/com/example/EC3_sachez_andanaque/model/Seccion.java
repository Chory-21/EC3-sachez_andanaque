package com.example.EC3_sachez_andanaque.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Seccion")
public class Seccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 1, nullable = false, unique = true)
    private String nombre; // Ej: 'A', 'B', 'C', 'D'

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

