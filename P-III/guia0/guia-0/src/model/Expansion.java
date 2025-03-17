package model;

import java.time.LocalDate;

public class Expansion extends Media{

    private LocalDate fechaLanzamiento;

    public Expansion() {
    }

    public Expansion(String titulo, String creador, String genero, LocalDate fechaLanzamiento) {
        super(titulo, creador, genero);
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }
}
