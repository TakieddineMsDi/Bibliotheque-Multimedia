package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.dao;

import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.frames.ShowMessage;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Auteur;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Est_Ecrit;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Etudiant;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Exemplaire;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Fields;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Getters;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Livre;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Model;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Reservation;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Validations;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Generate;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.utilities.ConnectionClass;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.utilities.KeyWords;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import oracle.jdbc.driver.OraclePreparedStatement;
import oracle.jdbc.driver.OracleResultSet;
import oracle.ord.im.OrdImage;
import oracle.ord.im.OrdImageSignature;
import oracle.ord.im.OrdVideo;

public class DAO {

	public static int executeUpdate(String SQL, String Who) {
		new ConnectionClass();
		if (ConnectionClass.getStatus(KeyWords._Check).toString()
				.equals(KeyWords._Success)) {
			try {
				Statement stmt = ConnectionClass.getConnection()
						.createStatement();
				stmt.executeUpdate(SQL);
				stmt.close();
				return 1;
			} catch (Exception e) {
				new ShowMessage("executeUpdate Called By : " + Who
						+ " executing SQL : " + SQL, e.getMessage(), e);
			}
		} else {
			new ShowMessage("Connection Problem From executeUpdate Called By "
					+ Who, ConnectionClass.getStatus(KeyWords._Get).toString(),
					null);
			return -1;
		}
		return 0;
	}

	public static OracleResultSet executeQuery(String SQL, String Who) {
		new ConnectionClass();
		if (ConnectionClass.getStatus(KeyWords._Check).toString()
				.equals(KeyWords._Success)) {
			try {
				Statement stmt = ConnectionClass.getConnection()
						.createStatement();
				OracleResultSet rset = (OracleResultSet) stmt.executeQuery(SQL);
				return rset;
			} catch (SQLException e) {
				new ShowMessage("executeQuery Called By : " + Who
						+ " executing SQL : " + SQL, e.getMessage(), e);
				return null;
			}
		} else {
			new ShowMessage("Connection Problem From executeQuery Called By "
					+ Who, ConnectionClass.getStatus(KeyWords._Get).toString(),
					null);
			return null;
		}
	}

	public static int getNewID(Model Model) {
		if (Model != null) {
			if (Model.isAuteur() || Model.isEtudiant()) {
				OracleResultSet rset = executeQuery(
						"SELECT MAX(" + Model.getPrimaryKeysFields()[0]
								+ ") AS MAX FROM " + Model.getModelName(),
						"getNewID For " + Model.getModelName());
				try {
					int Max = 0;
					while (rset.next()) {
						Max = rset.getInt("MAX");
					}
					return Max + 1;
				} catch (SQLException e) {
					new ShowMessage("getNewID " + Model.getModelName(),
							e.getMessage(), e);
				}
			}
		}
		return 0;
	}

	public static int update(Model This, Model model) {
		if (Getters.getValidFieldsForUpdate(This, model) != null) {
			String[] fields = Getters.getValidFieldsForUpdate(This, model);
			Object[] values = Getters.getValidValuesForUpdateSeparated(This,
					model);
			for (int i = 0; i < fields.length; i++) {
				if (!Validations.FieldInPrimaryKeysFields(model, fields[i])
						&& !Validations.FieldInUniquesFields(model, fields[i])) {
					String Update = null;
					if (fields[i].equals(Fields.Fields_Image)
							|| fields[i].equals(Fields.Fields_Signature)) {
						Update = "UPDATE "
								+ This.getModelName()
								+ " "
								+ "SET IMAGE=ORDSYS.ORDImage.init(),SIGNATURE=ORDSYS.ORDImageSignature.init()";
					} else {
						Update = "UPDATE " + This.getModelName() + " "
								+ values[i];
					}
					if (Getters.getValidValuesForSelect(This) != null) {
						for (int j = 0; j < Getters
								.getValidValuesForSelect(This).length; j++) {
							Update += " "
									+ Getters.getValidValuesForSelect(This)[j];
						}
					}
					int x = executeUpdate(Update,
							"Update " + This.getModelName());
					if (x == 1) {
						This.setProp(fields[i], model.getProp(fields[i]));
					}
					try {
						ConnectionClass.getConnection().commit();
						if (fields[i].equals(Fields.Fields_Image)
								|| fields[i].equals(Fields.Fields_Signature)) {
							insertImage(This.setURLImage(model.getURLImage()));
						}
						if (fields[i].equals(Fields.Fields_Video)) {
							insertVideo(This.setURLVideo(model.getURLVideo()));
						}
					} catch (Exception e) {
						new ShowMessage("update " + This.getModelName()
								+ " updating " + fields[i], e.getMessage(), e);
						return -1;
					}
					if (x != 1) {
						return x;
					}
				}
			}
		}
		return 0;
	}

