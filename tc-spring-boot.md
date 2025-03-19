
# Arquitectura Cliente-Servidor

Es un modelo de diseño de software y red en el que las tareas se reparten entre los proveedores de recursos o servicios (servidores) y los demandante o consumidores de estos llamados clientes.

Establece que existe una serie de clientes que puede conectarse a servidores para consumir un determinado servicio.

La principal caracteristica de este modelo es el hecho de que un mismo servicio puede estar siendo consumido al mismo tiempo por sin fin de clientes, siempre y cuando el servidor encargado de recibir las peticiones tenga la capacidad suficiente para tratarlas.

### Clientes:
- En una arquitectura Cliente-Servidor, un navegador es la mejor representacion de un cliente que solicita pedidos a un servidor.
- El cliente "comprende" las respuestas provenientes del servidor, las interpreta y muestra en pantalla al usuario.

### Servidores:
- Un servidor web o servidor HTTP representa al servidor que se encarga de procesar los pedidos de distintos clientes en una aplicacion web.
- Tiene la capacidad de recibir y administrar pedidos, para determinar la respuesta a enviar.

# Protocolo HTTP

Es un conjunto de reglas que se debe seguir para poder obtener o lograr un determinado resultado o acceder a un determinado recurso o servicio.

HTTP, "Hypertext Transfer Protocol", protocolo de transferencia de hipertexto. Permite que las solicitudes (requests) y las respuestas (responses) entre clientes y servidores, tengan un determinado formato a seguir y respetar para que puedan comunicarse sin inconvenientes.

## Request

Es el mensaje que se lleva a cabo desde un cliente hacia un servidor para poder acceder a un determinado servicio.

Una request que se lleva a cabo en una comunicacion que utiliza el protocolo HTTP tiene una seria de partes:

- Metodo: Se utiliza para indicar bajo que metodo o verbo HTTP se enviara el mensaje. GET, POST, PUT y DELETE.
- URL: Direccion en donde se encuentra el servidor y a la cual el cliente esta enviando la request.
- Header: Contiene atributos o especificaciones necesarias para una correcta comunicacion.
- Body: Campo opcional donde en caso de ser necesario pueden incluirse objetos, texto o datos en particular.

## Response

En el protocolo HTTP, la estructura es muy similar a la de las requests, pero cuenta con un Status Code que ayuda a que el cliente comprenda si se pudo procesar correctamente la solicitud en el servidor.

- Status Code:
    - Codigos de rango 100: Respuestas de tipo informativas.
    - Codigos de rango 200: La solicitud fue procesada correctamente.
    - Codigos de rango 300: Informar que se producira una redireccion.
    - Codigos de rango 400: Representan errores causados por la solicitud del cliente.
    - Codigos de rango 500: Manifiestan errores pero que fueron causados por el servidor.
- Header: Contiene atributos o especificaciones necesarias para una correcta comunicacion.
- Body: Campo opcional donde en caso de ser necesario pueden incluirse objetos, texto o datos en particular.

# Arquitectura REST

Representational state transfer (transferencia de estado representacional) es un estilo de arquitectura de software que define o establece un conjunto de estandares, propiedades y buenas practicas que de pueden implementar sobre HTTP. Su principal funcion es la de permitir que un desarrollo web pueda operar con otros mediante sus estandares a traves de internet o de una red. La caracteristica que destaca a REST es el hecho de que es "stateless".

En base a la aquitectura REST, en el protocolo HTTP existen varios metodos o verbos que pueden ser utilizados para las comunicaciones de las solicitudes, donde cada uno de ellos tiene una finalidad en particular.

# Metodos HTTP

- GET: Solicita una representacion de un recurso especifico. Estas peticiones solo deben recuperar datos.
- POST: Se utiliza para enviar una entidad a un recurso en especifico, causando a menudo un cambio en el estado o efectos secundarios en el servidor.
- PUT: Reemplaza todas las representaciones actuales del recurso de destino con la carga util de la peticion.
- DELETE: Borra un recurso en especifico.
- PATCH: Es utilizado para aplicar modificaciones parciales a un recurso.

