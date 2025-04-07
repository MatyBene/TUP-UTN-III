package controllers;

import models.DAO.AlumnoDAO;
import models.DAO.DireccionDAO;
import models.Direccion;

import java.util.List;

public class DireccionController{

    private final DireccionDAO direccionDAO;
    private final AlumnoDAO alumnoDAO;

    public DireccionController(){
        this.direccionDAO = new DireccionDAO();
        this.alumnoDAO = new AlumnoDAO();
    }

    public void agregarDireccion(String calle,
                                 int altura,
                                 int alumnoId){

        direccionDAO.insertarDireccion(new Direccion(calle, altura, alumnoId));
    }

    public List<Direccion> listarDireccionesXIdAlumno(int alumnoId){
        return direccionDAO.listarDireccionesXAlumno(alumnoId);
    }
}
