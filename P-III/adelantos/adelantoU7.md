**Unidad 7: Persistencia de Datos con Spring Data y MySQL**

---

# 1. Fundamentos de Bases de Datos Relacionales

Una base de datos relacional organiza los datos en tablas relacionadas entre sí. Cada tabla contiene filas (registros) y columnas (atributos). Las bases de datos relacionales usan SQL (Structured Query Language) para gestionar los datos.

Conceptos clave:
- **Tabla**: Colección de datos organizados en columnas y filas.
- **Clave primaria (Primary Key)**: Identificador único para cada registro.
- **Clave foránea (Foreign Key)**: Campo que establece una relación con otra tabla.
- **Relaciones**: Uniones lógicas entre tablas (OneToMany, ManyToOne, ManyToMany).

Ejemplo de tablas relacionadas:

```sql
CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE pedidos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    cliente_id INT,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);
```

---

# 2. JPA y Hibernate: Configuración y Uso

## JPA (Java Persistence API)

Es una especificación para la persistencia de datos en aplicaciones Java. Define cómo interactuar con bases de datos mediante objetos Java.

## Hibernate

Es una implementación popular de JPA. Facilita el trabajo con bases de datos evitando la necesidad de escribir mucho código SQL.

## Dependencias necesarias en `pom.xml`

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

## Configuración en `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mi_base_de_datos
spring.datasource.username=root
spring.datasource.password=mi_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# 3. Mapeo de Entidades y Relaciones

En JPA, representamos tablas mediante **entidades** (clases anotadas).

## Ejemplo de Entidad Simple

```java
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
}
```

## Relaciones entre Entidades

- **@OneToMany**: Un cliente tiene muchos pedidos.
- **@ManyToOne**: Muchos pedidos pertenecen a un solo cliente.
- **@ManyToMany**: Relación de muchos a muchos (por ejemplo, productos y pedidos).

## Ejemplo de Relación OneToMany

```java
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;
}

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
```

---

# 4. Consultas con Spring Data JPA

Spring Data JPA genera consultas automáticamente a partir de los nombres de los métodos de repositorio.

## Repositorios

```java
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNombreContaining(String nombre);
}
```

- `findByNombreContaining(String nombre)`: Busca clientes cuyo nombre contenga el texto indicado.

## Consultas personalizadas con @Query

```java
@Query("SELECT c FROM Cliente c WHERE c.nombre LIKE %:nombre%")
List<Cliente> buscarPorNombre(@Param("nombre") String nombre);
```

## Modificaciones con @Modifying

```java
@Transactional
@Modifying
@Query("UPDATE Cliente c SET c.nombre = :nombre WHERE c.id = :id")
void actualizarNombre(@Param("id") Long id, @Param("nombre") String nombre);
```

---

# 5. Transacciones y Manejo de Concurrencia

## @Transactional

Spring proporciona la anotación `@Transactional` para asegurarse que un conjunto de operaciones se ejecuten de forma atómica: o se completan todas exitosamente o se revierte todo en caso de error.

```java
@Transactional
public void realizarPedido(Pedido pedido) {
    pedidoRepository.save(pedido);
    actualizarStock(pedido);
}
```

## Concurrencia

Para manejar accesos simultáneos a los datos, Hibernate implementa estrategias como:
- **Optimistic Locking**: Se comprueba si un registro ha sido modificado antes de confirmar cambios.
- **Pessimistic Locking**: Se bloquea un registro para evitar que otros usuarios lo modifiquen mientras está en uso.

Ejemplo de uso de Optimistic Locking:

```java
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private int version;

    private String nombre;
}
```

El campo `@Version` permite a Hibernate detectar conflictos de concurrencia.

---

# Resumen Final

Al finalizar esta unidad, serás capaz de:
- Configurar Spring Boot para conectarse a bases de datos MySQL.
- Utilizar JPA e Hibernate para mapear entidades y relaciones.
- Realizar operaciones CRUD automáticas y consultas personalizadas.
- Gestionar transacciones y manejar concurrencia de datos de manera segura.

Con estas herramientas, podrás crear aplicaciones backend con persistencia de datos robusta y eficiente.
