package models;

import java.util.Date;

public class PrestamoEntity{

    private Integer id;
    private Integer libroId;
    private Integer usuarioId;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    public PrestamoEntity(){
    }

    public PrestamoEntity(Integer id,
                          Integer libroId,
                          Integer usuarioId,
                          Date fechaPrestamo,
                          Date fechaDevolucion){
        this.id = id;
        this.libroId = libroId;
        this.usuarioId = usuarioId;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public PrestamoEntity(Integer libroId,
                          Integer usuarioId){
        this.libroId = libroId;
        this.usuarioId = usuarioId;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getLibroId(){
        return libroId;
    }

    public void setLibroId(Integer libroId){
        this.libroId = libroId;
    }

    public Integer getUsuarioId(){
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId){
        this.usuarioId = usuarioId;
    }

    public Date getFechaPrestamo(){
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo){
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion(){
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion){
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString(){
        return "\nPrestamoEntity{" + "id=" + id + ", libroId=" + libroId + ", usuarioId=" + usuarioId + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + '}';
    }
}
