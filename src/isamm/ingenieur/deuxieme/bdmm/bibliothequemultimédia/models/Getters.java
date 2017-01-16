package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models;

import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.utilities.KeyWords;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Properties;

import oracle.ord.im.OrdImage;
import oracle.ord.im.OrdImageSignature;
import oracle.ord.im.OrdVideo;

public class Getters {
	public static String getModelName(Model model) {
		if (model != null) {
			String ClassName = model.getClass().getName();
			String toReturn = "";
			if (ClassName.equals(Fields.Types_Auteur)) {
				toReturn = Fields.Models_Auteur;
			} else if (ClassName.equals(Fields.Types_Est_Ecrit)) {
				toReturn = Fields.Models_Est_Ecrit;
			} else if (ClassName.equals(Fields.Types_Etudiant)) {
				toReturn = Fields.Models_Etudiant;
			} else if (ClassName.equals(Fields.Types_Exemplaire)) {
				toReturn = Fields.Models_Exemplaire;
			} else if (ClassName.equals(Fields.Types_Livre)) {
				toReturn = Fields.Models_Livre;
			} else if (ClassName.equals(Fields.Types_Reservation)) {
				toReturn = Fields.Models_Reservation;
			} else {
				toReturn = null;
			}
			return toReturn;
		}
		return null;
	}

	public static String[] getPrimaryKeysFields(Model model) {
		if (model != null) {
			if (model.isAuteur()) {
				return Fields.Auteur_PrimaryKeys;
			} else if (model.isEst_Ecrit()) {
				return Fields.Est_Ecrit_PrimaryKeys;
			} else if (model.isEtudiant()) {
				return Fields.Etudiant_PrimaryKeys;
			} else if (model.isExemplaire()) {
				return Fields.Exemplaire_PrimaryKeys;
			} else if (model.isLivre()) {
				return Fields.Livre_PrimaryKeys;
			} else if (model.isReservation()) {
				return Fields.Reservation_PrimaryKeys;
			}
		}
		return null;
	}

	public static String[] getUniqueFields(Model model) {
		if (model != null) {
			if (model.isAuteur()) {
				return Fields.Auteur_Unique;
			} else if (model.isEst_Ecrit()) {
				return null;
			} else if (model.isEtudiant()) {
				return Fields.Etudiant_Unique;
			} else if (model.isExemplaire()) {
				return null;
			} else if (model.isLivre()) {
				return null;
			} else if (model.isReservation()) {
				return null;
			}
		}
		return null;
	}

	public static String[] getNullableFields(Model model) {
		if (model != null) {
			if (model.isAuteur()) {
				return null;
			} else if (model.isEst_Ecrit()) {
				return null;
			} else if (model.isEtudiant()) {
				return Fields.Etudiant_Nullable;
			} else if (model.isExemplaire()) {
				return null;
			} else if (model.isLivre()) {
				return Fields.Livre_Nullable;
			} else if (model.isReservation()) {
				return null;
			}
		}
		return null;
	}

	public static String[] getAutoIncrementFields(Model model) {
		if (model != null) {
			if (model.isAuteur()) {
				return Fields.Auteur_Auto_Increment;
			} else if (model.isEst_Ecrit()) {
				return null;
			} else if (model.isEtudiant()) {
				return Fields.Etudiant_Auto_Increment;
			} else if (model.isExemplaire()) {
				return null;
			} else if (model.isLivre()) {
				return null;
			} else if (model.isReservation()) {
				return null;
			}
		}
		return null;
	}

	public static String[] getFields(Model model) {
		if (model != null) {
			if (model.isAuteur()) {
				return Fields.Auteur_Fields;
			} else if (model.isEst_Ecrit()) {
				return Fields.Est_Ecrit_Fields;
			} else if (model.isEtudiant()) {
				return Fields.Etudiant_Fields;
			} else if (model.isExemplaire()) {
				return Fields.Exemplaire_Fields;
			} else if (model.isLivre()) {
				return Fields.Livre_Fields;
			} else if (model.isReservation()) {
				return Fields.Reservation_Fields;
			}
		}
		return null;
	}
	
