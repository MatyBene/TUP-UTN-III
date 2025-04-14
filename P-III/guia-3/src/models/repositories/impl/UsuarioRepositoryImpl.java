package models.repositories.impl;

import config.DBConnection;
import models.entities.UsuarioEntity;
import models.repositories.interfaces.IUsuarioRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepositoryImpl implements IUsuarioRepository{

    private final Connection connection;

    public UsuarioRepositoryImpl(){
        this.connection = DBConnection.getInstance()
                                      .getConnection();
    }

    @Override
    public void guardar(UsuarioEntity o){
        String query = "insert into usuarios (nombre, apellido, dni, email) values (?, ?, ?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, o.getNombre());
            stmt.setString(2, o.getApellido());
            stmt.setString(3, o.getDni());
            stmt.setString(4, o.getEmail());
            stmt.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<UsuarioEntity> listar(){
        List<UsuarioEntity> usuarios = new ArrayList<>();
        String query = "select * from usuarios";

        try(PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                usuarios.add(new UsuarioEntity(rs.getInt("id_usuario"),
                                               rs.getString("nombre"),
                                               rs.getString("apellido"),
                                               rs.getString("dni"),
                                               rs.getString("email"),
                                               rs.getTimestamp("fecha_creacion")
                                                 .toLocalDateTime()));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return usuarios;
    }

    @Override
    public Optional<UsuarioEntity> buscarXId(Integer id){
        return Optional.empty();
    }

    @Override
    public Optional<UsuarioEntity> buscarXDni(String dni){
        return Optional.empty();
    }

    @Override
    public void modificar(UsuarioEntity o){

    }

    @Override
    public void eliminar(UsuarioEntity o){

    }

    @Override
    public Integer obtenerUltimoId(){
        String query = "select last_insert_id() as ultimo_id";

        try(PreparedStatement stmt = connection.prepareStatement(query)){
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return rs.getInt("ultimo_id");
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
