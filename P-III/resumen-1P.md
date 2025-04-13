# Paradigma de programacion funcional

## Programacion funcional

En java, se implementa mediante expresiones lambda, interfaces funcionales y la API de Streams.

| Caracteristica | Imperativa | Funcional |
| - | - | - |
| Definicion | Se basa en instrucciones paso a paso que modifican el estado del programa | Se basa en la evaluacion de funciones matematicas sin modificar el estado |
| Estado mutable | Modifica variables y estructuras de datos | Evita cambios en el estado, usa estructuras inmutables |
| Efectos secundarios | Puede tener efectos secundarios (cambiar variables globales, modificar archivos, etc) | Minimiza efectos secundarios, las funciones son puras |
| Enfoque | Se centra en el como lograr un resultado (procedimientos y bucles) | Se centra en el que se quiere lograr (transformaciones de datos) |

## Sintaxis basica de las expresiones lambda

(parametros) -> {cuerpo de la funcion}

## Interfaz funcional

- Solo puede tener un metodo abstracto.
- Puede contener metodos default y static sin perder su condicion de funcional.
- Se puede marcar con la anotacion @FunctionalInterface.

Ej:

```java
@FunctionalInterface
interface Operacion {
    // unico metodo abstracto
    int calcular(int a, int b); 

    // metodo por defecto
    default void mostrarMensaje(){
        System.out.println("Ejecutando operacion...");
    }

    // metodo estatico
    static void mensajeEstatico(){
        System.out.println("Metodo estatico en interfaz.");
    }
}

public class Main {
    public static void main(String[] args){
        Operacion multiplicacion = (a, b) -> a * b;

        System.out.println(multiplicacion.calcular(4,2)); // Salida: 8
        multiplicacion.mostrarMensaje(); // Salida: Ejecutando operacion...
        Operacion.mensajeEstatico(); // Salida: Metodo estatico en interfaz.

    }
}
```

## Libreria java.util.function

Paquete de Java que contiene una serie de interfaces funcionales diseñadas para facilitar la programacion funcional mediante expresiones lambda y referencias a metodos.

- Reduce la necesidad de definir interfaces funcionales personalizadas.
- Mejora la legibilidad y reutilizacion del codigo.
- Compatible con APIs modernas como Streams y Optional.

## Principales interfaces funcionales en java.util.function

- ```Consumer<T>``` -> Ejecuta una accion sin devolver resultado.
- ```Supplier<T>``` -> Provee un valor sin recibir argumentos.
- ```Predicate<T>``` -> Recibe un argumento y devuelve true o false.
- ```Function<T, R>``` -> Recibe un argumento de tipo T y devuelve un resultado de tipo R.
- ```BiFunction<T, U, R>``` -> Recibe dos argumentos de tipo T y U, y devuelve un resultado de tipo R.

### ----------------------------------------------------------------------------------

# API Stream y Optionals

## Stream

Es una secuencia de elementos (flujo de datos) que permite realizar operaciones funcionales sobre colecciones de datos de manera declarativa y eficiente, sin modificar la fuente original.

## .filter()

Se usa para filtrar elementos de una secuencia segun una condicion booleana. Devuelve un nuevo Stream con los elementos que cumplen la condicion especificada.

## .map()

Transforma cada elemento de la secuencia aplicando una funcion y devuelve un nuevo Stream con los elementos modificados. Se usa para realizar mapeos o conversiones sobre los datos.

## .reduce()

Se usa para reducir una secuencia de elementos a un unico valor aplicando una funcion acumulativa.

## For vs Streams

| Aspecto | ```For``` tradicional | ```Stream``` API |
| - | - | - |
| Paradigma | Imperativo | Declarativo |
| Legibilidad | Mas verboso | Mas conciso y expresivo |
| Paralelizacion | No tiene soporte nativo para ejecucion paralela | Soporta ```parallelStream()``` para procesamiento en paralelo |
| Eficiencia | Puede ser mas eficiente en algunos casos debido a menos sobrecarga | Optimizado internamente, pero con ligera sobrecarga inicial |
| Inmutabilidad | Generalmente modifica estructuras mutables | Promueve inmutabilidad y evita efectos secundarios |

