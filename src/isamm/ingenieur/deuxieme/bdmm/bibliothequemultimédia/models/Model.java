package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models;

import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.dao.DAO;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.utilities.EncryptUtils;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.utilities.KeyWords;
import jTablesClasses.Action;
import jTablesClasses.ButtonsEditor;
import jTablesClasses.ButtonsRenderer;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import oracle.jdbc.driver.OracleResultSet;
import oracle.ord.im.OrdImage;
import oracle.ord.im.OrdImageSignature;
import oracle.ord.im.OrdVideo;

public abstract class Model {

	private Properties Info = null;

	public Model() {
		Info = new Properties();
	}

	public static Model createModel(String ModelName, Object... values) {
		if (Validations.InList(ModelName, Fields.Models)) {
			for (int i = 0; i < Fields.Models.length; i++) {
				if (Fields.Models[i].equals(ModelName)) {
					switch (i) {
					// Auteur
					case 0: {
						if (values.length == 0) {
							return new Auteur();
						} else if (values.length == 1) {
							if (values[0].getClass().getName()
									.equals(Object[].class.getName())) {
								Object Values[] = (Object[]) values[0];
								if (Values.length == Getters
										.getFields(ModelName).length) {
									return new Auteur(Values);
								} else {
									return null;
								}
							} else if (values[0].getClass().getName()
									.equals(ArrayList.class.getName())) {
								ArrayList<Object> Values = (ArrayList<Object>) values[0];
								if (Values.size() == Getters
										.getFields(ModelName).length) {
									return new Auteur(Values);
								} else {
									return null;
								}
							}
						} else {
							if (values.length == Getters.getFields(ModelName).length) {
								return new Auteur(values);
							} else {
								return null;
							}
						}
					}
					// Est_Ecrit
					case 1: {
						if (values == null) {
							return new Est_Ecrit();
						} else if (values.length == 1) {
							if (values[0].getClass().getName()
									.equals(Object[].class.getName())) {
								Object Values[] = (Object[]) values[0];
								if (Values.length == Getters
										.getFields(ModelName).length) {
									return new Est_Ecrit(Values);
								} else {
									return null;
								}
							} else if (values[0].getClass().getName()
									.equals(ArrayList.class.getName())) {
								ArrayList<Object> Values = (ArrayList<Object>) values[0];
								if (Values.size() == Getters
										.getFields(ModelName).length) {
									return new Est_Ecrit(Values);
								} else {
									return null;
								}
							}
						} else {
							if (values.length == Getters.getFields(ModelName).length) {
								return new Est_Ecrit(values);
							} else {
								return null;
							}
						}
					}
					// Etudiant
					case 2: {
						if (values == null) {
							return new Etudiant();
						} else if (values.length == 1) {
							if (values[0].getClass().getName()
									.equals(Object[].class.getName())) {
								Object Values[] = (Object[]) values[0];
								if (Values.length == Getters
										.getFields(ModelName).length) {
									return new Etudiant(Values);
								} else {
									return null;
								}
							} else if (values[0].getClass().getName()
									.equals(ArrayList.class.getName())) {
								ArrayList<Object> Values = (ArrayList<Object>) values[0];
								if (Values.size() == Getters
										.getFields(ModelName).length) {
									return new Etudiant(Values);
								} else {
									return null;
								}
							}
						} else {
							if (values.length == Getters.getFields(ModelName).length) {
								return new Etudiant(values);
							} else {
								return null;
							}
						}
					}
					// Exemplaire
					case 3: {
						if (values == null) {
							return new Exemplaire();
						} else if (values.length == 1) {
							if (values[0].getClass().getName()
									.equals(Object[].class.getName())) {
								Object Values[] = (Object[]) values[0];
								if (Values.length == Getters
										.getFields(ModelName).length) {
									return new Exemplaire(Values);
								} else {
									return null;
								}
							} else if (values[0].getClass().getName()
									.equals(ArrayList.class.getName())) {
								ArrayList<Object> Values = (ArrayList<Object>) values[0];
								if (Values.size() == Getters
										.getFields(ModelName).length) {
									return new Exemplaire(Values);
								} else {
									return null;
								}
							}
						} else {
							if (values.length == Getters.getFields(ModelName).length) {
								return new Exemplaire(values);
							} else {
								return null;
							}
						}
					}
					// Livre
					case 4: {
						if (values == null) {
							return new Livre();
						} else if (values.length == 1) {
							if (values[0].getClass().getName()
									.equals(Object[].class.getName())) {
								Object Values[] = (Object[]) values[0];
								if (Values.length == Getters
										.getFields(ModelName).length) {
									return new Livre(Values);
								} else {
									return null;
								}
							} else if (values[0].getClass().getName()
									.equals(ArrayList.class.getName())) {
								ArrayList<Object> Values = (ArrayList<Object>) values[0];
								if (Values.size() == Getters
										.getFields(ModelName).length) {
									return new Livre(Values);
								} else {
									return null;
								}
							}
						} else {
							if (values.length == Getters.getFields(ModelName).length) {
								return new Livre(values);
							} else {
								return null;
							}
						}
					}
					// Reservation
					case 5: {
						if (values == null) {
							return new Reservation();
						} else if (values.length == 1) {
							if (values[0].getClass().getName()
									.equals(Object[].class.getName())) {
								Object Values[] = (Object[]) values[0];
								if (Values.length == Getters
										.getFields(ModelName).length) {
									return new Reservation(Values);
								} else {
									return null;
								}
							} else if (values[0].getClass().getName()
									.equals(ArrayList.class.getName())) {
								ArrayList<Object> Values = (ArrayList<Object>) values[0];
								if (Values.size() == Getters
										.getFields(ModelName).length) {
									return new Reservation(Values);
								} else {
									return null;
								}
							}
						} else {
							if (values.length == Getters.getFields(ModelName).length) {
								return new Reservation(values);
							} else {
								return null;
							}
						}
					}
					}
				}
			}
		}
		return null;
	}
	
	

