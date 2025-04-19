package repositories;

import config.DBConnection;
import models.LibroEntity;
import repositories.interfaces.ILibroRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LibroRepository implements ILibroRepository {

    private final Connection connection;

    public LibroRepository() {
        this.connection = DBConnection.getInstance().getConnection();
    }

    @Override
    public void guardar(LibroEntity o) {
        String query = "insert into libros (titulo, autor, anio_publicacion, unidades_disponibles) values (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, o.getTitulo());
            stmt.setString(2, o.getAutor());
            stmt.setInt(3, o.getAnioPublicacion());
            stmt.setInt(4, o.getStock());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<LibroEntity> listar() {
        List<LibroEntity> libros = new ArrayList<>();
        String query = "select * from libros";

        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                libros.add(new LibroEntity(rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getInt("anio_publicacion"),
                        rs.getInt("unidades_disponibles")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libros;
    }

    @Override
    public Optional<LibroEntity> buscarXId(Integer id) {
        String query = "select * from libros where id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new LibroEntity(rs.getInt("id"),
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getInt("anio_publicacion"),
                            rs.getInt("unidades_disponibles")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return Optional.empty();
    }

    @Override
    public void modificar(LibroEntity o) {
        String query = "update libros set titulo = ?, autor = ?, anio_publicacion = ?, unidades_disponibles = ? where id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, o.getTitulo());
            stmt.setString(2, o.getAutor());
            stmt.setInt(3, o.getAnioPublicacion());
            stmt.setInt(4, o.getStock());
            stmt.setInt(5, o.getId());
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Integer id) {
        String query = "delete from libros where id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
