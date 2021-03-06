DROP DATABASE PROYECTO2;
CREATE SCHEMA IF NOT EXISTS PROYECTO2;

USE PROYECTO2;

CREATE TABLE IF NOT EXISTS USUARIO(
    id INT NOT NULL AUTO_INCREMENT, 
    usuario VARCHAR(100) NOT NULL,
    password VARCHAR(45) NOT NULL,
    rol VARCHAR(20) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (id,usuario)
);

CREATE TABLE IF NOT EXISTS ADMINISTRADOR(
    codigo VARCHAR(45) NOT NULL ,
    dpi VARCHAR(13) NOT NULL ,
    nombre VARCHAR(60) NOT NULL ,
    id_USUARIO INT NOT NULL ,
    PRIMARY KEY (codigo),
    FOREIGN KEY (id_USUARIO) REFERENCES USUARIO(id),
    UNIQUE (codigo,dpi,id_USUARIO)
);

CREATE TABLE  IF NOT EXISTS CONSULTA(
    id INT NOT NULL AUTO_INCREMENT ,
    nombre VARCHAR (45) NOT NULL ,
    costo DOUBLE NOT NULL ,
    PRIMARY KEY (id),
    UNIQUE (id,nombre)
);

CREATE TABLE  IF NOT EXISTS MEDICO(
    codigo VARCHAR (45) NOT NULL ,
    nombre VARCHAR (60) NOT NULL ,
    dpi VARCHAR (13) NOT NULL ,
    telefono VARCHAR (8) NOT NULL ,
    numero_colegiado VARCHAR (20) NOT NULL ,
    email VARCHAR (45) NOT NULL ,
    inicio_horario VARCHAR(15) NOT NULL ,
    fin_horario VARCHAR(15) NOT NULL,
    inicio_labores DATE NOT NULL,
    id_USUARIO INT NOT NULL ,
    PRIMARY KEY(codigo),
    FOREIGN KEY (id_USUARIO) REFERENCES USUARIO(id),
    UNIQUE (codigo,dpi,numero_colegiado,email,telefono,id_USUARIO)

);

CREATE TABLE  IF NOT EXISTS ESPECIALIDAD_MEDICO(
    id INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR (45) NOT NULL ,
    MEDICO_codigo VARCHAR (45) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (MEDICO_codigo) REFERENCES MEDICO(codigo),
    UNIQUE (id)
);

CREATE TABLE IF NOT EXISTS PACIENTE(
    codigo INT NOT NULL AUTO_INCREMENT ,
    nombre VARCHAR (60) NOT NULL ,
    dpi VARCHAR (13) NOT NULL ,
    telefono VARCHAR (8) NOT NULL ,
    email VARCHAR (45) NOT NULL ,
    sexo VARCHAR (10) NOT NULL ,
    peso DOUBLE NOT NULL ,
    tipo_sangre VARCHAR (5) NOT NULL ,
    fecha_nacimiento DATE NOT NULL ,
    id_USUARIO INT NOT NULL ,
    PRIMARY KEY (codigo),
    FOREIGN KEY (id_USUARIO) REFERENCES USUARIO(id),
    UNIQUE (codigo,dpi,email,telefono,id_USUARIO)
);

CREATE TABLE IF NOT EXISTS LABORATORISTA(
    codigo VARCHAR (45) NOT NULL ,
    dpi VARCHAR (13) NOT NULL ,
    nombre VARCHAR (60) NOT NULL ,
    numero_registro VARCHAR (45) NOT NULL,
    telefono VARCHAR (8) NOT NULL ,
    email VARCHAR (45) NOT NULL ,
    inicio_labores DATE NOT NULL ,
    tipo_examen VARCHAR(45) NOT NULL,
    id_USUARIO INT NOT NULL ,
    PRIMARY KEY (codigo),
    FOREIGN KEY (id_USUARIO) REFERENCES USUARIO(id),
    UNIQUE (codigo,numero_registro,dpi,email,telefono,id_USUARIO)
);

