CREATE DATABASE libreria_db;
USE libreria_db;

CREATE TABLE autor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    nacionalidad VARCHAR(50),
    fecha_nacimiento DATE,
    biografia TEXT
);

CREATE TABLE libro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    genero VARCHAR(50),
    fecha_publicacion DATE,
    autor_id INT,
    FOREIGN KEY (autor_id) REFERENCES autor(id) ON DELETE CASCADE
);

INSERT INTO autor (nombre, nacionalidad, fecha_nacimiento, biografia) VALUES 
('Gabriel García Márquez', 'Colombiana', '1927-03-06', 'Premio Nobel de Literatura en 1982.'),
('J.K. Rowling', 'Británica', '1965-07-31', 'Autora de la famosa saga de Harry Potter.');

INSERT INTO libro (titulo, genero, fecha_publicacion, autor_id) VALUES 
('Cien años de soledad', 'Realismo mágico', '1967-06-05', 1),
('El coronel no tiene quien le escriba', 'Ficción', '1961-01-01', 1),
('Harry Potter y la piedra filosofal', 'Fantasía', '1997-06-26', 2);