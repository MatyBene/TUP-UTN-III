package model;

import java.util.UUID;

public abstract class Media implements Comparable<Media>{

    protected String titulo;
    protected String creador;
    protected String genero;
    protected String id;

    public Media() {
    }

    public Media(String titulo, String creador, String genero) {
        this.titulo = titulo;
        this.creador = creador;
        this.genero = genero;
        this.id = UUID.randomUUID().toString();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getId() {
        return id;
    }

    @Override
    public int compareTo(Media media) {
        return this.id.compareTo(media.id);
    }
}
