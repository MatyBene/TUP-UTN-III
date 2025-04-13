package models.services;


import models.entities.CuentaEntity;
import models.entities.UsuarioEntity;
import models.entities.enums.TipoCuenta;
import models.repositories.impl.CredencialRepositoryImpl;
import models.repositories.impl.CuentaRepositoryImpl;
import models.repositories.impl.UsuarioRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class UsuarioService{

    private final UsuarioRepositoryImpl usuarioRepository;
    private final CredencialRepositoryImpl credencialRepository;
    private final CuentaRepositoryImpl cuentaRepository;

    public UsuarioService(){
        this.usuarioRepository = new UsuarioRepositoryImpl();
        this.credencialRepository = new CredencialRepositoryImpl();
        this.cuentaRepository = new CuentaRepositoryImpl();
    }

    public void crear(UsuarioEntity usuario){
        if(usuarioRepository.buscarXDni(usuario.getDni())
                            .isPresent()){
            throw new IllegalArgumentException("El DNI ya se encuentra registrado.");
        }

        usuarioRepository.guardar(usuario);
        Integer usuarioId = usuarioRepository.obtenerUltimoId();
        usuario.getCredencial()
               .setUsuarioId(usuarioId);
        credencialRepository.guardar(usuario.getCredencial());
        cuentaRepository.guardar(new CuentaEntity(usuarioId, TipoCuenta.CAJA_AHORRO, 0.0));

    }

    public Optional<UsuarioEntity> obtenerUsuarioXDni(String dni){
        List<UsuarioEntity> usuarios = usuarioRepository.listar();

        Optional<UsuarioEntity> usuario = usuarios.stream()
                                                  .filter(u -> u.getDni()
                                                                .equals(dni))
                                                  .findFirst();

        return Optional.ofNullable(usuario ? usuario : null);
    }
}
