package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models;

import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.utilities.EncryptUtils;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.utilities.KeyWords;

import java.util.Properties;

public class Setters {
	public static void setPropStatic(Properties Prop, String Type, String key,
			Object value) {
		if (value != null && !"".equals(value)) {
			if (Type.equals(value.getClass().getName())) {
				if(key.equals(Fields.Fields_Pass)){
					Prop.put(key, EncryptUtils.base64encode(((String)value)));
				}else{
				Prop.put(key, value);
				}
			} else {
				if (Type.equals(Fields.Types_Integer)) {
					Prop.put(key, 0);
				} else {
					Prop.put(key, KeyWords._Null);
				}
			}
		} else {
			if (Type.equals(Fields.Types_Integer)) {
				Prop.put(key, 0);
			} else {
				Prop.put(key, KeyWords._Null);
			}
		}
	}

	public static void setPropStatic(Properties Prop, String Type, String key,
			Object value, boolean NullableForInt) {
		if (value != null && !"".equals(value)) {
			if (Type.equals(value.getClass().getName())) {
				if (Type.equals(Fields.Types_Integer)) {
					if (NullableForInt) {
						if ((int) value < 0) {
							Prop.put(key, 0);
						} else {
							Prop.put(key, value);
						}
					} else {
						if ((int) value < -1) {
							Prop.put(key, -1);
						} else {
							Prop.put(key, value);
						}
					}
				} else {
					Prop.put(key, value);
				}
			} else {
				if (Type.equals(Fields.Types_Integer)) {
					if (NullableForInt) {
						Prop.put(key, 0);
					} else {
						Prop.put(key, -1);
					}
				} else {
					Prop.put(key, KeyWords._Null);
				}
			}
		} else {
			if (Type.equals(Fields.Types_Integer)) {
				if (NullableForInt) {
					Prop.put(key, 0);
				} else {
					Prop.put(key, -1);
				}
			} else {
				Prop.put(key, KeyWords._Null);
			}
		}
	}

	public static void setPropStatic(Properties Prop, String key, Object value) {
		if (value != null && !"".equals(value)) {
			Prop.put(key, value);
		} else {
			Prop.put(key, KeyWords._Null);
		}

	}

	public static void setPropStatic(Model model, Properties Prop, String Key,
			Object Value) {
		for (int i = 0; i < model.getFields().length; i++) {
			if (model.getFields()[i].equals(Key)) {
				if (Value != null && !"".equals(Value)) {
					if (Value.getClass().getName().equals(model.getTypes()[i])) {
						if (model.getTypes()[i].equals(Fields.Types_Integer)) {
							if (Validations.FieldInNullableFields(model,
									model.getFields()[i])) {
								if ((int) Value < -1) {
									Prop.put(Key, -1);
								} else {
									Prop.put(Key, Value);
								}
							} else {
								if ((int) Value < 0) {
									Prop.put(Key, 0);
								} else {
									Prop.put(Key, Value);
								}
							}
						} else {
							if (model.getFields()[i].equals(Fields.Fields_Mail)) {
								if (Validations
										.ValidEmailAddress((String) Value)) {
									Prop.put(Key, Value);
								} else {
									Prop.put(Key, KeyWords._Null);
								}
							} else {
								if(Key.equals(Fields.Fields_Pass)){
									Prop.put(Key, EncryptUtils.base64encode(((String)Value)));
								}else{
								Prop.put(Key, Value);
							}}
						}
					} else {
						if (model.getTypes()[i].equals(Fields.Types_Integer)) {
							if ((Validations.FieldInNullableFields(model,
									model.getFields()[i]))) {
								Prop.put(Key, -1);
							} else {
								Prop.put(Key, 0);
							}
						} else {
							Prop.put(Key, KeyWords._Null);
						}
					}
				} else {
					if (model.getTypes()[i].equals(Fields.Types_Integer)) {
						if ((Validations.FieldInNullableFields(model,
								model.getFields()[i]))) {
							Prop.put(Key, -1);
						} else {
							Prop.put(Key, 0);
						}
					} else {
						Prop.put(Key, KeyWords._Null);
					}
				}
			}
		}
	}

	public static void setInteger(Properties Prop, String key, Object value,
			boolean Nullable) {
		setPropStatic(Prop, Fields.Types_Integer, key, value, Nullable);
	}

	public static void setString(Properties Prop, String key, Object value) {
		setPropStatic(Prop, Fields.Types_String, key, value);
	}

	public static void setDate(Properties Prop, String key, Object value) {
		setPropStatic(Prop, Fields.Types_Date, key, value);
	}

	public static void setOrdImage(Properties Prop, String key, Object value) {
		setPropStatic(Prop, Fields.Types_OrdImage, key, value);
	}

	public static void setOrdImageSignature(Properties Prop, String key,
			Object value) {
		setPropStatic(Prop, Fields.Types_OrdImageSignature, key, value);
	}

	public static void setOrdVideo(Properties Prop, String key, Object value) {
		setPropStatic(Prop, Fields.Types_OrdVideo, key, value);
	}

	public static void setAuteur(Properties Prop, String key, Object value) {
		setPropStatic(Prop, Fields.Types_Auteur, key, value);
	}

	public static void setEst_Ecrit(Properties Prop, String key, Object value) {
		setPropStatic(Prop, Fields.Types_Est_Ecrit, key, value);
	}

	public static void setEtudiant(Properties Prop, String key, Object value) {
		setPropStatic(Prop, Fields.Types_Etudiant, key, value);
	}

	public static void setExemplaire(Properties Prop, String key, Object value) {
		setPropStatic(Prop, Fields.Types_Exemplaire, key, value);
	}

	public static void setLivre(Properties Prop, String key, Object value) {
		setPropStatic(Prop, Fields.Types_Livre, key, value);
	}

	public static void setReservation(Properties Prop, String key, Object value) {
		setPropStatic(Prop, Fields.Types_Reservation, key, value);
	}

	public static void setModel(Properties Prop, String key, Object value) {
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
				setPropStatic(Prop, value.getClass().getName(), key, value);
			}
		}
	}
}
