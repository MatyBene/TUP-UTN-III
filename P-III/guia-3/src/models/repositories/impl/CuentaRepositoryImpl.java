package models.repositories.impl;

import config.DBConnection;
import models.entities.CuentaEntity;
import models.entities.enums.TipoCuenta;
import models.repositories.interfaces.ICuentaRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CuentaRepositoryImpl implements ICuentaRepository{

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
            stmt.setString(2,
                           o.getTipo()
                            .toString());
            stmt.setDouble(3, o.getSaldo());
            stmt.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<CuentaEntity> listar(){
        List<CuentaEntity> cuentas = new ArrayList<>();
        String query = "select * from cuentas";

        try(PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                cuentas.add(new CuentaEntity(rs.getInt("id_cuenta"),
                                             rs.getInt("id_usuario"),
                                             TipoCuenta.valueOf(rs.getString("tipo")),
                                             rs.getDouble("saldo"),
                                             rs.getTimestamp("fecha_creacion")
                                               .toLocalDateTime()));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return cuentas;
    }

    @Override
    public Optional<CuentaEntity> buscarXId(Integer id){
        String query = "select * from cuentas where id_cuenta = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()){
            stmt.setInt(1, id);
            if(rs.next()){
                return Optional.of(new CuentaEntity(rs.getInt("id_cuenta"),
                                                    rs.getInt("id_usuario"),
                                                    TipoCuenta.valueOf(rs.getString("tipo")),
                                                    rs.getDouble("saldo"),
                                                    rs.getTimestamp("fecha_creacion")
                                                      .toLocalDateTime()));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void modificar(CuentaEntity o){
        String query = "update cuentas set saldo = ? where id_cuenta = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setDouble(1,o.getSaldo());
            stmt.setInt(2, o.getId());
            stmt.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(CuentaEntity o){
        String query = "delete from cuentas where id_cuenta = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, o.getId());
            stmt.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
