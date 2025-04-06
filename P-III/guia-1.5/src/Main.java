import models.Product;
import utils.DisplayManager;


import java.util.*;
import java.util.stream.Collectors;

import static utils.DisplayManager.*;

public class Main{

    //    private static final List<Product> products = List.of();
    private static final List<models.Product> products = loadProducts();
    private static final String ELECTRONICA = "Electrónica";
    private static final double PRECIO_MINIMO_FILTRO = 1000.0;
    private static final double DESCUENTO = 0.85;
    private static final double COSTO_ELECTRONICA = 0.65;
    private static final double COSTO_DEFAULT = 0.45;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Menú de opciones
            menu();

            try{
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch(InputMismatchException e){
                printError("Ingrese un numero valido.");
                scanner.nextLine();
                opcion = -1;
            }

            switch(opcion){
                case 1 -> {
                    Optional<List<Product>> filtered = filterByCategoryAndSortByPrice();

                    filtered.ifPresentOrElse(DisplayManager::printList, () -> printError("No se encontraron productos."));
                }
                case 2 -> {
                    double avgPrice = reduccionDeDatos();

                    printMsg("Precio promedio: " + avgPrice);
                }
                case 3 -> {
                    Map<String, Product> expProducts = productoMasCaro();

                    printMap(expProducts);
                }
                case 4 -> {
                    String name = usoDeOptionals().orElse("Producto Inexistente");

                    printMsg(name);
                }
                case 5 -> {
                    try{
                        Product barato = productoMasBarato();
                        printProduct(barato);
                    } catch(NoSuchElementException e){
                        printError("Producto Inexistente.");
                    }
                }
                case 6 -> {
                    Optional<List<String>> productosEnStock = productosEnStockOrdenadosAlfabeticamente();

                    productosEnStock.ifPresentOrElse(DisplayManager::printList, () -> printError("No hay ningun produto en la lista"));
                }
                case 7 -> {
                    Optional<Integer> totalStock = calculoDeStockTotal();

                    totalStock.ifPresentOrElse(stock -> printMsg("El stock total es: " + stock), () -> printError("No hay stock."));
                }
                case 8 -> {
                    Optional<Map<String, Long>> stock = stockPorCategoria();

                    stock.ifPresentOrElse(DisplayManager::printMap, () -> printError("No hay categorias con al menos 3 productos."));
                }
                case 9 -> {
                    Optional<List<Product>> listDescuentos = aplicarDescuento();

                    listDescuentos.ifPresentOrElse(DisplayManager::printList, () -> printError("No hay productos con descuento."));
                }
                case 10 -> {
                    double gananciaTotal = gananciaTotalDeInventario();

                    printMsg("Ganancia total del inventario: " + gananciaTotal);
                }
                case 0 -> printMsg("Saliendo del programa...");
                default -> printMsg("Opción no válida, intente de nuevo.");
            }

        } while(opcion != 0);

