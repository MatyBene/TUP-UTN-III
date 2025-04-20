package models.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsuarioEntity{

    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private LocalDateTime fechaCreacion;
    private CredencialEntity credencial;
    private List<CuentaEntity> cuentas;

    public UsuarioEntity(){
    }

    public UsuarioEntity(String nombre,
                         String apellido,
                         String dni,
                         String email,
                         CredencialEntity credencial){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.fechaCreacion = LocalDateTime.now();
        this.credencial = credencial;
        this.cuentas = new ArrayList<>();
    }

    public UsuarioEntity(Integer id,
                         String nombre,
                         String apellido,
                         String dni,
                         String email,
                         LocalDateTime fechaCreacion){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public String getDni(){
        return dni;
    }

    public void setDni(String dni){
        this.dni = dni;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public LocalDateTime getFechaCreacion(){
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }

    public CredencialEntity getCredencial(){
        return credencial;
    }

    public void setCredencial(CredencialEntity credencial){
        this.credencial = credencial;
    }

    public List<CuentaEntity> getCuentas(){
        return cuentas;
    }

    public void setCuentas(List<CuentaEntity> cuentas){
        this.cuentas = cuentas;
    }

    @Override
    public String toString(){
        return "\nUsuarioEntity{" + "id=" + id + ", nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + ", dni='" + dni + '\'' + ", email='" + email + '\'' + ", fechaCreacion=" + fechaCreacion + ", credencial=" + credencial + ", cuentas=" + cuentas + '}';
    }
}