	public static String[] getFields(String model) {
		if (model != null) {
			if (model.equals(Fields.Models_Auteur)) {
				return Fields.Auteur_Fields;
			} else if (model.equals(Fields.Models_Est_Ecrit)) {
				return Fields.Est_Ecrit_Fields;
			} else if (model.equals(Fields.Models_Etudiant)) {
				return Fields.Etudiant_Fields;
			} else if (model.equals(Fields.Models_Exemplaire)) {
				return Fields.Exemplaire_Fields;
			} else if (model.equals(Fields.Models_Livre)) {
				return Fields.Livre_Fields;
			} else if (model.equals(Fields.Models_Reservation)) {
				return Fields.Reservation_Fields;
			}
		}
		return null;
	}

	public static String[] getTypes(Model model) {
		if (model != null) {
			if (model.isAuteur()) {
				return Fields.Auteur_Types;
			} else if (model.isEst_Ecrit()) {
				return Fields.Est_Ecrit_Types;
			} else if (model.isEtudiant()) {
				return Fields.Etudiant_Types;
			} else if (model.isExemplaire()) {
				return Fields.Exemplaire_Types;
			} else if (model.isLivre()) {
				return Fields.Livre_Types;
			} else if (model.isReservation()) {
				return Fields.Reservation_Types;
			}
		}
		return null;
	}

	public static Object getPropStatic(Properties Prop, String key) {
		if (Prop.get(key) != null && !KeyWords._Null.equals(Prop.get(key))) {
			if (key.equals(Fields.Fields_Mail)) {
				if (Validations.ValidEmailAddress(Prop.get(key))) {
					return Prop.get(key);
				} else {
					return null;
				}
			} else {
				return Prop.get(key);
			}
		} else {
			return null;
		}
	}

	public static Object[] getValues(Model model) {
		if (model != null) {
			Object[] values = (Object[]) Array.newInstance(Object.class,
					model.getFields().length);
			for (int i = 0; i < model.getFields().length; i++) {
				String Field = model.getFields()[i];
				values[i] = model.getProp(Field);
			}
			return values;
		}
		return null;
	}

	public static Object[] getPrimaryKeysValues(Model model) {
		if (model != null) {
			Object[] values = (Object[]) Array.newInstance(Object.class,
					model.getPrimaryKeysFields().length);
			;
			for (int i = 0; i < model.getPrimaryKeysFields().length; i++) {
				String Field = model.getPrimaryKeysFields()[i];
				values[i] = model.getProp(Field);
			}
			return values;
		}
		return null;
	}

	public static Object[] getUniqueValues(Model model) {
		if (model != null) {
			if (model.getUniqueFields() != null) {
				Object[] values = (Object[]) Array.newInstance(Object.class,
						model.getUniqueFields().length);
				for (int i = 0; i < model.getUniqueFields().length; i++) {
					String Field = model.getUniqueFields()[i];
					values[i] = model.getProp(Field);
				}
				return values;
			}
			return null;
		}
		return null;
	}

	public static Object[] getNullableValues(Model model) {
		if (model != null) {
			if (model.getNullableFields() != null) {
				Object[] values = (Object[]) Array.newInstance(Object.class,
						model.getNullableFields().length);
				;
				for (int i = 0; i < model.getNullableFields().length; i++) {
					String Field = model.getNullableFields()[i];
					values[i] = model.getProp(Field);
				}
				return values;
			}
			return null;
		}
		return null;
	}

