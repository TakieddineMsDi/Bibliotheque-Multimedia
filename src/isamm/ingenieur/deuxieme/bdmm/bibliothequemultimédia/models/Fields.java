package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models;

import java.sql.Date;

import oracle.ord.im.OrdImage;
import oracle.ord.im.OrdImageSignature;
import oracle.ord.im.OrdVideo;

public class Fields {

	public static String JTable_Action = "Action";
	
	public static String DefaultMail = "ADMail@ADMail.DEF";
	public static String DefaultISBN = "ADefaultISBN12345";
	public static int DefaultNBExemplaire = 0;
	// Models
	public static String Models_Auteur = "AUTEUR";
	public static String Models_Est_Ecrit = "EST_ECRIT";
	public static String Models_Etudiant = "ETUDIANT";
	public static String Models_Exemplaire = "EXEMPLAIRE";
	public static String Models_Livre = "LIVRE";
	public static String Models_Reservation = "RESERVATION";

	// All
	public static String[] Models = { 
									Models_Auteur
									,Models_Est_Ecrit
									,Models_Etudiant
									,Models_Exemplaire
									,Models_Livre
									,Models_Reservation 
									};
	// All
	// Models

	// Types
	public static String Types_Integer = Integer.class.getName();
	public static String Types_String = "".getClass().getName();
	public static String Types_Date = Date.class.getName();
	public static String Types_OrdImage = OrdImage.class.getName();
	public static String Types_OrdImageSignature = OrdImageSignature.class.getName();
	public static String Types_OrdVideo = OrdVideo.class.getName();
	public static String Types_Auteur = Auteur.class.getName();
	public static String Types_Est_Ecrit = Est_Ecrit.class.getName();
	public static String Types_Etudiant = Etudiant.class.getName();
	public static String Types_Exemplaire = Exemplaire.class.getName();
	public static String Types_Livre = Livre.class.getName();
	public static String Types_Reservation = Reservation.class.getName();

	// All
	public static String[] Types = { 
		                           Types_Integer
		                           ,Types_String
		                           ,Types_Date
		                           ,Types_OrdImage
		                           ,Types_OrdImageSignature
		                           ,Types_OrdVideo
		                           ,Types_Auteur
		                           ,Types_Est_Ecrit
		                           ,Types_Etudiant
		                           ,Types_Exemplaire
		                           ,Types_Livre
		                           ,Types_Reservation
		                           };
	// All
	// Types

	// Fields
	// Auteur And Livre Fields
	public static String Fields_Image = "IMAGE";// ORDImage
	public static String Fields_Signature = "SIGNATURE";// ORDImageSignature
	// Auteur And Livre Fields

	// Est_Ecrit and Exemplaire and Reservation Fields
	public static String Fields_Ref_Livre = "REF_LIVRE";// Livre Primary Key
	// Est_Ecrit and Exemplaire and Reservation Fields

	// Exemplaire And Reservation Fields
	public static String Fields_Ref_Etudiant = "REF_ETUDIANT";// Etudiant Primary Key
	// Exemplaire And Reservation Fields

	// Etudiant And Auteur Fields
	public static String Fields_Num_Personne = "NUM_PERSONNE";// int Primary Key
	public static String Fields_Nom = "NOM";// String
	public static String Fields_Prenom = "PRENOM";// String
	public static String Fields_Adresse = "ADRESSE";// String
	public static String Fields_Mail = "MAIL";// String Unique
	// Etudiant And Auteur Fields

	// Auteur Fields
	public static String Fields_Video = "VIDEO";// ORDVideo
	// Auteur Fields

	// Est_Ecrit Fields
	public static String Fields_Ref_Auteur = "REF_AUTEUR";// Auteur Primary Key
	// Est_Ecrit Fields

	// Etudiant Fields
	public static String Fields_Login = "LOGIN";// String unique
	public static String Fields_Pass = "PASS";// String
	public static String Fields_Date_Validite_Carte = "DATE_VALIDITE_CARTE";// Date
	public static String Fields_Nb_Emprunt = "NB_EMPRUNT";// int
	// Etudiant Fields

	// Exemplaire Fields
	public static String Fields_Date_Sortie = "DATE_SORTIE";// Date
	public static String Fields_Date_Retour = "DATE_RETOUR";// Date
	// Exemplaire Fields

	// Livre Fields
	public static String Fields_ISBN = "ISBN";// String Primary Key
	public static String Fields_Titre = "TITRE";// String
	public static String Fields_Date_Publication = "DATE_PUBLICATION";// Date
	public static String Fields_Editeur = "EDITEUR";// String
	public static String Fields_Lots_Cles = "LOTS_CLES";// String
	public static String Fields_Nb_Exemplaires = "NB_EXEMPLAIRES";// int
	// Livre Fields

	// Reservation Fields
	public static String Fields_Date_Reservation = "DATE_RESERVATION";// Date
	// Reservation Fields

