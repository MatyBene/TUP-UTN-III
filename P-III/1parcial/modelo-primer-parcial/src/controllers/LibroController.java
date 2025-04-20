package controllers;

import models.LibroEntity;
import services.LibroService;

import java.util.List;
import java.util.Optional;

public class LibroController{

    private final LibroService libroService;

    public LibroController(){
        this.libroService = new LibroService();
    }

    public Optional<LibroEntity> libroMasPrestado(){
        return libroService.masPrestado();
    }

    public void prestarLibro(Integer id){
        libroService.reducirStock(id);
    }

    public int totalLibrosDisponibles(){
        return libroService.librosDisponibles();
    }

    public List<LibroEntity> listarLibros(){
        return libroService.libros();
    }
}