	public static Object[] getValuesToShow(Model model) {
		if (model != null) {
			if (model.getFieldsToShow() != null) {
				Object[] values = (Object[]) Array.newInstance(Object.class,
						model.getFieldsToShow().length);
				for (int i = 0; i < model.getFieldsToShow().length - 1; i++) {
					if (!model.getFieldsToShow().equals(Fields.JTable_Action)) {
						if (model.getFieldsToShow()[i]
								.equals(Fields.Fields_Image)
								|| model.getFieldsToShow()[i]
										.equals(Fields.Fields_Video)) {
							values[i] = "";
						} else {
							String Field = model.getFieldsToShow()[i];
							if(Field.equals(Fields.Fields_Pass)){
								values[i] = model.DecryptPass(model.getProp(Field));
							}else{
							values[i] = model.getProp(Field);
							}
						}
					}
				}
				values[values.length - 1] = "";
				return values;
			}
			return null;
		}
		return null;
	}

	public static String[] getFieldsToShow(Model model) {
		ArrayList<String> SimpleFields = new ArrayList<String>();
		//if(model.isAuteur()||model.isEtudiant()||model.isLivre()){
		for (int i = 0; i < model.getFields().length; i++) {
			if (!model.getFields()[i].equals(Fields.Fields_Signature)) {
				SimpleFields.add(model.getFields()[i]);
			}
		}
		SimpleFields.add(Fields.JTable_Action);
		String[] Return = (String[]) Array.newInstance(String.class,
				SimpleFields.size());
		for (int i = 0; i < SimpleFields.size(); i++) {
			Return[i] = SimpleFields.get(i);
		}
		return Return;
	}
	
	public static String[] getSimpleFieldsToShow(Model model) {
		ArrayList<String> SimpleFields = new ArrayList<String>();
		//if(model.isAuteur()||model.isEtudiant()||model.isLivre()){
		for (int i = 0; i < model.getFields().length; i++) {
			if (!model.getFields()[i].equals(Fields.Fields_Signature)) {
				SimpleFields.add(model.getFields()[i]);
			}
		}
		String[] Return = (String[]) Array.newInstance(String.class,
				SimpleFields.size());
		for (int i = 0; i < SimpleFields.size(); i++) {
			Return[i] = SimpleFields.get(i);
		}
		return Return;
	}


	public static Object[] getAutoIncrementValues(Model model) {
		if (model != null) {
			if (model.getAuto_IncrementFields() != null) {
				Object[] values = (Object[]) Array.newInstance(Object.class,
						model.getAuto_IncrementFields().length);
				;
				for (int i = 0; i < model.getAuto_IncrementFields().length; i++) {
					String Field = model.getAuto_IncrementFields()[i];
					values[i] = model.getProp(Field);
				}
				return values;
			}
			return null;
		}
		return null;
	}

	public static int getInteger(Properties Prop, String key, boolean Nullable) {
		Object value = getPropStatic(Prop, key);
		if (value != null) {
			if (value.getClass().getName().equals(Fields.Types_Integer)) {
				return (int) value;
			}
		}
		if (Nullable) {
			return 0;
		} else {
			return -1;
		}
	}

	public static String getString(Properties Prop, String key) {
		Object value = getPropStatic(Prop, key);
		if (value != null) {
			if (value.getClass().getName().equals(Fields.Types_String)) {
				return (String) value;
			}
		}
		return null;
	}

	public static Date getDate(Properties Prop, String key) {
		Object value = getPropStatic(Prop, key);
		if (value != null) {
			if (value.getClass().getName().equals(Fields.Types_Date)) {
				return (Date) value;
			}
		}
		return null;
	}

	public static OrdImage getOrdImage(Properties Prop, String key) {
		Object value = getPropStatic(Prop, key);
		if (value != null) {
			if (value.getClass().getName().equals(Fields.Types_OrdImage)) {
				return (OrdImage) value;
			}
		}
		return null;
	}

	public static OrdImageSignature getOrdImageSignature(Properties Prop,
			String key) {
		Object value = getPropStatic(Prop, key);
		if (value != null) {
			if (value.getClass().getName()
					.equals(Fields.Types_OrdImageSignature)) {
				return (OrdImageSignature) value;
			}
		}
		return null;
	}

	public static OrdVideo getOrdVideo(Properties Prop, String key) {
		Object value = getPropStatic(Prop, key);
		if (value != null) {
			if (value.getClass().getName().equals(Fields.Types_OrdVideo)) {
				return (OrdVideo) value;
			}
		}
		return null;
	}

