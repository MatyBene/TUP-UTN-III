import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Listas de datos para usar en los ejercicios
    private static final List<Integer> numeros = List.of(8, 3, 5, 1, 9, 6, 12, 3, 7, 4, 2, 10, 15, 20);
    private static final List<String> nombres = List.of("Juan", "Ana", "Pedro", "Carla", "Miguel");
    private static final List<String> palabras = List.of("Java", "Stream", "Lambda", "Funcional", "API");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Menú de opciones
            System.out.println("\n===== MENÚ DE EJERCICIOS STREAMS Y LAMBDAS =====");
            System.out.println("1. Filtrar números pares");
            System.out.println("2. Transformar una lista de nombres a mayúsculas");
            System.out.println("3. Ordenar una lista de números");
            System.out.println("4. Contar elementos mayores a un valor dado");
            System.out.println("5. Obtener los primeros 5 elementos de una lista");
            System.out.println("6. Convertir una lista de palabras en su longitud");
            System.out.println("7. Concatenar nombres con una separación");
            System.out.println("8. Eliminar duplicados de una lista");
            System.out.println("9. Obtener los 3 números más grandes de una lista");
            System.out.println("10. Agrupar palabras por su longitud");
            System.out.println("11. Encontrar el producto de todos los números de una lista");
            System.out.println("12. Obtener el nombre más largo de una lista");
            System.out.println("13. Convertir una lista de enteros en una cadena separada por guiones");
            System.out.println("14. Agrupar una lista de números en pares e impares");
            System.out.println("15. Obtener la suma de los cuadrados de los números impares");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1 -> filtrarNumerosPares();
                case 2 -> transformarNombresAMayusculas();
                case 3 -> ordenarListaNumeros();
                case 4 -> contarMayoresQue(5);
                case 5 -> obtenerPrimeros5Elementos();
                case 6 -> convertirPalabrasALongitud();
                case 7 -> concatenarNombres();
                case 8 -> eliminarDuplicados();
                case 9 -> obtenerTop3Numeros();
                //case 10 -> agruparPalabrasPorLongitud();
                //case 11 -> productoDeNumeros();
                //case 12 -> nombreMasLargo();
                //case 13 -> listaEnterosComoString();
                //case 14 -> agruparParesEImpares();
                //case 15 -> sumaDeCuadradosImpares();
                //case 0 -> System.out.println("Saliendo del programa...");
                //default -> System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    // Resolucion de los ejercicios

    // 1
    public static void filtrarNumerosPares() {
        List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).toList();
        System.out.println("Lista de pares: " + pares);
    }

    // 2
    public static void transformarNombresAMayusculas() {
        List<String> mayusculas = nombres.stream().map(String::toUpperCase).toList();
        System.out.println("Lista de nombres en mayusculas: " + mayusculas);
    }

    // 3
    public static void ordenarListaNumeros() {
        List<Integer> ordenados = numeros.stream().sorted().toList();
        System.out.println("Lista de numeros ordenados: " + ordenados);
    }

    // 4
    public static void contarMayoresQue(int x) {
        int mayores = (int) numeros.stream().filter(n -> n > x).count();
        System.out.println("La cantidad de numeros mayores a " + x + " es: " + mayores);
    }

    // 5
    public static void obtenerPrimeros5Elementos() {
        List<Integer> primeros5 = numeros.stream().limit(5).toList();
        System.out.println("Los primeros 5 elementos de la lista son: " + primeros5);
    }

    // 6
    public static void convertirPalabrasALongitud(){
        List<Integer> longitudPalabras = palabras.stream().map(String::length).toList();
        System.out.println("Lista con la longitud de cada palabra: " + longitudPalabras);
    }

    // 7
    public static void concatenarNombres() {
        String nombresConcatenados = nombres.stream().reduce((x, y) -> x + ", " + y).orElse("");
        System.out.println("Nombres concatenados: " + nombresConcatenados);
    }

    // 8
    public static void eliminarDuplicados() {
        List<Integer> noRepetidos = numeros.stream().distinct().toList();
        System.out.println("Lista de numeros no repetidos: " + noRepetidos);
    }

    // 9
    public static void obtenerTop3Numeros() {
        List<Integer> top3 = numeros.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
//        List<Integer> top3 = numeros.stream().sorted(Comparator.reverseOrder()).limit(3).sorted().toList();
        System.out.println("Los tres numeros mas grandes son: " + top3);
    }

//    // 10
//    public static void agruparPalabrasPorLongitud() {
//
//    }
//
//    // 11
//    public static void productoDeNumeros() {
//
//    }
//
//    // 12
//    public static void nombreMasLargo() {
//
//    }
//
//    // 13
//    public static void listaEnterosComoString() {
//
//    }
//
//    // 14
//    public static void agruparParesEImpares() {
//
//    }
//
//    // 15
//    public static void sumaDeCuadradosImpares() {
//
//    }
}