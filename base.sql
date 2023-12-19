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

create table taille(
    id serial primary key,
    nom varchar(50) not null
);

create table type(
    id serial primary key,
    nom varchar(50) not null
);

create table fabricationPoketra(
    id serial primary key,
    idType int not null,
    idTaille int not null,
    FOREIGN KEY(idType) REFERENCES type(id),
    FOREIGN KEY(idTaille) REFERENCES type(id),
);

create table quantiteMatiereFabrication(
    idFabricationPoketra serial primary key,
    idMatiere int not null,
    quantite int not null,
    FOREIGN KEY(idMatiere) REFERENCES matiere(id)
);