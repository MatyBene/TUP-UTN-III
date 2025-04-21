package view;

import config.DBConnection;

import java.util.InputMismatchException;
import java.util.Scanner;

import static model.utils.DisplayManager.printMsg;

public class Menu{

    public static void menuPrincipal(){
        Scanner scanner = new Scanner(System.in);
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
                case 1 -> {}
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
                case 0 -> printMsg("Saliendo del programa");
                default -> printMsg("Opcion no valida, intente de nuevo");
            }

        } while(opcion != 0);

        scanner.close();
        DBConnection.cerrarConexion();
    }

    public static void mostrarMenu(){

        printMsg("---  ---");
        printMsg("- Menu principal -");
        printMsg("1. ");
        printMsg("2. ");
        printMsg("3. ");
        printMsg("4. ");
        printMsg("5. ");
        printMsg("6. ");
        printMsg("7. ");
        printMsg("8. ");
        printMsg("9. ");
        printMsg("10. ");
        printMsg("11. ");
        printMsg("12. ");
        printMsg("13. ");
        printMsg("0. Salir");

    }
}