	public static int add(Model Model) {
		if (Model != null) {
			if (Validations.ValidForInsert(Model)) {
				Model New = null;
				if (Validations.InList(Fields.Fields_Ref_Auteur,
						Model.getFields())) {
					New = (Model) get(Model.getModel(Fields.Fields_Ref_Auteur),
							false);
					if (New == null) {
						int x = add(Model.getModel(Fields.Fields_Ref_Auteur));
						if (x != 1) {
							return x;
						}
					}
				}
				New = null;
				if (Validations.InList(Fields.Fields_Ref_Etudiant,
						Model.getFields())) {
					New = (Model) get(
							Model.getModel(Fields.Fields_Ref_Etudiant), false);
					if (New == null) {
						int x = add(Model.getModel(Fields.Fields_Ref_Etudiant));
						if (x != 1) {
							return x;
						}
					}
				}
				New = null;
				if (Validations.InList(Fields.Fields_Ref_Livre,
						Model.getFields())) {
					New = (Model) get(Model.getModel(Fields.Fields_Ref_Livre),
							false);
					if (New == null) {
						int x = add(Model.getModel(Fields.Fields_Ref_Livre));
						if (x != 1) {
							return x;
						}
					}
				}
				new ConnectionClass();
				if (ConnectionClass.getStatus(KeyWords._Check).toString()
						.equals(KeyWords._Success)) {
					if (Model.isEst_Ecrit() || Model.isExemplaire()
							|| Model.isReservation()) {
						New = null;
						if (Model.isExemplaire() || Model.isReservation()) {

							Model toget = null;
							if (Model.isExemplaire()) {
								toget = new Exemplaire().setRef_Livre(
										Model.getRef_Livre()).setRef_Etudiant(
										Model.getRef_Etudiant());
							} else {
								toget = new Reservation().setRef_Livre(
										Model.getRef_Livre()).setRef_Etudiant(
										Model.getRef_Etudiant());
							}
							New = (Model) get(toget, false);
							if (New != null) {
								return -1;
							}
						} else if (Model.isEst_Ecrit()) {
							New = null;
							New = (Model) get(Model, false);
							if (New != null) {
								return -1;
							}
						}
					}
					New = null;
					if (Model.isAuteur() || Model.isEtudiant()
							|| Model.isLivre()) {
						if (Model.isAuteur() || Model.isEtudiant()) {
							if (Model.isAuteur()) {
								New = (Model) get(
										new Auteur().setMail(Model.getMail()),
										false);
								if (New != null) {
									return -1;
								}
								New = null;
								New = (Model) get(
										new Auteur().setNum_Personne(Model
												.getNum_Personne()), false);
								if (New != null) {
									return -1;
								}
							} else {
								New = (Model) get(
										new Etudiant().setMail(Model.getMail()),
										false);
								if (New != null) {
									return -1;
								}
								New = null;
								New = (Model) get(
										new Etudiant().setNum_Personne(Model
												.getNum_Personne()), false);
								if (New != null) {
									return -1;
								}
								New = null;
								if (Model.getLogin() != null) {
									New = (Model) get(
											new Etudiant().setLogin(Model
													.getLogin()), false);
									if (New != null) {
										return -1;
									}
								}
							}
						} else {
							New = null;
							New = (Model) get(
									new Livre().setISBN(Model.getISBN()), false);
							if (New != null) {
								return -1;
							}
						}
					}
					String Insert = Model.generateSQLInsert();
					int x = executeUpdate(Insert,
							"Adding " + Model.getModelName());
					try {
						ConnectionClass.getConnection().commit();
					} catch (SQLException e) {
						new ShowMessage("Commiting to add "
								+ Model.getModelName(), e.getMessage(), e);
					}
					if (x == 1) {
						if (Model.isAuteur() || Model.isLivre()) {
							if (Model.isAuteur()) {
								if (Model.getURLImage() != null) {
									if (insertImage(Model) == -1) {
										return -1;
									}
								}
								if (Model.getURLVideo() != null) {
									if (insertVideo(Model) == -1) {
										return -1;
									}
								}
							}
							if (Model.isLivre()) {
								if (Model.getURLImage() != null) {
									insertImage(Model);
								}
							}
						}

						return 1;
					}
					return -1;
				} else {
					new ShowMessage("Connection Problem", ConnectionClass
							.getStatus(KeyWords._Get).toString(), null);
					return -1;
				}
			}
			return 0;
		}
		return 0;
	}

