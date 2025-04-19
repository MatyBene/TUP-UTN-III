package repositories;

import config.DBConnection;
import models.UsuarioEntity;
import repositories.interfaces.IUsuarioRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioRepository implements IUsuarioRepository {

    private final Connection connection;

    public UsuarioRepository() {
        this.connection = DBConnection.getInstance().getConnection();
    }

    @Override
    public void guardar(UsuarioEntity o) {
        String query = "insert into usuarios (nombre, email) values (?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, o.getNombre());
            stmt.setString(2, o.getEmail());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UsuarioEntity> listar() {
        List<UsuarioEntity> usuarios = new ArrayList<>();
        String query = "select * from usuarios";

        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                usuarios.add(new UsuarioEntity(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    @Override
    public Optional<UsuarioEntity> buscarXId(Integer id) {
        String query = "select * from usuarios where id = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()){
            stmt.setInt(1, id);
            if(rs.next()){
                return Optional.of(new UsuarioEntity(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email")));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void modificar(UsuarioEntity o) {
        String query = "update usuarios set nombre = ?, email = ? where id = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setString(1, o.getNombre());
            stmt.setString(2, o.getEmail());
            stmt.setInt(3, o.getId());
            stmt.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(UsuarioEntity o) {
        String query = "delete from usuarios where id = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, o.getId());
            stmt.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
