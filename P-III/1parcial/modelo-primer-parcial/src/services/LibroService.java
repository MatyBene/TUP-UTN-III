package services;

import models.LibroEntity;
import models.PrestamoEntity;
import repositories.LibroRepository;
import repositories.PrestamoRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class LibroService{

    private final LibroRepository libroRepository;
    private final PrestamoRepository prestamoRepository;

    public LibroService(){
        this.libroRepository = new LibroRepository();
        this.prestamoRepository = new PrestamoRepository();
    }

    public Optional<LibroEntity> masPrestado(){
        List<LibroEntity> libros = libroRepository.listar();
        List<PrestamoEntity> prestamos = prestamoRepository.listar();

        return libros.stream()
                     .max(Comparator.comparingInt(l -> (int) prestamos.stream()
                                                                      .filter(p -> p.getLibroId() == l.getId())
                                                                      .count()));
    }

    public boolean stockDisponible(LibroEntity libro){
        return libro.getStock() > 0;
    }

    public void reducirStock(Integer id){
        libroRepository.buscarXId(id)
                       .ifPresent(libro -> {
                           if(stockDisponible(libro)){
                               libro.setStock(libro.getStock() - 1);
                               libroRepository.modificar(libro);
                           } else {
                               System.out.println("El libro no tiene stock disponible.");
                           }
                       });
    }

    public void aumentarStock(Integer id){
        libroRepository.buscarXId(id)
                       .ifPresent(libro -> {
                           libro.setStock(libro.getStock() + 1);
                           libroRepository.modificar(libro);
                       });
    }

    public int librosDisponibles(){
        return libroRepository.listar()
                              .stream()
                              .mapToInt(LibroEntity::getStock)
                              .sum();
    }

    public List<LibroEntity> libros(){
        return libroRepository.listar();
    }
}
