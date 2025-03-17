package service;

import model.Media;
import repository.Repositorio;

import java.util.Scanner;

public class Menu implements IMenu{

    private Scanner scanner = new Scanner(System.in);
    private Repositorio<Media> repositorio = new Repositorio<>();

    @Override
    public void mostrarMenu() {

    }

    @Override
    public void agregarMedia() {

    }

    @Override
    public void eliminarMedia() {

    }

    @Override
    public void mostrarLista() {

    }

    @Override
    public void filtrarXTipo() {

    }

    @Override
    public void filtrarXGenero() {

    }

    @Override
    public void mostrarXId() {
        System.out.println("Ingrese el ID que desea buscar: ");
        String idABuscar = scanner.nextLine();
        Media media = repositorio.buscarXId(idABuscar);

        if (media != null){
            System.out.println("Titulo: " + media.getTitulo());
            System.out.println("\nCreador: " + media.getCreador());
            System.out.println("\nGenero: " + media.getGenero());
        }
    }
}
