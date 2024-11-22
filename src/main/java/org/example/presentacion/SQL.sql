
CREATE DATABASE AlquilerMaquinas;

USE AlquilerMaquinas;

-- Tabla para almacenar los clientes
CREATE TABLE Clientes (
    cliente_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_completo VARCHAR(255) NOT NULL,
    correo_electronico VARCHAR(255) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    direccion TEXT
);

-- Tabla para almacenar las máquinas multifuncionales
CREATE TABLE Maquinas (
    maquina_id INT AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(255) NOT NULL,
    numero_serie VARCHAR(255) UNIQUE NOT NULL,
    estado ENUM('Disponible', 'Alquilada') DEFAULT 'Disponible',
    UNIQUE (numero_serie)
);

-- Tabla para almacenar los alquileres de las máquinas
CREATE TABLE Alquileres (
    alquiler_id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    maquina_id INT,
    fecha_inicio DATE,
    fecha_fin DATE,
    estado ENUM('Activo', 'Desactivado') DEFAULT 'Activo',
    FOREIGN KEY (cliente_id) REFERENCES Clientes(cliente_id),
    FOREIGN KEY (maquina_id) REFERENCES Maquinas(maquina_id)
);

INSERT INTO Clientes (nombre_completo, correo_electronico, telefono, direccion)
VALUES ('Juan Pérez', 'juan.perez@correo.com', '555-1234', 'Calle Ficticia 123');

INSERT INTO Maquinas (modelo, numero_serie, estado)
VALUES ('Canon ImageRunner', 'SN123456', 'Disponible');

INSERT INTO Alquileres (cliente_id, maquina_id, fecha_inicio, fecha_fin)
VALUES (1, 1, '2024-11-22', '2024-11-30');

-- Insertar datos en la tabla Clientes
INSERT INTO Clientes (nombre_completo, correo_electronico, telefono, direccion)
VALUES
('Juan Pérez', 'juan.perez@example.com', '555-1234', 'Calle Ficticia 123, Ciudad XYZ'),
('María García', 'maria.garcia@example.com', '555-5678', 'Avenida Libertad 456, Ciudad ABC'),
('Carlos López', 'carlos.lopez@example.com', '555-9876', 'Calle Real 789, Ciudad DEF'),
('Ana Martínez', 'ana.martinez@example.com', '555-6543', 'Calle del Sol 101, Ciudad GHI'),
('Laura Sánchez', 'laura.sanchez@example.com', '555-4321', 'Calle Nueva 202, Ciudad JKL');

-- Insertar datos en la tabla Maquinas
INSERT INTO Maquinas (modelo, numero_serie, estado)
VALUES
('Canon ImageRunner 2525', 'IR2525SN12345', 'Disponible'),
('Xerox Phaser 6510', 'XP6510SN23456', 'Disponible'),
('HP LaserJet Pro MFP M426', 'HP426SN34567', 'Alquilada'),
('Brother MFC-L3770CDW', 'BLC3770SN45678', 'Disponible'),
('Ricoh MP C4504', 'RICOH4504SN56789', 'Alquilada');

-- Insertar datos en la tabla Alquileres
INSERT INTO Alquileres (cliente_id, maquina_id, fecha_inicio, fecha_fin, estado)
VALUES
(1, 3, '2024-11-01', '2024-11-10', 'Activo'),
(2, 5, '2024-11-05', '2024-11-12', 'Activo'),
(3, 4, '2024-11-08', '2024-11-15', 'Activo'),
(4, 1, '2024-11-10', '2024-11-20', 'Activo'),
(5, 2, '2024-11-12', '2024-11-18', 'Desactivado');

RENAME TABLE Clientes TO Cliente;



