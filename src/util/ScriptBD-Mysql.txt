/*CREANDO LA BASE DE DATOS*/
CREATE DATABASE BD_FARMACIA
USE BD_FARMACIA

/*******************************************************************************************************/
/*CREANDO TABLAS Y VALIDANDO*/

CREATE TABLE tb_usuario(
	usuario char(6) primary key,
    pass char(30)
);

/*INSERTAR USUARIO*/
insert into tb_usuario values('admin','12345');
insert into tb_usuario values('val','12345');
insert into tb_usuario values('abel','12345');
insert into tb_usuario values('andree','12345');

select * from tb_usuario;

 /*INSERTAR USUARIO*/
insert into tb_usuario values(1,'luis','luis');
select * from tb_usuario;

CREATE TABLE tb_distrito( 
	codDistrito		int PRIMARY KEY auto_increment,
	descripcion		varchar(80)	NOT NULL);

/*TABLA FARMACIA*/
CREATE TABLE tb_farmacia( 
	CodFarmacia	int	NOT NULL PRIMARY KEY auto_increment,
	RazonSocial	varchar(50)		NOT NULL,
	Direccion	varchar(150)	NOT NULL,
	Telefono	varchar(15)		NOT NULL);

/*TABLA CARGO*/
CREATE TABLE tb_cargo( 
	CodCargo	int	NOT NULL PRIMARY KEY auto_increment,
	Descripcion		varchar(80)	NOT NULL);

/*TABLA EMPLEADO*/
CREATE TABLE tb_empleado( 
	CodEmpleado	int	PRIMARY KEY auto_increment,
	Nombres		varchar(50)		NOT NULL,
	Apellidos	varchar(100)	NOT NULL,
	DNI			integer			NOT NULL,
	Telefono	varchar(15)		NOT NULL,
	Email		varchar(100)	NULL,
	Direccion	varchar(150)	NOT NULL);
select * from tb_empleado;
/*TABLA CLIENTE*/
CREATE TABLE tb_cliente( 
	CodCliente		int		NOT NULL	PRIMARY KEY auto_increment,
	Nombres			varchar(50)		NOT NULL,
	Apellidos		varchar(100)	NOT NULL,
	DNI				integer				NOT NULL,
	Telefono		varchar(15)		NOT NULL,
	Email			varchar(100)	NULL,
	Direccion		varchar(150)	NOT NULL);


/*TABLA DISTRIBUIDORA*/
CREATE TABLE tb_distribuidora( 
	CodDistribuidora	int	NOT NULL	PRIMARY KEY auto_increment,
	RazonSocial			varchar(50)		NOT NULL,
	RUC					varchar(11)		NOT NULL,
	Tipo				varchar(50)		NOT NULL,
	Telefono			varchar(15)		NOT NULL,
	Email				varchar(100)	NULL,
	Direccion			varchar(150)	NOT NULL);
    
    select * from tb_distribuidora;


/*TABLA CONTACTO*/
CREATE TABLE tb_contacto(
	CodDistribuidora	int	NOT NULL	REFERENCES DISTRIBUIDORA,
	CodContacto			char(8)			NOT NULL,
	Nombre				varchar(50)		NOT NULL,
	Cargo				varchar(50)		NOT NULL,
	Telefono			varchar(15)		NOT NULL);


/*TABLA PROVEEDOR*/
CREATE TABLE tb_proveedor( 
	idProveedor int primary key,
	nombre varchar(30),
    dni varchar(8),
    direccion varchar(50),
    telefono varchar(10),
    fechaRegistro date);


CREATE TABLE opcion(
	idopcion int primary key,
    nombre varchar(30),
    estado int,
    tipo int
);

/*TABLA MARCA*/
CREATE TABLE tb_marca( 
	CodMarca	int	NOT NULL	PRIMARY KEY auto_increment,
	Descripcion	varchar(80)	NULL);


/*TABLA CATEGORIA*/
CREATE TABLE tb_categoria( 
	CodCategoria	int NOT NULL	PRIMARY KEY auto_increment,
	Descripcion		varchar(80)	NOT NULL);


/*TABLA MEDICAMENTO */
CREATE TABLE MEDICAMENTO( 
	CodMedicamento			int			NOT NULL	PRIMARY KEY auto_increment,
    Nombre varchar (80),
	Precio					double		NULL,
	FechaVencimiento		date			NULL,
	StockActual				integer			NULL);
select * from medicamento;

/*TABLA BOLETA*/
CREATE TABLE tb_boleta( 
	NroBoleta		int	NOT NULL	PRIMARY KEY auto_increment,
	Fecha			date	NOT NULL,
	SubTotal		double	NULL,
	Total			double	NULL);


/*TABLA DETALLE_BOLETA */
CREATE TABLE tb_detalleBoleta( 
	NroBoleta		int	NOT NULL	REFERENCES BOLETA,
	CodMedicamento	int	NOT NULL	REFERENCES MEDICAMENTO,
	Cantidad		int	NOT NULL,
	Importe			double	NOT NULL,
	PrecioVenta		double	NOT NULL,
	PRIMARY KEY (NroBoleta, CodMedicamento));