CREATE TABLE IF NOT EXISTS DIAS_TRABAJO(
    id INT NOT NULL AUTO_INCREMENT ,
    dia VARCHAR (20) NOT NULL ,
    LABORATORISTA_codigo VARCHAR (45) NOT NULL ,
    PRIMARY KEY (id),
    FOREIGN KEY (LABORATORISTA_codigo) REFERENCES LABORATORISTA(codigo),
    UNIQUE (id)
);

CREATE TABLE IF NOT EXISTS EXAMEN(
    codigo INT NOT NULL AUTO_INCREMENT ,
    nombre VARCHAR (45) NOT NULL ,
    orden TINYINT NOT NULL ,
    descripcion TEXT NOT NULL ,
    costo DOUBLE NOT NULL ,
    tipo_informe VARCHAR (3) NOT NULL ,
    PRIMARY KEY (codigo),
    UNIQUE (codigo,nombre)
);

CREATE TABLE IF NOT EXISTS SOLUCITUD_EXAMEN(
    id INT AUTO_INCREMENT  NOT NULL ,
    nombre_orden VARCHAR (45),
    orden MEDIUMBLOB,
    fecha DATE NOT NULL ,
    EXAMEN_codigo INT NOT NULL ,
    LABORATORISTA_codigo VARCHAR (45) NOT NULL ,
    PACIENTE_codigo INT NOT NULL ,
    MEDICO_codigo VARCHAR (45),
    PRIMARY KEY (id),
    FOREIGN KEY (EXAMEN_codigo) REFERENCES EXAMEN(codigo),
    FOREIGN KEY (LABORATORISTA_codigo) REFERENCES LABORATORISTA(codigo),
    FOREIGN KEY (PACIENTE_codigo) REFERENCES PACIENTE(codigo),
    UNIQUE (id)
);

CREATE TABLE IF NOT EXISTS RESULTADO(
    codigo INT AUTO_INCREMENT  NOT NULL ,
    fecha DATE NOT NULL ,
    hora VARCHAR(15) NOT NULL ,
    nombre_orden VARCHAR (45),
    orden MEDIUMBLOB,
    nombre_informe VARCHAR (45) NOT NULL ,
    informe MEDIUMBLOB NOT NULL,
    MEDICO_codigo VARCHAR (45),
    LABORATORISTA_codigo VARCHAR (45) NOT NULL ,
    PACIENTE_codigo INT NOT NULL ,
    EXAMEN_codigo INT NOT NULL ,
    PRIMARY KEY (codigo),
    FOREIGN KEY (LABORATORISTA_codigo) REFERENCES LABORATORISTA(codigo),
    FOREIGN KEY (PACIENTE_codigo) REFERENCES  PACIENTE(codigo),
    FOREIGN KEY (EXAMEN_codigo) REFERENCES EXAMEN(codigo),
    UNIQUE (codigo)
);
CREATE TABLE IF NOT EXISTS CITA(
    codigo INT AUTO_INCREMENT NOT NULL ,
    fecha DATE NOT NULL ,
    hora VARCHAR(15) NOT NULL ,
    MEDICO_codigo VARCHAR (45) NOT NULL ,
    PACIENTE_codigo INT NOT NULL ,
    especialidad VARCHAR (45),
    PRIMARY KEY (codigo),
    FOREIGN KEY (MEDICO_codigo) REFERENCES MEDICO(codigo),
    FOREIGN KEY (PACIENTE_codigo) REFERENCES PACIENTE(codigo),
    UNIQUE (codigo)
);

CREATE TABLE IF NOT EXISTS REPORTE(
    codigo INT AUTO_INCREMENT  NOT NULL ,
    informe TEXT NOT NULL,
    fecha DATE NOT NULL ,
    hora VARCHAR(15) NOT NULL ,
    MEDICO_codigo VARCHAR (45) NOT NULL ,
    PACIENTE_codigo INT NOT NULL ,
    PRIMARY KEY (codigo),
    FOREIGN KEY (MEDICO_codigo) REFERENCES MEDICO(codigo),
    FOREIGN KEY (PACIENTE_codigo) REFERENCES PACIENTE(codigo),
    UNIQUE (codigo)
);