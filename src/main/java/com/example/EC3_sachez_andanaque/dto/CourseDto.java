package com.example.EC3_sachez_andanaque.dto;

public class CourseDto {
    private Integer id;
    private String name;
    private int credit;
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CourseDto(Integer id, String name, int credit, String descripcion) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.descripcion = descripcion;

    }

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCredit() { return credit; }
    public void setCredit(int credit) { this.credit = credit; }

}

