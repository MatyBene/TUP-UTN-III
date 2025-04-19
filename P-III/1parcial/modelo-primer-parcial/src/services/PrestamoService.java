package services;

import models.LibroEntity;
import models.PrestamoEntity;
import repositories.LibroRepository;
import repositories.PrestamoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static utils.DisplayManager.printMsg;

public class PrestamoService {

    private final PrestamoRepository prestamoRepository;
    private final LibroRepository libroRepository;

    public PrestamoService() {
        this.prestamoRepository = new PrestamoRepository();
        this.libroRepository = new LibroRepository();
    }

    public void crear(PrestamoEntity prestamo){
        prestamoRepository.guardar(prestamo);
    }

    public void devolverPrestamo(Integer id){
        Optional<PrestamoEntity> oPrestamo = prestamoRepository.buscarXId(id);

        if (oPrestamo.isPresent() && oPrestamo.get().getFechaDevolucion() == null) {
            PrestamoEntity prestamo = oPrestamo.get();
            prestamo.setFechaDevolucion(new Date());
            prestamoRepository.modificar(prestamo);

            LibroEntity libro = libroRepository.buscarXId(prestamo.getLibroId()).get();
            libro.setStock(libro.getStock() + 1);
            libroRepository.modificar(libro);
        } else {
            printMsg("No existe prestamo con ese id o ya se devolvio ese prestamo");
        }
    }

    public List<PrestamoEntity> prestamos(){
        return prestamoRepository.listar();
    }

    public List<PrestamoEntity> prestamosActivos(){
        List<PrestamoEntity> prestamos = prestamoRepository.listar();

        return prestamos.stream()
                .filter(p -> p.getFechaDevolucion() == null)
                .toList();
    }
}