	public static int insertImage(Model Model) {
		String Select = "SELECT " + Fields.Fields_Image + ","
				+ Fields.Fields_Signature + " FROM " + Model.getModelName()
				+ " WHERE " + Model.getPrimaryKeysFields()[0] + "='"
				+ Model.getPrimaryKeysValues()[0] + "' FOR UPDATE";
		System.out.println(Select);
		try {
			Statement stmt = ConnectionClass.getConnection().createStatement();
			OracleResultSet rset = (OracleResultSet) stmt.executeQuery(Select);
			if (rset.next()) {
				OrdImage imgObj = (OrdImage) rset.getORAData(
						Fields.Fields_Image, OrdImage.getORADataFactory());
				OrdImageSignature imgSig = (OrdImageSignature) rset.getORAData(
						Fields.Fields_Signature,
						OrdImageSignature.getORADataFactory());
			
				try {
					imgObj.loadDataFromFile(Model.getURLImage().toString());
				} catch (IOException e) {
					new ShowMessage("Adding " + Model.getModelName()
							+ " Preparing Image For Insert", e.getMessage(), e);
					return -1;
				}
				imgObj.setProperties();
				if (imgObj.checkProperties()) {
					Model.setImage(imgObj);
					imgSig.generateSignature(imgObj);
					Model.setSignature(imgSig);
					String Update = "UPDATE " + Model.getModelName()
							+ " SET IMAGE=?,SIGNATURE=? WHERE "
							+ Model.getPrimaryKeysFields()[0] + "='"
							+ Model.getPrimaryKeysValues()[0] + "'";
					OraclePreparedStatement pstmt = (OraclePreparedStatement) ConnectionClass
							.getConnection().prepareStatement(Update);
					pstmt.setORAData(1, imgObj);
					pstmt.setORAData(2, imgSig);
					pstmt.execute();
					Model.setImage(imgObj);
					Model.setSignature(imgSig);
					ConnectionClass.getConnection().commit();
					pstmt.close();
				}

			}
			stmt.close();
			rset.close();
		} catch (Exception e) {
			new ShowMessage("Exception While Adding InsertImage"
					+ Model.getModelName(), e.getMessage(), e);
			return -1;
		}
		return 1;
	}

	public static int insertVideo(Model Model) {
		String Select = "SELECT VIDEO FROM " + Model.getModelName() + " WHERE "
				+ Model.getPrimaryKeysFields()[0] + "='"
				+ Model.getNum_Personne() + "' FOR UPDATE";
		try {
			Statement stmt = ConnectionClass.getConnection().createStatement();
			OracleResultSet rset = (OracleResultSet) stmt.executeQuery(Select);
			if (rset.next()) {
				OrdVideo vdoObj = (OrdVideo) rset.getORAData("VIDEO",
						OrdVideo.getORADataFactory());
				try {
					vdoObj.loadDataFromFile(Model.getURLVideo());
				} catch (IOException e) {
					new ShowMessage("Adding " + Model.getModelName()
							+ " Uploading Video", e.getMessage(), e);
					return -1;
				}
				byte[] ctx[] = new byte[4000][1];
				vdoObj.setProperties(ctx);
				if (vdoObj.checkProperties(ctx)) {
					String Update = "UPDATE " + Model.getModelName()
							+ " SET VIDEO=? WHERE "
							+ Model.getPrimaryKeysFields()[0] + "='"
							+ Model.getNum_Personne() + "'";
					OraclePreparedStatement pstmt = (OraclePreparedStatement) ConnectionClass
							.getConnection().prepareStatement(Update);
					pstmt.setORAData(1, vdoObj);
					pstmt.execute();
					Model.setProp("VIDEO", vdoObj);
					ConnectionClass.getConnection().commit();
					pstmt.close();

				}
			}
			stmt.close();
			rset.close();
		} catch (Exception e) {
			new ShowMessage("Exception While Adding InsertVideo"
					+ Model.getModelName(), e.getMessage(), e);
			return -1;
		}
		return 1;
	}
	
	@SuppressWarnings("unchecked")
	public static OracleResultSet get(Object Model){
		if(Model != null){
			if(Validations.isModel(Model)){
				return executeQuery(((Model)Model).generateSQLSelect(), "get - OracleResultSet");
			}else{
				return executeQuery(Generate.SQLSelectFromList((ArrayList<Model>)Model), "get - OracleResultSet");
			}
		}
		return null;
	}

