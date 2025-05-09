
# Exposición: Usuarios y Privilegios en MySQL

## 🎯 Objetivo
Explicar cómo se gestionan los **usuarios y privilegios** en MySQL para garantizar la seguridad y el control de acceso a los datos.

---

## 🧠 Conceptos clave

### 🔐 1. ¿Qué son los usuarios en MySQL?
Son cuentas que permiten a las personas o aplicaciones conectarse a una base de datos. Cada usuario tiene:
- Un **nombre de usuario** (`user`)
- Un **host** (lugar desde donde se conecta, como `'localhost'`)
- Una **contraseña** (opcional)

### 🎛️ 2. ¿Qué son los privilegios?
Son permisos que se otorgan a un usuario para realizar acciones específicas como:
- `SELECT`, `INSERT`, `UPDATE`, `DELETE`
- `CREATE`, `DROP`, `ALTER`
- `GRANT`, `REVOKE`, `ALL PRIVILEGES`

---

## 🛠️ Comandos básicos con ejemplos prácticos

### ✅ Crear un usuario
```sql
CREATE USER 'juan'@'localhost' IDENTIFIED BY '1234';
```

### ✅ Ver usuarios existentes
```sql
SELECT User, Host FROM mysql.user;
```

### ✅ Otorgar privilegios
```sql
GRANT SELECT, INSERT ON tienda.productos TO 'juan'@'localhost';
```

### ✅ Ver privilegios otorgados
```sql
SHOW GRANTS FOR 'juan'@'localhost';
```

### 🚫 Revocar privilegios
```sql
REVOKE INSERT ON tienda.productos FROM 'juan'@'localhost';
```

### 🔄 Modificar contraseña
```sql
ALTER USER 'juan'@'localhost' IDENTIFIED BY 'nuevaPassword';
```

### ❌ Eliminar un usuario
```sql
DROP USER 'juan'@'localhost';
```

---

## 🧪 Ejemplo práctico paso a paso

1. Crear base de datos y tabla:
```sql
CREATE DATABASE tienda;
USE tienda;

CREATE TABLE productos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100),
  precio DECIMAL(10,2)
);
```

2. Crear un nuevo usuario:
```sql
CREATE USER 'ana'@'localhost' IDENTIFIED BY 'ana123';
```

3. Otorgar permisos limitados:
```sql
GRANT SELECT ON tienda.productos TO 'ana'@'localhost';
```

4. Probar conexión como *ana*:
```bash
mysql -u ana -p
```

5. Consultar productos:
```sql
SELECT * FROM tienda.productos;
```

6. Intentar insertar (falla):
```sql
INSERT INTO tienda.productos (nombre, precio) VALUES ('Coca', 250);
```

---

## 🧩 Buenas prácticas (expandidas)

### ✅ No usar `root` para tareas diarias

**Por qué:** El usuario root tiene todos los permisos. Usarlo para tareas comunes puede provocar errores graves.

**Ejemplo incorrecto:**
```sql
DROP DATABASE produccion;
```

**Recomendación:** Crear usuarios específicos con permisos limitados.

---

### ✅ Dar solo los privilegios necesarios

**Concepto:** Principio de menor privilegio.

**Ejemplo correcto:**
```sql
GRANT SELECT ON tienda.productos TO 'consultaUser'@'localhost';
```

**Ejemplo incorrecto:**
```sql
GRANT SELECT, INSERT, DELETE ON tienda.productos TO 'consultaUser'@'localhost';
```

---

### ✅ Usar `%` con cuidado

**Qué hace:** Permite conexión desde cualquier IP.

**Riesgo:** Facilita ataques si se adivina la contraseña.

**Ejemplo seguro:**
```sql
CREATE USER 'ana'@'192.168.0.15' IDENTIFIED BY 'clave123';
```

**Ejemplo riesgoso:**
```sql
CREATE USER 'ana'@'%' IDENTIFIED BY 'clave123';
```

---

### ✅ Auditar con `SHOW GRANTS`

**Para qué sirve:** Ver qué permisos tiene un usuario.

**Ejemplo:**
```sql
SHOW GRANTS FOR 'juan'@'localhost';
```

**Recomendación:** Usarlo regularmente para auditorías de seguridad.

---

## 📋 Estructura sugerida para tu presentación

1. Introducción: ¿Qué es un usuario? ¿Qué son los privilegios?
2. Tipos de privilegios: Ejemplos comunes.
3. Creación y gestión de usuarios: Comandos con demostración.
4. Caso práctico en vivo (con tabla `productos`).
5. Buenas prácticas.
6. Preguntas y cierre.
