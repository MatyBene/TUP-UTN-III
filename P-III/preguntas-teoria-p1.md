# Preguntas

1. La interfaz Function<T, R> representa una funcion que acepta un argumento y devuelve un resultado. *VERDADERO*
2. El metodo map de los streams puede cambiar el tipo de los elementos del stream.
3. Las interfaces funcionales pueden tener varios metodos abstractos. *FALSO*
4. La inmutabilidad de los datos es un principio de la programacion funcional.
5. El metodo filter de los streams requiere una funcion que devuelva un boolean.
6. En que caso se recomienda usar la clase ```Optional<T>```
   - Como parameto de un metodo
   - Como tipo de retorno
   - Como atributo dentro de una clase
   - Todas las anteriores
7. Cual es el proposito de la anotacion @FunctionalInterface?
   - Hace que la clase sea funcional
   - Indica que la interfaz debe tener solo un metodo abstracto
   - Permite que una clase implemente multiples interfaces
   - Habilita metodos estaticos
8. Cual de las siguientes opciones describe mejor una expresion lambda?
   - Es una clase anonima
   - Es una forma de crear metodos sin nombre
   - Es una interfaz funcional
   - Es una subclase de Function
9. Cual es la firma de la interfaz ```Predicate<T>```?
   - T apply(T t)
   - void accept(t t)
   - boolean test(T t)
   - R apply(T t, U u)
10. Que metodo de la clase Optional se usa para obtener el valor o un valor por defecto si esta vacio?
     - get()
     - orElse()
     - ifPresent()
     - orElseThrow()
11. Cual de las siguientes es una interfaz funcional?
     - Runnable
     - Comparator
     - Consumer
     - Todas las anteriores
12. Cual es el proposito del patron Singleton?
     - Permitir herencia multiple
     - Separar logica de presentacion
     - Proteger acceso concurrente
     - Garantizar que una clase tenga una unica instancia
13. Que elemento clave se utiliza en un Singleton para evitar multiples instancias?
    - Un metodo abstracto
    - Una interfaz funcional
    - Un bloque try-catch
    - Una variable estatica privada
14. Cual es la funcion principal de un DTO (Data Transfer Object)?
    - Acceder directamente a la base de datos
    - Renderizar vistas en MVC
    - Definir la logica de negocio
    - Transportar datos entre capas de una aplicacion
15. 
16. El principio de Responsabilidad Unica (SRP) indica que...
     - Una clase debe tener multiples responsabilidades
     - Una clase no debe tener atributos privados
     - Una clase debe implementar varias interfaces
     - Una clase debe tener una sola razon para cambiar
17. A que principio SOLID corresponde el siguiente predicado "Las clases deben estar abiertas a extension pero cerradas a modificacion"
    - Principio de Codigo Abierto - Cerrado
    - Principio de Sustitucion de Liskov
    - Principio de Segregacion de Interfaz
    - Principio de Inversion de Dependencia
18. En el patron MVC, que componente gestiona la logica de negocio?
    - Vista
    - Controlador
    - DAO
    - Modelo
19. Cual es la responsabilidad principal del Controlador en MVC?
    - Mostrar los datos al usuario
    - Realizar consultas SQL directamente
    - Serializar objetos
    - Recibir la entrada del usuario y coordinar la respuesta
20. Que componente en MVC se encarga de representar la interfaz grafica al usuario?
    - Modelo
    - Controlador
    - Vista
    - Servicio
21. Por que se utiliza la arquitectura MVC?
    - Para evitar el uso de patrones de diseño
    - Para tener una unica clase con toda la logica
    - Para evitar usar bases de datos
    - Para separar responsabilidades y facilitar el mantenimiento
22. Cual es el objetico de una API?
    - Proveer almacenamiento de datos
    - Aumentar el rendimiento del servidor
    - Permitir la comunicacion entre componentes de software
    - Ejecutar programas externos automaticamente