	public static Auteur getAuteur(Properties Prop, String key) {
		Object value = getPropStatic(Prop, key);
		if (value != null) {
			if (value.getClass().getName().equals(Fields.Types_Auteur)) {
				return (Auteur) value;
			}
		}
		return null;
	}

	public static Est_Ecrit getEst_Ecrit(Properties Prop, String key) {
		Object value = getPropStatic(Prop, key);
		if (value != null) {
			if (value.getClass().getName().equals(Fields.Types_Est_Ecrit)) {
				return (Est_Ecrit) value;
			}
		}
		return null;
	}

	public static Etudiant getEtudiant(Properties Prop, String key) {
		Object value = getPropStatic(Prop, key);
		if (value != null) {
			if (value.getClass().getName().equals(Fields.Types_Etudiant)) {
				return (Etudiant) value;
			}
		}
		return null;
	}

	public static Exemplaire getExemplaire(Properties Prop, String key) {
		Object value = getPropStatic(Prop, key);
		if (value != null) {
			if (value.getClass().getName().equals(Fields.Types_Exemplaire)) {
				return (Exemplaire) value;
			}
		}
		return null;
	}

	public static Livre getLivre(Properties Prop, String key) {
		Object value = getPropStatic(Prop, key);
		if (value != null) {
			if (value.getClass().getName().equals(Fields.Types_Livre)) {
				return (Livre) value;
			}
		}
		return null;
	}

	public static Reservation getReservation(Properties Prop, String key) {
		Object value = getPropStatic(Prop, key);
		if (value != null) {
			if (value.getClass().getName().equals(Fields.Types_Reservation)) {
				return (Reservation) value;
			}
		}
		return null;
	}

	public static Model getModel(Properties Prop, String key) {
		Object value = getPropStatic(Prop, key);
		if (value != null) {
			if (value.getClass().getName().equals(Fields.Types_Auteur)
					|| value.getClass().getName()
							.equals(Fields.Types_Est_Ecrit)
					|| value.getClass().getName().equals(Fields.Types_Etudiant)
					|| value.getClass().getName()
							.equals(Fields.Types_Exemplaire)
					|| value.getClass().getName().equals(Fields.Types_Livre)
					|| value.getClass().getName()
							.equals(Fields.Types_Reservation)) {
				return (Model) value;
			}
		}
		return null;
	}

	public static String[] getValidFields(Model model) {
		if (model != null) {
			ArrayList<String> fields = new ArrayList<String>();
			for (int i = 0; i < model.getFields().length; i++) {
				if (Validations.ValidField(model, model.getFields()[i])) {
					fields.add(model.getFields()[i]);
				}
			}
			if (fields.size() > 0) {
				String[] Return = (String[]) Array.newInstance(String.class,
						fields.size());
				for (int i = 0; i < fields.size(); i++) {
					Return[i] = fields.get(i);
				}
				return Return;
			}
		}
		return null;
	}

	public static String[] getValidFieldsForInsert(Model model) {
		if (Validations.ValidForInsert(model)) {
			return getValidFields(model);
		}
		return null;
	}

	public static String[] getValidFieldsForSelect(Model model) {
		return getValidFields(model);
	}

	public static String[] getValidFieldsForUpdate(Model This, Model model) {
		String[] fields = getValidFields(model);
		if (fields != null && Validations.SameModel(This, model)) {
			ArrayList<String> newFields = new ArrayList<String>();
			for (int i = 0; i < fields.length; i++) {
				if (!fields[i].equals(Fields.Fields_Image)
						&& !fields[i].equals(Fields.Fields_Signature)
						&& !fields[i].equals(Fields.Fields_Video)) {
					if (This.getProp(fields[i]) != null) {
						if (!This.getProp(fields[i]).equals(
								model.getProp(fields[i]))) {
							newFields.add(fields[i]);
						}
					} else {
						newFields.add(fields[i]);
					}
				} else {
					newFields.add(fields[i]);
				}
			}
			if (newFields.size() > 0) {
				String[] Return = (String[]) Array.newInstance(String.class,
						newFields.size());
				for (int i = 0; i < newFields.size(); i++) {
					Return[i] = newFields.get(i);
				}
				return Return;
			}
		}
		return null;
	}

