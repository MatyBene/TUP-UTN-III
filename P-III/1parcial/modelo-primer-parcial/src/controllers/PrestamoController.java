package controllers;

import models.PrestamoEntity;
import services.PrestamoService;

import java.util.List;

public class PrestamoController{

    private final PrestamoService prestamoService;

    public PrestamoController(){
        this.prestamoService = new PrestamoService();
    }

    public void generarPrestamo(PrestamoEntity prestamo){
        prestamoService.crear(prestamo);
    }

    public void marcarPrestamoDevuelto(Integer id){
        prestamoService.devolverPrestamo(id);
    }

    public List<PrestamoEntity> listarPrestamos(){
        return prestamoService.prestamos();
    }

    public List<PrestamoEntity> listarPrestamosActivos(){
        return prestamoService.prestamosActivos();
    }
}
