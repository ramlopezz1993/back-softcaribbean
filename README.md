#Prueba de Softcaribbean back.

Prueba que consiste en insertar, modificar y consultar sobre un arbol binario y a su vez reflejar los cambios en base de datos, persisiendo una tabla de cliente. 

##Empezando
Crear tabla de base de datos mysql.

create table tcus_clientes
(
 nmid                bigint auto_increment
 primary key,
 cus_nmcliente       int                                     not null,
 cus_dsnombres       varchar(120)                            not null,
 cus_dsapellidos     varchar(120)                            not null,
 cus_dsdireccion     varchar(120)                            not null,
 cus_dscorreo        varchar(120)                            not null,
 cus_cdtelefono      varchar(20)                             not null,
 cus_cdtelefonoalter varchar(20)                             null,
 cus_cdcelular       varchar(20)                             null,
 cus_nmcargo         int                                     not null,
 cus_dscargo         varchar(120)                            not null,
 cus_nmciudad        int                                     not null,
 cus_dsciudad        varchar(60)                             not null,
 cus_fenacimiento    date                                    not null,
 cus_genero          varchar(1)                              not null,
 cus_nmcomunidad     int                                     not null,
 cus_dscomunidad     varchar(120)                            not null,
 cus_dsempresalabora varchar(200)                            not null,
 cus_nmdivision      int                                     not null,
 cus_dsdivision      varchar(120)                            not null,
 cus_nmpais          int                                     not null,
 cus_dspais          varchar(120)                            not null,
 cus_hobbies         text                                    not null,
 cus_feregistro      timestamp default '0000-00-00 00:00:00' not null,
 cus_febaja          timestamp default '0000-00-00 00:00:00' not null,
 constraint tcus_clientes_cus_nmcliente_uindex
 unique (cus_nmcliente)
);

* Insertar usuario para realizar las pruebas automatizadas.
INSERT INTO db_softcaribbean.tcus_clientes (nmid, cus_nmcliente, cus_dsnombres, cus_dsapellidos, cus_dsdireccion, cus_dscorreo, cus_cdtelefono, cus_cdtelefonoalter, cus_cdcelular, cus_nmcargo, cus_dscargo, cus_nmciudad, cus_dsciudad, cus_fenacimiento, cus_genero, cus_nmcomunidad, cus_dscomunidad, cus_dsempresalabora, cus_nmdivision, cus_dsdivision, cus_nmpais, cus_dspais, cus_hobbies, cus_feregistro, cus_febaja) VALUES (11, 37, 'Alfonso', 'Echeverry Maldonado', 'Calle nueva', 'correoNuevo@mail.com', '0000000', '1111111', '2222222222', 105, 'Ingenieria', 7, 'Pereira', '2021-04-13', 'M', 10, 'Pereirano', 'Confenalco', 24, 'Deportista', 7, 'Canada', 'Cocinar', '2021-04-13 03:49:31', '2021-04-13 03:49:31');

##Notas

* el árbol se maneja con el campo "cus_nmcliente" como indice para recorrerlo y hacer operaciones el cual lo trato como si fuera la cédula del cliente.

##Prerrequisitos

* tabla tcus_clientes en mysql BD.

###Instalación
Para poder ejecutar la aplicación en el ambiente local se debe tener instalado lo siguiente:

* Java 11 (JDK y JRE).

##Construido con
* Java 11 Lts
* Spring boot
* Maven
* Lombok
* J-unit
* Datasource mysql

##Autores

**Ricardo Andrés Martínez López** - Desarrollador * ramlopezz93@gmail.com