	public static Object[] getValidValuesForInsert(Model model) {
		if (getValidFieldsForInsert(model) != null) {
			ArrayList<Object> values = new ArrayList<Object>();
			int j = 0;
			for (int i = 0; i < model.getFields().length; i++) {
				if (j < getValidFields(model).length) {
					if (model.getFields()[i].equals(getValidFields(model)[j])) {
						if (model.getFields()[i].contains("DATE")) {
							values.add("TO_DATE('"
									+ model.getFormattedDate(model
											.getDate(model.getFields()[i]))
									+ "','DD/MM/RRRR')");
						} else if (model.getFields()[i].contains("REF")) {
							values.add("("
									+ Generate.SQLREF(model.getModel(model
											.getFields()[i]), 0) + ")");
						} else if (model.getFields()[i]
								.equals(Fields.Fields_Image)
								|| model.getFields()[i]
										.equals(Fields.Fields_Video)
								|| model.getFields()[i]
										.equals(Fields.Fields_Signature)) {
							if (model.getFields()[i]
									.equals(Fields.Fields_Image)) {
								values.add("ORDSYS.ORDImage.init()");
							} else if (model.getFields()[i]
									.equals(Fields.Fields_Video)) {
								values.add("ORDSYS.ORDVideo.init()");
							} else {
								values.add("ORDSYS.ORDImageSignature.init()");
							}
						} else {
							values.add("'" + model.getValues()[i] + "'");
						}
						j++;
					}
				}
			}
			Object[] Return = (Object[]) Array.newInstance(Object.class,
					values.size());
			for (int i = 0; i < values.size(); i++) {
				Return[i] = values.get(i);
			}
			return Return;
		}
		return null;
	}

