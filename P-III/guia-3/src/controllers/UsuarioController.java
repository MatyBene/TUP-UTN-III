package controllers;

import models.entities.CredencialEntity;
import models.entities.UsuarioEntity;
import models.services.UsuarioService;

public class UsuarioController{

    private final UsuarioService usuarioService;

    public UsuarioController(){
        this.usuarioService = new UsuarioService();
    }

    public void registrarUsuario(UsuarioEntity nuevoUsuario){
        usuarioService.crear(nuevoUsuario);
    }
}