	// All
	// Auteur
	public static String[] Auteur_Fields = {
		                                   Fields_Num_Personne
		                                   ,Fields_Nom
		                                   ,Fields_Prenom
		                                   ,Fields_Adresse
		                                   ,Fields_Mail
		                                   ,Fields_Image
		                                   ,Fields_Signature
		                                   ,Fields_Video
		                                   };

	public static String[] Auteur_Types = {
		                                  Types_Integer
		                                  ,Types_String
		                                  ,Types_String
		                                  ,Types_String
		                                  ,Types_String
		                                  ,Types_OrdImage
		                                  ,Types_OrdImageSignature
		                                  ,Types_OrdVideo
		                                  };
	public static String[] Auteur_Auto_Increment = {
		                                    Auteur_Fields[0]
									        };
	public static String[] Auteur_PrimaryKeys = {
		                                        Auteur_Fields[0]
		                                        };

	public static String[] Auteur_Unique = {
		                                   Auteur_Fields[4]
			                               };
	// Auteur

	// Est_Ecrit
	public static String[] Est_Ecrit_Fields = {
		                                      Fields_Ref_Livre
		                                      ,Fields_Ref_Auteur
		                                      };

	public static String[] Est_Ecrit_Types = {
		                                     Types_Livre
		                                     ,Types_Auteur};

	public static String[] Est_Ecrit_PrimaryKeys = {
		                                           Est_Ecrit_Fields[0]
		                                           ,Est_Ecrit_Fields[1]
		                                           };
	// Est_Ecrit

	// Etudiant
	public static String[] Etudiant_Fields = {
		                                     Fields_Num_Personne
		                                     ,Fields_Nom
		                                     ,Fields_Prenom
		                                     ,Fields_Adresse
		                                     ,Fields_Mail
		                                     ,Fields_Login
		                                     ,Fields_Pass
		                                     ,Fields_Date_Validite_Carte
		                                     ,Fields_Nb_Emprunt
		                                     };
	public static String[] Etudiant_Auto_Increment = {
												     Etudiant_Fields[0]
												     };
	public static String[] Etudiant_Types = {
		                                    Types_Integer
		                                    ,Types_String
		                                    ,Types_String
		                                    ,Types_String
		                                    ,Types_String
		                                    ,Types_String
		                                    ,Types_String
		                                    ,Types_Date
		                                    ,Types_Integer
		                                    };

	public static String[] Etudiant_PrimaryKeys = {
		                                          Etudiant_Fields[0]
		                                          };

	public static String[] Etudiant_Unique = {
		                                     Etudiant_Fields[4]
		                                     ,Etudiant_Fields[5]
		                                     };

	public static String[] Etudiant_Nullable = {
		                                       Etudiant_Fields[8]
			                                   };
	// Etudiant

	// Exemplaire
	public static String[] Exemplaire_Fields = {
		                                       Fields_Ref_Livre
		                                       ,Fields_Ref_Etudiant
		                                       ,Fields_Date_Sortie
		                                       ,Fields_Date_Retour
		                                       };

	public static String[] Exemplaire_Types = {
		                                      Types_Livre
		                                      ,Types_Etudiant
		                                      ,Types_Date
		                                      ,Types_Date
		                                      };

	public static String[] Exemplaire_PrimaryKeys = {
		                                            Exemplaire_Fields[0]
			                                        ,Exemplaire_Fields[1]
			                                        };
	// Exemplaire

	// Livre
	public static String[] Livre_Fields = {
		                                  Fields_ISBN
		                                  ,Fields_Titre
		                                  ,Fields_Date_Publication
		                                  ,Fields_Editeur
		                                  ,Fields_Lots_Cles
		                                  ,Fields_Nb_Exemplaires
		                                  ,Fields_Image
		                                  ,Fields_Signature
		                                  };

	public static String[] Livre_Types = {
		                                 Types_String
		                                 ,Types_String
		                                 ,Types_Date
		                                 ,Types_String
		                                 ,Types_String
		                                 ,Types_Integer
		                                 ,Types_OrdImage
		                                 ,Types_OrdImageSignature
		                                 };

	public static String[] Livre_PrimaryKeys = {
		                                       Livre_Fields[0]
		                                       };

	public static String[] Livre_Nullable = {
		                                    Livre_Fields[5]
		                                    };

	// Livre

	// Reservation
	public static String[] Reservation_Fields = {
		                                        Fields_Ref_Livre
		                                        ,Fields_Ref_Etudiant
		                                        ,Fields_Date_Reservation
		                                        };

	public static String[] Reservation_Types = {
		                                       Types_Livre
		                                       ,Types_Etudiant
		                                       ,Types_Date
		                                       };

	public static String[] Reservation_PrimaryKeys = {
		                                             Reservation_Fields[0]
		                                             ,Reservation_Fields[1]
		                                             };
	// Reservation
	// All
	// Fields
}
