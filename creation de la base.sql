CREATE TYPE T_Livre as object(ISBN varchar (20),Titre varchar(30),Date_Publication date,Editeur varchar(30),Lots_Cles varchar(30),Nb_Exemplaires number,Image ORDSYS.ORDImage,Signature ORDSYS.ORDImageSignature);
/
CREATE TYPE T_Personne as object(Num_Personne number,Nom varchar (20),Prenom varchar(30),Adresse varchar(30),Mail varchar(25)) NOT FINAL;
/
CREATE TYPE T_Auteur under T_Personne(Image ORDSYS.ORDImage,Signature ORDSYS.ORDImageSignature,Video ORDSYS.ORDVideo);
/
CREATE TYPE T_Etudiant under T_Personne(Login varchar (20),Pass varchar (30),Date_Validite_Carte Date,Nb_Emprunt number);
/
CREATE TYPE T_Est_Ecrit as object(Ref_Livre REF T_Livre,Ref_Auteur REF T_Auteur);
/
CREATE TYPE T_Exemplaire as object(Ref_Livre REF T_Livre,Ref_Etudiant REF T_Etudiant,Date_Sortie Date,Date_Retour Date);
/
CREATE TYPE T_Reservation as object(Ref_Livre REF T_Livre,Ref_Etudiant REF T_Etudiant,Date_Reservation Date);
/
Create table Livre of T_Livre(primary key(ISBN));
/
Create table Auteur of T_Auteur(primary key(Num_Personne));
/
Create table Etudiant of T_Etudiant(primary key(Num_Personne));
/
Create table Est_Ecrit of T_Est_ecrit(
	CONSTRAINT Est_Ecrit_Ref_Livre Ref_Livre REFERENCES Livre,
	CONSTRAINT Est_Ecrit_Ref_Livre_null CHECK ( Ref_Livre IS NOT NULL),
	CONSTRAINT Est_Ecrit_Ref_Auteur Ref_Auteur REFERENCES Auteur,
	CONSTRAINT Est_Ecrit_Ref_Auteur_null CHECK(Ref_Auteur IS NOT NULL)
);
/
Create table Exemplaire of T_Exemplaire(
	CONSTRAINT Exemplaire_Ref_Livre Ref_Livre REFERENCES Livre,
	CONSTRAINT Exemplaire_Ref_Livre_null CHECK ( Ref_Livre IS NOT NULL),
	CONSTRAINT Exemplaire_Ref_Etudiant Ref_Etudiant REFERENCES Etudiant,
	CONSTRAINT Exemplaire_Ref_Etudiant_null CHECK(Ref_Etudiant IS NOT NULL)
);
/
Create table Reservation of T_Reservation(
	CONSTRAINT Reservation_Ref_Livre Ref_Livre REFERENCES Livre,
	CONSTRAINT Reservation_Ref_Livre_null CHECK ( Ref_Livre IS NOT NULL),
	CONSTRAINT Reservation_Ref_Etudiant Ref_Etudiant REFERENCES Etudiant,
	CONSTRAINT Reservation_Ref_Etudiant_null CHECK(Ref_Etudiant IS NOT NULL)
);
/