# Unidad 8: Seguridad con Spring Security y JWT

---

## 1. Conceptos de Seguridad y Autenticación

Antes de implementar seguridad en una aplicación, es importante entender algunos conceptos básicos:

- **Autenticación**: Verificar que un usuario es quien dice ser.
- **Autorización**: Definir qué recursos puede acceder un usuario autenticado.
- **JWT (JSON Web Token)**: Formato de token compacto y seguro para intercambiar información entre partes.
- **OAuth2**: Protocolo de autorización que permite a aplicaciones acceder a recursos protegidos sin exponer credenciales.

La seguridad en aplicaciones web se basa en proteger tanto la autenticación como la autorización.

---

## 2. Configuración Básica de Spring Security

Spring Security es un framework de seguridad muy robusto para aplicaciones Java.

### Dependencia en Maven

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

Con esta dependencia, Spring Boot activa seguridad básica: todas las rutas están protegidas y se necesita autenticación.

### Configuración de Usuario en Memoria

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withUsername("usuario")
                                .password(passwordEncoder().encode("password"))
                                .roles("USER")
                                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

Esto crea un usuario en memoria para autenticación rápida en entornos de desarrollo.

---

## 3. Roles y Permisos en Spring Security

Permiten definir accesos más finos a las rutas de la aplicación.

### Ejemplo de Restricción por Rol

```java
@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
        .anyRequest().authenticated()
        .and()
        .formLogin();
}
```

- `hasRole("ADMIN")`: Solo usuarios con rol ADMIN pueden acceder.
- `hasAnyRole("USER", "ADMIN")`: Usuarios con rol USER o ADMIN pueden acceder.

---

## 4. Manejo de Sesiones y Cookies

Spring Security maneja sesiones automáticamente, pero se puede personalizar.

### Configuración de Manejo de Sesiones

```java
@Override
protected void configure(HttpSecurity http) throws Exception {
    http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
}
```

- `SessionCreationPolicy.STATELESS`: No guarda sesiones de usuario en el servidor. Ideal para APIs REST donde se usa JWT.

### Desactivar CSRF

```java
http.csrf().disable();
```

Para APIs REST, generalmente se desactiva CSRF.

---

## 5. Autenticación con JWT

JWT permite una autenticación "sin estado".

### Flujo Básico

1. Usuario envía credenciales.
2. Servidor valida y genera un JWT.
3. Cliente guarda el JWT y lo envía en cada solicitud.
4. Servidor valida el JWT.

### Dependencia de `jjwt`

```xml
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.9.1</version>
</dependency>
```

### Crear un Token

```java
String token = Jwts.builder()
    .setSubject("usuario")
    .setIssuedAt(new Date())
    .setExpiration(new Date(System.currentTimeMillis() + 3600000))
    .signWith(SignatureAlgorithm.HS512, "secreto_clave")
    .compact();
```

### Validar un Token

```java
Claims claims = Jwts.parser()
    .setSigningKey("secreto_clave")
    .parseClaimsJws(token)
    .getBody();

String username = claims.getSubject();
```

---

## 6. Implementación de OAuth2 en Spring Boot

OAuth2 permite a usuarios autorizar aplicaciones usando su cuenta de Google, GitHub, etc.

### Dependencia en Maven

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-client</artifactId>
</dependency>
```

### Configuración en `application.properties`

```properties
spring.security.oauth2.client.registration.google.client-id=TU_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=TU_CLIENT_SECRET
```

---

## Resumen Final

Con esta unidad serás capaz de:

- Aplicar autenticación y autorización en proyectos Spring Boot.
- Utilizar roles y permisos para proteger rutas.
- Implementar JWT para autenticación sin estado.
- Integrar OAuth2 como método de autenticación.

Esto te permitirá desarrollar aplicaciones web mucho más seguras.

---

**Fin de la Unidad 8**