## .parallelStream()

Permite procesar los elementos de un Stream en paralelo, dividiendo la carga de trabajo en multiples hilos para mejorar el rendimiento en operacions sobre grandes volumenes de datos.

### Casos recomendados

- Cuando trabajas con grandes cantidades de datos y el procesamiento de cada elemento es costoso.
- Cuando la operacion es independiente para cada elemento.
- Cuando el hardware tiene multiples nucleos.

### Casos donde NO es recomendable

- Si la cantidad de datos es pequeña (el costo de gestionar los hilos supera el beneficio).
- Si hay modificaciones consurrentes a estructuras compartidas.
- Si el orden de los resultados es importante.

## El problema del NullPointerException

Ocurre cuando intentamos acceder a un metodo o atributo de un objeto que es null.

## ```Optional<T>```

Esta clase fue diseñada para evitar el NullPointerException y mejorar la gestion de valores nulos de manera segura y declarativa. En lugar de devolver null, te permite representar calores presentes o ausentes, proporcionando metodos para manejar ambas situaciones sin necesidad de validaciones manuales con if.

## Principales metodos de Optional

- ```.of(valor)```: Crea un Optional con un valor (no puede ser null).
- ```.ofNullable(valor)```: Crea un Optional con un valor, o vacio si es null.
- ```.isPresent()```: Devuelve true si el Optional tiene un valor.
- ```.ifPresent(Consumer<T>)```: Ejecuta una accion si el valor esta presente.
- ```.orElse(valorDefecto)```: Devuelve el valor si esta presente, o el valor por defecto si no lo esta.

## Cuando usar Optional

- Para metodos que ppueden devolver null, como consultas a base de datos o archivos.
- Para evitar comprobaciones manuales de null.
- Para mejorar la legibilidad y seguridad del codigo.

## Cuando NO usar Optional

- Parametros de metodos (usar ```Objects.requireNonNull()``` en su lugar).
- Atributos de una clase (usar valores predeterminados o validaciones).

### ----------------------------------------------------------------------------------

# Introducción a JDBC, Patrón Singleton y MVC

## JDBC

Java DataBase Connectivity es una APi de Java que permite conectar aplicaciones Java con bases de datos. Proporciona metodos para ejecutar consultas SQL, recuperar datos y administrar conexciones de forma eficiente.

[1] Register driver -> [2] Get connection -> [3] Create Statement -> [4] Execute query -> [5] Close connection

## Patrones de diseño

Son tecnicas para resolver problemas recurrentes de diseño de software.

- Creacionales: Soluciona la creacion de objetos, hace un sistema independiente de como sus objetos son creados.
- Estructurales: Describe como los objetos se componen para formar estructuras complejas.
- Comportamentales: Establece soluciones relacionadas con el comportamiento de la aplicacion respecto a la interaccion entre objetos y clases.

## Patron Singleton

Es un patron de diseño creacional que nos permite asegurarnos de que una clase tenga una unica instancia, a la vez que proporciona un punto de acceso global a dicha instancia.

### Problema 

El patron Singleton resuelve dos problemas al mismo tiempo, vulnerando el Principio de responsabilidad unica:

1. Garantizar que una clase tenga una unica instancia.
2. Proporcionar un punto de acceso global a dicha instancia.

### Solucion

1. Hacer privado el constructor por defecto para evitar que otros objetos utilicen el operador new con la clase Singleton.
2. Crear un metodo de creacion estatico que actua como constructor.

## Cuando aplicar el patron Singleton

Cuando una clase de tu programa tan solo deba tener una instancia disponible para todos los clientes.

## Patron DAO (Data Accsess Object)

Se utiliza para separar la logica de acceso a datos de la logica de negocio de una aplicacion. Su proposito es proporcionar una capa de abstraccion entre la aplicacion y la base de datos, facilitando el mantenimiento, la reutilizacion del codigo y la portabilidad del sistema.

