DROP DATABASE IF EXISTS empresa;
CREATE DATABASE empresa;
USE empresa;

CREATE TABLE departamentos (
  id integer,
  dnombre varchar(15) DEFAULT NULL,
  localidad varchar(15) DEFAULT NULL,
  CONSTRAINT PK_DPTOS PRIMARY KEY (ID) 
);


CREATE TABLE empleados (
  id integer ,
  nombre varchar(50) DEFAULT NULL,
  oficio varchar(10) DEFAULT NULL,
  fecha_alt date DEFAULT NULL,
  salario float(6,2) DEFAULT NULL,
  comision float(6,2) DEFAULT NULL,
  departamento integer NOT NULL,
  CONSTRAINT PK_EMPLEADOS PRIMARY KEY (ID),
  CONSTRAINT FK_EMPLEADOS  FOREIGN KEY (departamento) REFERENCES departamentos(id)
  
);


INSERT INTO departamentos (id, dnombre, localidad) VALUES
(10, 'CONTABILIDAD', 'SEVILLA'),
(20, 'INVESTIGACIÓN', 'MADRID'),
(30, 'VENTAS', 'BARCELONA'),
(40, 'PRODUCCIÓN', 'BILBAO');






