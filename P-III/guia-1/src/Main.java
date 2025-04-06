import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // Listas de datos para usar en los ejercicios
    private static final List<Integer> numbers = List.of(8, 3, 5, 1, 9, 6, 12, 3, 7, 4, 2, 10, 15, 20);
    private static final List<String> names = List.of("Juan", "Ana", "Pedro", "Carla", "Miguel");
    private static final List<String> words = List.of("Java", "Stream", "Lambda", "Funcional", "API");

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
                case 1 -> filterEvenNumbers();
                case 2 -> convertNamesToUppercase();
                case 3 -> sortNumbersList();
                case 4 -> countGreaterThan(5);
                case 5 -> getFirstFiveElements();
                case 6 -> convertWordsToLength();
                case 7 -> concatenateNames();
                case 8 -> removeDuplicates();
                case 9 -> getTop3Numbers();
                case 10 -> groupWordsByLength();
                case 11 -> productOfNumbers();
                case 12 -> longestName();
                case 13 -> listOfIntegersAsString();
                case 14 -> groupEvensAndOdds();
                case 15 -> sumOfOddSquares();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    // Resolucion de los ejercicios

    // 1
    public static void filterEvenNumbers() {
        List<Integer> evenList = numbers.stream()
                                        .filter(n -> n % 2 == 0)
                                        .toList();

        System.out.println("Numeros pares filtrados: " + evenList);
    }

    // 2
    public static void convertNamesToUppercase() {
        List<String> uppercaseNamesList = names.stream()
                                               .map(String::toUpperCase)
                                               .toList();

        System.out.println("Listado de nombres en mayusculas: " + uppercaseNamesList);
    }

    // 3
    public static void sortNumbersList() {
        List<Integer> sortedNumbers = numbers.stream()
                                             .sorted()
                                             .toList();

        System.out.println("Lista de numeros ordenados de menor a mayor: " + sortedNumbers);
    }

    // 4
    public static void countGreaterThan(int value) {
        long count = numbers.stream()
                            .filter(n -> n > value)
                            .count();

        System.out.println("La cantidad de numeros mayores a " + value + " es: " + count);
    }

    // 5
    public static void getFirstFiveElements() {
        List<Integer> firstFive = numbers.stream()
                                         .limit(5)
                                         .toList();

        System.out.println("Los primeros 5 elementos del listado de numeros son: " + firstFive);
    }

    // 6
    public static void convertWordsToLength() {
        List<Integer> lengths = words.stream()
                                     .map(String::length)
                                     .toList();

        System.out.println("Lista con las longitudes de cada palabra: " + lengths);
    }

    // 7
    public static void concatenateNames() {
        String stringOfNames = names.stream()
                                    .reduce((x, y) -> x + ", " + y)
                                    .orElse("");
        System.out.println("Nombres concatenados: " + stringOfNames);
    }

    // 8
    public static void removeDuplicates() {
        List<Integer> noDuplicates = numbers.stream()
                                            .distinct()
                                            .toList();

        System.out.println("Lista de numeros sin duplicados: " + noDuplicates);
    }

    // 9
    public static void getTop3Numbers() {
        List<Integer> top3 = numbers.stream()
                                    .sorted(Comparator.reverseOrder())
                                    .limit(3)
                                    .toList();

        System.out.println("Los 3 numeros mas grandes son: " + top3);
    }

    // 10
    public static void groupWordsByLength() {
        Map<Integer, List<String>> wordLength = words.stream()
                                                     .collect(Collectors.groupingBy(String::length));

        System.out.println("Palabras agrupadas por longitud: " + wordLength);
    }

    // 11
    public static void productOfNumbers() {
        Integer product = numbers.stream()
                                 .reduce(1, (x, y) -> x * y);

        System.out.println("El producto de todos los numeros es: " + product);
    }

    // 12
    public static void longestName() {
        String name = names.stream()
                           .reduce((n1, n2) -> n1.length() >= n2.length() ? n1 : n2)
                           .orElse("");

        System.out.println("El nombre mas largo es: " + name);
    }

    // 13
    public static void listOfIntegersAsString() {
        String stringNumbers = numbers.stream()
                                      .map(String::valueOf)
                                      .collect(Collectors.joining(" - "));

        System.out.println("Numeros encadenados: " + stringNumbers);
    }

    // 14
    public static void groupEvensAndOdds() {
        Map<Boolean, List<Integer>> group = numbers.stream()
                                                   .collect(Collectors.partitioningBy(x -> x % 2 == 0));

        System.out.println("Lista de pares: " + group.get(true));
        System.out.println("Lista de impares: " + group.get(false));
    }

    // 15
    public static void sumOfOddSquares() {
        Integer sum = numbers.stream()
                             .filter(n -> n % 2 != 0)
                             .map(n -> n * n)
                             .reduce(0, Integer::sum);

        System.out.println("La suma de los cuadrados de los numeros impares es: " + sum);
    }

}