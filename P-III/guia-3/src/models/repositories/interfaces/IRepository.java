package models.repositories.interfaces;

import java.util.List;
import java.util.Optional;

public interface IRepository<T>{

    void guardar(T o);
    List<T> listar();
    Optional<T> buscarXId(Integer id);
    void modificar(T o);
    void eliminar(T o);

}
