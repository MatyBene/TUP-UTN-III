package models.DAO;

import config.ConexionMySQL;
import models.Direccion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DireccionDAO{

    private final Connection conexion;

    public DireccionDAO(){
        this.conexion = ConexionMySQL.getInstancia()
                                     .getConexion();
    }

    public void insertarDireccion(Direccion direccion){
        String query = "insert into direcciones (calle, altura, alumno_id) values (?, ?, ?)";

        try(PreparedStatement stmt = conexion.prepareStatement(query)){
            stmt.setString(1, direccion.getCalle());
            stmt.setInt(2, direccion.getAltura());
            stmt.setInt(3, direccion.getAlumnoId());
            stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Direccion> listarDireccionesXAlumno(int alumnoId){
        List<Direccion> direcciones = new ArrayList<>();
        String query = "select * from direcciones where alumno_id = ?";

        try(PreparedStatement stmt = conexion.prepareStatement(query)){
            stmt.setInt(1, alumnoId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Direccion direccion = new Direccion();
                direccion.setId(rs.getInt("id"));
                direccion.setCalle(rs.getString("calle"));
                direccion.setAltura(rs.getInt("altura"));
                direccion.setAlumnoId(rs.getInt("alumno_id"));
                direcciones.add(direccion);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return direcciones;
    }
}
