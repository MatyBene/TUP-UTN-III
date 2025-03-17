package repository;

import java.util.List;

public interface IRepositorio<T> {

    void agregarMedia(T media);
    void eliminarMedia(String id);
    List<T> obtenerTodos();
    void modificarMedia(String id, T nuevoMedia);
    T buscarXId(String id);

}