# Librerias

Son un conjunto de bloques de codigo especificadas en forma de funcionalidades que se utilizan para resolver problemas o necesidades especificas que se pueden presentar en diferentes tipos de proyectos durante el desarrollo de software.

Su principal caracteristica es el hecho de que pueden ser reutilizadas la cantidad de veces que sean necesarias.

# Frameworks

Son marcos o entornos de trabajo que incluyen dentro de si un conjunto de herramientas y librerias que pueden ser utilizadas de forma sencilla.

Su principal funcionalidad es la de facilitar y reducir tiempos a la hora de desarrollar aplicaciones complejas.

# Frameworks vs. Librerias

| Framework | Libreria |
|-----------|-----------|
| Incluye un conjunto de herramientas para resolver un problema    | Es una herramienta que tiene como finalidad resolver un aspecto o necesidad en particular  |
| Posee herramientas para determinar la compatibilidad entre los diferentes complementos que son necesarios para un proyecto    | La verificacion de compatibilidad de una libreria con otras herramientas o librerias es responsabilidad del programador   |
| Tiene una serie de normas o reglas a seguir para poder desarrollar un proyecto de esta manera    | Si no existe un framework de por medio, las librerias pueden combinarse o utilizarse entre si decualquier forma, dependiendo de lo que establezca el programador   |

# Spring Framework

Es un conjunto de proyectos de codigo abierto desarrollados en Java con el objetivo de agilizar el desarrollo de aplicaciones en este lenguaje. 

- Spring Boot: Facilita la creacion y configuracion inicial de proyectos de Spring para generar aplicaciones de facil y rapida puesta en marcha.
- Spring Data: Utilizado para la administracion, manejo y comunicacion con bases ded atos, tanto relacionales como no-relacionales.
- Spring Security: Utilizado para las cuestiones de seguridad que puede necesitar todo proyecto.
- Spring Web Services: Utilizado para facilitar el desarrollo de Web Services SOAP.

# Spring Boot 

Es una extension de Spring Framework. Fue creado con la finalidad de facilitar la creacion de aplicaciones web.

Requiere una configuracion minima y puede ser integrado con otros proyectos de Spring o librerias externas. 

Spring Boot = Spring Framework + Servidor Web embebido - Configuracion XML

# Spring Initializr

Para facilitar la creacion de proyectos de forma generica y que estos puedan ser levantados desde cualquier IDE, Spring Boot ofrece una herramienta conocida como Initializr.

Spring Initializr es una API que permite la creacion de proyectos con sus respectivas dependencias de forma sencilla ahorrando gran cantidad de tiempo a la hora de configurar los mismos.

# Patron Modelo Vista Controlador (MVC)

Es un patron de diseño de software que permite una separacion entre la logica de negocio de una aplicacion y la vista que se le presenta al usuario, utilizando como intermediario a un controlador que se encarga de tomar la decision de como interactuan la vista y el modelo entre si.

- Controlador: Recibe las ordenes del usuario, solicita los datos al modelo y se los comunica a la vista.
- Modelo: Se encarga del modelado de los datos. En el se encuentra generalmente la logica de usuario y las fuentes de datos.
- Vista: Es la interfaz grafica que se le presenta al usuario. Recibe datos provenientes del modelo a traves del controlador y se los muestra al usuario en cuestion.

# APIs Rest

API (application programming interface) es un conjunto de funciones y metodos que se usan para diseñar e integrar software de diferentes aplicaciones. Esto permite que, dos aplicaciones se puedan comunicar entre si.

La forma mas comun de implementacion de una API es mediante REST (Representational State Transfer), el cual es un tipo de servicio que se caracteriza por no tener estado alguno y por lograr interconexiones mediante el protocolo HTTP con mensajes de tipo XML o JSON.