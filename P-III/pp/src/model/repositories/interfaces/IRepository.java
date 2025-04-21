package model.repositories.interfaces;

import java.util.List;
import java.util.Optional;

public interface IRepository<T>{

    void guardar(T o);
    List<T> listar();
    Optional<T> buscarPorId(int id);
    void modificar(T o);
    void eliminar(int id);

}
