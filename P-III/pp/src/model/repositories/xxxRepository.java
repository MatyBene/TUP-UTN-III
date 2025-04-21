package model.repositories;

import config.DBConnection;
import model.entities.xxxEntity;
import model.repositories.interfaces.IxxxRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class xxxRepository implements IxxxRepository{

    private final Connection connection;

    public xxxRepository(){
        this.connection = DBConnection.getInstance()
                                      .getConnection();
    }

    @Override
    public void guardar(xxxEntity o){
        String query = "insert into xxx (, ) values (?, ?)";

        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, o.getNombre());
            stmt.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<xxxEntity> listar(){
        List<xxxEntity> xxx = new ArrayList<>();
        String query = "select * from xxx";

        try(PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                xxx.add(new xxxEntity(rs.getInt("id"), rs.getString("nombre"), rs.getString("email")));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return xxx;
    }

    @Override
    public Optional<xxxEntity> buscarPorId(int id){
        String query = "select * from xxx where id = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return Optional.of(new xxxEntity(rs.getInt("id"), rs.getString("nombre"), rs.getString("email")));
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void modificar(xxxEntity o){
        String query = "update xxx set nombre = ?, email = ? where id = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, o.getNombre());
            stmt.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id){
        String query = "delete from xxx where id = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, id);
            stmt.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
