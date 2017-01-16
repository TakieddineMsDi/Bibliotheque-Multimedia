package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models;

import java.lang.reflect.Array;
import java.util.ArrayList;

import oracle.ord.im.OrdImage;
import oracle.ord.im.OrdImageSignature;
import oracle.ord.im.OrdVideo;

public class Auteur extends Model {

	public Auteur() {
		super();
	}
	
	public Auteur(Object Num_Personne,Object Nom, Object Prenom,
			Object Adresse, Object Mail) {
		Object[] Fields = { Num_Personne, Nom, Prenom, Adresse, Mail, null,
				null, null };
		for (int i = 0; i < getFields().length; i++) {
			String Key = getFields()[i];
			Object Value = Fields[i];
			setProp(Key, Value);
		}
	}
	
	public Auteur(Object Nom, Object Prenom,
			Object Adresse, Object Mail) {
		Object[] Fields = { getNewID(), Nom, Prenom, Adresse, Mail, null,
				null, null };
		for (int i = 0; i < getFields().length; i++) {
			String Key = getFields()[i];
			Object Value = Fields[i];
			setProp(Key, Value);
		}
	}
	
	public Auteur(Object Nom, Object Prenom,
			Object Adresse, Object Mail, Object Image, Object Signature,
			Object Video) {
		Object[] Fields = { getNewID(), Nom, Prenom, Adresse, Mail, Image,
				Signature, Video };
		for (int i = 0; i < getFields().length; i++) {
			String Key = getFields()[i];
			Object Value = Fields[i];
			setProp(Key, Value);
		}
	}

	public Auteur(Object Num_Personne, Object Nom, Object Prenom,
			Object Adresse, Object Mail, Object Image, Object Signature,
			Object Video) {
		Object[] Fields = { Num_Personne, Nom, Prenom, Adresse, Mail, Image,
				Signature, Video };
		for (int i = 0; i < getFields().length; i++) {
			String Key = getFields()[i];
			Object Value = Fields[i];
			setProp(Key, Value);
		}
	}

	public Auteur(ArrayList<Object> Fields) {
		if (Fields != null) {
			if (Fields.size() == getFields().length) {
				Object[] Fieldss = (Object[]) Array.newInstance(Object.class,
						getFields().length);
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

	public Auteur(Object[] Fields) {
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
	public Object getLivres() {
		if(Validations.SimplePrimaryKeysValid(this)){
			return new Est_Ecrit(null, this).get();
		}
		return null;
	}

	@Override
	public boolean isAuteur() {
		return Validations.is(this, Fields.Models_Auteur);
	}
	
	@Override
	public int delete() {
		if(new Est_Ecrit().setRef_Auteur(this).get() != null){
			Model estecrit = toOneModel(new Est_Ecrit().setRef_Auteur(this).get());
			int x = estecrit.delete();
			if(x != 1){
				return x;
			}
			return super.delete();
		}else{
			return super.delete();	
		}
	}

	@Override
	public String getURLImage() {
		return getString("URLImage");
	}

	@Override
	public Model setURLImage(Object URL) {
		setString("URLImage", URL);
		return this;
	}

	@Override
	public String getURLVideo() {
		return getString("URLVideo");
	}

	@Override
	public Model setURLVideo(Object URL) {
		setString("URLVideo", URL);
		return this;
	}

	@Override
	public Object[] getMoreOfAdresse() {
		return getMoreOf(Fields.Fields_Adresse);
	}

	@Override
	public Object[] getMoreOfImage() {
		return getMoreOf(Fields.Fields_Image);
	}

	@Override
	public Object[] getMoreOfSignature() {
		return getMoreOf(Fields.Fields_Signature);
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
	public Object[] getMoreOfVideo() {
		return getMoreOf(Fields.Fields_Video);
	}

	@Override
	public Model setMoreOfAdresse(Object[] values) {
		setMoreOf(Fields.Fields_Adresse, values);
		return this;
	}

	@Override
	public Model setMoreOfImage(Object[] values) {
		setMoreOf(Fields.Fields_Image, values);
		return this;
	}

	@Override
	public Model setMoreOfSignature(Object[] values) {
		setMoreOf(Fields.Fields_Signature, values);
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
	public Model setMoreOfVideo(Object[] values) {
		setMoreOf(Fields.Fields_Video, values);
		return this;
	}

	@Override
	public String getAdresse() {
		return getString(Fields.Fields_Adresse);
	}

	@Override
	public OrdImage getImage() {
		return getOrdImage(Fields.Fields_Image);
	}

	@Override
	public OrdImageSignature getSignature() {
		return getOrdImageSignature(Fields.Fields_Signature);
	}

	@Override
	public String getMail() {
		return getString(Fields.Fields_Mail);
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
	public String getPrenom() {
		return getString(Fields.Fields_Prenom);
	}

	@Override
	public OrdVideo getVideo() {
		return getOrdVideo(Fields.Fields_Video);
	}

	@Override
	public Model setAdresse(Object Adresse) {
		setString(Fields.Fields_Adresse, Adresse);
		return this;
	}

	@Override
	public Model setImage(Object Image) {
		setOrdImage(Fields.Fields_Image, Image);
		return this;
	}

	@Override
	public Model setSignature(Object Signature) {
		setOrdImageSignature(Fields.Fields_Signature, Signature);
		return this;
	}

	@Override
	public Model setMail(Object Mail) {
		setString(Fields.Fields_Mail, Mail);
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
	public Model setVideo(Object Video) {
		setOrdVideo(Fields.Fields_Video, Video);
		return this;
	}
	@Override
	public String toString() {
		return getNom()+" "+getPrenom();
	}
}
