CREATE DATABASE HPVentas;
USE HPVentas;

CREATE TABLE Vendedores (
    id_vendedor INT AUTO_INCREMENT,
    nombre VARCHAR(50),
    ciudad VARCHAR(25),
    ventas DOUBLE,
    PRIMARY KEY (id_vendedor)
);
