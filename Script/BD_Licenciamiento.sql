CREATE DATABASE LICENCIAMIENTO;

use LICENCIAMIENTO
--Tabla PLANTA
CREATE TABLE planta(
	id_planta int NOT NULL,
	planta varchar(250),
	CONSTRAINT plantaPK PRIMARY KEY(id_planta));

--Tabla EQUIPO DE COMPUTO
CREATE TABLE eq_computo(
	nombre_equipo varchar (250) NOT NULL,
	modelo varchar(250),
	id_planta  int,
	CONSTRAINT nombrePK PRIMARY KEY  (nombre_equipo),
	CONSTRAINT EqComp_Planta FOREIGN KEY (id_planta) references planta(id_planta));

--Tabla TIPO DE ADQUISICION
create table tipo_adquisicion(
	id_tipoAdquisicion int identity NOT NULL,
	tipoAdquisicion varchar(250),
	descripcion varchar(650)
	CONSTRAINT tipoAdquiPK PRIMARY KEY(id_tipoAdquisicion));

--Tabla TIPO DE LICENCIA
create table tipo_licencia(
	id_tipoLicencia int identity NOT NULL,
	tipoLicencia varchar(250),
	descripcion varchar(650),
	CONSTRAINT tipoLicenciaPK PRIMARY KEY(id_tipoLicencia));

--Tabla PROVEEDORES
create table proveedor(
	id_proveedor int identity NOT NULL,
	nombre_proveedor varchar(250),
	domicilio varchar(250),
	e_mail varchar(250),
	telefono varchar(250),
	fax varchar(250),
	contacto varchar(250),
	comentarios varchar(650)
	CONSTRAINT proveedorPK PRIMARY KEY(id_proveedor));

--Tabla SOFTWARE
create table software(
	id_software int identity NOT NULL,
	ticket varchar(250),
	fechaAdquisicion date,
	nom_software varchar(250),
	fecha_Inicio date,
	fecha_fin date, 
	notificacion_vencimiento date,
	unidades int,
	precio_unidad money,
	impuesto money,
	descuento money,
	total money,
	referencia_ubicacion varchar(650),
	descripcion varchar(650),
	id_tipoAdquisicion int,
	id_tipoLicencia int,
	id_proveedor int,
	CONSTRAINT softwarePK PRIMARY KEY(id_software),
	CONSTRAINT software_AdquisicionFK FOREIGN KEY(id_tipoAdquisicion) references tipo_adquisicion(id_tipoAdquisicion),
	CONSTRAINT software_TipoLicenciaFK FOREIGN KEY(id_tipoLicencia) references tipo_Licencia(id_tipoLicencia),
	CONSTRAINT software_ProveedorFK FOREIGN KEY(id_proveedor) references proveedor(id_proveedor));

	--CHECAR ESTO!!!
--TABLA DE ASIGNACIONES
CREATE TABLE asignacion_software(
	nombre_equipo varchar(250),
	id_software int,
	CONSTRAINT asignacion_softwarePK PRIMARY KEY(nombre_equipo, id_software),
	CONSTRAINT asignacion_equipoFK FOREIGN KEY (nombre_equipo) REFERENCES eq_computo(nombre_equipo),
	CONSTRAINT asignacion_softwareFK FOREIGN KEY (id_software) REFERENCES software(id_software));


---TABLAS PARA EL LOGIN
--TABLA USUARIO
CREATE TABLE users(
	id_user int NOT NULL,
	e_mail varchar(250),
	username varchar(250),
	usepassword varchar(250),
	CONSTRAINT userPK PRIMARY KEY(id_user));

--TABLA ROLES
CREATE TABLE rol(
	id_rol int NOT NULL, 
	rol varchar(250),
	CONSTRAINT rolPK PRIMARY KEY(id_rol));

CREATE TABLE user_rol(
	id_user int NOT NULL,
	id_rol int,
	CONSTRAINT user_rolPK PRIMARY KEY(id_user, id_rol),
	CONSTRAINT user_usersFK FOREIGN KEY(id_user) references users(id_user),
	CONSTRAINT user_rolFK FOREIGN KEY(id_rol) references rol(id_rol));















