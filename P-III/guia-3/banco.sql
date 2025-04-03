CREATE DATABASE IF NOT EXISTS banco;
USE banco;

CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    dni VARCHAR(20) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE credenciales (
    id_credencial INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    permiso ENUM('CLIENTE', 'ADMINISTRADOR', 'GESTOR') NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE
);

CREATE TABLE cuentas (
    id_cuenta INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    tipo ENUM('CAJA_AHORRO', 'CUENTA_CORRIENTE') NOT NULL,
    saldo DECIMAL(10,2) DEFAULT 0,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE
);


INSERT INTO usuarios (id_usuario, nombre, apellido, dni, email, fecha_creacion) VALUES
(1, 'Juan', 'Pérez', '12345678', 'juan.perez@email.com', '2025-03-25 15:37:49'),
(2, 'María', 'Gómez', '87654321', 'maria.gomez@email.com', '2025-03-25 15:37:49'),
(3, 'Carlos', 'López', '11223344', 'carlos.lopez@email.com', '2025-03-25 15:37:49'),
(4, 'Ana', 'Fernández', '44332211', 'ana.fernandez@email.com', '2025-03-25 15:37:49'),
(5, 'Pedro', 'Martínez', '55667788', 'pedro.martinez@email.com', '2025-03-25 15:37:49');

INSERT INTO credenciales (id_credencial, id_usuario, username, password, permiso) VALUES
(1, 1, 'juanperez', '1234', 'CLIENTE'),
(2, 2, 'mariagomez', '1234', 'ADMINISTRADOR'),
(3, 3, 'carloslopez', '1234', 'GESTOR'),
(4, 4, 'anamartinez', '1234', 'CLIENTE'),
(5, 5, 'pedrofernandez', '1234', 'ADMINISTRADOR');

INSERT INTO cuentas (id_cuenta, id_usuario, tipo, saldo, fecha_creacion) VALUES
(1, 1, 'CAJA_AHORRO', 15000.5, '2025-03-25 15:37:49'),
(2, 1, 'CUENTA_CORRIENTE', 5000.75, '2025-03-25 15:37:49'),
(3, 2, 'CAJA_AHORRO', 30000, '2025-03-25 15:37:49'),
(4, 3, 'CUENTA_CORRIENTE', 12000.2, '2025-03-25 15:37:49'),
(5, 4, 'CAJA_AHORRO', 8000.9, '2025-03-25 15:37:49'),
(6, 5, 'CUENTA_CORRIENTE', 25000, '2025-03-25 15:37:49');