package views;

import controllers.AlumnoController;
import controllers.DireccionController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu{

    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        AlumnoController alumnoController = new AlumnoController();
        DireccionController direccionController = new DireccionController();
        int opcion;

        do {
            opciones();
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
                    System.out.println("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese el apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.println("Ingrese la edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el email: ");
                    String email = scanner.nextLine();
                    alumnoController.agregarAlumno(nombre, apellido, edad, email);
                }
                case 2 -> {}
                case 3 -> {}
                case 4 -> {}
                case 5 -> {}
                case 6 -> {}
                case 7 -> {}
                default -> System.out.println("Opcion no valida, intente de nuevo.");
            }
        } while(opcion != 0);

        scanner.close();
    }

    public static void opciones(){
        System.out.println("1. Insertar alumno");
        System.out.println("2. Insertar dirección");
        System.out.println("3. Listar alumnos");
        System.out.println("4. Listar direcciones por alumno");
        System.out.println("5. Actualizar edad de un alumno");
        System.out.println("6. Eliminar un alumno");
        System.out.println("7. Eliminar una dirección");
        System.out.println("0. Salir");
    }
}