	public Model Show() {
		for (int i = 0; i < getFields().length; i++) {
			System.out.println(getFields()[i] + " = " + getValues()[i]);
		}
		return this;
	}

	@SuppressWarnings("unchecked")
	public Model setOperators(String[] Operator) {
		if (Operator != null) {
			if (getProp("Operators") == null) {
				ArrayList<String> Ops = new ArrayList<String>();
				for (int i = 0; i < Operator.length; i++) {
					if (Operator[i] != null && !"".equals(Operator[i])) {
						Ops.add(Operator[i]);
					}
				}
				if (Ops.size() > 0) {
					setNewProp("Operators", Ops);
				}

			} else {
				for (int i = 0; i < Operator.length; i++) {
					if (Operator[i] != null && !"".equals(Operator[i])) {
						((ArrayList<String>) getProp("Operators"))
								.add(Operator[i]);
					}
				}
			}
		}
		return this;
	}

	@SuppressWarnings("unchecked")
	public String[] getOperators() {
		if (getProp("Operators") != null) {
			String[] Return = (String[]) Array.newInstance(String.class,
					((ArrayList<String>) getProp("Operators")).size());
			for (int i = 0; i < ((ArrayList<String>) getProp("Operators"))
					.size(); i++) {
				Return[i] = ((ArrayList<String>) getProp("Operators")).get(i);
			}
			return Return;
		}
		return null;
	}

	public Model eraseOperators() {
		Info.remove("Operators");
		return this;
	}

	public Model setOrderBy(String By, String Order) {
		if (By != null && !"".equals(By) && Order != null && !"".equals(Order)) {
			setString("Order", "ORDER BY " + By + " " + Order);
		}
		return this;
	}

	public String getOrderBy() {
		return getString("Order");
	}

	public Model eraseOrderBy() {
		Info.remove("Order");
		return this;
	}

	public Model setLimit(int Limit) {
		setString("Limit", "LIMIT " + Limit);
		return this;
	}

	public String getLimit() {
		return getString("Limit");
	}

	public Model eraseLimit() {
		Info.remove("Limit");
		return this;
	}

