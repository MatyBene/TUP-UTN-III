package models.services;


import models.entities.CredencialEntity;
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

    public Optional<UsuarioEntity> loguear(String username,
                                           String password){
        Optional<CredencialEntity> credencial = credencialRepository.buscarXUsername(username);

        if(credencial.isPresent() && credencial.get().getPassword().equals(password)){
            Optional<UsuarioEntity> usuario = usuarioRepository.buscarXId(credencial.get().getUsuarioId());
            if(usuario.isPresent()){
                usuario.get().setCredencial(credencial.get());
                usuario.get().setCuentas(cuentaRepository.);
            }
        }

    }

    public Optional<UsuarioEntity> obtenerUsuarioXDni(String dni){
        List<UsuarioEntity> usuarios = usuarioRepository.listar();

        return usuarios.stream()
                       .filter(u -> u.getDni()
                                     .equals(dni))
                       .findFirst();

    }
}
