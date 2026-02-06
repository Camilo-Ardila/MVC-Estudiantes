package com.example.devops.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Estudiante {

    @Id
    private int id;
    private String nombre;
    private String carrera;

    public Estudiante(int id, String nombre, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public Estudiante() {
    }

    public int getId() {
        return this.id;
    }

}