/*FALTA INSERTAR REGISTROS*/

/*******************************************************************************************************/


/*INSERTANDO REGISTROS*/

/*INSERTAR REGISTROS A LA TABLA CATEGORIAS --Inserción individual*/
INSERT INTO tb_distrito VALUES ('1001', 'MAGDALENA VIEJA');
INSERT INTO tb_distrito VALUES ('1002', 'RIMAC');
INSERT INTO tb_distrito VALUES ('1003', 'SAN BARTOLO');
INSERT INTO tb_distrito VALUES ('1004', 'SAN BORJA');
INSERT INTO tb_distrito VALUES ('1005', 'VILLA MARIA DEL TRIUNFO');
INSERT INTO tb_distrito VALUES ('1006', 'LIMA');
INSERT INTO tb_distrito VALUES ('1007', 'CHORRILLOS');
INSERT INTO tb_distrito VALUES ('1008', 'COMAS');
INSERT INTO tb_distrito VALUES ('1009', 'LOS OLIVOS');
INSERT INTO tb_distrito VALUES ('1010', 'INDEPENDENCIA');
INSERT INTO tb_distrito VALUES ('1011', 'LA MOLINA');

SELECT * FROM tb_distrito;


/*INSERTAR REGISTROS A LA TABLA FARMACIA --Inserción individual*/
INSERT INTO tb_farmacia VALUES ('20001', 'Inka Salud', 'Av. Los Incas Mz.Q Lte.17', '723-6457');
INSERT INTO tb_farmacia VALUES ('20002', 'Salud Farma', 'Antero Aspillaga 172', '745-2136');
INSERT INTO tb_farmacia VALUES ('20003', 'Farma Vida', 'Conde Castelar 140', '375-9916');

SELECT * FROM tb_farmacia;


/*INSERTAR REGISTROS A LA TABLA CARGO --Inserción individual*/
INSERT INTO tb_cargo VALUES ('10', 'Administrador');
INSERT INTO tb_cargo VALUES ('11', 'Farmaceutico');
INSERT INTO tb_cargo VALUES ('12', 'Cajero');

SELECT * FROM tb_cargo;


/*INSERTAR REGISTROS A LA TABLA EMPLEADO --Inserción individual*/
INSERT INTO tb_empleado VALUES ('100001', 'Franz Alberto', 'Quispe Huerta', 74311335, '950-063-214', 'franzquispe@gmail.com', 'Av. Los Incas 142');
INSERT INTO tb_empleado VALUES ('100002', 'Alejandro Hanz', 'Hidalgo Seguil', 96532148, '986-454-475', 'alejandrodid@gmail.com', 'Av. Guardia Civil 402');
INSERT INTO tb_empleado VALUES ('100003', 'Alexandra Juana', 'Huertas Ramírez', 78546219, '985-637-458', 'alexaj@gmail.com', 'Av. Guardia Peruana 120');
INSERT INTO tb_empleado VALUES ('100004', 'Frank Carlos', 'Ramos Chiclla', 48596321, '978-856-632', 'frankcar@gmail.com', 'Residencial La Cruceta 150');
INSERT INTO tb_empleado VALUES ('100005', 'Juana  Karla', 'Palacios Rivera', 35962147, '912-345-689', 'juanakl@gmail.com', 'Jr. Carlos Aguirre 125');
INSERT INTO tb_empleado VALUES ('100006', 'Flavia Rin', 'Rivera Pituy', 96532875, '958-674-481', 'rinf@gmail.com', 'Puerto Chicama 740');

SELECT * FROM tb_empleado;


/*INSERTAR REGISTROS A LA TABLA CLIENTE --Inserción individual*/
INSERT INTO tb_cliente VALUES ('001', 'Juan Carlos', 'Lariena Vasquez', 75869421, '942-563-875', 'juanLariena@gmail.com', 'Av. Las Gaviotas 120');
INSERT INTO tb_cliente VALUES ('002', 'Alexa Flavia', 'Tuya Apaza', 45621379, '968-547-256', 'alexatuya@gmail.com', 'Jirón Tacna 420');
INSERT INTO tb_cliente VALUES ('003', 'Marcos Ramiro', 'Vidarte Rodriguez', 45869871, '968-536-985', 'marcosvidarte@gmail.com', 'Av. Los Bicus 520');
INSERT INTO tb_cliente VALUES ('004', 'Julia María', 'RodriGuez Palma', 35698748, '978-541-236', 'juliarodriquez@gmail.com', 'Av. Surco 740');
INSERT INTO tb_cliente VALUES ('005', 'María Alejandra', 'Bueno Quispe', 14589678,'985-647-258', 'mariabueno@gmail.com', 'Av. El Sol 450');

