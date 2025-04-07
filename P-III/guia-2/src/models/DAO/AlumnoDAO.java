package models.DAO;

import config.ConexionMySQL;
import models.Alumno;
import models.DTO.AlumnoDTO;
import models.Direccion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO{

    private final Connection conexion;

    public AlumnoDAO(){
        this.conexion = ConexionMySQL.getInstancia()
                                     .getConexion();
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

    public List<AlumnoDTO> listarAlumnos(){
        List<AlumnoDTO> alumnosDTO = new ArrayList<>();
        String query = "select * from alumnos left join direcciones on alumnos.id = direcciones.alumno_id";

        try(Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(query)){
            while(rs.next()){
                int alumnoId = rs.getInt("id");
                AlumnoDTO alumnoDTO = buscarXId(alumnosDTO, alumnoId);
                if(alumnoDTO == null){
                    alumnoDTO = new AlumnoDTO();
                    alumnoDTO.setId(alumnoId);
                    alumnoDTO.setNombre(rs.getString("nombre"));
                    alumnoDTO.setApellido(rs.getString("apellido"));
                    alumnoDTO.setEdad(rs.getInt("edad"));
                    alumnoDTO.setEmail(rs.getString("email"));
                    alumnoDTO.setDirecciones(new ArrayList<>());
                    alumnosDTO.add(alumnoDTO);
                }
                String calle = rs.getString("calle");
                if(calle != null && !calle.isEmpty()){
                    Direccion direccion = new Direccion();
                    direccion.setCalle(calle);
                    direccion.setAltura(rs.getInt("altura"));
                    direccion.setAlumnoId(rs.getInt("alumno_id"));
                    alumnoDTO.getDirecciones().add(direccion);
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return alumnosDTO;
    }

    public <T> T buscarXId(List<T> lista, int id){
        for(T o : lista){
            if(o instanceof AlumnoDTO alumnoDTO && alumnoDTO.getId() == id){
                return o;
            } else if(o instanceof Alumno alumno && alumno.getId() == id){
                return o;
            }
        }
        return null;
    }
}
