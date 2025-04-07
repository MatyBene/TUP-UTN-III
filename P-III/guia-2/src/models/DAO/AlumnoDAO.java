package models.DAO;

import config.ConexionMySQL;
import models.Alumno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlumnoDAO{

    private final Connection conexion;

    public AlumnoDAO() {
        this.conexion = ConexionMySQL.getInstancia().getConexion();
    }

    public void insertarAlumno(Alumno alumno){
        String query = "insert into alumnos (nombre, apellido, edad, email) values (?, ?, ?, ?)";

        try(PreparedStatement stmt = conexion.prepareStatement(query)){
            stmt.setString(1, alumno.getNombre());
            stmt.setString(2, alumno.getApellido());
            stmt.setInt(3, alumno.getEdad());
            stmt.setString(4, alumno.getEmail());
            stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
