package models.repositories.impl;

import config.DBConnection;
import models.entities.CuentaEntity;
import models.repositories.interfaces.IRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CuentaRepositoryImpl implements IRepository<CuentaEntity>{

    private final Connection connection;

    public CuentaRepositoryImpl(){
        this.connection = DBConnection.getInstance()
                                      .getConnection();
    }

    @Override
    public void guardar(CuentaEntity o){
        String query = "insert into cuentas (id_usuario, tipo, saldo) values (?, ?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, o.getUsuarioId());
            stmt.setString(2, o.getTipo().toString());
            stmt.setDouble(3, o.getSaldo());
            stmt.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<CuentaEntity> listar(){
        return List.of();
    }

    @Override
    public Optional<CuentaEntity> buscarXId(Integer id){
        return Optional.empty();
    }

    @Override
    public void modificar(CuentaEntity o){

    }

    @Override
    public void eliminar(CuentaEntity o){

    }
}
