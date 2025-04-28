**Unidad 6: Desarrollo de API REST con Spring Web**

---

# 1. Spring MVC y Controladores

Spring MVC es un potente framework que sigue el patrón de arquitectura Modelo-Vista-Controlador (MVC). En aplicaciones de tipo REST, el controlador se encarga de actuar como intermediario entre el cliente (por ejemplo, un navegador o una app móvil) y el modelo de datos (como una base de datos). El controlador recibe solicitudes, procesa los datos y devuelve respuestas, generalmente en formato JSON, facilitando la interoperabilidad entre sistemas.

## @RestController

Anotación que marca una clase como un controlador REST, donde cada método devuelve directamente un objeto de Java. Este objeto es automáticamente convertido en JSON o XML (dependiendo de la configuración y las necesidades del cliente).

```java
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return new Usuario(id, "Juan", "juan@email.com");
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        usuario.setId(1L);
        return usuario;
    }
}
```

## @RequestMapping

Esta anotación define una ruta base común para todos los métodos de un controlador, lo cual ayuda a mantener el código más organizado.

Anotaciones específicas de HTTP

- **@GetMapping**: Maneja solicitudes HTTP GET (leer recursos).
- **@PostMapping**: Maneja solicitudes HTTP POST (crear recursos).
- **@PutMapping**: Maneja solicitudes HTTP PUT (actualizar recursos existentes).
- **@DeleteMapping**: Maneja solicitudes HTTP DELETE (eliminar recursos).

Estas anotaciones facilitan mucho el desarrollo, ya que no hace falta especificar explícitamente el método HTTP en cada ruta.

---

# 2. Manejo de parámetros con @PathVariable y @RequestParam

## @PathVariable

Utilizado para capturar valores directamente desde la URL. Muy útil para identificar un recurso único.

```java
@GetMapping("/productos/{id}")
public Producto obtenerProducto(@PathVariable Long id) {
    return productoService.buscarPorId(id);
}
```
En este ejemplo, {id} en la URL será automáticamente asignado al parámetro id del método.

## @RequestParam

Utilizado para capturar valores que vienen en el query string, típicamente usados para búsquedas o filtros.

```java
@GetMapping("/buscar")
public List<Producto> buscarProductos(@RequestParam String nombre) {
    return productoService.buscarPorNombre(nombre);
}
```
Permite capturar varios parámetros de búsqueda de forma muy flexible.

---

# 3. Validación de datos con @Valid

Spring Boot integra de forma nativa la especificación Bean Validation (JSR 380) para validar objetos de entrada antes de ser procesados.

## Ejemplo de validación:
```java
public class Usuario {

    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;

    @Email(message = "El email debe ser válido")
    private String email;

    // getters y setters
}

@PostMapping("/registrar")
public ResponseEntity<Usuario> registrarUsuario(@Valid @RequestBody Usuario usuario) {
    return ResponseEntity.ok(usuario);
}
```
Si el objeto Usuario no cumple con las restricciones de validación, automáticamente se genera un error 400 (Bad Request) con detalles del problema.

Anotaciones comunes de validación:

- **@NotNull**: El campo no puede ser nulo.
- **@Size(min=, max=)**: Especifica un tamaño mínimo y máximo para el valor.
- **@Email**: Verifica que el formato sea el de una dirección de correo electrónico válida.
- **@Pattern(regexp=)**: Valida contra una expresión regular personalizada.

---

# 4. Manejo de errores con @ExceptionHandler

Spring proporciona un mecanismo sencillo y efectivo para capturar errores y personalizar las respuestas de error usando @ExceptionHandler.

## Ejemplo:
```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> manejarNoEncontrado(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body("Recurso no encontrado: " + ex.getMessage());
    }
}
```
Esto asegura que cuando ocurra una NoSuchElementException, se envíe automáticamente una respuesta 404 personalizada.

Anotaciones relacionadas:

- **@ControllerAdvice**: Define una clase para manejar excepciones de forma global en toda la aplicación.
- **@ExceptionHandler**: Se usa dentro de @ControllerAdvice para especificar qué excepción capturar.

Esto mejora la calidad de las respuestas de la API y permite a los clientes entender mejor qué falló.

---

# 5. Implementación de un CRUD Completo

Un CRUD representa las operaciones básicas de manipulación de datos:

- **Crear** (Create) → POST
- **Leer** (Read) → GET
- **Actualizar** (Update) → PUT
- **Eliminar** (Delete) → DELETE

## Ejemplo de un Controlador CRUD:

```java
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }

    @GetMapping("/{id}")
    public Usuario obtener(@PathVariable Long id) {
        return usuarioService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.actualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
    }
}
```
Cada uno de estos métodos se comunica con un servicio (usuarioService) que maneja la lógica de negocio y la interacción con la base de datos.

# Resumen Final

Al completar esta unidad, serás capaz de:

- Construir APIs RESTful completas usando Spring Boot.
- Crear controladores eficientes que procesen solicitudes HTTP.
- Validar datos de entrada automáticamente usando anotaciones.
- Personalizar y mejorar el manejo de errores en tus servicios.
- Convertir objetos de Java en JSON y viceversa.
- Implementar un CRUD básico siguiendo buenas prácticas.

Todo esto sienta las bases necesarias para poder desarrollar sistemas backend robustos, seguros y escalables.