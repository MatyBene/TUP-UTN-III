package controllers;

import models.entities.CredencialEntity;
import models.entities.UsuarioEntity;
import models.services.UsuarioService;

import java.util.Optional;

public class UsuarioController{

    private final UsuarioService usuarioService;

    public UsuarioController(){
        this.usuarioService = new UsuarioService();
    }

    public void registrarUsuario(UsuarioEntity nuevoUsuario){
        usuarioService.crear(nuevoUsuario);
    }

    public Optional<UsuarioEntity> loguearUsuario(String username, String password){
        return usuarioService.loguear(username, password);
    }
}