## MVC

### Model

- Representa los datos y la logica de negocio de la aplicacion.
- Se encarga de gestionar la informacion y las reglas de negocio.
- Puede interactuar con una base de datos u otras fuentes de datos.

### Vista

- Se encarga de la presentacion de los datos al usuario.
- No contiene logica de negocio, solo muestra informacion recibida del Modelo.

### Controlador

- Actua como intermediario entre la Vista y el Modelo.
- Recibe las entradas del usuario desde la vista y actualiza el modelo o la vista segun corresponda.

### ----------------------------------------------------------------------------------

# INTRODUCCIÓN AL DESARROLLO BACKEND

## Arquitectura Cliente-Servidor

Es un modelo de diseño en el que el cliente solicita recurso o servicios al servidor, que responde a estas peticiones. Esta separacion permite escalabilidad y modularidad en el desarrollo de aplicaciones.

- Cliente: Aplicacion que solicita recursos o servicios.
- Servidor: Proveedor de recursos o servicios. Es quien procesa las solicitudes y se encarga de la logica de negocios.
- Protocolo HTTP: Medio de comunicacion entre cliente y servidor.

## API (Application Programming Interface)

Son mecanismos que permiten a dos componentes de software comunicarse entre si mediante un conjunto de definiciones y protocolos.

## API Rest

- Stateless: Cada peticion del cliente contiene toda la informacion necesaria, el servidor no mantiene el estado de la sesion.
- Client-Server: Separacion entre cliente y servidor.
- Cacheable: Las respuestas pueden almacenarse en cache para mejorar el rendimiento.
- Uniform Interface: Uso de recursos identificables mediante URLs y operaciones definidas por HTTP.

## Peticiones a una API Rest

Cuando un cliente necesita acceder a un recurso, este dedbe primero inicializar la comunicacion realizando una peticion a la API. Esta peticion, se estructura de la siguiente manera:

- URL: Es la direccion web que identifica el recurso o servicio al que deseas acceder.
- Metodo HTTP: Indica la accion que deseas realizar sobre el recurso.
- Encabezados (Headers): Proporcionan informacion adicional sobre la peticion.
- Cuerpo (Body): Contiene los datos que se envian al servidor.

## Metodos HTTP

Rest define un conjunto de funciones que los clientes pueden utilizar para acceder a los datos del servidor.

- GET: Solicita datos sin modificar el estado del servidor.
- POST: Envia datos al servidor para crear un recurso.
- PUT: Actualiza un recurso existente.
- PATCH: Actualiza parcialmente un recurso.
- DELETE: Elimina un recurso.

## Encabezados

Son pares clave-valor que se incluyen en la peticiones y respuestas HTTP. Proporcionan informacion adicional sobre la peticion o la respuesta.

- Accept: Indica los tipos de contenido que el cliente puede aceptar en la respuesta.
- Authorization: Contiene informacion de autenticacion.
- Content-Type: Indica el tipo de contenido del cuerpo de la peticion o respuesta.
- Cookie: Contiene cookies que se envian al servidor.

## Body

Contiene los datos que se envian al servidor. El formato del cuerpo depende del tipo de peticion y de la API. Para peticiones POST o PUT, el cuerpo suele contener la informacion del recurso que se va a crear o actualizar.

## Respuesta de una API

Cuenta con Headers y un Body, pero tambien cuenta con un status code, que nos da informacion acerca de como ha sido procesada nuestra peticion.

## Status code

Son esenciales para una comunicacion efectiva entre el cliente y el servidor en una API Rest. Permiten al cliente comprender si la solicitud fue exitosa, si hubo algun error o si se requiere alguna accion adicional.

