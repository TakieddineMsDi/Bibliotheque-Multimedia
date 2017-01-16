package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models;

import java.lang.reflect.Array;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Exemplaire extends Model {

	public Exemplaire() {
		super();
	}

	public Exemplaire(Object Ref_Livre, Object Ref_Etudiant,
			Object Date_Sortie, Object Date_Retour) {
		super();
		Object[] Fields = { Ref_Livre, Ref_Etudiant, Date_Sortie, Date_Retour };
		for (int i = 0; i < getFields().length; i++) {
			String Key = getFields()[i];
			Object Value = Fields[i];
			setProp(Key, Value);
		}
	}

	public Exemplaire(ArrayList<Object> Fields) {
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

	public Exemplaire(Object[] Fields) {
		super();
		if (Fields != null) {
			if (Fields.length > 0) {
				for (int i = 0; i < getFields().length; i++) {
					String Key = getFields()[i];
					Object Value = Fields[i];
					setProp(Key, Value);
				}
			}
		}
	}

	@Override
	public boolean isExemplaire() {
		return Validations.is(this, Fields.Models_Exemplaire);
	}

	@Override
	public Date getDate_Retour() {
		return getDate(Fields.Fields_Date_Retour);
	}

	@Override
	public Object[] getMoreOfDate_Retour() {
		return getMoreOf(Fields.Fields_Date_Retour);
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
	public Date getDate_Sortie() {
		return getDate(Fields.Fields_Date_Sortie);
	}

	@Override
	public Object[] getMoreOfDate_Sortie() {
		return getMoreOf(Fields.Fields_Date_Sortie);
	}

	@Override
	public Etudiant getRef_Etudiant() {
		return getEtudiant(Fields.Fields_Ref_Etudiant);
	}

	@Override
	public Object[] getMoreOfRef_Etudiant() {
		return getMoreOf(Fields.Fields_Ref_Etudiant);
	}

	@Override
	public Livre getRef_Livre() {
		return getLivre(Fields.Fields_Ref_Livre);
	}

	@Override
	public Object[] getMoreOfRef_Livre() {
		return getMoreOf(Fields.Fields_Ref_Livre);
	}

	@Override
	public Model setDate_Retour(Object Date_Retour) {
		setDate(Fields.Fields_Date_Retour, Date_Retour);
		return this;
	}

	@Override
	public Model setMoreOfDate_Retour(Object[] values) {
		setMoreOf(Fields.Fields_Date_Retour, values);
		return this;
	}

	@Override
	public Model setDate_Sortie(Object Date_Sortie) {
		setDate(Fields.Fields_Date_Sortie, Date_Sortie);
		return this;
	}

	@Override
	public Model setMoreOfDate_Sortie(Object[] values) {
		setMoreOf(Fields.Fields_Date_Sortie, values);
		return this;
	}

	@Override
	public Model setRef_Etudiant(Object Ref_Etudiant) {
		setEtudiant(Fields.Fields_Ref_Etudiant, Ref_Etudiant);
		return this;
	}

	@Override
	public Model setMoreOfRef_Etudiant(Object[] values) {
		setMoreOf(Fields.Fields_Ref_Etudiant, values);
		return this;
	}

	@Override
	public Model setRef_Livre(Object Ref_Livre) {
		setLivre(Fields.Fields_Ref_Livre, Ref_Livre);
		return this;
	}

	@Override
	public Model setMoreOfRef_Livre(Object[] values) {
		setMoreOf(Fields.Fields_Ref_Livre, values);
		return this;
	}
	
	@Override
	public Model setRef(Object model) {
		if(model != null){
			if(Validations.isModel(model)){
				if(((Model)model).isEtudiant()){
					setRef_Etudiant(model);
				}else if(((Model)model).isLivre()){
					setRef_Livre(model);
				}
			}
		}
		return super.setRef(model);
	}
}
