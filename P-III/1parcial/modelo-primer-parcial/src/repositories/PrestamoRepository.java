package repositories;

import config.DBConnection;
import models.PrestamoEntity;
import repositories.interfaces.IPrestamoRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PrestamoRepository implements IPrestamoRepository {
    private final Connection connection;

    public PrestamoRepository() {
        this.connection = DBConnection.getInstance().getConnection();
    }

    @Override
    public void guardar(PrestamoEntity o) {
        String query = "insert into prestamos (libro_id, usuario_id, fecha_prestamo) values (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, o.getLibroId());
            stmt.setInt(2, o.getUsuarioId());
            stmt.setDate(3, (Date) o.getFechaPrestamo());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PrestamoEntity> listar() {
        List<PrestamoEntity> prestamos = new ArrayList<>();
        String query = "select * from prestamos";

        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                prestamos.add(new PrestamoEntity(rs.getInt("id"),
                        rs.getInt("libro_id"),
                        rs.getInt("usuario_id"),
                        rs.getDate("fecha_prestamo"),
                        rs.getDate("fecha_devolucion")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prestamos;
    }

    @Override
    public Optional<PrestamoEntity> buscarXId(Integer id) {
        String query = "select * from prestamos where id = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()){
            stmt.setInt(1, id);
            if(rs.next()){
                return Optional.of(new PrestamoEntity(rs.getInt("id"),
                        rs.getInt("libro_id"),
                        rs.getInt("usuario_id"),
                        rs.getDate("fecha_prestamo"),
                        rs.getDate("fecha_devolucion")));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void modificar(PrestamoEntity o) {
        String query = "update prestamos set libro_id = ?, usuario_id = ?, fecha_prestamo = ? where id = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, o.getLibroId());
            stmt.setInt(2, o.getUsuarioId());
            stmt.setDate(3, (Date) o.getFechaPrestamo());
            stmt.setInt(4, o.getId());
            stmt.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(PrestamoEntity o) {
        String query = "delete from prestamos where id = ?";

        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, o.getId());
            stmt.execute();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