- 1xx (Informativos): Indican que la solicitud fue recibida y se esta procesando.
- 2xx (Exitosos): Señalan que la solicitud fue completada con exito.
- 3xx (Redirecciones): Informan que el recurso solicitado se ha movido y se requiere una accion adicional para completar la solicitud.
- 4xx (Errores del cliente): Indican que hubo un problema con la solicitud del cliente.
- 5xx (Errores del servidor): Señalan que hubo un problema en el servidor al procesar la solicitud.

## Restful vs Restish

Una API Restful se adhiere estrictamente a los principios y restricciones de la arquitectura REST. Por otro lado, una API Restish se asemeja a una API Restful, pero no cumple estrictamente con todos los principios de REST. Puede haber desviaciones en la interfaz uniforme, el manejo del estado o la capacidad de cache.

## Versionado

Con el tiempo, una api puede evolucionar y cambiar, pero es importante no dejar de servir a los clientes que dependen de ella. Esta problematica se suele solucionar con versionado, otorgando mantenimiento a versiones previas por un tiempo.

## Paginacion

Un volumen tan grande de informacion vuelve mas lentas e ineficientes las peticiones, para lo cual se implementa paginacion.

### ----------------------------------------------------------------------------------

# INTRODUCCIÓN A SPRING BOOT

## Framework

Es un conjunto de herramientas, bibliotecas y convenciones que proporcionan una estructura predefinida para el desarrollo de software. Su objetivo principal es simplificar y acelerar el proceso de desarrollo al ofrecer soluciones a problemas comunes y establecer una base solida sobre la cual construir aplicaciones.

### Caracteristicas:

- Abstraccion.
- Reusabilidad.
- Modularidad.
- Estandarizacion.
- Productividad.
- Inversion de control (IoC).

## Spring

Framework de codigo abierto para el desarrollo de aplicaciones Java que facilita la creacion de aplicaciones empresariales escalables. Se basa en principios como la inyeccion de dependencias (DI) y la inversion de control (IoC) para gestionar los objetos de la aplicacion.

### Caracteristicas:

- Inyeccion de dependencias (DI): Spring gestiona las dependencias entre los componentes de una aplicacion.
- Programacion orientada a aspectos (AOP): es un paradigma de programacion que busca modularizar y separar las preocupaciones transversales o cross-cutting concerns de la logica principal de un programa.
- Modulos: Spring se compone de varios modulos que ofrecen funcionalidades especificas, permitiendo al programador utilizar aquellos que requiera.

## Spring Boot

Es una extension de Spring que simplifica la creacion de aplicaciones, eliminando la necesidad de configuraciones manuales y proporcionando una experiencia lista para ejecutarse.

### Caracteristicas:

- Configuracion automatica (Spring Boot Starter): Detecta dependencias y configura la aplicacion de manera automatica.
- Servidor embebido: No requiere un servidor externo, ya que los incluye por defecto.
- Starter POMs: Spring Boot ofrece Proyectos de Objetos Maven que agrupan dependencias comunes para diferentes tipos de aplicaciones.
- Spring Boot Actuatos: Proporciona herramientas oara monitoreo y gestion de la aplicacion.
- Ecosistema y comunidad: Spring Boot forma parte de un ecosistema mas grande que incluye muchos proyectos adicionales como Spring Data, Spring Security y Spring Batch.

### Ventajas:

- Productividad.
- Escalabilidad.
- Flexibilidad.
- Mantenimiento.
- Integracion.
- Seguridad.

## Diferencia Spring vs Spring Boot

| Caracteristica | Spring | Spring Boot |
| - | - | - |
| Configuracion | Manual (XML o Java) | Automatica |
| Servidor embebido | No | Si |
| Dependencias | Multiples dependencias manuales | Starters preconffigurados |
| Ideal para | Aplicaciones empresariales complejas | Microservicios y aplicaciones rapidas |

### ----------------------------------------------------------------------------------

# SPRING INITIALIZR E INTRODUCCIÓN A LAS DEPENDENCIAS

## Spring Initializr

Es una herramienta que facilita la creacion de proyectos Spring Boot al permitir la seleccion de dependencias y configuraciones iniciales a traves de una interfaz web o un cliente de linea de comandos.

