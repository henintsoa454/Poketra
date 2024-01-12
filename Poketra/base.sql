create database poketra;
create role poketra LOGIN PASSWORD 'poketra';
alter database poketra OWNER TO poketra;

drop table stockMatiere;
drop view typeFabricationPoketraFormuleFabrication;
drop table formuleFabrication cascade;
drop table fabricationPoketra cascade;
drop table type cascade;
drop table taille cascade;
drop table lookMatiere cascade;
drop table look cascade;
drop table matiere cascade;

create table matiere(
    id serial primary key,
    nom varchar(50) not null,
    prixUnitaire decimal(18,5) not null
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
    idType integer not null,
    idTaille integer not null,
    FOREIGN KEY (idType) REFERENCES type(id),
    FOREIGN KEY (idTaille) REFERENCES taille(id)
);

create table formuleFabrication(
    idFabricationPoketra integer not null,
    idMatiere integer not null,
    quantite decimal(18,5) not null,
    FOREIGN KEY (idFabricationPoketra) REFERENCES fabricationPoketra(id),
    FOREIGN KEY (idMatiere) REFERENCES matiere(id)
);

CREATE VIEW typeFabricationPoketraFormuleFabrication AS
SELECT t.id AS type_id, t.nom AS type_nom,
       fp.id AS fabrication_id, fp.idType AS fabrication_type_id, fp.idTaille AS fabrication_taille_id,
       ff.idFabricationPoketra AS formule_fabrication_id, ff.idMatiere AS formule_matiere_id, ff.quantite AS formule_quantite,
       t.id AS type_fk, fp.idType AS fabrication_type_fk, fp.id AS fabrication_fk, ff.idFabricationPoketra AS formule_fabrication_fk, ff.idMatiere AS formule_matiere_fk
FROM type t
JOIN fabricationPoketra fp ON t.id = fp.idType
JOIN formuleFabrication ff ON fp.id = ff.idFabricationPoketra;

create table stockMatiere(
    idMatiere integer not null,
    quantite integer not null,
    etat integer not null,
    dateAction integer not null,
    FOREIGN KEY (idMatiere) REFERENCES matiere(id)
);

create table historiqueFabrication(
    id serial primary key,
    idFabricationPoketra integer not null,
    quantite integer not null,
    dateFabrication date not null,
    FOREIGN KEY (idFabricationPoketra) REFERENCES fabricationPoketra(id)
);