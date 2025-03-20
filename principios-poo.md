# SOLID

El principio SOLID es un conjunto de principios fundamentales en la programacion orientada a objetos (POO) que ayudan a diseñar software mas mantenible, escalable y comprensible. El acronimo SOLID representa los siguientes principios:

- S - Principio ded responsabilidad unica (SRP)
    
        Cada clase debe tener una unica razon para cambiar, es decir, deber ser responsable de una sola funcionalidad dentro del sistema. Si una clase tiene multiples responsabilidades, cualquier cambio en una de ellas podria afectar a las demas, lo que aumenta el acoplamiento y dificulta el mantenimiento.
        
- O - Principio de abierto/cerrado (OCP)

        El codigo debe estar abierto para la extension, pero cerrado para la modificacion. Esto significa que debemos agregar nuevas funcionalidades sin modificar el codigo existente, lo que reduce el riesgo de introducir errores y facilita el mantenimiento.

- L - Principio de sustitucion de Liskov (LSP)

        Las subclases deben poder reemplazar a sus clases base sin alterar el comportamiento del programa. Si una subclase cambia el comportamiento de la clase base de forma inesperada, puede romper el sistema.

- I - Principio de segregacion de interfaces (ISP)

        Las interfaces deben ser especificas y no obligar a las clases a implementar metodos que no necesitan. Es preferible tener varias interfaces pequeñas y especializadas en lugar de una unica interfaz grande y generica.

- D - Principio de inversion de dependencias (DIP)

        Las clases deben depender de abstracciones (interfaces o clases abstractas) y no de implementaciones concretas. Esto permite cambiar implementaciones facilmente sin afectar a otras partes del codigo.

# Clases y objetos

- Clase

        Es una plantilla que define atributos y metodos.

- Objeto

        Es una instancia de una clase.

# Encapsulamineto

Consiste en ocultar los atributos de una clase y acceder a ellos mediante metodos publicos (getters y setters). Se logra con modificadores de acceso (private, public, protected).

# Herencia

Permite que una clase hija herede atributos y metodos de una clase padre. Se usa la palabra clave extends.

# Polimorfismo

- Polimorfismo de sobreescritura (@Override)

        Permite que una sublase modifique el comportamiento de un metodo heredado.

- Polimorfismo de sobrecarga

        Permite que varios metodos tengan el mismo nombre, pero con diferentes parametros.

# Abstraccion

Una clase abstracta no se puede instanciar, solo se puede usar como base para otras clases. Un metodo abstracto no tiene implementacion en la clase padre, solo en las subclases.

# Interfaces

Una interfaz solo define metodos (sin implementacion) que las clases deben implementar. Permite simular la herencia multiple en Java.

# Modificadores de acceso

| Modificador   | Mismo Clase | Mismo Paquete | Subclases | Otras Clases |
|--------------|------------|--------------|-----------|--------------|
| `private`    | ✅ Sí      | ❌ No        | ❌ No     | ❌ No        |
| *(default)*  | ✅ Sí      | ✅ Sí        | ❌ No     | ❌ No        |
| `protected`  | ✅ Sí      | ✅ Sí        | ✅ Sí     | ❌ No        |
| `public`     | ✅ Sí      | ✅ Sí        | ✅ Sí     | ✅ Sí        |

# Manejo de excepciones (try - catch - finally)

Se usa para manejar errores en tiempo de ejecucion sin que el programa se detenga.

# Variable estatica (static)

- Se declara con la palabra clave static.
- Pertenece a la clase en lugar de a las instancias (objetos).
- Todas las instancias de la clase comparten la misma variable.
- Se accede usando el nombre de la clase (Clase.nombreVariable).

# Variable de instancia

- No usa static, pertenece a cada objeto de la clase.
- Cada instancia de la clase tiene su propia copia.
- Se accede con this.nombreVariable o desde el objeto.

# Variable local

- Se declara dentro de un metodo, constructor o bloque.
- Solo exite mientras el metodo se esta ejecutando.
- No tiene valores por defecto, debe inicializarse antes de usarse.

# Variable de clase (final static)

- Es estatica y constante, no puede cambiar su valor.
- Se inicializa una sola vez.
- Se accede igual que las variables estaticas.

