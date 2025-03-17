package repository;

import exception.IdentificadorDuplicadoException;
import model.Media;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Repositorio<T extends Media> implements IRepositorio<T>{

    private List<T> lista = new ArrayList<>();

    /**
     * Agrega un elemento de media al repositorio.
     *
     * @param media el elemento de media a agregar
     * @throws IdentificadorDuplicadoException si un elemento de media con el mismo ID ya existe en el repositorio
     */
    @Override
    public void agregarMedia(T media) {
        for(T obj : lista){
            if(obj.getId().equals(media.getId())){
                throw new IdentificadorDuplicadoException("El id ya existe.");
            }
        }

        lista.add(media);
    }

    /**
     * Elimina un elemento de media del repositorio por su ID.
     *
     * @param id el ID del elemento de media a eliminar
     */
    @Override
    public void eliminarMedia(String id) {
        lista.removeIf(media -> media.getId().equals(id));
    }

    /**
     * Obtiene una lista de todos los elementos de media en el repositorio,
     * ordenados por título.
     *
     * @return una lista de todos los elementos de media ordenados por título
     */
    @Override
    public List<T> obtenerTodos() {
        lista.sort(Comparator.comparing(Media::getTitulo));
        return lista;
    }

    @Override
    public void modificarMedia(String id, T nuevoMedia) {

    }

    /**
     * Busca un elemento de media en el repositorio por su ID.
     *
     * @param id el ID del elemento de media a buscar
     * @return el elemento de media con el ID especificado, o null si no se encuentra
     */
    @Override
    public T buscarXId(String id) {
        for(T media : lista){
            if(media.getId().equals(id)){
                return media;
            }
        }
        return null;
    }
}
