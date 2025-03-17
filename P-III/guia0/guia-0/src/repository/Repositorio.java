package repository;

import model.Media;

import java.util.ArrayList;
import java.util.List;

public class Repositorio<T extends Media> implements IRepositorio<T>{

    private List<T> coleccion = new ArrayList<>();

    @Override
    public void agregarMedia(T media) {

    }

    @Override
    public void eliminarMedia(String id) {

    }

    @Override
    public List<T> obtenerTodos() {
        return List.of();
    }

    @Override
    public void modificarMedia(String id, T nuevoMedia) {

    }

    @Override
    public T buscarXId(String id) {
        return null;
    }
}
