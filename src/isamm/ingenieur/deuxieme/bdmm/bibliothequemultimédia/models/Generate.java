package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models;

import java.util.ArrayList;

public class Generate {
	public static String SQLREF(Model model, int k) {
		if (model != null) {
			String Return = "";
			if (k == 0) {
				Return = "SELECT REF(M) FROM " + model.getModelName() + " M";
			} else if (Validations.PrimaryKeysValid(model)) {
				Return = "SELECT REF(X) FROM " + model.getModelName() + " X";
			}
			if (!Validations.NullFields(model)) {
				boolean More = false;
				for (int i = 0; i < model.getPrimaryKeysFields().length; i++) {
					if (model.getPrimaryKeysValues()[i] != null) {
						if (model.getPrimaryKeysFields()[i].contains("REF")) {
							if (More) {
								if (Validations
										.SimplePrimaryKeysValid(model.getModel(model
												.getPrimaryKeysFields()[i]))) {
									if (k == 0) {
										Return += " AND M."
												+ model.getPrimaryKeysFields()[i]
												+ " = ("
												+ SQLREF(
														model.getModel(model
																.getPrimaryKeysFields()[i]),
														1) + ")";
									} else {
										Return += " AND X."
												+ model.getPrimaryKeysFields()[i]
												+ " = ("
												+ SQLREF(
														model.getModel(model
																.getPrimaryKeysFields()[i]),
														1) + ")";
									}
								}
							} else {
								if (Validations
										.SimplePrimaryKeysValid(model.getModel(model
												.getPrimaryKeysFields()[i]))) {
									More = true;
									if (k == 0) {
										Return += " WHERE M."
												+ model.getPrimaryKeysFields()[i]
												+ " = ("
												+ SQLREF(
														model.getModel(model
																.getPrimaryKeysFields()[i]),
														1) + ")";
									} else {
										Return += " WHERE X."
												+ model.getPrimaryKeysFields()[i]
												+ " = ("
												+ SQLREF(
														model.getModel(model
																.getPrimaryKeysFields()[i]),
														1) + ")";
									}
								}
							}
						} else if (!model.getPrimaryKeysValues()[i].equals(0)) {
							if (More) {
								if (k == 0)
									Return += " AND M."
											+ model.getPrimaryKeysFields()[i]
											+ " = '"
											+ model.getPrimaryKeysValues()[i]
											+ "'";
								else
									Return += " AND X."
											+ model.getPrimaryKeysFields()[i]
											+ " = '"
											+ model.getPrimaryKeysValues()[i]
											+ "'";
							} else {
								More = true;
								if (k == 0)
									Return += " WHERE M."
											+ model.getPrimaryKeysFields()[i]
											+ " = '"
											+ model.getPrimaryKeysValues()[i]
											+ "'";
								else
									Return += " WHERE X."
											+ model.getPrimaryKeysFields()[i]
											+ " = '"
											+ model.getPrimaryKeysValues()[i]
											+ "'";
							}
						}
					}
				}
			}
			return Return;
		}
		return null;
	}

	public static String SQLInsert(Model model) {
		if (model != null) {
			if (Getters.getValidFieldsForInsert(model) != null) {
				String Insert = "INSERT INTO " + model.getModelName() + " (";
				for (int i = 0; i < Getters.getValidFields(model).length; i++) {
					if (i == 0) {
						Insert += Getters.getValidFields(model)[i];
					} else {
						Insert += "," + Getters.getValidFields(model)[i];
					}
				}
				Insert += ") VALUES(";
				for (int i = 0; i < Getters.getValidValuesForInsert(model).length; i++) {
					if (i == 0) {
						Insert += Getters.getValidValuesForInsert(model)[i];
					} else {
						Insert += ","
								+ Getters.getValidValuesForInsert(model)[i];
					}
				}
				Insert += ")";
				return Insert;
			}
		}
		return null;
	}

	public static String SQLSelect(Model model) {
		if (model != null) {
			String Select = "SELECT * FROM " + model.getModelName();
			if (Getters.getValidValuesForSelect(model) != null) {
				for (int i = 0; i < Getters.getValidValuesForSelect(model).length; i++) {
					Select += " " + Getters.getValidValuesForSelect(model)[i];
				}
			}
			return Select;
		}
		return null;
	}

	public static String SQLSelectFromList(ArrayList<Model> list) {
		if (list != null) {
			Model model = null;
			model = list.get(0);
			if (list.size() > 1) {
				for (int i = 1; i < list.size(); i++) {
					if (Getters.getValidFieldsForSelect(model) != null) {
						for (int j = 0; j < Getters
								.getValidFieldsForSelect(model).length; j++) {
							Object[] val = { list.get(i).getProp(
									Getters.getValidFieldsForSelect(model)[j]) };
							model.setMoreOf(
									Getters.getValidFieldsForSelect(model)[j],
									val);
						}
					}
				}
			}
			return model.generateSQLSelect();
		}
		return null;
	}

	public static String SQLDelete(Model model) {
		String Delete = "DELETE FROM " + model.getModelName();
		if (Getters.getValidValuesForSelect(model) != null) {
			for (int i = 0; i < Getters.getValidValuesForSelect(model).length; i++) {
				Delete += " " + Getters.getValidValuesForSelect(model)[i];
			}
		}
		return Delete;
	}

	public static String SQLUpdate(Model This, Model model) {
		if (This != null) {
			if (model != null) {
				if (Validations.SameModel(This, model)) {
					if (Getters.getValidValuesForUpdate(This, model) != null) {
						String Update = "UPDATE " + model.getModelName();
						for (int i = 0; i < Getters.getValidValuesForUpdate(
								This, model).length; i++) {
							Update += " "
									+ Getters.getValidValuesForUpdate(This,
											model)[i];
						}
						if (Getters.getValidValuesForSelect(This) != null) {
							for (int i = 0; i < Getters
									.getValidValuesForSelect(This).length; i++) {
								Update += " "
										+ Getters.getValidValuesForSelect(This)[i];
							}
						}
						return Update;
					}
				}
			}
		}
		return null;
	}
}
