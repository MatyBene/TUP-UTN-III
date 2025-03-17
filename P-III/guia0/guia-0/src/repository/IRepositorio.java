package repository;

import model.Juego;

import java.util.List;

public interface IRepositorio<T> {

    void agregarMedia(T media);
    void eliminarMedia(String id);
    List<T> obtenerTodos();
    List<Juego> obtenerJuegos();
    void modificarMedia(String id, T nuevoMedia);
    T buscarXId(String id);

}
