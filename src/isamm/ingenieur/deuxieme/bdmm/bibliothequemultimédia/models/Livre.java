package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models;

import java.lang.reflect.Array;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import oracle.ord.im.OrdImage;
import oracle.ord.im.OrdImageSignature;

public class Livre extends Model {

	public Livre() {
		super();
	}
	
	public Livre(Object ISBN, Object Titre, Object Date_Publication,
			Object Editeur, Object Lots_Cles, Object Nb_Exemplaires) {
		super();
		Object[] Fields = { ISBN, Titre, Date_Publication, Editeur, Lots_Cles,
				Nb_Exemplaires, null, null };
		for (int i = 0; i < getFields().length; i++) {
			String Key = getFields()[i];
			Object Value = Fields[i];
			setProp(Key, Value);
		}
	}

	public Livre(Object ISBN, Object Titre, Object Date_Publication,
			Object Editeur, Object Lots_Cles, Object Nb_Exemplaires,
			Object Image, Object Signature) {
		super();
		Object[] Fields = { ISBN, Titre, Date_Publication, Editeur, Lots_Cles,
				Nb_Exemplaires, Image, Signature };
		for (int i = 0; i < getFields().length; i++) {
			String Key = getFields()[i];
			Object Value = Fields[i];
			setProp(Key, Value);
		}
	}

	public Livre(ArrayList<Object> Fields) {
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

	public Livre(Object[] Fields) {
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
	public Object getAuteurs() {
		if(Validations.SimplePrimaryKeysValid(this)){
			return new Est_Ecrit(this, null).get();
		}else{
		return null;
		}
	}
	
	@Override
	public Object getExemplaires() {
		if(Validations.SimplePrimaryKeysValid(this)){
			return new Exemplaire(this, null, null, null).get();
		}else{
			return null;
		}
	}
	
	@Override
	public Object getReservations() {
		if(Validations.SimplePrimaryKeysValid(this)){
			return new Reservation(this, null, null).get();
		}else{
			return null;
		}
	}
	
	@Override
	public int delete() {
		if(new Reservation().setRef_Livre(this).get() != null||new Exemplaire().setRef_Livre(this).get() != null||new Est_Ecrit().setRef_Livre(this).get() != null){
			Model reservations = toOneModel(new Reservation().setRef_Etudiant(this).get());
			Model exemplaires = toOneModel(new Exemplaire().setRef_Etudiant(this).get());
			Model estecrit = toOneModel(new Est_Ecrit().setRef_Etudiant(this).get());
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
			if(estecrit != null){
			x = estecrit.delete();
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
	public boolean isLivre() {
		return Validations.is(this, Fields.Models_Livre);
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
	public String getFormattedDate(Date date) {
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");
			return df.format(date);
		}
		return null;
	}

	@Override
	public Date getDate_Publication() {
		return getDate(Fields.Fields_Date_Publication);
	}

	@Override
	public Object[] getMoreOfDate_Publication() {
		return getMoreOf(Fields.Fields_Date_Publication);
	}

	@Override
	public String getEditeur() {
		return getString(Fields.Fields_Editeur);
	}

	@Override
	public Object[] getMoreOfEditeur() {
		return getMoreOf(Fields.Fields_Editeur);
	}

	@Override
	public OrdImage getImage() {
		return getOrdImage(Fields.Fields_Image);
	}

	@Override
	public Object[] getMoreOfImage() {
		return getMoreOf(Fields.Fields_Image);
	}

	@Override
	public OrdImageSignature getSignature() {
		return getOrdImageSignature(Fields.Fields_Signature);
	}

	@Override
	public Object[] getMoreOfSignature() {
		return getMoreOf(Fields.Fields_Signature);
	}

	@Override
	public String getISBN() {
		return getString(Fields.Fields_ISBN);
	}

	@Override
	public Object[] getMoreOfISBN() {
		return getMoreOf(Fields.Fields_ISBN);
	}

	@Override
	public String getLots_Cles() {
		return getString(Fields.Fields_Lots_Cles);
	}

	@Override
	public Object[] getMoreOfLots_Cles() {
		return getMoreOf(Fields.Fields_Lots_Cles);
	}

	@Override
	public int getNb_Exemplaires() {
		return getInteger(Fields.Fields_Nb_Exemplaires, false);
	}

	@Override
	public Object[] getMoreOfNb_Exemplaire() {
		return getMoreOf(Fields.Fields_Nb_Exemplaires);
	}

	@Override
	public String getTitre() {
		return getString(Fields.Fields_Titre);
	}

	@Override
	public Object[] getMoreOfTitre() {
		return getMoreOf(Fields.Fields_Titre);
	}

	@Override
	public Model setDate_Publication(Object Date_Publication) {
		setDate(Fields.Fields_Date_Publication, Date_Publication);
		return this;
	}

	@Override
	public Model setMoreOfDate_Publication(Object[] values) {
		setMoreOf(Fields.Fields_Date_Publication, values);
		return this;
	}

	@Override
	public Model setEditeur(Object Editeur) {
		setString(Fields.Fields_Editeur, Editeur);
		return this;
	}

	@Override
	public Model setMoreOfEditeur(Object[] values) {
		setMoreOf(Fields.Fields_Editeur, values);
		return this;
	}

	@Override
	public Model setImage(Object Image) {
		setOrdImage(Fields.Fields_Image, Image);
		return this;
	}

	@Override
	public Model setMoreOfImage(Object[] values) {
		setMoreOf(Fields.Fields_Image, values);
		return this;
	}

	@Override
	public Model setSignature(Object Signature) {
		setOrdImageSignature(Fields.Fields_Signature, Signature);
		return this;
	}

	@Override
	public Model setMoreOfSignature(Object[] values) {
		setMoreOf(Fields.Fields_Signature, values);
		return this;
	}

	@Override
	public Model setISBN(Object ISBN) {
		setString(Fields.Fields_ISBN, ISBN);
		return this;
	}

	@Override
	public Model setMoreOfISBN(Object[] values) {
		setMoreOf(Fields.Fields_ISBN, values);
		return this;
	}

	@Override
	public Model setLots_Cles(Object Lots_Cles) {
		setString(Fields.Fields_Lots_Cles, Lots_Cles);
		return this;
	}

	@Override
	public Model setMoreOfLots_Cles(Object[] values) {
		setMoreOf(Fields.Fields_Lots_Cles, values);
		return this;
	}

	@Override
	public Model setNb_Exemplaire(Object Nb_Exemplaires) {
		setInteger(Fields.Fields_Nb_Exemplaires, Nb_Exemplaires, false);
		return this;
	}

	@Override
	public Model setMoreOfNb_Exemplaire(Object[] values) {
		setMoreOf(Fields.Fields_Nb_Exemplaires, values);
		return this;
	}

	@Override
	public Model setTitre(Object Titre) {
		setString(Fields.Fields_Titre, Titre);
		return this;
	}

	@Override
	public Model setMoreOfTitre(Object[] values) {
		setMoreOf(Fields.Fields_Titre, values);
		return this;
	}
	
	@Override
	public String toString() {
		return getTitre();
	}
}