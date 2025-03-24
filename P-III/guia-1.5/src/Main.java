import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

//    private static final List<Producto> productos = List.of();
    private static final List<Producto> productos = cargarProductos();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Menú de opciones
            System.out.println("\n===== Guia 1.5 =====");
            System.out.println("1. Obtener una lista con los nombres y precios de los productos de la categoría\n" +
                    "\"Electrónica\" cuyo precio sea mayor a 1000, ordenados de mayor a menor\n" +
                    "precio.");
            System.out.println("2. Calcular el precio promedio de los productos de la categoría \"Hogar\", pero\n" +
                    "solo considerando aquellos con stock disponible.");
            System.out.println("3. Obtener el producto más caro de cada categoría y devolver un mapa con la\n" +
                    "categoría como clave y el producto más caro como valor.");
            System.out.println("4. Encontrar el producto de la categoría \"Deportes\" con stock mayor a 10\n" +
                    "unidades, obtener su nombre en minúsculas y devolverlo dentro de un\n" +
                    "Optional. Mostrarlo o si no existe, mostrar “Producto Inexistente”");
            System.out.println("5. Encontrar el producto mas barato calculando el valor total de todas las\n" +
                    "unidades en stock (Precio * stock). Devolver un Opcional con el producto. En\n" +
                    "caso de que no exista, lanzar una excepción.");
            System.out.println("6. Obtener una lista con los nombres de los productos que tienen stock,\n" +
                    "ordenarlos alfabéticamente y excluir los productos con nombres de menos de\n" +
                    "5 caracteres.");
            System.out.println("7. Obtener el total de unidades en stock de todos los productos, pero solo\n" +
                    "considerando aquellos con precio superior al promedio.");
            System.out.println("8. Calcular cuántas unidades en stock hay por categoría, excluyendo categorías\n" +
                    "con menos de 3 productos.");
            System.out.println("9. Crear una nueva lista de productos con un 15% de descuento en su precio,\n" +
                    "pero solo si el producto tiene más de 20 unidades en stock.");
            System.out.println("10. Calcular la ganancia total si se vendiera todo el inventario, considerando que\n" +
                    "el costo de compra de cada producto es un 45% del valor de venta o de un\n" +
                    "65% si pertenece a la categoria Electronica.");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1 -> filtradoYTransformacion("Electrónica", 1000);
                case 2 -> reduccionDeDatos();
                case 3 -> productoMasCaro();
                case 4 -> usoDeOptionals() ;
                case 5 -> productoMasBarato();
                case 6 -> productosEnStockOrdenadosAlfabeticamente();
                case 7 -> calculoDeStockTotal();
                case 8 -> stockPorCategoria();
                case 9 -> aplicarDescuento();
                case 10 -> gananciaTotalDeInventario();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    // 1
    public static void filtradoYTransformacion(String cat, double pre){
        List<Producto> filtrados = productos.stream()
                .filter(p -> (p.getCategoria().equals(cat) && p.getPrecio() > 1000))
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .toList();

        Optional<List<Producto>> optionalFiltrados = Optional.of(filtrados).filter(lista -> !lista.isEmpty());

        optionalFiltrados.ifPresentOrElse(
                lista -> System.out.println("Productos de la categoria " + cat + ", con una precio mayor a " + pre + ": " + lista),
                () -> System.out.println("No hay preductos en la categoria " + cat + " con un precio mayor a " + pre));
    }

    // 2
    public static void reduccionDeDatos(){
        double precioPromedio = productos.stream()
                .filter(p -> p.getCategoria().equals("Hogar") && p.getStock() > 0)
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0);

        System.out.println("Precio promedio de productos de Hogar: " + precioPromedio);
    }

    // 3
    public static void productoMasCaro(){
        Map<String, Producto> masCaroXCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Producto::getPrecio)),
                                Optional::orElseThrow
                        )
                ));

        System.out.println("Producto mas caro por categoria: " + masCaroXCategoria);
    }

    // 4
    public static void usoDeOptionals(){
        Optional<String> prod = productos.stream()
                .filter(p -> p.getCategoria().equals("Deportes") && p.getStock() > 10)
                .map(p -> p.getNombre().toLowerCase())
                .findFirst();

        System.out.println("Producto: " + prod.orElse("Producto Inexistente"));
    }

    // 5
    public static void productoMasBarato(){
        Optional<Producto> masBarato = productos.stream()
                .min(Comparator.comparingDouble(p -> p.getPrecio() * p.getStock()));

        System.out.println("El producto mas barato es: " + masBarato.orElseThrow());
    }

    // 6
    public static void productosEnStockOrdenadosAlfabeticamente(){

    }

    // 7
    public static void calculoDeStockTotal(){

    }

    // 8
    public static void stockPorCategoria(){

    }

    // 9
    public static void aplicarDescuento(){

    }

    // 10
    public static void gananciaTotalDeInventario(){

    }

    public static List<Producto> cargarProductos() {
        return List.of(
                new Producto("Laptop", 1500, "Electrónica", 5),
                new Producto("Smartphone", 800, "Electrónica", 10),
                new Producto("Televisor", 1200, "Electrónica", 3),
                new Producto("Heladera", 2000, "Hogar", 2),
                new Producto("Microondas", 500, "Hogar", 8),
                new Producto("Silla", 150, "Muebles", 12),
                new Producto("Mesa", 300, "Muebles", 7),
                new Producto("Zapatillas", 100, "Deportes", 15),
                new Producto("Pelota", 50, "Deportes", 20),
                new Producto("Bicicleta", 500, "Deportes", 5),
                new Producto("Libro", 30, "Librería", 50),
                new Producto("Cuaderno", 10, "Librería", 100),
                new Producto("Lámpara", 80, "Hogar", 30),
                new Producto("Cafetera", 250, "Hogar", 6),
                new Producto("Auriculares", 120, "Electrónica", 14),
                new Producto("Teclado", 90, "Electrónica", 9),
                new Producto("Mouse", 60, "Electrónica", 18),
                new Producto("Monitor", 700, "Electrónica", 4),
                new Producto("Cama", 800, "Muebles", 2),
                new Producto("Sofá", 1000, "Muebles", 3),
                new Producto("Espejo", 120, "Hogar", 12),
                new Producto("Ventilador", 150, "Hogar", 7),
                new Producto("Patines", 180, "Deportes", 5),
                new Producto("Raqueta", 220, "Deportes", 6),
                new Producto("Taza", 15, "Hogar", 40)
        );
    }
}