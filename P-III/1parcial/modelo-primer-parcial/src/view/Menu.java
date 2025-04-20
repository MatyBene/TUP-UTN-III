package view;

import config.DBConnection;
import controllers.LibroController;
import controllers.PrestamoController;
import controllers.UsuarioController;
import models.LibroEntity;
import models.PrestamoEntity;
import models.UsuarioEntity;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import static utils.DisplayManager.printList;
import static utils.DisplayManager.printMsg;

public class Menu{

    public static void menuPrincipal(){
        Scanner scanner = new Scanner(System.in);
        UsuarioController usuarioController = new UsuarioController();
        PrestamoController prestamoController = new PrestamoController();
        LibroController libroController = new LibroController();

        int opcion;

        do {
            mostrarMenu();
            try{
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch(InputMismatchException e){
                System.out.println("Ingrese un numero valido.");
                scanner.nextLine();
                opcion = -1;
            }

            switch(opcion){
                case 1 -> {
                    printMsg("Ingrese el nombre del usuario: ");
                    String nombre = scanner.nextLine();
                    printMsg("Ingrese el email del usuario: ");
                    String email = scanner.nextLine();

                    usuarioController.crearUsuario(new UsuarioEntity(nombre, email));
                }
                case 2 -> {
                    printMsg("Ingrese el id del usuario a dar de baja:");
                    Integer id = scanner.nextInt();
                    scanner.nextLine();
                    usuarioController.eliminarUsuario(id);
                }
                case 3 -> {
                    printList(usuarioController.listarUsuariosConPrestamosActivos());
                }
                case 4 -> {
                    printMsg("Ingrese el id del usuario: ");
                    Integer idUsuario = scanner.nextInt();
                    scanner.nextLine();

                    if(usuarioController.puedeSolicitar(idUsuario)){
                        printMsg("Ingrese el id del libro: ");
                        Integer idLibro = scanner.nextInt();
                        scanner.nextLine();

                        libroController.prestarLibro(idLibro);
                        prestamoController.generarPrestamo(new PrestamoEntity(idLibro, idUsuario));

                    } else {
                        printMsg("El usuario ya esta en el limite de prestamos");
                    }
                }
                case 5 -> {
                    printMsg("Ingrese el id del prestamo: ");
                    Integer id = scanner.nextInt();
                    scanner.nextLine();

                    prestamoController.marcarPrestamoDevuelto(id);
                }
                case 6 -> {
                    printList(prestamoController.listarPrestamos());
                }
                case 7 -> {
                    printList(prestamoController.listarPrestamosActivos());
                }
                case 8 -> {
                    Optional<LibroEntity> libro = libroController.libroMasPrestado();

                    if(libro.isPresent()){
                        System.out.println(libro);
                    } else {
                        printMsg("No se presto ningun libro");
                    }
                }
                case 9 -> {
                    int librosDisponibles = libroController.totalLibrosDisponibles();
                    printMsg("La cantidad de libros disponibles es: " + librosDisponibles);
                }
                case 10 -> {
                    printList(libroController.listarLibros());
                }
                case 11 -> {
                    Optional<UsuarioEntity> usuario = usuarioController.usuarioConMayorNumeroDePrestamosHistorico();

                    if(usuario.isPresent()){
                        System.out.println(usuario);
                    } else {
                        printMsg("Todavia ningun usuario solicito un prestamo");
                    }
                }
                case 12 -> {
                }
                case 13 -> {
                    printList(usuarioController.listarUsuarios());
                }
                case 0 -> printMsg("Saliendo de la biblioteca");
                default -> printMsg("Opcion no valida, intente de nuevo");
            }
        } while(opcion != 0);

        scanner.close();
        DBConnection.cerrarConexion();
    }

    public static void mostrarMenu(){

        printMsg("--- Biblioteca ---");
        printMsg("- Menu principal -");
        printMsg("1. Dar de alta un usuario");
        printMsg("2. Dar de baja un usuario");
        printMsg("3. Listar todos los usuarios con prestamos activos");
        printMsg("4. Generar un prestamo nuevo");
        printMsg("5. Marcar un prestamo como devuelto");
        printMsg("6. Visualizar todos los prestamos");
        printMsg("7. Visualizar todos los prestamos activos");
        printMsg("8. Visualizar libro mas prestado");
        printMsg("9. Visualizazr el total de libros disponibles");
        printMsg("10. Visualizar todos los libros");
        printMsg("11. Visualizar el usuario con mayor numero de prestamos historicos en el sistema");
        printMsg("12. Visualizar el promedio de prestamos");
        printMsg("13. Listar todo los usuarios");
        printMsg("0. Salir");

    }
}
