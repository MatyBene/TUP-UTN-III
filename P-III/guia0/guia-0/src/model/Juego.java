package model;

public class Juego extends Media{

    private String version;

    public Juego() {
    }

    public Juego(String titulo, String creador, String genero, String version) {
        super(titulo, creador, genero);
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