## Spring Web

Es una biblioteca fundamental para el desarrollo de aplicaciones web con Spring. Proporciona funcionalidades esenciales para la comunicacion HTTP y la integracion con tecnologias web.

- Soporte para el protocolo HTTP y manipulacion de solicitudes y respuestas.
- Cliente REST para consumir APIs externas.
- Soporte para WebSockets.

## Spring MVC

Es un modulo de Spring que extiende spring-web para proporcionar el patron de diseño MVC. Esta diseñado especificamente para el desarrollo de aplicaciones web basadas en controladores y vistas dinamicas.

- Soporte para controladores con anotaciones (@Controller, @RestController).
- Manejo de peticiones HTTP con @RequestMapping, @GetMapping, @PostMapping, etc.

## Spring Web Starter

Es un starter de Spring Boot que configura automaticamente el entorno necesario para desarrollar apliaciones web basadas en Spring MVC. Incluye todas las dependencias esenciales para manejar solicitudes HTTP, crear controladores, procesar JSON y ejecutar un servidor web embebido.

### Incluye:

- spring-web: Soporte para HTTP y cliente REST.
- spring-webmvc: Implementacion de Spring MVC (Controladores, Vistas, Routing).
- jackson-databind: Soporte para serializacion/deserializacion de JSON.
- tomcat-embed-core: Servidor embebido Apache Tomcat.
- validation-api: Soporte para validacion de datos con anotaciones.
- spring-boot-starter: Configuracion base ded Spring Boot.

## Spring Data

Conjunto de proyectos dentro del ecosistema Spring que facilita la interaccion con bases de datos, eliminando gran parte del codigo repetitivo asociado con el acceso a datos. Su objetivo principal es proporcionar una capa de abstraccion sobre diferentes tecnologias de persistencia, como bases de datos relacionales y NoSQL.

### Familia Spring Data

- spring-data-jdbc: Implementacion de JDBC API para gestionar conexion y consultas a una base de datos relacional.
- spring-data-jpa: Simplifica la interaccion con bases de datos realcionales a traves de Java Persistance API.
- spring-data-mongodb: Soporte para base de datos MongoDB (NoSQL).
- spring-data-redis: Para almacenamiento en cache con Redis.
- spirng-data-elasticsearch: SOporte para bases de datos ElasticSearch.

## Spring Security

Framework que proporciona mecanismos de autenticacion y autorizacion para aplicaciones Java. Su objetivo es proteger aplicaciones web y servicios REST mediante configuraciones flexibles y seguras.

- Autenticacion y autorizacion robustas.
- Integracion con bases de datos y proveedores de identidad.
- Soporte para OAuth2 y JWT.
- Prevencion de ataques comunes como CSRF y XSS.

### ----------------------------------------------------------------------------------

# BEANS E INYECCIÓN DE DEPENDENCIAS

## Anotaciones

Son una forma de agregar metadatos al codigo fuente. Estos metadatos pueden ser utilizados por el compilador, herramientas de desarrollo o en tiempo de ejecucion a traves de reflexion.

- No afectan la logica del programa directamente.
- Se utilizan para configurar comportamientos en frameworks y bibliotecas.
- Pueden ser procesadas en tiempo de compilacion o ejecucion.
- Se pueden dedfinir anotaciones personalizadas.

## Lombok

Biblioteca de Java que utiliza anotaciones para simplificar la escritura de codigo repetitivo. 

- Utiliza anotaciones para indicar el codigo a generar.
- La generacion de codigo ocurre en tiempo de compilacion.
- El codigo generado se incluye en el codigo compilado final.

### Anotaciones de Lombok

