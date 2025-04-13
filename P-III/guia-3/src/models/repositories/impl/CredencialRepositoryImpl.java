package models.repositories.impl;

import config.DBConnection;
import models.entities.CredencialEntity;
import models.repositories.interfaces.IRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CredencialRepositoryImpl implements IRepository<CredencialEntity>{

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
            stmt.setString(4, o.getPermiso().toString());
            stmt.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<CredencialEntity> listar(){
        return List.of();
    }

    @Override
    public Optional<CredencialEntity> buscarXId(Integer id){
        return Optional.empty();
    }

    @Override
    public void modificar(CredencialEntity o){

    }

    @Override
    public void eliminar(CredencialEntity o){

    }
}
