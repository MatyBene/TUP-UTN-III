package controllers;

import models.UsuarioEntity;
import services.UsuarioService;

import java.util.List;
import java.util.Optional;

public class UsuarioController{

    private final UsuarioService usuarioService;

    public UsuarioController(){
        this.usuarioService = new UsuarioService();
    }

    public void crearUsuario(UsuarioEntity usuario){
        usuarioService.crear(usuario);
    }

    public void eliminarUsuario(Integer id){
        usuarioService.eliminar(id);
    }

    public List<UsuarioEntity> listarUsuariosConPrestamosActivos(){
        return usuarioService.UsuariosConPrestamosActivos();
    }

    public boolean puedeSolicitar(Integer id){
        return usuarioService.puedeSolicitar(id);
    }

    public List<UsuarioEntity> listarUsuarios(){
        return usuarioService.usuarios();
    }

    public Optional<UsuarioEntity> usuarioConMayorNumeroDePrestamosHistorico(){
        return usuarioService.usuarioConMasPrestamos();
    }
}
