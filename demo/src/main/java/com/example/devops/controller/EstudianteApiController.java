package com.example.devops.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.devops.DB.EstudiantesDB;
import com.example.devops.model.Estudiante;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteApiController {

    @PostMapping
    public ResponseEntity<Estudiante> register(@RequestBody Estudiante estudiante) {
        if (estudiante == null) {
            return ResponseEntity.badRequest().build();
        }

        boolean added = EstudiantesDB.addEstudiante(estudiante);
        if (!added) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(estudiante);
    }

    @GetMapping
    public ResponseEntity<ArrayList<Estudiante>> list() {
        return ResponseEntity.ok(EstudiantesDB.Estudiantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getById(@PathVariable int id) {

        Estudiante estudiante = EstudiantesDB.findById(id);

        if (estudiante == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(estudiante);
    }

    @GetMapping("/search")
    public ResponseEntity<ArrayList<Estudiante>> searchByNombre(@RequestParam String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        ArrayList<Estudiante> resultados = EstudiantesDB.findByNombre(nombre);

        return ResponseEntity.ok(resultados);
    }

}
