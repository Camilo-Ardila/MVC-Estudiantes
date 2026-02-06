package com.example.devops.DB;
import com.example.devops.model.Estudiante;
import java.util.ArrayList;

public class EstudiantesDB{

    public static ArrayList<Estudiante> Estudiantes = new ArrayList<Estudiante>();

    public static boolean addEstudiante(Estudiante e) {

        if(e.getId() < 0){
            return false;
        }

        for (Estudiante estudiante: Estudiantes) {
            if (estudiante.getId() == e.getId()) {
                return false;
            }
        }
        Estudiantes.add(e);
        return true;
    }

}
