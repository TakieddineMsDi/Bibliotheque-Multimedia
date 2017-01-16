package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Est_Ecrit extends Model {

	public Est_Ecrit() {
		super();
	}

	public Est_Ecrit(Object Ref_Livre, Object Ref_Auteur) {
		super();
		if(Ref_Auteur != null){
		if(!Ref_Auteur.getClass().getName().equals(Object[].class.getName())){
		Object[] fields = { Ref_Livre, Ref_Auteur };
		for (int i = 0; i < getFields().length; i++) {
			String Key = getFields()[i];
			Object Value = fields[i];
			setProp(Key, Value);
		}
		}else{
			setProp(Fields.Fields_Ref_Livre, Ref_Livre);
			
				setProp(Fields.Fields_Ref_Auteur, ((Object[])Ref_Auteur)[0]);
				if(((Object[])Ref_Auteur).length > 1){
					Object[] vals = new Object[((Object[])Ref_Auteur).length-1];
					for(int i=1;i<((Object[])Ref_Auteur).length;i++){
						vals[i-1] = ((Object[])Ref_Auteur)[i];
					}
					setMoreOf(Fields.Fields_Ref_Auteur, vals);
				}
		}
		}
	}
	
	@Override
	public int add() {
		if(getMoreOfRef_Auteur() != null){
			Auteur auteur = getRef_Auteur();
			int x = super.add();
			if(x != 1){
				return x;
			}
			for(int i=0;i<getMoreOfRef_Auteur().length;i++){
				setRef_Auteur(getMoreOfRef_Auteur()[i]);
				x = super.add();
				if(x != 1){
					return x;
				}
			}
			setRef_Auteur(auteur);
			return 1;
		}else{
		return super.add();
		}
	}

	public Est_Ecrit(ArrayList<Object> Fields) {
		super();
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

	public Est_Ecrit(Object[] Fields) {
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
	public boolean isEst_Ecrit() {
		return Validations.is(this, Fields.Models_Est_Ecrit);
	}

	@Override
	public Auteur getRef_Auteur() {
		return getAuteur(Fields.Fields_Ref_Auteur);
	}

	@Override
	public Object[] getMoreOfRef_Auteur() {
		return getMoreOf(Fields.Fields_Ref_Auteur);
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
	public Model setRef_Auteur(Object Ref_Auteur) {
		setAuteur(Fields.Fields_Ref_Auteur, Ref_Auteur);
		return this;
	}
	
	@Override
	public Model setRef(Object model) {
		if(model != null){
			if(Validations.isModel(model)){
				if(((Model)model).isAuteur()){
					setRef_Auteur(model);
				}else if(((Model)model).isLivre()){
					setRef_Livre(model);
				}
			}
		}
		return super.setRef(model);
	}

	@Override
	public Model setMoreOfRef_Auteur(Object[] values) {
		setMoreOf(Fields.Fields_Ref_Auteur, values);
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
}
