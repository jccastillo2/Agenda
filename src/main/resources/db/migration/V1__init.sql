CREATE TABLE Usuario(
    id serial ,
    Nombre VARCHAR(25)  NULL,
    Direccion VARCHAR(25)  NULL,
    Correo VARCHAR(30)  null,
    Contacto Int  null,
    primary key (id)
    );
CREATE TABLE  Horario(
    id serial ,
    Inicio Time  null,
    Fin Time  null,
    Fecha DATE  null,
    primary key (id)

    );
Create TABLE Actividades(
    id serial,
    Detalle VARCHAR (150),
    Tipo VARCHAR (2),
    primary key(id),
    Usuario_id int null,
    foreign KEY (Usuario_id) references Usuario(id),
    Horario_id int null,
    foreign key (Horario_id) references Horario(id)
    );
