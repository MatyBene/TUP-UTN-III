package models.repositories.interfaces;

import models.entities.UsuarioEntity;

import java.util.Optional;

public interface IUsuarioRepository extends IRepository<UsuarioEntity>{

    Optional<UsuarioEntity> buscarXDni(String dni);
    Integer obtenerUltimoId();

}
