package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models;

import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.utilities.EncryptUtils;

import java.lang.reflect.Array;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Etudiant extends Model {

	public Etudiant() {
		super();
	}

	public Etudiant(Object Nom, Object Prenom,
			Object Adresse, Object Mail, Object Login, Object Pass,
			Object Date_Validite_Carte, Object Nb_Emprunt) {
		super();
		Object[] Fields = { getNewID(), Nom, Prenom, Adresse, Mail, Login,
				Pass, Date_Validite_Carte, Nb_Emprunt };
		for (int i = 0; i < getFields().length; i++) {
			String Key = getFields()[i];
			Object Value = Fields[i];
			setProp(Key, Value);
		}
	}
	
	public Etudiant(Object Num_Personne, Object Nom, Object Prenom,
			Object Adresse, Object Mail, Object Login, Object Pass,
			Object Date_Validite_Carte, Object Nb_Emprunt) {
		super();
		Object[] Fields = { Num_Personne, Nom, Prenom, Adresse, Mail, Login,
				Pass, Date_Validite_Carte, Nb_Emprunt };
		for (int i = 0; i < getFields().length; i++) {
			String Key = getFields()[i];
			Object Value = Fields[i];
			setProp(Key, Value);
		}
	}

	public Etudiant(ArrayList<Object> Fields) {
		super();
		if (Fields != null) {
			if (Fields.size() == getFields().length) {
				Object[] Fieldss = (Object[]) Array.newInstance(Object.class,
						getFields().length);
				;
				for (int i = 0; i < getFields().length; i++) {
					Fieldss[i] = Fields.get(i);
				}
				for (int i = 0; i < getFields().length; i++) {
					String Key = getFields()[i];
					Object Value = Fieldss[i];
					setProp(Key, Value);
				}
			}
		}
	}

	public Etudiant(Object[] Fields) {
		super();
		if (Fields != null) {
			if (Fields.length == getFields().length) {
				for (int i = 0; i < getFields().length; i++) {
					String Key = getFields()[i];
					Object Value = Fields[i];
					setProp(Key, Value);
				}

			}
		}
	}

	@Override
	public Object getExemplaires() {
		if(Validations.SimplePrimaryKeysValid(this)){
			return new Exemplaire(null, this, null, null).get();
		}else{
		return null;
		}
	}
	
	@Override
	public Object getReservations() {
		if(Validations.SimplePrimaryKeysValid(this)){
			return new Reservation(null, this, null).get();
		}else{
		return null;
		}
	}
	
	@Override
	public int delete() {
		if(new Reservation().setRef_Etudiant(this).get() != null||new Exemplaire().setRef_Etudiant(this).get() != null){
			Model reservations = toOneModel(new Reservation().setRef_Etudiant(this).get());
			Model exemplaires = toOneModel(new Exemplaire().setRef_Etudiant(this).get());
			int x = 0;
			if(reservations != null){
			x = reservations.delete();
			if(x != 1){
				return x;
			}
			}
			if(exemplaires != null){
			x = exemplaires.delete();
			if(x != 1){
				return x;
			}
			}
			return super.delete();
		}else{
			return super.delete();	
		}
	}
	
	@Override
	public boolean isEtudiant() {
		return Validations.is(this, Fields.Models_Etudiant);
	}

	@Override
	public Object[] getMoreOfAdresse() {
		return getMoreOf(Fields.Fields_Adresse);
	}

	@Override
	public Object[] getMoreOfDate_Validite_Carte() {
		return getMoreOf(Fields.Fields_Date_Validite_Carte);
	}

	@Override
	public Object[] getMoreOfMail() {
		return getMoreOf(Fields.Fields_Mail);
	}

	@Override
	public Object[] getMoreOfNom() {
		return getMoreOf(Fields.Fields_Nom);
	}

	@Override
	public Object[] getMoreOfNum_Personne() {
		return getMoreOf(Fields.Fields_Num_Personne);
	}

	@Override
	public Object[] getMoreOfPrenom() {
		return getMoreOf(Fields.Fields_Prenom);
	}

	@Override
	public Object[] getMoreOfLogin() {
		return getMoreOf(Fields.Fields_Login);
	}

	@Override
	public Object[] getMoreOfPass() {
		return getMoreOf(Fields.Fields_Pass);
	}

	@Override
	public Object[] getMoreOfNb_Emprunt() {
		return getMoreOf(Fields.Fields_Nb_Emprunt);
	}

	@Override
	public Model setMoreOfAdresse(Object[] values) {
		setMoreOf(Fields.Fields_Adresse, values);
		return this;
	}

	@Override
	public Model setMoreOfDate_Validite_Carte(Object[] values) {
		setMoreOf(Fields.Fields_Date_Validite_Carte, values);
		return this;
	}

	@Override
	public Model setMoreOfMail(Object[] values) {
		setMoreOf(Fields.Fields_Mail, values);
		return this;
	}

	@Override
	public Model setMoreOfNom(Object[] values) {
		setMoreOf(Fields.Fields_Nom, values);
		return this;
	}

	@Override
	public Model setMoreOfNum_Personne(Object[] values) {
		setMoreOf(Fields.Fields_Num_Personne, values);
		return this;
	}

	@Override
	public Model setMoreOfPrenom(Object[] values) {
		setMoreOf(Fields.Fields_Prenom, values);
		return this;
	}

	@Override
	public Model setMoreOfNb_Emprunt(Object[] values) {
		setMoreOf(Fields.Fields_Nb_Emprunt, values);
		return this;
	}

	@Override
	public Model setMoreOfLogin(Object[] values) {
		setMoreOf(Fields.Fields_Login, values);
		return this;
	}

	@Override
	public Model setMoreOfPass(Object[] values) {
		setMoreOf(Fields.Fields_Pass, values);
		return this;
	}

	@Override
	public String getAdresse() {
		return getString(Fields.Fields_Adresse);
	}

	@Override
	public Date getDate_Validite_Carte() {
		return getDate(Fields.Fields_Date_Validite_Carte);
	}

	@Override
	public String getFormattedDate(Date date) {
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");
			return df.format(date);
		}
		return null;
	}

	@Override
	public String getLogin() {
		return getString(Fields.Fields_Login);
	}

	@Override
	public String getMail() {
		return getString(Fields.Fields_Mail);
	}

	@Override
	public int getNb_Emprunt() {
		return getInteger(Fields.Fields_Nb_Emprunt, false);
	}

	@Override
	public String getNom() {
		return getString(Fields.Fields_Nom);
	}

	@Override
	public int getNum_Personne() {
		return getInteger(Fields.Fields_Num_Personne, true);
	}

	@Override
	public String getPass() {
		return getString(Fields.Fields_Pass);
	}
	
	@Override
	public String getDecryptedPass() {
		if(getPass() != null){
			return EncryptUtils.base64decode(getPass());
		}else{
			return null;
		}
	}

	@Override
	public String getPrenom() {
		return getString(Fields.Fields_Prenom);
	}

	@Override
	public Model setAdresse(Object Adresse) {
		setString(Fields.Fields_Adresse, Adresse);
		return this;
	}

	@Override
	public Model setMail(Object Mail) {
		setString(Fields.Fields_Mail, Mail);
		return this;
	}

	@Override
	public Model setNb_Emprunt(Object Nb_Emprunt) {
		setInteger(Fields.Fields_Nb_Emprunt, Nb_Emprunt, false);
		return this;
	}

	@Override
	public Model setPass(Object Pass) {
		setString(Fields.Fields_Pass, Pass);
		return this;
	}
	
	@Override
	public String EncryptPass(Object Pass) {
		String pass = null;
		if(Pass != null){
			if(Pass.getClass().getName().equals(Fields.Types_String)){
				if(!Pass.equals("")){
					pass = EncryptUtils.base64encode((String)Pass);
				}
			}
		}
		return pass;
	}
	
	@Override
	public String DecryptPass(Object Pass) {
		String pass = null;
		if(Pass != null){
			if(Pass.getClass().getName().equals(Fields.Types_String)){
				if(!Pass.equals("")){
					pass = EncryptUtils.base64decode((String)Pass);
				}
			}
		}
		return pass;
	}

	@Override
	public Model setDate_Validite_Carte(Object Date_Validite_Carte) {
		setDate(Fields.Fields_Date_Validite_Carte, Date_Validite_Carte);
		return this;
	}

	@Override
	public Model setLogin(Object Login) {
		setString(Fields.Fields_Login, Login);
		return this;
	}

	@Override
	public Model setNom(Object Nom) {
		setString(Fields.Fields_Nom, Nom);
		return this;
	}

	@Override
	public Model setNum_Personne(Object Num_Personne) {
		setInteger(Fields.Fields_Num_Personne, Num_Personne, true);
		return this;
	}

	@Override
	public Model setPrenom(Object Prenom) {
		setString(Fields.Fields_Prenom, Prenom);
		return this;
	}
	@Override
	public String toString() {
		return getNom()+" "+getPrenom();
	}
}