	public static Object[] getValidValuesForSelect(Model model) {
		if (getValidFieldsForSelect(model) != null) {
			ArrayList<Object> values = new ArrayList<Object>();
			int j = 0;
			boolean First = true;
			boolean Default = true;
			String DefaultOp = "AND";
			String DefaultSameOp = "OR";
			if (!Validations.OpsSynctoFields(model)) {
				Default = false;
			}
			int k = 0;
			for (int i = 0; i < model.getFields().length; i++) {
				if (!model.getFields()[i].equals(Fields.Fields_Image)
						&& !model.getFields()[i]
								.equals(Fields.Fields_Signature)
						&& !model.getFields()[i].equals(Fields.Fields_Video)) {
					if (j < getValidFieldsForSelect(model).length) {
						if (model.getFields()[i]
								.equals(getValidFieldsForSelect(model)[j])) {
							if (model.getFields()[i].contains("DATE")) {
								if (First) {
									values.add("WHERE "
											+ model.getFields()[i]
											+ " = TO_DATE('"
											+ model.getFormattedDate(model
													.getDate(model.getFields()[i]))
											+ "','DD/MM/RRRR')");
									First = false;
								} else {
									if (Default) {
										values.add(DefaultOp
												+ " "
												+ model.getFields()[i]
												+ " = TO_DATE('"
												+ model.getFormattedDate(model.getDate(model
														.getFields()[i]))
												+ "','DD/MM/RRRR')");
									} else {
										values.add(model.getOperators()[k]
												+ " "
												+ model.getFields()[i]
												+ " = TO_DATE('"
												+ model.getFormattedDate(model.getDate(model
														.getFields()[i]))
												+ "','DD/MM/RRRR')");
										k++;
									}
								}
								if (model.getMoreOf(model.getFields()[i]) != null) {
									for (int m = 0; m < model.getMoreOf(model
											.getFields()[i]).length; m++) {
										values.add(DefaultSameOp
												+ " "
												+ model.getFields()[i]
												+ " = TO_DATE('"
												+ model.getFormattedDate((Date) model.getMoreOf(model
														.getFields()[i])[m])
												+ "','DD/MM/RRRR')");
									}
								}
							} else if (model.getFields()[i].contains("REF")) {
								if (First) {
									values.add("WHERE "
											+ model.getFields()[i]
											+ " = ("
											+ Generate.SQLREF(
													model.getModel(model
															.getFields()[i]), 0)
											+ ")");
									First = false;
								} else {
									if (Default) {
										values.add(DefaultOp
												+ " "
												+ model.getFields()[i]
												+ " = ("
												+ Generate.SQLREF(
														model.getModel(model
																.getFields()[i]),
														0) + ")");
									} else {
										values.add(model.getOperators()[k]
												+ " "
												+ model.getFields()[i]
												+ " = ("
												+ Generate.SQLREF(
														model.getModel(model
																.getFields()[i]),
														0) + ")");
										k++;
									}
								}
								if (model.getMoreOf(model.getFields()[i]) != null) {
									for (int m = 0; m < model.getMoreOf(model
											.getFields()[i]).length; m++) {
										values.add(DefaultSameOp
												+ " "
												+ model.getFields()[i]
												+ " = ("
												+ Generate.SQLREF(
														((Model) (model
																.getMoreOf(model
																		.getFields()[i])[m])),
														0) + ")");
									}
								}
							} else {
								if (First) {
									values.add("WHERE " + model.getFields()[i]
											+ " = '" + model.getValues()[i]
											+ "'");
									First = false;
								} else {
									if (Default) {
										values.add(DefaultOp + " "
												+ model.getFields()[i] + " = '"
												+ model.getValues()[i] + "'");
									} else {
										values.add(model.getOperators()[k]
												+ " " + model.getFields()[i]
												+ " = '" + model.getValues()[i]
												+ "'");
										k++;
									}
								}
								if (model.getMoreOf(model.getFields()[i]) != null) {
									for (int m = 0; m < model.getMoreOf(model
											.getFields()[i]).length; m++) {
										values.add(DefaultSameOp
												+ " "
												+ model.getFields()[i]
												+ " = '"
												+ model.getMoreOf(model
														.getFields()[i])[m]
												+ "'");
									}
								}
							}
							j++;
						}
					}
				}
			}
			if (values.size() > 0) {
				Object[] Return = (Object[]) Array.newInstance(Object.class,
						values.size());
				for (int i = 0; i < values.size(); i++) {
					Return[i] = values.get(i);
				}
				return Return;
			}
		}
		return null;
	}

	public static Object[] getValidValuesForUpdateSeparated(Model This,
			Model model) {
		if (getValidFieldsForUpdate(This, model) != null
				&& Validations.SameModel(This, model)) {
			ArrayList<Object> values = new ArrayList<Object>();
			int j = 0;
			for (int i = 0; i < model.getFields().length; i++) {
				if (j < getValidFieldsForUpdate(This, model).length) {
					if (model.getFields()[i].equals(getValidFieldsForUpdate(
							This, model)[j])) {
						if (model.getFields()[i].contains("DATE")) {
							values.add("SET "
									+ model.getFields()[i]
									+ " = TO_DATE('"
									+ model.getFormattedDate(model
											.getDate(model.getFields()[i]))
									+ "','DD/MM/RRRR')");
						} else if (model.getFields()[i].contains("REF")) {
							values.add("SET "
									+ model.getFields()[i]
									+ " = ("
									+ Generate.SQLREF(model.getModel(model
											.getFields()[i]), 0) + ")");
						} else if (model.getFields()[i]
								.equals(Fields.Fields_Image)
								|| model.getFields()[i]
										.equals(Fields.Fields_Video)
								|| model.getFields()[i]
										.equals(Fields.Fields_Signature)) {
							if (model.getFields()[i]
									.equals(Fields.Fields_Image)) {
								values.add("SET " + model.getFields()[i]
										+ " = ORDSYS.ORDImage.init()");
							} else if (model.getFields()[i]
									.equals(Fields.Fields_Video)) {
								values.add("SET " + model.getFields()[i]
										+ " = ORDSYS.ORDVideo.init()");
							} else {
								values.add("SET " + model.getFields()[i]
										+ " = ORDSYS.ORDImageSignature.init()");
							}
						} else {
							values.add("SET " + model.getFields()[i] + " = '"
									+ model.getValues()[i] + "'");
						}
						j++;
					}
				}
			}
			Object[] Return = (Object[]) Array.newInstance(Object.class,
					values.size());
			for (int i = 0; i < values.size(); i++) {
				Return[i] = values.get(i);
			}
			return Return;
		}
		return null;
	}

