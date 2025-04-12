package models.entities.enums;

import java.time.LocalDateTime;

public class CuentaEntity{

    private Integer id;
    private Integer usuarioId;
    private TipoCuenta tipo;
    private Double saldo;
    private LocalDateTime fechaCreacion;

    public CuentaEntity(){
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

    public TipoCuenta getTipo(){
        return tipo;
    }

    public void setTipo(TipoCuenta tipo){
        this.tipo = tipo;
    }

    public Double getSaldo(){
        return saldo;
    }

    public void setSaldo(Double saldo){
        this.saldo = saldo;
    }

    public LocalDateTime getFechaCreacion(){
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion){
        this.fechaCreacion = fechaCreacion;
    }
}
