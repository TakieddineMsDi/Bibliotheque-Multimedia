package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Validations {
	public static boolean is(Model model, String Model) {
		if (model != null) {
			String ModelName = model.getModelName();
			if (ModelName != null) {
				if (ModelName.equals(Model)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean SameModel(Model This, Model model) {
		if (model != null) {
			if (model.getModelName().equals(This.getModelName())) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static boolean InList(String Field, Object[] List) {
		if (List != null) {
			for (int i = 0; i < List.length; i++) {
				if (List[i].equals(Field)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean FieldInPrimaryKeysFields(Model model, String Field) {
		if (model != null) {
			return InList(Field, model.getPrimaryKeysFields());
		}
		return false;
	}

	public static boolean FieldInUniquesFields(Model model, String Field) {
		if (model != null) {
			return InList(Field, model.getUniqueFields());
		}
		return false;
	}

	public static boolean FieldInNullableFields(Model model, String Field) {
		if (model != null) {
			return InList(Field, model.getNullableFields());
		}
		return false;
	}
	
	public static boolean FieldInAutoIncrementFields(Model model, String Field) {
		if (model != null) {
			return InList(Field, model.getAuto_IncrementFields());
		}
		return false;
	}
	
	public static boolean isModel(Object value){
		if(value != null){
			if (value.getClass().getName().equals(Fields.Types_Auteur)
					|| value.getClass().getName()
							.equals(Fields.Types_Est_Ecrit)
					|| value.getClass().getName().equals(Fields.Types_Etudiant)
					|| value.getClass().getName()
							.equals(Fields.Types_Exemplaire)
					|| value.getClass().getName().equals(Fields.Types_Livre)
					|| value.getClass().getName()
							.equals(Fields.Types_Reservation)) {
				return true;
			}
		}
		return false;
	}

	public static boolean ValidEmailAddress(Object email) {
		if (email != null) {
			boolean result = true;
			try {
				InternetAddress emailAddr = new InternetAddress((String) email);
				emailAddr.validate();
			} catch (AddressException ex) {
				result = false;
			}
			return result;
		}
		return false;
	}

	public static boolean ValidField(Model model, String Field) {
		if (model != null) {
			if (Field != null) {
				for (int i = 0; i < model.getFields().length; i++) {
					if (model.getFields()[i].equals(Field)) {
						if (model.getValues()[i] != null) {
							if (FieldInPrimaryKeysFields(model, Field)) {
								if (model.getValues()[i].equals(0)) {
									return false;
								}
								if(Field.equals(Fields.Fields_Ref_Auteur)
										|| Field.equals(Fields.Fields_Ref_Etudiant)
										|| Field.equals(Fields.Fields_Ref_Livre)){
									if(!SimplePrimaryKeysValid(model.getModel(Field))){
										return false;
									}
								}
							} else if (FieldInUniquesFields(model, Field)) {
								if(Field.equals(model.getPrimaryKeysFields()[0])){
								if (!ValidEmailAddress(model.getUniqueValues()[0])) {
									return false;
								}
								}
							} else if (FieldInNullableFields(model, Field)) {
								if (model.getValues()[i].equals(-1)) {
									return false;
								}
							}
							if (Field.equals(Fields.Fields_Image)
									|| Field.equals(Fields.Fields_Signature)) {
								if (model.getURLImage() == null) {
									return false;
								}
							} else if (Field.equals(Fields.Fields_Video)) {
								if (model.getURLVideo() == null) {
									return false;
								}
							}
						} else {
							if (Field.equals(Fields.Fields_Image)
									|| Field.equals(Fields.Fields_Signature)) {
								if (model.getURLImage() == null) {
									return false;
								}
							} else if (Field.equals(Fields.Fields_Video)) {
								if (model.getURLVideo() == null) {
									return false;
								}
							} else {
								return false;
							}
						}
						return true;
					}
				}
			}
			return false;
		}
		return false;
	}
	
	public static boolean PrimaryKeysValid(Model model) {
		if(model != null){
		for (int i = 0; i < model.getPrimaryKeysFields().length; i++) {
			if(!ValidField(model, model.getPrimaryKeysFields()[i])){
				return false;
			}
		}
		return true;
		}
		return false;
	}
	
	public static boolean SimplePrimaryKeysValid(Model model) {
		if(model != null){
		for (int i = 0; i < model.getPrimaryKeysFields().length; i++) {
			if (model.getPrimaryKeysValues()[i] != null) {
				if (model.getPrimaryKeysValues()[i].equals(0)) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
		}
		return false;
	}
	
	public static boolean OpsSynctoFields(Model model) {
		if (Getters.getValidFields(model) != null) {
			if (model.getOperators() != null) {
				int j=0;
				for(int i=0;i<Getters.getValidFields(model).length;i++){
					if(!Getters.getValidFields(model)[i].equals(Fields.Fields_Image)
							|| !Getters.getValidFields(model)[i].equals(Fields.Fields_Signature)
							|| !Getters.getValidFields(model)[i].equals(Fields.Fields_Video)){
						j++;
					}
				}
				if (model.getOperators().length == j - 1) {
					return false;
				} else {
					return true;
				}
			} else {
				return true;
			}
		} else {
			return true;
		}
	}
	
	public static boolean ValidForInsert(Model model){
		if(model != null){
			if(!NullFields(model)){
				for(int i=0;i<model.getPrimaryKeysFields().length;i++){
					if(model.getPrimaryKeysValues()[i] != null){
						if(model.getPrimaryKeysFields()[i].contains("REF")){
							if(!ValidForInsert(model.getModel(model.getPrimaryKeysFields()[i]))){
								return false;
							}
						}
						else if(model.getPrimaryKeysValues()[i].equals(0)){
							return false;
						}
					}else{
					return false;
					}
				}
				if(model.getUniqueFields() != null){
					if(!ValidEmailAddress(model.getUniqueValues()[0])){
						return false;
					}
				}
				if(model.getNullableFields() != null){
					for(int i=0;i<model.getNullableFields().length;i++){
						if(model.getNullableValues().equals(-1)){
							return false;
						}
					}
				}
				return true;
			}
			return false;
		}
		return false;
	}

	public static boolean NullFields(Model model) {
		if (model != null) {
			for (int i = 0; i < model.getValues().length; i++) {
				if (ValidField(model, model.getFields()[i])) {
					return false;
				}
			}
			return true;
		}
		return true;
	}

}