	public static Object[] getValidValuesForUpdate(Model This, Model model) {
		if (getValidFieldsForUpdate(This, model) != null
				&& Validations.SameModel(This, model)) {
			ArrayList<Object> values = new ArrayList<Object>();
			int j = 0;
			boolean More = false;
			for (int i = 0; i < model.getFields().length; i++) {
				if (j < getValidFieldsForUpdate(This, model).length) {
					if (model.getFields()[i].equals(getValidFieldsForUpdate(
							This, model)[j])) {
						if (model.getFields()[i].contains("DATE")) {
							if (More) {
								values.add(","
										+ model.getFields()[i]
										+ " = TO_DATE('"
										+ model.getFormattedDate(model
												.getDate(model.getFields()[i]))
										+ "','DD/MM/RRRR')");
							} else {
								More = true;
								values.add("SET "
										+ model.getFields()[i]
										+ " = TO_DATE('"
										+ model.getFormattedDate(model
												.getDate(model.getFields()[i]))
										+ "','DD/MM/RRRR')");
							}
						} else if (model.getFields()[i].contains("REF")) {
							if (More) {
								values.add(","
										+ model.getFields()[i]
										+ " = ("
										+ Generate.SQLREF(model.getModel(model
												.getFields()[i]), 0) + ")");
							} else {
								More = true;
								values.add("SET "
										+ model.getFields()[i]
										+ " = ("
										+ Generate.SQLREF(model.getModel(model
												.getFields()[i]), 0) + ")");
							}
						} else if (model.getFields()[i]
								.equals(Fields.Fields_Image)
								|| model.getFields()[i]
										.equals(Fields.Fields_Video)
								|| model.getFields()[i]
										.equals(Fields.Fields_Signature)) {
							if (model.getFields()[i]
									.equals(Fields.Fields_Image)) {
								if (More) {
									values.add("," + model.getFields()[i]
											+ " = ORDSYS.ORDImage.init()");
								} else {
									More = true;
									values.add("SET " + model.getFields()[i]
											+ " = ORDSYS.ORDImage.init()");

								}
							} else if (model.getFields()[i]
									.equals(Fields.Fields_Video)) {
								if (More) {
									values.add("," + model.getFields()[i]
											+ " = ORDSYS.ORDVideo.init()");
								} else {
									More = true;
									values.add("SET " + model.getFields()[i]
											+ " = ORDSYS.ORDVideo.init()");
								}
							} else {
								if (More) {
									values.add(","
											+ model.getFields()[i]
											+ " = ORDSYS.ORDImageSignature.init()");
								} else {
									More = true;
									values.add("SET "
											+ model.getFields()[i]
											+ " = ORDSYS.ORDImageSignature.init()");
								}
							}
						} else {
							if (More) {
								values.add("," + model.getFields()[i] + " = '"
										+ model.getValues()[i] + "'");
							} else {
								More = true;
								values.add("SET " + model.getFields()[i]
										+ " = '" + model.getValues()[i] + "'");
							}
						}
						j++;
					}
				}
			}
			Object[] Return = (Object[]) Array.newInstance(Object.class,
					values.size());
			for (int i = 0; i < values.size(); i++) {
				Return[i] = values.get(i);
			}
			return Return;
		}
		return null;
	}

}
