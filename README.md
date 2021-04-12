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

##Notas

* el árbol se maneja con el campo "cus_nmcliente" como indice para recorrerlo y hacer operaciones el cual lo trato como si fuera la cédula del cliente.
* en el archivo postman dejo las peticiones codiguradas.

##Prerrequisitos

* tabla tcus_clientes en mysql BD.

###Instalación
Para poder ejecutar la aplicación en el ambiente local se debe tener instalado lo siguiente:

* Java 11 (JDK y JRE).

##Construido con
* Java 8 (Java SE-1.8)
* Spring boot
* Maven
* Lombok
* J-unit
* Datasource mysql

##Autores

**Ricardo Andrés Martínez López** - Desarrollador * ramlopezz93@gmail.com