        scanner.close();
    }

    // 1 OPTIONAL,
    public static Optional<List<Product>> filterByCategoryAndSortByPrice(){
        List<Product> filtered = products.stream()
                                         .filter(p -> p.getCategory()
                                                       .equals(ELECTRONICA) && p.getPrice() > PRECIO_MINIMO_FILTRO)
                                         .sorted(Comparator.comparingDouble(Product::getPrice)
                                                           .reversed())
                                         .toList();

        return Optional.of(filtered);
    }

    // 2 NO OPTIONAL
    public static double reduccionDeDatos(){
        return products.stream()
                       .filter(p -> p.getCategory()
                                     .equals("Hogar") && p.getStock() > 0)
                       .mapToDouble(Product::getPrice)
                       .average()
                       .orElse(0);
    }

    // 3 NO OPTIONAL, es lo mismo el map vacio por falta de datos u otro caso
    public static Map<String, Product> productoMasCaro(){
        return products.stream()
                       .collect(Collectors.toMap(Product::getCategory, p -> p, (p1, p2) ->
                               p1.getPrice() > p2.getPrice() ? p1 : p2));
    }

    // 4 OPTIONAL
    public static Optional<String> usoDeOptionals(){
        return products.stream()
                       .filter(p -> p.getCategory()
                                     .equals("Deportes") && p.getStock() > 10)
                       .map(p -> p.getName()
                                  .toLowerCase())
                       .findFirst();
    }

    // 5
    public static Product productoMasBarato() throws NoSuchElementException{
        return products.stream()
                       .min(Comparator.comparingDouble(p -> p.getPrice() * p.getStock()))
                       .orElseThrow(() -> new NoSuchElementException("No hay productos disponibles"));
    }

    // 6 OPTIONAL
    public static Optional<List<String>> productosEnStockOrdenadosAlfabeticamente(){
        List<String> productos = products.stream()
                                         .filter(p -> p.getStock() > 0)
                                         .map(Product::getName)
                                         .filter(name -> name.length() >= 5)
                                         .sorted()
                                         .toList();

        return Optional.ofNullable(productos.isEmpty() ? null : productos);
    }

    // 7 NO OPTIONAL, siempre devuelve un int
    public static Optional<Integer> calculoDeStockTotal(){
        double avgPrice = products.stream()
                                  .mapToDouble(Product::getPrice)
                                  .average()
                                  .orElse(0);
        int totalStock = products.stream()
                                 .filter(p -> p.getPrice() > avgPrice)
                                 .mapToInt(Product::getStock)
                                 .sum();
        return Optional.of(totalStock);
    }

    // 8 OPTIONAL, el map vacio significa que la condicion no se cumplio
    public static Optional<Map<String, Long>> stockPorCategoria(){
        Map<String, Long> cantidadXCategoria = products.stream()
                                                       .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));

        Map<String, Long> filtrado = products.stream()
                                             .filter(p -> cantidadXCategoria.get(p.getCategory()) >= 3)
                                             .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingLong(Product::getStock)));

        return Optional.ofNullable(filtrado.isEmpty() ? null : filtrado);
    }

    // 9 OPTIONAL, la lista puede estar vacia
    public static Optional<List<Product>> aplicarDescuento(){
        List<Product> productList = products.stream()
                                            .filter(p -> p.getStock() > 20)
                                            .map(p -> new Product(p.getName(), p.getPrice() * DESCUENTO, p.getCategory(), p.getStock()))
                                            .toList();

        return Optional.ofNullable(productList.isEmpty() ? null : productList);
    }

    // 10 NO OPTIONAL, siempre devuelve un double
    public static double gananciaTotalDeInventario(){

        return products.stream()
                       .mapToDouble(p -> {
                           double costo = p.getCategory()
                                           .equals(ELECTRONICA) ? p.getPrice() * COSTO_ELECTRONICA :
                                          p.getPrice() * COSTO_DEFAULT;
                           return p.getStock() * (p.getPrice() - costo);
                       })
                       .sum();
    }

    public static List<Product> loadProducts(){
        return List.of(new Product("Laptop", 1500, "Electrónica", 5), new Product("Smartphone", 800, "Electrónica", 10), new Product("Televisor", 1200, "Electrónica", 3), new Product("Heladera", 2000, "Hogar", 2), new Product("Microondas", 500, "Hogar", 8), new Product("Silla", 150, "Muebles", 12), new Product("Mesa", 300, "Muebles", 7), new Product("Zapatillas", 100, "Deportes", 15), new Product("Pelota", 50, "Deportes", 20), new Product("Bicicleta", 500, "Deportes", 5), new Product("Libro", 30, "Librería", 50), new Product("Cuaderno", 10, "Librería", 100), new Product("Lámpara", 80, "Hogar", 30), new Product("Cafetera", 250, "Hogar", 6), new Product("Auriculares", 120, "Electrónica", 14), new Product("Teclado", 90, "Electrónica", 9), new Product("Mouse", 60, "Electrónica", 18), new Product("Monitor", 700, "Electrónica", 4), new Product("Cama", 800, "Muebles", 2), new Product("Sofá", 1000, "Muebles", 3), new Product("Espejo", 120, "Hogar", 12), new Product("Ventilador", 150, "Hogar", 7), new Product("Patines", 180, "Deportes", 5), new Product("Raqueta", 220, "Deportes", 6), new Product("Taza", 15, "Hogar", 40));
    }

    public static void menu(){
        printMsg("\n===== Guia 1.5 =====");
        printMsg("1. Obtener una lista con los nombres y precios de los productos de la categoría \"Electrónica\" cuyo precio sea mayor a 1000, ordenados de mayor a menor precio.");
        printMsg("2. Calcular el precio promedio de los productos de la categoría \"Hogar\", pero solo considerando aquellos con stock disponible.");
        printMsg("3. Obtener el producto más caro de cada categoría y devolver un mapa con la categoría como clave y el producto más caro como valor.");
        printMsg("4. Encontrar el producto de la categoría \"Deportes\" con stock mayor a 10 unidades, obtener su nombre en minúsculas y devolverlo dentro de un Optional. Mostrarlo o si no existe, mostrar “Producto Inexistente”");
        printMsg("5. Encontrar el producto mas barato calculando el valor total de todas las unidades en stock (Precio * stock). Devolver un Opcional con el producto. En caso de que no exista, lanzar una excepción.");
        printMsg("6. Obtener una lista con los nombres de los productos que tienen stock, ordenarlos alfabéticamente y excluir los productos con nombres de menos de 5 caracteres.");
        printMsg("7. Obtener el total de unidades en stock de todos los productos, pero solo considerando aquellos con precio superior al promedio.");
        printMsg("8. Calcular cuántas unidades en stock hay por categoría, excluyendo categorías con menos de 3 productos.");
        printMsg("9. Crear una nueva lista de productos con un 15% de descuento en su precio, pero solo si el producto tiene más de 20 unidades en stock.");
        printMsg("10. Calcular la ganancia total si se vendiera todo el inventario, considerando que el costo de compra de cada producto es un 45% del valor de venta o de un 65% si pertenece a la categoria Electronica.");
        printMsg("0. Salir");
        printMsg("Seleccione una opción: ");
    }
}