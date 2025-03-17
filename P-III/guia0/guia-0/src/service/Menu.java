package service;

import model.Expansion;
import model.Juego;
import model.Media;
import repository.Repositorio;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Menu implements IMenu{

    private Scanner scanner = new Scanner(System.in);
    private Repositorio<Media> repositorio = new Repositorio<>();

    @Override
    public void mostrarMenu() {
        while(true){
            System.out.println("1. Agregar media" +
                    "\n2. Eliminar media" +
                    "\n3. Mostrar listado" +
                    "\n4. Filtrar por genero" +
                    "\n5. Modificar atributo" +
                    "\n6. Buscar por id" +
                    "\n7. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion){
                case 1:
                    agregarMedia();
                    break;
                case 2:
                    eliminarMedia();
                    break;
                case 3:
                    mostrarLista();
                    break;
                case 4:
                    filtrarXGenero();
                    break;
                case 5:
                    break;
                case 6:
                    mostrarXId();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Ingrese una opcion valida.");
            }
        }
    }

    @Override
    public void agregarMedia() {
        System.out.println("1. Agregar juego." +
                "\n2. Agregar expansion.");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Creador: ");
        String creador = scanner.nextLine();
        System.out.print("Género: ");
        String genero = scanner.nextLine();

        switch(opcion){
            case 1:
                System.out.println("Version: ");
                int version = scanner.nextInt();
                Juego juego = new Juego(titulo, creador, genero, version);
                repositorio.agregarMedia(juego);
                break;
            case 2:
                try {
                    System.out.print("Fecha de lanzamiento (YYYY-MM-DD): ");
                    LocalDate fechaLanzamiento = LocalDate.parse(scanner.nextLine()); // Convierte la cadena en LocalDate
                    Expansion expansion = new Expansion(titulo, creador, genero, fechaLanzamiento);
                    repositorio.agregarMedia(expansion);
                } catch (DateTimeParseException e) {
                    System.out.println("Formato invalido. Intente nuevamente con el formato YYYY-MM-DD.");
                }
                break;
        }
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
