package view;

import config.DBConnection;
import controllers.CuentaController;
import controllers.UsuarioController;
import models.entities.CredencialEntity;
import models.entities.UsuarioEntity;
import models.entities.enums.Permiso;
import models.repositories.impl.UsuarioRepositoryImpl;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import static models.utils.DisplayManager.*;

public class Menu{

    private static UsuarioEntity usuarioLogueado = null;
    private static final Scanner scanner = new Scanner(System.in);
    private static final UsuarioController usuarioController = new UsuarioController();
    private static final CuentaController cuentaController = new CuentaController();
    private static final UsuarioRepositoryImpl usuarioRepository = new UsuarioRepositoryImpl();

    public static void inicioApp(){
        while(usuarioLogueado != null){
             menuPrincipal();
        }
        menuInicio();
    }

    private static void menuInicio(){

        printList(usuarioRepository.listar());
        printMsg("------ Banco ------");
        printMsg("1. Iniciar sesion.");
        printMsg("2. Registrarse.");
        printMsg("3. Salir.");
        printMsg("Saleccione una opcion: ");

        int opcion;
        try {
            opcion = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            printError("Ingrese un número válido.");
            scanner.nextLine();
            opcion = -1;
        }

        switch(opcion){
            case 1 -> iniciarSesion();
            case 2 -> registrarse();
            case 3 -> {
                printMsg("Saliendo del banco.");
                System.exit(0);
            }
            default -> printError("Ingrese una opcion valida");
        }
    }

    private static void registrarse(){
        printMsg("------ Formulario de registro ------");
        printMsg("Nombre: ");
        String nombre = scanner.nextLine();
        printMsg("Apellido: ");
        String apellido = scanner.nextLine();
        printMsg("DNI: ");
        String dni = scanner.nextLine();
        printMsg("Email: ");
        String email = scanner.nextLine();
        printMsg("Username: ");
        String username = scanner.nextLine();
        printMsg("Password: ");
        String password = scanner.nextLine();

        CredencialEntity credencialRegistro = new CredencialEntity(username, password, Permiso.CLIENTE);
        UsuarioEntity usuarioRegistro = new UsuarioEntity(nombre, apellido, dni, email, credencialRegistro);

        usuarioController.registrarUsuario(usuarioRegistro);

        usuarioLogueado = usuarioController.loguearUsuario(username, password).get();
    }

    private static void iniciarSesion(){
        printMsg("------ Iniciar sesion ------");
        printMsg("Ingresar usuario: ");
        String username = scanner.nextLine();
        printMsg("Ingresar contraseña: ");
        String password = scanner.nextLine();

        Optional<UsuarioEntity> usuario = usuarioController.loguearUsuario(username, password);
        usuarioLogueado = usuario.orElse(null);

        if (usuarioLogueado == null) {
            printError("Credenciales incorrectas. Intente nuevamente.");
            menuInicio();
        } else {
            printMsg("Inicio de sesión exitoso. Bienvenido, " + usuarioLogueado.getNombre());
        }
    }

    private static void menuPrincipal(){
        int opcion;

        do {
            opcionesMenuPrincipal();
            try{
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch(InputMismatchException e){
                printError("Ingrese un numero valido");
                scanner.nextLine();
                opcion = -1;
            }

            switch(opcion){
                case 1 -> {
                    printList(usuarioLogueado.getCuentas());
                }
                case 2 -> {}
                case 3 -> {}
                case 4 -> {}
                case 5 -> {}
                case 6 -> {}
                case 7 -> {}
                case 8 -> {}
                case 9 -> {}
                case 10 -> {}
                case 11 -> {}
                case 12 -> {}
                case 13 -> {}
                case 14 -> {}
                case 15 -> {}
                case 16 -> {}
                case 17 -> {}
                case 18 -> {}
                case 19 -> {}
                default  -> {}
            }
        } while(opcion != 0);

        scanner.close();
        DBConnection.cerrarConexion();
    }

    private static void opcionesMenuPrincipal(){
        printMsg("------ Menu principal ------");
        printMsg("1. Ver mis cuentas");
        printMsg("2. Ver todos los usuarios");
        printMsg("3. Buscar por DNI");
        printMsg("4. Buscar por Email");
        printMsg("5. Modificar mis datos");
        printMsg("6. Modificar datos de otro usuario");
        printMsg("7. Eliminar usuario");
        printMsg("8. Ver cuentas propias");
        printMsg("9. Ver cuentas de otro usuario");
        printMsg("10. Ver total del saldo propio");
        printMsg("11. Ver total del saldo de un usuario por DNI");
        printMsg("12. Depositar en cuenta propia");
        printMsg("13. Depositar en cuenta de tercero");
        printMsg("14. Transferir desde cuenta propia");
        printMsg("15. Transferir entre cuentas terceros");
        printMsg("16. Ver cantidad de usuarios clientes");
        printMsg("17. Ver cantidad de cuentas por tipo");
        printMsg("18. Ver usuario con mayor saldo total");
        printMsg("19. Listar usuarios por saldo total");
        printMsg("Seleccione una opción: ");
    }
}