23. Que significa que una API REST sea "stateless"?
    - El cliente mantiene el estado del servidor
    - El servidor no guarda estado entre peticiones
    - No se permite el uso de bases de datos
    - El cliente no tiene acceso a metodos HTTP
24. Cual de los siguientes NO es un principio de REST?
    - Stateless
    - Uniform Interface
    - Mantenimiento de sesion del servidor
    - Client-Server
25. Que metodo HTTP se utiliza para obtener un recurso? *GET*
26. Que metodo HTTP se utiliza para actualizar un recurso existente? *PATCH*
27. Que componente de una peticion contiene informacion adicional como autenticacion o tipo de contenido?
    - URL
    - Headers
    - Body
    - Endpoint
28. Los codigos HTTP 2xx indican una operacion exitosa. *VERDADERO*
29. Los codigos HTTP 4xx indican un error por parte del servidor. *FALSO*
30. El uso de PreparedStatement ayuda a prevenir ataques por inyeccion SQL. 
31. El metodo executeQuery() se usa para ejecutar sentencia SQL del tipo INSERT, UPDATE o DELETE.
32. ResultSet permite recorrer el resultado de una consulta SQL fila por fila.
33. Cual de las siguientes interfaces representa la conexion activa con la base de datos?
    - DriverManager
    - Connection
    - Statement
    - ResultSet
34. Cual de los siguientes metodos ejecuta una consulta SELECT y devuelve un ResultSet?
    - executeUpdate()
    - execute()
    - executeQuery()
    - runSelect()
35. Que metodo se utiliza para preparar una sentencia SQL dinamica con parametros?
    - createStatement()
    - prepareCall()
    - prepareStatement()
    - execute()
36. Que elemento se recomienda cerrar manualmente al usar JDBC para evitar fugas de recursos?
    - Clases de utilidad
    - Conexiones, Statements y ResultSets
    - Paquetes
    - Imports
37. El archivo application.properties es utilizado para manejar configuraciones. *VERDADERO*
38. Cual de los siguientes es un objetivo principal de Spring Boot?
    - Crear APIs REST
    - Simplificar el desarrollo de aplicaciones Spring
    - Generar codigo automaticamente
    - Ejecutar scripts SQL
39. Que dependencia en pom.xml se necesita para comenzar una app web en Spring Boot?
    - spring-core
    - spring-orm
    - spring-boot-starter-web
    - spring-jpa
40. Cual es la anotacion que indica el punto de entrada de una aplicacion Spring Boot?
    - @Controller
    - @SpringBootApplication
    - RestController
41. Cual es una ventaja directa de Spring Boot frente a Spring Framework tradicional?
    - Mayor compatibilidad con XML y JSON
    - Mejor rendimiento
    - Configuracion automatica y arranque rapido
    - Necesidad de mas archivos de configuracion
42. Un Bean en Spring es simplemente un objeto que no puede ser gestionado por el controlador. *FALSO*
43. @Component y @Bean se usan para declarar Beans en Spring, pero en contextos distintos.
44. El ciclo de vida de un Bean siempre comienza al momento de su uso por primera vez (lazy).
45. Como se puede inyectar una dependencia en Spring Boot?
    - Por constructor
    - Por campo
    - Por Setter
    - Todas las anteriores
46. Que hace la anotacion @Autowired?
    - Define una clase como un Bean
    - Ejecuta un metodo despues de construir un objeto
    - Inyecta automaticamente una dependencia
    - Define una propiedad como constante
47. Que anotacion se usa para marcar una clase como componente administrado por Spring?
    - @Managed
    - @Injectable
    - @Component
    - @Bean
48. Que anotacion se suele usar para clases que implementan logica de negocio?
    - @Component
    - @Service
    - @Repository
    - @Configuration
49. Cual es la diferencia entre @Component y @Bean?
    - @Component es para bibliotecas externas, @Bean para internas
    - @Component se usa en clases, @Bean en metodos
    - No hay diferencia
    - @Bean se aplica solo a interfaces
