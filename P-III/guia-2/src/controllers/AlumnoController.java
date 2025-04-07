package controllers;

import models.Alumno;
import models.DAO.AlumnoDAO;

public class AlumnoController{

    private final AlumnoDAO alumnoDAO;

    public AlumnoController(){
        this.alumnoDAO = new AlumnoDAO();
    }

    public void agregarAlumno(String nombre, String apellido, int edad, String email){
        alumnoDAO.insertarAlumno(new Alumno(nombre, apellido, edad, email));
    }

}