	@SuppressWarnings("unchecked")
	public Model setMoreOf(String Field, Object[] Value) {
		for (int i = 0; i < this.getFields().length; i++) {
			if (getFields()[i].equals(Field)) {
				if (Value != null && !"".equals(Value)) {
					for (int j = 0; j < Value.length; j++) {
						if (Value[j].getClass().getName().equals(getTypes()[i])) {
							if (Value[j] != null && !"".equals(Value[j])) {
								boolean add = true;
								if (Validations.FieldInPrimaryKeysFields(this,
										Field)) {
									if (Value[j].equals(0)) {
										add = false;
									}
								}
								if (getNullableFields() != null) {
									if (Validations.FieldInNullableFields(this,
											Field)) {
										if (Value[j].equals(-1)) {
											add = false;
										}
									}
								}
								if (getUniqueFields() != null) {
									if (Validations.FieldInUniquesFields(this,
											Field)) {
										if (getUniqueFields()[0].equals(Field)) {
											if (!Validations
													.ValidEmailAddress(Value[j])) {
												add = false;
											}
										}
									}
								}
								if (add) {
									if (getProp("MoreOf" + Field) == null) {
										ArrayList<Object> More = new ArrayList<Object>();
										if (Field.equals(Fields.Fields_Pass)) {
											More.add(EncryptUtils
													.base64encode((String) Value[j]));
										} else {
											More.add(Value[j]);
										}
										setNewProp("MoreOf" + Field, More);
									} else {
										if (Field.equals(Fields.Fields_Pass)) {
											((ArrayList<Object>) getProp("MoreOf"
													+ Field))
													.add(EncryptUtils
															.base64encode((String) Value[j]));
										} else {
											((ArrayList<Object>) getProp("MoreOf"
													+ Field)).add(Value[j]);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return this;
	}

	@SuppressWarnings("unchecked")
	public Object[] getMoreOf(String Field) {
		if (getProp("MoreOf" + Field) != null) {
			Object[] Return = (Object[]) Array.newInstance(Object.class,
					((ArrayList<Object>) getProp("MoreOf" + Field)).size());
			for (int i = 0; i < ((ArrayList<Object>) getProp("MoreOf" + Field))
					.size(); i++) {
				Return[i] = ((ArrayList<Object>) getProp("MoreOf" + Field))
						.get(i);
			}
			return Return;
		}
		return null;
	}

	public String generateSQLDelete() {
		return Generate.SQLDelete(this);
	}

	public String generateSQLInsert() {
		return Generate.SQLInsert(this);
	}

	public String generateSQLSelect() {
		return Generate.SQLSelect(this);
	}

	public String generateSQLUpdate(Model model) {
		return Generate.SQLUpdate(this, model);
	}

	public int getNewID() {
		return DAO.getNewID(this);
	}

	public int add() {
		return DAO.add(this);
	}

	public Object get() {
		return DAO.get(this, true);
	}
	
	public Model getOne(){
		Object model = get();
		if(model != null){
			if(Validations.isModel(model)){
				return (Model)model;
			}else{
				return ((ArrayList<Model>)model).get(0);
			}
		}
		return null;
	}
	
	public ArrayList<Model> getArrayList(){
		Object model = get();
		if(model != null){
			if(Validations.isModel(model)){
				return new ArrayList<Model>(Arrays.asList((Model)model));
			}else{
				return ((ArrayList<Model>)model);
			}
		}
		return null;
	}
	
	public Object[] getArray(){
		Object model = get();
		if(model != null){
			if(Validations.isModel(model)){
				return new Model[]{(Model)model};
			}else{
				return ((ArrayList<Model>)model).toArray();
			}
		}
		return null;
	}

	public OracleResultSet getRS() {
		return DAO.get(get());
	}

	@SuppressWarnings("unchecked")
	public String generateSQLSelectFromList() {
		Object values = get();
		if (values != null) {
			if (Validations.isModel(values)) {
				return ((Model) values).generateSQLSelect();
			} else {
				return Generate.SQLSelectFromList((ArrayList<Model>) values);
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Object[][] getPreparedDataToshow() {
		Object values = get();
		if (values != null) {
			if (Validations.isModel(values)) {
				Object[][] Return = { ((Model) values).getValuesToShow() };
				for (int i = 0; i < Return.length; i++) {
					for (int j = 0; j < Return[i].length; j++) {
						System.out.print(Return[i][j] + " ");
					}
					System.out.println();
				}
				return Return;
			} else {
				Object[][] Return = (Object[][]) Array.newInstance(
						Object[].class, ((ArrayList<Model>) values).size());
				for (int i = 0; i < ((ArrayList<Model>) values).size(); i++) {
					Return[i] = ((ArrayList<Model>) values).get(i)
							.getValuesToShow();
				}
				return Return;
			}
		}
		return null;
	}

	public int delete() {
		return DAO.delete(this);
	}

	public int update(Model model) {
		return DAO.update(this, model);
	}

	public Object getLivres() {
		return null;
	}

	public Object getExemplaires() {
		return null;
	}

	public Object getReservations() {
		return null;
	}

	public Object getAuteurs() {
		return null;
	}

	public void eraseMoreOf(String Field) {
		Info.remove("MoreOf" + Field);
	}

	public String getModelName() {
		return Getters.getModelName(this);
	}

	public boolean isAuteur() {
		return false;
	}

	public boolean isEst_Ecrit() {
		return false;
	}

	public boolean isEtudiant() {
		return false;
	}

	public boolean isExemplaire() {
		return false;
	}

	public boolean isLivre() {
		return false;
	}

	public boolean isReservation() {
		return false;
	}

	public String[] getPrimaryKeysFields() {
		return Getters.getPrimaryKeysFields(this);
	}

	public Object[] getPrimaryKeysValues() {
		return Getters.getPrimaryKeysValues(this);
	}

	public String[] getUniqueFields() {
		return Getters.getUniqueFields(this);
	}

	public Object[] getUniqueValues() {
		return Getters.getUniqueValues(this);
	}

	public String[] getNullableFields() {
		return Getters.getNullableFields(this);
	}

	public Object[] getNullableValues() {
		return Getters.getNullableValues(this);
	}

	public String[] getAuto_IncrementFields() {
		return Getters.getAutoIncrementFields(this);
	}

	public Object[] getAuto_IncrementValues() {
		return Getters.getAutoIncrementValues(this);
	}

	public String[] getFields() {
		return Getters.getFields(this);
	}

	public String[] getFieldsToShow() {
		return Getters.getFieldsToShow(this);
	}
	
	public String[] getSimpleFieldsToShow() {
		return Getters.getSimpleFieldsToShow(this);
	}

	public Object[] getValuesToShow() {
		return Getters.getValuesToShow(this);
	}

	public int getActionFieldIndex() {
		return getFieldsToShow().length - 1;
	}
	
	public JTable setJTable(JTable table,JTable Management){
		TableColumn Action = table.getColumnModel().getColumn(getActionFieldIndex());
		if(isAuteur()){
			table.setRowHeight(100);
			TableColumn Image = table.getColumnModel().getColumn(getImageFieldIndex());
			Image.setCellRenderer(new ButtonsRenderer(Arrays.asList(new JButton()), Arrays.asList("Afficher")));
			Image.setCellEditor(new ButtonsEditor(table, Arrays.asList(new JButton()), Arrays.asList((AbstractAction)new Action(table, this, "Afficher",KeyWords._ShowImage,Management)), Arrays.asList("Afficher")));
			TableColumn Video = table.getColumnModel().getColumn(getVideoFieldIndex());
			Video.setCellRenderer(new ButtonsRenderer(Arrays.asList(new JButton()), Arrays.asList("Afficher")));
			Video.setCellEditor(new ButtonsEditor(table, Arrays.asList(new JButton()), Arrays.asList((AbstractAction)new Action(table, this, "Afficher",KeyWords._ShowVideo,Management)), Arrays.asList("Afficher")));
			if(getLinkAction() == null){
			Action.setCellRenderer(new ButtonsRenderer(Arrays.asList(new JButton(),new JButton(),new JButton(),new JButton()), Arrays.asList("delete","update","Livres","Add Livre")));
			Action.setCellEditor(new ButtonsEditor(table, Arrays.asList(new JButton(),new JButton(),new JButton(),new JButton()), Arrays.asList((AbstractAction)new Action(table, this, "delete",KeyWords._Delete,Management),(AbstractAction)new Action(table, this.setUpdateAction(), "update",KeyWords._Update,Management),(AbstractAction)new Action(table, this, "Livres",KeyWords._ShowLivres,Management),(AbstractAction)new Action(table, this, "Add Livre",KeyWords._AddLivre,Management)), Arrays.asList("delete","update","Livres","Add Livre")));
			}else{
				Action.setCellRenderer(new ButtonsRenderer(Arrays.asList(new JButton(),new JButton(),new JButton(),new JButton(),new JButton()), Arrays.asList("delete","deleteLink","update","Livres","Add Livre")));
				Action.setCellEditor(new ButtonsEditor(table, Arrays.asList(new JButton(),new JButton(),new JButton(),new JButton(),new JButton()), Arrays.asList((AbstractAction)new Action(table, this, "delete",KeyWords._Delete,Management),(AbstractAction)new Action(table, this, "deleteLink",KeyWords._DeleteLink,Management),(AbstractAction)new Action(table, this.setUpdateAction(), "update",KeyWords._Update,Management),(AbstractAction)new Action(table, this, "Livres",KeyWords._ShowLivres,Management),(AbstractAction)new Action(table, this, "Add Livre",KeyWords._AddLivre,Management)), Arrays.asList("delete","deleteLink","update","Livres","Add Livre")));
			}
		}if(isEst_Ecrit()){
			table.setRowHeight(40);
			Action.setCellRenderer(new ButtonsRenderer(Arrays.asList(new JButton()), Arrays.asList("delete")));
			Action.setCellEditor(new ButtonsEditor(table, Arrays.asList(new JButton()), Arrays.asList((AbstractAction)new Action(table, this, "delete",KeyWords._Delete,Management)), Arrays.asList("delete")));
		}if(isEtudiant()){
			table.setRowHeight(210);
			Action.setResizable(true);
			Action.setWidth(200);
			if(getLinkAction() != null){
			Action.setCellRenderer(new ButtonsRenderer(Arrays.asList(new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton()), Arrays.asList("delete","deleteLink","update","Reservations","Emprunts","Reserver","Emprunter")));
			Action.setCellEditor(new ButtonsEditor(table, Arrays.asList(new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton()), Arrays.asList((AbstractAction)new Action(table, this, "delete",KeyWords._Delete,Management),(AbstractAction)new Action(table, this, "deleteLink",KeyWords._DeleteLink,Management),(AbstractAction)new Action(table, this.setUpdateAction(), "update",KeyWords._Update,Management),(AbstractAction)new Action(table, this, "Reservations",KeyWords._ShowReservation,Management),(AbstractAction)new Action(table, this, "Emprunts",KeyWords._ShowEmprunt,Management),(AbstractAction)new Action(table, this, "Reserver",KeyWords._ReserverLivre,Management),(AbstractAction)new Action(table, this, "Emprunter",KeyWords._EmpruntLivre,Management)), Arrays.asList("delete","deleteLink","update","Reservations","Emprunts","Reserver","Emprunter")));
			}else{
				Action.setCellRenderer(new ButtonsRenderer(Arrays.asList(new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton()), Arrays.asList("delete","update","Reservations","Emprunts","Reserver","Emprunter")));
				Action.setCellEditor(new ButtonsEditor(table, Arrays.asList(new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton()), Arrays.asList((AbstractAction)new Action(table, this, "delete",KeyWords._Delete,Management),(AbstractAction)new Action(table, this.setUpdateAction(), "update",KeyWords._Update,Management),(AbstractAction)new Action(table, this, "Reservations",KeyWords._ShowReservation,Management),(AbstractAction)new Action(table, this, "Emprunts",KeyWords._ShowEmprunt,Management),(AbstractAction)new Action(table, this, "Reserver",KeyWords._ReserverLivre,Management),(AbstractAction)new Action(table, this, "Emprunter",KeyWords._EmpruntLivre,Management)), Arrays.asList("delete","update","Reservations","Emprunts","Reserver","Emprunter")));
			}
		}if(isExemplaire()){
			Action.setCellRenderer(new ButtonsRenderer(Arrays.asList(new JButton()), Arrays.asList("delete")));
			Action.setCellEditor(new ButtonsEditor(table, Arrays.asList(new JButton()), Arrays.asList((AbstractAction)new Action(table, this, "delete",KeyWords._Delete,Management)), Arrays.asList("delete")));
		}if(isLivre()){
			table.setRowHeight(240);
			TableColumn Image = table.getColumnModel().getColumn(getImageFieldIndex());
			Image.setCellRenderer(new ButtonsRenderer(Arrays.asList(new JButton()), Arrays.asList("Afficher")));
			Image.setCellEditor(new ButtonsEditor(table, Arrays.asList(new JButton()), Arrays.asList((AbstractAction)new Action(table, this, "Afficher",KeyWords._ShowImage,Management)), Arrays.asList("Afficher")));
			if(getLinkAction() != null){
				Action.setCellRenderer(new ButtonsRenderer(Arrays.asList(new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton()), Arrays.asList("delete","deleteLink","update","Auteurs","Add Auteur","Reservations","Emprunts","Reserver","Emprunter")));
				Action.setCellEditor(new ButtonsEditor(table, Arrays.asList(new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton()), Arrays.asList((AbstractAction)new Action(table, this, "delete",KeyWords._Delete,Management),(AbstractAction)new Action(table, this, "deleteLink",KeyWords._DeleteLink,Management),(AbstractAction)new Action(table, this.setUpdateAction(), "update",KeyWords._Update,Management),(AbstractAction)new Action(table, this, "Auteurs",KeyWords._LivreAuteur,Management),(AbstractAction)new Action(table, this, "Add Auteur",KeyWords._AddAuteur,Management),(AbstractAction)new Action(table, this, "Reservations",KeyWords._ShowReservation,Management),(AbstractAction)new Action(table, this, "Emprunts",KeyWords._ShowEmprunt,Management),(AbstractAction)new Action(table, this, "Reserver",KeyWords._ReserverLivre,Management),(AbstractAction)new Action(table, this, "Emprunter",KeyWords._EmpruntLivre,Management)), Arrays.asList("delete","deleteLink","update","Auteurs","Add Auteur","Reservations","Emprunts","Reserver","Emprunter")));
			}else{
			Action.setCellRenderer(new ButtonsRenderer(Arrays.asList(new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton()), Arrays.asList("delete","update","Auteurs","Add Auteur","Reservations","Emprunts","Reserver","Emprunter")));
			Action.setCellEditor(new ButtonsEditor(table, Arrays.asList(new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton()), Arrays.asList((AbstractAction)new Action(table, this, "delete",KeyWords._Delete,Management),(AbstractAction)new Action(table, this.setUpdateAction(), "update",KeyWords._Update,Management),(AbstractAction)new Action(table, this, "Auteurs",KeyWords._LivreAuteur,Management),(AbstractAction)new Action(table, this, "Add Auteur",KeyWords._AddAuteur,Management),(AbstractAction)new Action(table, this, "Reservations",KeyWords._ShowReservation,Management),(AbstractAction)new Action(table, this, "Emprunts",KeyWords._ShowEmprunt,Management),(AbstractAction)new Action(table, this, "Reserver",KeyWords._ReserverLivre,Management),(AbstractAction)new Action(table, this, "Emprunter",KeyWords._EmpruntLivre,Management)), Arrays.asList("delete","update","Auteurs","Add Auteur","Reservations","Emprunts","Reserver","Emprunter")));
			}
		}if(isReservation()){
			Action.setCellRenderer(new ButtonsRenderer(Arrays.asList(new JButton()), Arrays.asList("delete")));
			Action.setCellEditor(new ButtonsEditor(table, Arrays.asList(new JButton()), Arrays.asList((AbstractAction)new Action(table, this, "delete",KeyWords._Delete,Management)), Arrays.asList("delete")));
		}
		return table;
	}
	
	public JTable repaint(JTable table,JTable management){
		DefaultTableModel tablemodel = (DefaultTableModel)table.getModel();
		tablemodel.setDataVector(getPreparedDataToshow(), getFieldsToShow());
		table = setJTable(table,management);
		return table;
	}
	
	public Object[] ValuestoArray(){
		Object[] values = new Object[getFields().length];
		for(int i=0;i<values.length;i++){
			values[i] = getProp(getFields()[i]);
		}
		return values;
	}
	
	public JTable makeMJTable(){
		String[] columnNames = getSimpleFieldsToShow();
		Object[][] data = new Object[][]{getValuesToShow()};
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		JTable AuteurJT = new JTable(model);
		AuteurJT.setAutoCreateRowSorter(true);
		return AuteurJT;
	}
	
	public JTable repaintMJTable(JTable Manage){
		DefaultTableModel tablemodel = (DefaultTableModel)Manage.getModel();
		tablemodel.setDataVector(new Object[][]{getValuesToShow()}, getSimpleFieldsToShow());
		return Manage;
	}
	
	public Model getModelFromJTable(Model model, JTable table, String Action) {
		if (model != null) {
			if (model.isAuteur()) {
				if (Action.equals(KeyWords._Add)) {
					model.setNum_Personne(model.getNewID());
				}
				if (Action.equals(KeyWords._Filter)) {
                    if(table.getValueAt(0, 0) != null){
                    	if(table.getValueAt(0, 0).getClass().getName().equals(Fields.Types_Integer)){
                    		model.setNum_Personne((int)table.getValueAt(0, 0));
                    	}if(table.getValueAt(0, 0).getClass().getName().equals(Fields.Types_String)){
                    		try{
                    			int num = Integer.parseInt((String)table.getValueAt(0, 0));
                    			model.setNum_Personne(num);
                    		}catch(Exception x){
                    			
                    		}
                    	}
                    }
				}
				if (Action.equals(KeyWords._Update)) {
					if(table.getValueAt(0, 0) != null){
                    	if(table.getValueAt(0, 0).getClass().getName().equals(Fields.Types_Integer)){
                    		model.setNum_Personne((int)table.getValueAt(0, 0));
                    	}if(table.getValueAt(0, 0).getClass().getName().equals(Fields.Types_String)){
                    		try{
                    			int num = Integer.parseInt((String)table.getValueAt(0, 0));
                    			model.setNum_Personne(num);
                    		}catch(Exception x){
                    			
                    		}
                    	}
                    }
				}
				model.setNom(table.getValueAt(0, 1));
				model.setPrenom(table.getValueAt(0, 2));
				model.setAdresse(table.getValueAt(0, 3));
				model.setMail(table.getValueAt(0, 4));
				if(table.getValueAt(0, 5) != null){
					model.setURLImage(table.getValueAt(0, 5));
				}if(table.getValueAt(0, 6) != null){
					model.setURLVideo(table.getValueAt(0, 6));
				}
			}
			if (model.isEtudiant()) {
				if (Action.equals(KeyWords._Add)) {
					model.setNum_Personne(model.getNewID());
				}
				if (Action.equals(KeyWords._Filter)) {
                    if(table.getValueAt(0, 0) != null){
                    	if(table.getValueAt(0, 0).getClass().getName().equals(Fields.Types_Integer)){
                    		model.setNum_Personne((int)table.getValueAt(0, 0));
                    	}if(table.getValueAt(0, 0).getClass().getName().equals(Fields.Types_String)){
                    		try{
                    			int num = Integer.parseInt((String)table.getValueAt(0, 0));
                    			model.setNum_Personne(num);
                    		}catch(Exception x){
                    			
                    		}
                    	}
                    }
				}
				if (Action.equals(KeyWords._Update)) {
					if(table.getValueAt(0, 0) != null){
                    	if(table.getValueAt(0, 0).getClass().getName().equals(Fields.Types_Integer)){
                    		model.setNum_Personne((int)table.getValueAt(0, 0));
                    	}if(table.getValueAt(0, 0).getClass().getName().equals(Fields.Types_String)){
                    		try{
                    			int num = Integer.parseInt((String)table.getValueAt(0, 0));
                    			model.setNum_Personne(num);
                    		}catch(Exception x){
                    			
                    		}
                    	}
                    }
				}
				model.setNom(table.getValueAt(0, 1));
				model.setPrenom(table.getValueAt(0, 2));
				model.setAdresse(table.getValueAt(0, 3));
				model.setMail(table.getValueAt(0, 4));
				model.setLogin(table.getValueAt(0, 5));
				model.setPass(table.getValueAt(0, 6));
				if(table.getValueAt(0, 7) != null)
				{
					if(table.getValueAt(0, 7).getClass().getName().equals(Fields.Types_Date)){
						model.setDate_Validite_Carte(table.getValueAt(0, 7));
					}if(table.getValueAt(0, 7).getClass().getName().equals(java.util.Date.class.getName())){
						model.setDate_Validite_Carte(new Date(((java.util.Date)table.getValueAt(0, 7)).getTime()));
					}if(table.getValueAt(0, 7).getClass().getName().equals(Fields.Types_String)){
						if(!table.getValueAt(0, 7).equals("")){
							model.setDate_Validite_Carte(new Date(new java.util.Date((String)table.getValueAt(0, 7)).getTime()));
						}
					}
				}
				if(table.getValueAt(0, 8) != null){
					if(table.getValueAt(0, 8).getClass().getName().equals(Fields.Types_Integer)){
						model.setNb_Emprunt(table.getValueAt(0, 8));
					}
					if(table.getValueAt(0, 8).getClass().getName().equals(Fields.Types_String)){
						try{
							int num = Integer.parseInt((String)table.getValueAt(0, 8));
						    model.setNb_Emprunt(num);
						}catch(Exception x){
							
						}
					}
				}
			}
			if (model.isLivre()) {
                 model.setISBN(table.getValueAt(0, 0));
                 model.setTitre(table.getValueAt(0, 1));
 				if(table.getValueAt(0, 2) != null)
 				{
 					if(table.getValueAt(0, 2).getClass().getName().equals(Fields.Types_Date)){
 						model.setDate_Publication(table.getValueAt(0, 2));
 					}if(table.getValueAt(0, 2).getClass().getName().equals(java.util.Date.class.getName())){
 						model.setDate_Publication(new Date(((java.util.Date)table.getValueAt(0, 2)).getTime()));
 					}if(table.getValueAt(0, 2).getClass().getName().equals(Fields.Types_String)){
 						if(!table.getValueAt(0, 2).equals("")){
 							model.setDate_Publication(new Date(new java.util.Date((String)table.getValueAt(0, 2)).getTime()));
 						}
 					}
 				}
 				model.setEditeur(table.getValueAt(0, 3));
 				model.setLots_Cles(table.getValueAt(0, 4));
 				if(table.getValueAt(0, 5) != null){
					if(table.getValueAt(0, 5).getClass().getName().equals(Fields.Types_Integer)){
						model.setNb_Exemplaire(table.getValueAt(0, 5));
					}
					if(table.getValueAt(0, 5).getClass().getName().equals(Fields.Types_String)){
						try{
							int num = Integer.parseInt((String)table.getValueAt(0, 5));
						    model.setNb_Exemplaire(num);
						}catch(Exception x){
							
						}
					}
				}
 				if(table.getValueAt(0, 6) != null){
					model.setURLImage(table.getValueAt(0, 6));
				}
			}
		}
		return model;
	}
	
	public static Model toOneModel(Object model,String... What){
		if(model != null){
			if(Validations.isModel(model)){
				if(What != null && What.length > 0){
				return ((Model)model).getModel(What[0]);
				}else{
					return ((Model)model);
				}
			}else{
			    Model Model = null;
			    if(What != null && What.length > 0){
				if(model.getClass().getName().equals(Model[].class.getName())){
					Model[] models = (Model[])model;
					for(int i=0;i<models.length;i++){
						if(i==0){
							Model = Model.createModel(models[i].getModel(What[0]).getModelName(), models[i].getModel(What[0]).ValuestoArray());
						}else{
							for(int j=0;j<models[i].getModel(What[0]).getFields().length;j++){
								Model.setMoreOf(models[i].getModel(What[0]).getFields()[i], new Object[]{models[i].getModel(What[0]).ValuestoArray()[i]});
							}
						}
					}
				}else{
					ArrayList<Model> models = (ArrayList<Model>)model;
					for(int i=0;i<models.size();i++){
						if(i==0){
							Model = Model.createModel(models.get(i).getModel(What[0]).getModelName(), models.get(i).getModel(What[0]).ValuestoArray());
						}else{
							for(int j=0;j<models.get(i).getModel(What[0]).getFields().length;j++){
								Model.setMoreOf(models.get(i).getModel(What[0]).getFields()[i], new Object[]{models.get(i).getModel(What[0]).ValuestoArray()[i]});
							}
						}
					}
				}
			    }else{
					if(model.getClass().getName().equals(Model[].class.getName())){
						Model[] models = (Model[])model;
						for(int i=0;i<models.length;i++){
							if(i==0){
								Model = Model.createModel(models[i].getModelName(), models[i].ValuestoArray());
							}else{
								for(int j=0;j<models[i].getFields().length;j++){
									Model.setMoreOf(models[i].getFields()[i], new Object[]{models[i].ValuestoArray()[i]});
								}
							}
						}
					}else{
						ArrayList<Model> models = (ArrayList<Model>)model;
						for(int i=0;i<models.size();i++){
							if(i==0){
								Model = Model.createModel(models.get(i).getModelName(), models.get(i).ValuestoArray());
							}else{
								for(int j=0;j<models.get(i).getFields().length;j++){
									Model.setMoreOf(models.get(i).getFields()[i], new Object[]{models.get(i).ValuestoArray()[i]});
								}
							}
						}
					}
			    }
				return Model;
			}
		}
		return null;
	}

	public int getImageFieldIndex() {
		if (isAuteur() || isLivre()) {
			if (isAuteur()) {
				return getFieldsToShow().length - 3;
			} else {
				return getFieldsToShow().length - 2;
			}
		}
		return -1;
	}

	public int getVideoFieldIndex() {
		if (isAuteur()) {
			return getFieldsToShow().length - 2;
		}
		return -1;
	}

	public String[] getTypes() {
		return Getters.getTypes(this);
	}

	public Object[] getValues() {
		return Getters.getValues(this);
	}

	public Model setProp(String Key, Object Value) {
		Setters.setPropStatic(this, Info, Key, Value);
		return this;
	}

	public String getDecryptedPass() {
		return null;
	}

	public Model setNewProp(String key, Object value) {
		Setters.setPropStatic(Info, key, value);
		return this;
	}

	public Object getProp(String Key) {
		return Getters.getPropStatic(Info, Key);
	}

	public int getInteger(String key, boolean Nullable) {
		return Getters.getInteger(Info, key, Nullable);
	}

	public Model setInteger(String key, Object value, boolean Nullable) {
		Setters.setInteger(Info, key, value, Nullable);
		return this;
	}

	public String getString(String key) {
		return Getters.getString(Info, key);
	}
	
	public String DecryptPass(Object Pass){
	   return null;	
	}
	
	public String EncryptPass(Object Pass){
		return null;
	}

	public Model setString(String key, Object value) {
		Setters.setString(Info, key, value);
		return this;
	}

	public Date getDate(String key) {
		return Getters.getDate(Info, key);
	}

	public Model setDate(String key, Object value) {
		Setters.setDate(Info, key, value);
		return this;
	}

	public OrdImage getOrdImage(String key) {
		return Getters.getOrdImage(Info, key);
	}

	public Model setOrdImage(String key, Object value) {
		Setters.setOrdImage(Info, key, value);
		return this;
	}

	public Model setOrdImageSignature(String Key, Object value) {
		Setters.setOrdImageSignature(Info, Key, value);
		return this;
	}

	public OrdImageSignature getOrdImageSignature(String Key) {
		return Getters.getOrdImageSignature(Info, Key);
	}

	public OrdVideo getOrdVideo(String key) {
		return Getters.getOrdVideo(Info, key);
	}

	public Model setOrdVideo(String key, Object value) {
		Setters.setOrdVideo(Info, key, value);
		return this;
	}

	public Auteur getAuteur(String key) {
		return Getters.getAuteur(Info, key);
	}

	public Model setAuteur(String key, Object value) {
		Setters.setAuteur(Info, key, value);
		return this;
	}

	public Est_Ecrit getEst_Ecrit(String key) {
		return Getters.getEst_Ecrit(Info, key);
	}

	public Model setEst_Ecrit(String key, Object value) {
		Setters.setEst_Ecrit(Info, key, value);
		return this;
	}

	public Etudiant getEtudiant(String key) {
		return Getters.getEtudiant(Info, key);
	}

	public Model setEtudiant(String key, Object value) {
		Setters.setEtudiant(Info, key, value);
		return this;
	}

	public Exemplaire getExemplaire(String key) {
		return Getters.getExemplaire(Info, key);
	}

	public Model setExemplaire(String key, Object value) {
		Setters.setExemplaire(Info, key, value);
		return this;
	}

	public Livre getLivre(String key) {
		return Getters.getLivre(Info, key);
	}

	public Model setLivre(String key, Object value) {
		Setters.setLivre(Info, key, value);
		return this;
	}

	public Reservation getReservation(String key) {
		return Getters.getReservation(Info, key);
	}

	public Model setReservation(String key, Object value) {
		Setters.setReservation(Info, key, value);
		return this;
	}

	public Model getModel(String key) {
		return Getters.getModel(Info, key);
	}

	public Model setModel(String key, Object value) {
		Setters.setModel(Info, key, value);
		return this;
	}

	public String getFormattedDate(Date date) {
		return null;
	}

	public OrdImage getImage() {
		return null;
	}

	public Object[] getMoreOfImage() {

		return null;
	}

	public OrdImageSignature getSignature() {
		return null;
	}

	public Object[] getMoreOfSignature() {
		return null;
	}

	public OrdVideo getVideo() {
		return null;
	}

	public Object[] getMoreOfVideo() {

		return null;
	}

	public String getURLImage() {
		return null;
	}

	public int getNum_Personne() {
		return 0;
	}

	public Object[] getMoreOfNum_Personne() {

		return null;
	}

	public String getNom() {
		return null;
	}

	public Object[] getMoreOfNom() {

		return null;
	}

	public String getPrenom() {
		return null;
	}

	public Object[] getMoreOfPrenom() {

		return null;
	}

	public String getAdresse() {
		return null;
	}

	public Object[] getMoreOfAdresse() {

		return null;
	}

	public String getMail() {
		return null;
	}

	public Object[] getMoreOfMail() {

		return null;
	}

	public Auteur getRef_Auteur() {
		return null;
	}

	public Object[] getMoreOfRef_Auteur() {

		return null;
	}

	public Livre getRef_Livre() {
		return null;
	}

	public Object[] getMoreOfRef_Livre() {

		return null;
	}

	public Date getDate_Validite_Carte() {
		return null;
	}

	public Object[] getMoreOfDate_Validite_Carte() {

		return null;
	}

	public String getLogin() {
		return null;
	}

	public Object[] getMoreOfLogin() {

		return null;
	}

	public int getNb_Emprunt() {
		return -1;
	}

	public Object[] getMoreOfNb_Emprunt() {

		return null;
	}

	public String getPass() {
		return null;
	}

	public Object[] getMoreOfPass() {

		return null;
	}

	public Etudiant getRef_Etudiant() {
		return null;
	}

	public Object[] getMoreOfRef_Etudiant() {

		return null;
	}

	public Date getDate_Retour() {
		return null;
	}

	public Object[] getMoreOfDate_Retour() {

		return null;
	}

	public Date getDate_Sortie() {
		return null;
	}

	public Object[] getMoreOfDate_Sortie() {

		return null;
	}

	public String getISBN() {
		return null;
	}

	public Object[] getMoreOfISBN() {

		return null;
	}

	public String getTitre() {
		return null;
	}

	public Object[] getMoreOfTitre() {

		return null;
	}

	public Date getDate_Publication() {
		return null;
	}

	public Object[] getMoreOfDate_Publication() {

		return null;
	}

	public String getEditeur() {
		return null;
	}

	public Object[] getMoreOfEditeur() {

		return null;
	}

	public String getLots_Cles() {
		return null;
	}

	public Object[] getMoreOfLots_Cles() {

		return null;
	}

	public int getNb_Exemplaires() {
		return -1;
	}

	public Object[] getMoreOfNb_Exemplaire() {

		return null;
	}

	public Date getDate_Reservation() {
		return null;
	}

	public Object[] getMoreOfDate_Reservation() {

		return null;
	}

	public String getURLVideo() {
		return null;
	}

	public Model setAdresse(Object Adresse) {

		return this;
	}

	public Model setMoreOfAdresse(Object[] values) {

		return this;
	}

	public Model setDate_Publication(Object Date_Publication) {

		return this;
	}

	public Model setMoreOfDate_Publication(Object[] values) {

		return this;
	}

	public Model setDate_Reservation(Object Date_Reservation) {

		return this;
	}

	public Model setMoreOfDate_Reservation(Object[] values) {

		return this;
	}

	public Model setDate_Retour(Object Date_Retour) {

		return this;
	}

	public Model setMoreOfDate_Retour(Object[] values) {

		return this;
	}

	public Model setDate_Sortie(Object Date_Sortie) {

		return this;
	}

	public Model setMoreOfDate_Sortie(Object[] values) {

		return this;
	}

	public Model setDate_Validite_Carte(Object Date_Validite_Carte) {

		return this;
	}

	public Model setMoreOfDate_Validite_Carte(Object[] values) {

		return this;
	}

	public Model setEditeur(Object Editeur) {

		return this;
	}

	public Model setMoreOfEditeur(Object[] values) {

		return this;
	}

	public Model setImage(Object Image) {

		return this;
	}

	public Model setMoreOfImage(Object[] values) {

		return this;
	}

	public Model setSignature(Object Signature) {

		return this;
	}

	public Model setMoreOfSignature(Object[] values) {

		return this;
	}

	public Model setISBN(Object ISBN) {

		return this;
	}

	public Model setMoreOfISBN(Object[] values) {

		return this;
	}

	public Model setLogin(Object Login) {

		return this;
	}

	public Model setMoreOfLogin(Object[] values) {

		return this;
	}

	public Model setLots_Cles(Object Lots_Cles) {

		return this;
	}

	public Model setMoreOfLots_Cles(Object[] values) {

		return this;
	}

	public Model setMail(Object Mail) {

		return this;
	}

	public Model setMoreOfMail(Object[] values) {

		return this;
	}

	public Model setNb_Emprunt(Object Nb_Emprunt) {

		return this;
	}

	public Model setMoreOfNb_Emprunt(Object[] values) {

		return this;
	}

	public Model setNb_Exemplaire(Object Nb_Exemplaires) {

		return this;
	}

	public Model setMoreOfNb_Exemplaire(Object[] values) {

		return this;
	}

	public Model setNom(Object Nom) {

		return this;
	}

	public Model setMoreOfNom(Object[] values) {

		return this;
	}

	public Model setNum_Personne(Object Num_Personne) {

		return this;
	}

	public Model setMoreOfNum_Personne(Object[] values) {

		return this;
	}

	public Model setPass(Object Pass) {

		return this;
	}

	public Model setMoreOfPass(Object[] values) {

		return this;
	}

	public Model setPrenom(Object Prenom) {

		return this;
	}

	public Model setMoreOfPrenom(Object[] values) {

		return this;
	}

	public Model setRef_Auteur(Object Ref_Auteur) {

		return this;
	}

	public Model setMoreOfRef_Auteur(Object[] values) {

		return this;
	}

	public Model setRef_Etudiant(Object Ref_Etudiant) {

		return this;
	}

	public Model setMoreOfRef_Etudiant(Object[] values) {

		return this;
	}

	public Model setRef_Livre(Object Ref_Livre) {

		return this;
	}

	public Model setMoreOfRef_Livre(Object[] values) {

		return this;
	}

	public Model setTitre(Object Titre) {

		return this;
	}

	public Model setMoreOfTitre(Object[] values) {

		return this;
	}

	public Model setURLImage(Object URL) {

		return this;
	}

	public Model setURLVideo(Object URL) {

		return this;
	}

	public Model setVideo(Object Video) {

		return this;
	}
	
	public Model setRef(Object model){
		
		return this;
	}

	public Model setMoreOfVideo(Object[] values) {

		return this;
	}
	
	@Override
	public String toString() {
		return null;
	}
	
	public Model setAction(String Action){
		Setters.setPropStatic(Info, "Action", Action);
		return this;
	}
	
	public Model setUpdateAction(){
		Setters.setPropStatic(Info, "Action", "Update");
		return this;
	}
	
	public Model setAddAction(){
		Setters.setPropStatic(Info, "Action", "Add");
		return this;
	}
	
	public Model setFilterAction(){
		Setters.setPropStatic(Info, "Action", "Filter");
		return this;
	}
	
	public boolean isAction(String Action){
		String action = getAction();
		if(Action != null){
			if(action.equals(Action)){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
	
	public boolean isActionUpdate(){
		return isAction("Update");
	}
	
	public boolean isActionAdd(){
		return isAction("Add");
	}
	
	public boolean isActionFilter(){
		return isAction("Filter");
	}
	
	public Model setLinkAction(Object Link){
		if(Validations.isModel(Link)){
		Setters.setPropStatic(Info, "ActionLink", Link);
		}
		return this;
	}
	
	public Model getLinkAction(){
		Object link = getProp("ActionLink");
		if(link != null){
			return (Model)link;
		}
		return null;
	}
	
	public Model setLink(Object model){
		if(Validations.isModel(model)){
		Setters.setPropStatic(Info, "Link", model);
		}
		return this;
	}
	
	public Model getLink(){
		Object link = getProp("Link");
		if(link != null){
			return (Model)link;
		}
		return null; 
	}
	
	public String getAction(){
		Object Action = Getters.getPropStatic(Info, "Action");
		if(Action != null){
			return (String)Action;
		}
		return null;
	}
	
	//public Model setInnerAction()
}