SELECT * FROM tb_cliente;


/*INSERTAR REGISTROS A LA TABLA DISTRIBUIDORA --Inserción individual*/
INSERT INTO tb_distribuidora VALUES ('1', 'HERSIL S.A.', '20487579878', 'Laboratorio', '2523438', 'informes@drogueriadicar.com.pe', 'Av. Los Frutales 220');
INSERT INTO tb_distribuidora VALUES ('2', 'BAYER S.A.', '26587815963', 'Laboratorio', '994616327', 'www.distribuidorespyg.com',	'Paseo de la República 3074, Piso 10');
INSERT INTO tb_distribuidora VALUES ('3', 'Química Suiza S.A.', '24982604857', 'Laboratorio', '912957776', 'www.decorepresentaciones.com', 'Republica de Panamá 2577');
INSERT INTO tb_distribuidora VALUES ('4', 'Drogueria Dicar S.A.C', '22984563289', 'Proveedor', '2523438', 'informes@drogueriadicar.com.pe', 'Av. Guardia Peruana 1465, Chorrillos');
INSERT INTO tb_distribuidora VALUES ('5', 'P&G DISTRIBUIDORES SRL', '23698719605', 'Proveedor', '994616327', 'www.distribuidorespyg.com', 'Cl. Añaquito 169 B, Lima');

SELECT * FROM tb_distribuidora;


/*INSERTAR REGISTROS A LA TABLA CONTACTO --Inserción individual*/
INSERT INTO tb_contacto VALUES ('000001', 'DIS01', 'Carlos Zegarra', 'Administrador', '745-6895');
INSERT INTO tb_contacto VALUES ('000002', 'DIS02', 'Ramiro Rodríguez', 'Administrador', '748-2131');
INSERT INTO tb_contacto VALUES ('000003', 'DIS03', 'Sebastián Tasayco', 'Administrador', '586-9745');

SELECT * FROM tb_contacto;


/*INSERTAR REGISTROS A LA TABLA PROVEEDOR --Inserción individual*/
INSERT INTO PROVEEDOR VALUES ('DIS04');
INSERT INTO PROVEEDOR VALUES ('DIS05');
INSERT INTO PROVEEDOR VALUES ('DIS06');

SELECT * FROM PROVEEDOR;


/*INSERTAR REGISTROS A LA TABLA MARCA --Inserción individual*/
INSERT INTO tb_marca VALUES ('101', 'Panadol Alergy');
INSERT INTO tb_marca VALUES ('102', 'Panadol Forte');
INSERT INTO tb_marca VALUES ('103', 'Panadol Antigripal');
INSERT INTO tb_marca VALUES ('104', 'Panadol Infantil');
INSERT INTO tb_marca VALUES ('105', 'Tramadolip');


SELECT * FROM tb_marca;


/*INSERTAR REGISTROS A LA TABLA CATEGORIA --Inserción individual*/
INSERT INTO tb_categoria VALUES ('0001', 'Analgésicos');
INSERT INTO tb_categoria VALUES ('0002', 'Laxantes');
INSERT INTO tb_categoria VALUES ('0003', 'Mucolíticos');
INSERT INTO tb_categoria VALUES ('0004', 'Antibioticos');
INSERT INTO tb_categoria VALUES ('0005', 'Antiinflamatorios');
INSERT INTO tb_categoria VALUES ('0006', 'Antiácidos');

SELECT * FROM tb_categoria;


/*INSERTAR REGISTROS A LA TABLA MEDICAMENTO --Inserción individual*/
INSERT INTO MEDICAMENTO VALUES ('5001', 'Paracetamol (Acetaminofén) 500 mg', 100.00, '2020-12-30', 100);
INSERT INTO MEDICAMENTO VALUES ('5002', 'Paracetamol 100 mg.', 150.00, '2020-12-30', 100);
INSERT INTO MEDICAMENTO VALUES ('5003', 'Acetaminofén 500 mg', 140.00, '2020-12-30', 50);
INSERT INTO MEDICAMENTO VALUES ('5004', 'Paracetamol 160 mg.', 80.00, '2020-12-30', 120);
INSERT INTO MEDICAMENTO VALUES ('5005', 'Tramadol hidrocloruro 100.0 mg', 125.00, '2020-12-30', 30);
INSERT INTO MEDICAMENTO VALUES ('5006', 'Tableta tramadol 50,0 mg', 150.00, '2020-12-30', 200);
INSERT INTO MEDICAMENTO VALUES ('5007', 'Ácido acetilsalicílico 400 mg', 155.00, '2020-12-30', 30);
INSERT INTO MEDICAMENTO VALUES ('5008', 'Acido Tilsalicílico',  150.00, '2020-12-30', 150);
INSERT INTO MEDICAMENTO VALUES ('5009', 'Alprazolam 0.5 mg', 110.00, '2020-12-30', 80);

SELECT * FROM MEDICAMENTO;