- @Getter & @Setter -> Genera los metodos Getter y Setter para los campos.
- @ToString -> Genera una implementacion del metodo toString().
- @EqualsAndHashCode -> Genera implementaciones de los metodos equals() y hashCode() basado en todos los campos.
- @RequiredArgsConstructor -> Genera un constructor con argumentos para los campos final y los campos anotados con @NonNull.
- @Data -> Engloba todas las anotaciones previas.
- @Value -> Similar a Data, pero sin los Setters.
- @NoArgsConstructor & @AllArgsConstructor -> Genera constructores.
- @NonNull -> Genera comprobaciones de nulidad para los parametros.
- @Builder -> Genera un patron de diseño Builder para la creacion de objetos.
- @Log, @Log4j, @Log4j2, @Slf4j, @XSlf4j -> Genera campos de registro (loggers).

## Inyeccion de dependencias

Es un principio del diseño de software que permite desacoplar los componentes de una aplicacion, facilitando la mantenibilidad y prueba del codigo. En lugar que una clase cree sus propias dependencias, estas le son proporcionadas desde el exterior. Spring Boot implementa la DI a traves del contenedor de Spring, que gestiona la creacion y configuracion de los objetos (beans) de la aplicacion.

## Contenedor de Spring

- Implementa el principio de Inversion de Control. En lugar de que tus objetos creen y administren sus propias dependencias, el contenedor se encarga de hacerlo.
- El contenedor "inyecta" las dependencias necesarias en tus objetos, lo que promueve un codigo mas limpio, flexible y facil de probar.
- Los objetos que el contenedor administra se llaman Beans. El contenedor se encarga de crear, configurar y ensamblar estos beans.
- Define el ciclo de vida de los Beans.

## Ciclo de vida de un Bean

1. Instanciacion: Spring crea una instancia del bean utilizando el contructor de la clase.
2. Inyeccion de dependencias: Una vez que se crea la instancia del bean, el contenedor inyecta las dependencias necesarias.
3. Inicializacion: Spring prepara el bean para su uso.
4. Uso: El bean esta completamente configurado y listo para ser utilizado.
5. Destruccion: Cuando la aplicacion se cierra o el bean ya no es necesario, Spring lo destruye para ahorra memoria y espacio.

## Instanciar un Bean

Para poder inyectar una dependencia, Spring Boot necesita tener en el contenedor Spring un Bean que corresponda a esa dependencia.

## Inyectar una dependencia

Spring Boot permite 3 formas principales de inyectar dependencias:

1. Inyeccion por constructor:

```java
@Service
public class MiServicio {
    private final MiRepositorio miRepositorio;

    @Autowired
    public MiServicio(MiRepositorio miRepositorio){
        this.miReposirotio = miRepositorio;
    }
}
```

2. Inyeccion por Setter:

```java
@Service
public class MiServicio {
    private final MiRepositorio miRepositorio;

    @Autowired
    public void setMiServicio(MiRepositorio miRepositorio){
        this.miReposirotio = miRepositorio;
    }
}
```

3. Inyeccion por Campo:

```java
@Service
public class MiServicio {
    @Autowired
    private MiRepositorio miRepositorio;
}
```

## Inicializacion de un Bean

Durante el proceso de inicializacion, se puede ejecutar logica personalizada para preparar un bean para su uso. Spring proporciona varias formas de personalizar la inicializacion de beans.

- Orden de inicializacion: Spring se encarga de llamar a los metodos de inicializacion en el momento adecuado, despues de que han configurado las dependencias del bean.
- Manejo de excepciones: Asegurate de manejar adecuadamente cualquier excepcion que pueda ocurrir durante la inicializacion.
- Consistencia: Elige un enfoque y manten la consistencia en toda tu aplicacion para facilitar el mantenimiento.

## Destruccion de un Bean

Spring tambien ofrece formas de ejecutar logica personalizada cuando un bean esta a punto de ser destruido. Esto resulta util para liberar recursos, cerrar conexiones o realizar otras tareas de limpieza.

- Orden de destruccion: El orden en que se llaman los metodos de destruccion no esta garantizado.
- Manejo de excepciones: Manejar las excepciones adecuadamente dentro de los metodos de destruccion.
- Consistencia: Elige un enfoque y manten la consistencia en toda tu aplicacion para facilitar el mantenimiento.