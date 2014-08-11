
create table usuario (id_u integer primary key auto_increment,
                    nombre varchar(80),
                    apellido_paterno varchar(80),
                    apellido_materno varchar(80),
                    carrera varchar(25),
                    correo varchar(80) );

create table libros (id_l integer primary key auto_increment, 
                    nombre varchar(80),
                    titulo varchar(80),
                    autor varchar(80),
                    editorial varchar(80));


create table prestamos (id_p integer primary key auto_increment, 
                    id_u integer,
                    id_l integer,
                    dia_prestamo date,
                    dia_entrega date,
                    nombre_libro varchar(50),
                    foreign key(id_u) references usuario(id_u),
                    foreign key(id_l) references libros(id_l));

select * from prestamos;