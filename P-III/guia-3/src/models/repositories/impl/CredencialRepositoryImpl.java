package models.repositories.impl;

import config.DBConnection;
import models.entities.CredencialEntity;
import models.entities.enums.Permiso;
import models.repositories.interfaces.ICredencialRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CredencialRepositoryImpl implements ICredencialRepository{

    private final Connection connection;

    public CredencialRepositoryImpl(){
        this.connection = DBConnection.getInstance()
                                      .getConnection();
    }

    @Override
    public void guardar(CredencialEntity o){
        String query = "insert into credenciales (id_usuario, username, password, permiso) values (?, ?, ?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, o.getUsuarioId());
            stmt.setString(2, o.getUsername());
            stmt.setString(3, o.getPassword());
            stmt.setString(4,
                           o.getPermiso()
                            .toString());
            stmt.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<CredencialEntity> listar(){
        List<CredencialEntity> credenciales = new ArrayList<>();
        String query = "select * from credenciales";

        try(PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                credenciales.add(new CredencialEntity(rs.getInt("id_credencial"),
                                                      rs.getInt("id_usuario"),
                                                      rs.getString("username"),
                                                      rs.getString("password"),
                                                      Permiso.valueOf(rs.getString("permiso"))));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return credenciales;
    }

    @Override
    public Optional<CredencialEntity> buscarXId(Integer id){
        String query = "select * from credenciales where id_credencial = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()){
            stmt.setInt(1, id);
            if(rs.next()){
                return Optional.of(new CredencialEntity(rs.getInt("id_credencial"),
                                                        rs.getInt("id_usuario"),
                                                        rs.getString("username"),
                                                        rs.getString("password"),
                                                        Permiso.valueOf(rs.getString("permiso"))));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    public Optional<CredencialEntity> buscarXUsername(String username){
        String query = "select * from credenciales where username = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, username);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return Optional.of(new CredencialEntity(rs.getInt("id_credencial"),
                                                            rs.getInt("id_usuario"),
                                                            rs.getString("username"),
                                                            rs.getString("password"),
                                                            Permiso.valueOf(rs.getString("permiso"))));
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void modificar(CredencialEntity o){
        String query = "update credenciales set username = ?, password = ?, permiso = ? where id_credencial = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, o.getUsername());
            stmt.setString(2, o.getPassword());
            stmt.setString(3,
                           o.getPermiso()
                            .toString());
            stmt.setInt(4, o.getId());
            stmt.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(CredencialEntity o){
        String query = "delete from credenciales where id_credencial = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, o.getId());
            stmt.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
