package view;

import controllers.CuentaController;
import controllers.UsuarioController;
import models.entities.CredencialEntity;
import models.entities.UsuarioEntity;
import models.entities.enums.Permiso;

import java.util.Scanner;

import static models.utils.DisplayManager.*;

public class Menu{

    private static UsuarioEntity usuarioLogueado = null;
    private static final Scanner scanner = new Scanner(System.in);
    private static final UsuarioController usuarioController = new UsuarioController();
    private static final CuentaController cuentaController = new CuentaController();

    public static void inicioApp(){
        while(usuarioLogueado != null){
             menuPrincipal();
        }
        menuInicio();
    }

    private static void menuInicio(){
        printMsg("------ Banco ------");
        printMsg("1. Iniciar sesion.");
        printMsg("2. Registrarse.");
        printMsg("3. Salir.");
        printMsg("Saleccione una opcion: ");

        int op = scanner.nextInt();
        scanner.nextLine();

        switch(op){
            case 1 -> iniciarSesion();
            case 2 -> registrarse();
            case 3 -> {
                printMsg("Saliendo del banco.");
                System.exit(0);
            }
            default -> printMsg("Ingrese una opcion valida");
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
    }

    private static void iniciarSesion(){
        printMsg("------ Iniciar sesion ------");
        printMsg("Ingresar usuario: ");
        String username = scanner.nextLine();
        printMsg("Ingresar contraseña: ");
        String password = scanner.nextLine();


    }

    private static void menuPrincipal(){
        boolean salir = false;

        while(!salir){
            printMsg("------ Menu principal ------");
            printMsg("1. Ver mis cuentas.");
            printMsg("2. Ver mi saldo.");
            printMsg("3. Depositar saldo en mi cuenta.");
        }
    }

}