	@SuppressWarnings("unused")
	public static Object get(Model Model, boolean MMSearch) {
		if (Model != null) {
			OracleResultSet rset = null;
			try {
				rset = executeQuery(Model.generateSQLSelect(),
						"get " + Model.getModelName());
				ArrayList<Model> Models = new ArrayList<Model>();
				while (rset.next()) {
					ArrayList<Object> fields = new ArrayList<Object>();
					for (int i = 0; i < Model.getFields().length; i++) {
						String Field = Model.getFields()[i];
						if (Field.contains("REF")) {
							if (Field.equals(Fields.Fields_Ref_Auteur)) {
								fields.add(get(new Auteur(rset.getREF(Field)
										.getSTRUCT().getAttributes()), false));
							}
							if (Field.equals(Fields.Fields_Ref_Etudiant)) {
								fields.add(get(new Etudiant(rset.getREF(Field)
										.getSTRUCT().getAttributes()), false));
							}
							if (Field.equals(Fields.Fields_Ref_Livre)) {
								fields.add(get(new Livre(rset.getREF(Field)
										.getSTRUCT().getAttributes()), false));
							}
						} else if (Field.contains("DATE")) {
							fields.add(rset.getDate(Field));
						} else if (Field.equals(Fields.Fields_Image)) {
							fields.add(rset.getORAData(Field,
									OrdImage.getORADataFactory()));
						} else if (Field.equals(Fields.Fields_Video)) {
							fields.add(rset.getORAData(Field,
									OrdVideo.getORADataFactory()));
						} else if (Field.equals(Fields.Fields_Signature)) {
							fields.add(rset.getORAData(Field,
									OrdImageSignature.getORADataFactory()));
						} else {
							if (Model.getTypes()[i]
									.equals(Fields.Types_Integer)) {
								fields.add(rset.getInt(Field));
							} else {
								fields.add(rset.getObject(Field));
							}
						}

					}
					Model model = null;
					if (Model.isAuteur()) {
						model = new Auteur(fields);
					} else if (Model.isEst_Ecrit()) {
						model = new Est_Ecrit(fields);
					} else if (Model.isEtudiant()) {
						model = new Etudiant(fields);
					} else if (Model.isExemplaire()) {
						model = new Exemplaire(fields);
					} else if (Model.isLivre()) {
						model = new Livre(fields);
					} else if (Model.isReservation()) {
						model = new Reservation(fields);
					}
					Models.add(model);
				}
				if (MMSearch) {
					if (Validations.InList(Fields.Fields_Image,
							Getters.getValidFields(Model))) {
						if (Models.size() > 0) {
							ArrayList<Model> Final = new ArrayList<Model>();
							for (int i = 0; i < Models.size(); i++) {
								if (Models.get(i).getSignature() != null) {
									try {
										if (Model.isAuteur()) {
											int NewID = getNewID(Model);
											String Prepare = "INSERT INTO "
													+ Model.getModelName()
													+ " "
													+ "("
													+ Fields.Fields_Num_Personne
													+ ","
													+ Fields.Fields_Mail
													+ ","
													+ Fields.Fields_Image
													+ ","
													+ Fields.Fields_Signature
													+ ") "
													+ "VALUES"
													+ "('"
													+ NewID
													+ "','"
													+ Fields.DefaultMail
													+ "'"
													+ ",ORDSYS.ORDImage.init()"
													+ ",ORDSYS.ORDImageSignature.init()"
													+ ")";
											int State = executeUpdate(Prepare,
													"Insert Image To Compare With");
											Prepare = "SELECT "
													+ Fields.Fields_Image
													+ ","
													+ Fields.Fields_Signature
													+ " FROM "
													+ Model.getModelName()
													+ " WHERE "
													+ Model.getPrimaryKeysFields()[0]
													+ " = '" + NewID
													+ "' FOR UPDATE";
											rset = executeQuery(Prepare,
													"Selecting Image And Signature to Compare With");
											if (rset.next()) {
												OrdImage imgObj = (OrdImage) rset
														.getORAData(
																Fields.Fields_Image,
																OrdImage.getORADataFactory());
												OrdImageSignature imgSig = (OrdImageSignature) rset
														.getORAData(
																Fields.Fields_Signature,
																OrdImageSignature
																		.getORADataFactory());
												try {
													imgObj.loadDataFromFile(Model
															.getURLImage()
															.toString());
												} catch (IOException e) {
													new ShowMessage(
															"Loading Image To Compare With "
																	+ Model.getModelName(),
															e.getMessage(), e);
													return -1;
												}
												imgObj.setProperties();
												if (imgObj.checkProperties()) {
													Model.setImage(imgObj);
													imgSig.generateSignature(imgObj);
													Model.setSignature(imgSig);
												}
											}
											String commande = "color=1 texture=0 shape=0 location=0";
											float f = OrdImageSignature
													.evaluateScore(
															Models.get(i)
																	.getSignature(),
															Model.getSignature(),
															commande);
											float seuil = 20;
											int similaire = OrdImageSignature
													.isSimilar(
															Models.get(i)
																	.getSignature(),
															Model.getSignature(),
															commande, seuil);
											if (similaire == 1) {
												Final.add(Models.get(i));
											}
										} else {
											String Prepare = "INSERT INTO "
													+ Model.getModelName()
													+ " "
													+ "("
													+ Fields.Fields_ISBN
													+ ","
													+ Fields.Fields_Nb_Exemplaires
													+ ","
													+ Fields.Fields_Image
													+ ","
													+ Fields.Fields_Signature
													+ ") "
													+ "VALUES"
													+ "('"
													+ Fields.DefaultISBN
													+ "','"
													+ Fields.DefaultNBExemplaire
													+ "'"
													+ ",ORDSYS.ORDImage.init()"
													+ ",ORDSYS.ORDImageSignature.init()"
													+ ")";
											int State = executeUpdate(Prepare,
													"Insert Image To Compare With");
											Prepare = "SELECT "
													+ Fields.Fields_Image
													+ ","
													+ Fields.Fields_Signature
													+ " FROM "
													+ Model.getModelName()
													+ " WHERE "
													+ Model.getPrimaryKeysFields()[0]
													+ " = '"
													+ Fields.DefaultISBN
													+ "' FOR UPDATE";
											rset = executeQuery(Prepare,
													"Selecting Image And Signature to Compare With");
											if (rset.next()) {
												OrdImage imgObj = (OrdImage) rset
														.getORAData(
																Fields.Fields_Image,
																OrdImage.getORADataFactory());
												OrdImageSignature imgSig = (OrdImageSignature) rset
														.getORAData(
																Fields.Fields_Signature,
																OrdImageSignature
																		.getORADataFactory());
												try {
													imgObj.loadDataFromFile(Model
															.getProp("URLImage")
															.toString());
												} catch (IOException e) {
													new ShowMessage(
															"Loading Image To Compare With "
																	+ Model.getModelName(),
															e.getMessage(), e);
													return -1;
												}
												imgObj.setProperties();
												if (imgObj.checkProperties()) {
													Model.setImage(imgObj);
													imgSig.generateSignature(imgObj);
													Model.setSignature(imgSig);
												}
											}
											String commande = "color=1 texture=0 shape=0 location=0";
											float f = OrdImageSignature
													.evaluateScore(
															Models.get(i)
																	.getSignature(),
															Model.getSignature(),
															commande);
											float seuil = 20;
											int similaire = OrdImageSignature
													.isSimilar(
															Models.get(i)
																	.getSignature(),
															Model.getSignature(),
															commande, seuil);
											if (similaire == 1) {
												Final.add(Models.get(i));
											}
										}
										ConnectionClass.getConnection()
												.rollback();
									} catch (Exception e) {
										new ShowMessage("getting "
												+ Model.getModelName()
												+ " Comparing Image",
												e.getMessage(), e);
									}
								}
							}
							if (Final.size() > 0) {
								if (Final.size() == 1) {
									return Final.get(0);
								} else {
									return Final;
								}
							}
						}
					} else {
						if (Models.size() > 0) {
							if (Models.size() == 1) {
								return Models.get(0);
							} else {
								return Models;
							}
						}
					}
				} else {
					if (Models.size() > 0) {
						if (Models.size() == 1) {
							return Models.get(0);
						} else {
							return Models;
						}
					}
				}
			} catch (Exception e) {
				new ShowMessage("get", e.getMessage(), e);
			} finally {
				try {
					rset.getStatement().close();
					rset.close();
				} catch (Exception e) {
					new ShowMessage(
							"get - Closing Statement and OracleResultSet ",
							e.getMessage(), e);
				}
			}
			return null;
		}
		return null;
	}

	public static int delete(Model model) {
		if (model != null) {
			int x = executeUpdate(model.generateSQLDelete(), "Deleting "
					+ model.getModelName());
			try {
				ConnectionClass.getConnection().commit();
			} catch (SQLException e) {
				new ShowMessage("Delete " + model.getModelName(),
						e.getMessage(), e);
				return -1;
			}
			if (x != 1) {
				return x;
			}
			return 1;
		}
		return 0;
	}
}
