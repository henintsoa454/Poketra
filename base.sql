create database poketra;
create role poketra LOGIN PASSWORD 'poketra';
alter database poketra OWNER TO poketra;

create table matiere(
    id serial primary key,
    nom varchar(50) not null
);

create table look(
    id serial primary key,
    nom varchar(50) not null
);

create table lookMatiere(
    idMatiere int not null,
    idLook int not null,
    FOREIGN KEY (idMatiere) REFERENCES matiere(id),
    FOREIGN KEY (idLook) REFERENCES look(id)
);