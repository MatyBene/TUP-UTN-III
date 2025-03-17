package model;

public class Juego extends Media{

    private int version;

    public Juego() {
    }

    public Juego(String titulo, String creador, String genero, int version) {
        super(titulo, creador, genero);
        this.version = version;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
