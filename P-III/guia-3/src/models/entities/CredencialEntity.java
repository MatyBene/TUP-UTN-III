package models.entities;

import models.entities.enums.Permiso;

public class CredencialEntity{

    private Integer id;
    private Integer usuarioId;
    private String username;
    private String password;
    private Permiso permiso;

    public CredencialEntity(){
    }

    public CredencialEntity(String username,
                            String password,
                            Permiso permiso){
        this.username = username;
        this.password = password;
        this.permiso = permiso;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getUsuarioId(){
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId){
        this.usuarioId = usuarioId;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Permiso getPermiso(){
        return permiso;
    }

    public void setPermiso(Permiso permiso){
        this.permiso = permiso;
    }
}
