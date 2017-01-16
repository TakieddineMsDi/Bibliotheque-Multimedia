package jTablesClasses;

import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.Media.ImageInJframe;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.frames.AddAuteurForLivre;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.frames.AddLivreForAuteur;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.frames.ReserverEtudiant;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Auteur;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Est_Ecrit;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Etudiant;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Exemplaire;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Fields;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Livre;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Model;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Reservation;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.utilities.KeyWords;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class Action extends AbstractAction {
	private JTable table;
	private Model Model = null;
	private String Action = null;
	private JTable Management = null;

	public Action(JTable table,Model model,String ButtonName,String action,JTable manage) {
		super(ButtonName);
		this.table = table;
		Model = model;
		Action = action;
		this.Management = manage;
	}
	
	/*public Action(JTable table,Model model,String ButtonName,String action) {
		super(ButtonName);
		this.table = table;
		Model = model;
		Action = action;
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		// Object o = table.getModel().getValueAt(table.getSelectedRow(), 0);
		int row = table.convertRowIndexToModel(table.getEditingRow());
		Object model = null;
		if(Model.isAuteur()){
				model = new Auteur().setNum_Personne(table.getModel().getValueAt(row, 0)).get();
		}if(Model.isEtudiant()){
			model = new Etudiant().setNum_Personne(table.getModel().getValueAt(row, 0)).get();
		}if(Model.isLivre()){
			model = new Livre().setISBN(table.getModel().getValueAt(row, 0)).get();
		}if(Model.isEst_Ecrit()){
			model = new Est_Ecrit(table.getModel().getValueAt(row, 0), table.getModel().getValueAt(row, 1)).get();
		}if(Model.isReservation()||Model.isExemplaire()){
			if(Model.isReservation()){
				model = new Reservation().setRef_Livre(table.getModel().getValueAt(row, 0)).setRef_Etudiant(table.getModel().getValueAt(row, 1)).get();
			}else{
				model = new Exemplaire().setRef_Livre(table.getModel().getValueAt(row, 0)).setRef_Etudiant(table.getModel().getValueAt(row, 1)).get();
			}
		}
		if(model != null){
			if(Action != null)
			{
				if(Action.equals(KeyWords._ShowLivres)){
					Model mod = Model.toOneModel(new Est_Ecrit(null, model).get(),Fields.Fields_Ref_Livre);
					if(mod != null){
						mod.setLinkAction(new Est_Ecrit()).setLink(model);
						table = mod.repaint(table,Management);
						table = mod.setJTable(table,Management);
					}
					else{
						JOptionPane.showMessageDialog(table, "no livres");
					}
				}if(Action.equals(KeyWords._LivreAuteur)){
					Model mod = Model.toOneModel(new Est_Ecrit(model, null).get(),Fields.Fields_Ref_Auteur);
					if(mod != null){
						mod.setLinkAction(new Est_Ecrit()).setLink(model);
					table = mod.repaint(table,Management);
					table = mod.setJTable(table,Management);
					}else{
						JOptionPane.showMessageDialog(table, "no Auteurs");
					}
				}if(Action.equals(KeyWords._ShowReservation)){
					if(((Model)model).isLivre()){
					Model mod = Model.toOneModel(new Reservation(model, null,null).setOrderBy(Fields.Fields_Date_Reservation, "ASC").get(),Fields.Fields_Ref_Etudiant);
					if(mod != null){
					mod.setLinkAction(new Reservation()).setLink(model);
				    table = mod.repaint(table,Management);
					table = mod.setJTable(table,Management);
					}else{
						JOptionPane.showMessageDialog(table, "no Reservations");
					}
					}else{
						Model mod = Model.toOneModel(new Reservation(null, model,null).setOrderBy(Fields.Fields_Date_Reservation, "ASC").get(),Fields.Fields_Ref_Livre);
						if(mod != null){ 
							mod.setLinkAction(new Reservation()).setLink(model);
						table = mod.repaint(table,Management);
						table = mod.setJTable(table,Management);
						}else{
							JOptionPane.showMessageDialog(table, "no Reservations");
						}
						
					}
				}if(Action.equals(KeyWords._ShowEmprunt)){
					if(((Model)model).isLivre()){
						Model mod = Model.toOneModel(new Exemplaire(model, null,null,null).get(),Fields.Fields_Ref_Etudiant);
						if(mod != null){
						    mod.setLinkAction(new Exemplaire()).setLink(model);
							table = mod.repaint(table,Management);
							table = mod.setJTable(table,Management);
						}else{
							JOptionPane.showMessageDialog(table, "no Emprunts");
						}
					}
					else{
						Model mod = Model.toOneModel(new Exemplaire(null, model,null,null).get(),Fields.Fields_Ref_Livre);
						if(mod != null){
							mod.setLinkAction(new Exemplaire()).setLink(model);
						table = mod.repaint(table,Management);
						table = mod.setJTable(table,Management);
						}else{
							JOptionPane.showMessageDialog(table, "no Emprunts");
						}
					}
				}
				if(Action.equals(KeyWords._AddLivre)){
					JFrame frame = new AddLivreForAuteur((Model)model);
				}
				if(Action.equals(KeyWords._ReserverLivre)){
						JFrame frame = new ReserverEtudiant((Model)model);
				}
				if(Action.equals(KeyWords._AddAuteur)){
					JFrame frame = new AddAuteurForLivre((Model)model);
				}
				if(Action.equals(KeyWords._Delete)){
					if(((Model)model).delete() == 1){
						JOptionPane.showMessageDialog(table, "row deleted !");
						((DefaultTableModel)table.getModel()).removeRow(row);
					}else{
						JOptionPane.showMessageDialog(table, "erreur!! can't delete row !");
					}
				}if(Action.equals(KeyWords._DeleteLink)){
					if(Model.getLinkAction().isEst_Ecrit()){
						if(Model.isAuteur()){
							if((new Est_Ecrit(Model.getLink(), model)).delete() == 1){
								JOptionPane.showMessageDialog(table, "row deleted !");
								((DefaultTableModel)table.getModel()).removeRow(row);
							}else{
								JOptionPane.showMessageDialog(table, "erreur!! can't delete row !");
							}
						}else{
							if((new Est_Ecrit(model, Model.getLink())).delete() == 1){
								JOptionPane.showMessageDialog(table, "row deleted !");
								((DefaultTableModel)table.getModel()).removeRow(row);
							}else{
								JOptionPane.showMessageDialog(table, "erreur!! can't delete row !");
							}
						}
					}else if(Model.getLinkAction().isReservation()){
						if(Model.isLivre()){
							if((new Reservation(model, Model.getLink(), null).delete()) == 1){
								JOptionPane.showMessageDialog(table, "row deleted !");
								((DefaultTableModel)table.getModel()).removeRow(row);
							}else{
								JOptionPane.showMessageDialog(table, "erreur!! can't delete row !");
							}
						}else{
							if((new Reservation(Model.getLink(), model, null).delete()) == 1){
								JOptionPane.showMessageDialog(table, "row deleted !");
								((DefaultTableModel)table.getModel()).removeRow(row);
							}else{
								JOptionPane.showMessageDialog(table, "erreur!! can't delete row !");
							}
						}
					}else if(Model.getLinkAction().isExemplaire()){
						if(Model.isLivre()){
							if((new Exemplaire(model, Model.getLink(), null,null).delete()) == 1){
								JOptionPane.showMessageDialog(table, "row deleted !");
								((DefaultTableModel)table.getModel()).removeRow(row);
							}else{
								JOptionPane.showMessageDialog(table, "erreur!! can't delete row !");
							}
						}else{
							if((new Exemplaire(Model.getLink(),model, null,null).delete()) == 1){
								JOptionPane.showMessageDialog(table, "row deleted !");
								((DefaultTableModel)table.getModel()).removeRow(row);
							}else{
								JOptionPane.showMessageDialog(table, "erreur!! can't delete row !");
							}
						}
					}
					else{
						JOptionPane.showMessageDialog(table, "erreur!! can't delete row !");
					}
				}
				if(Action.equals(KeyWords._Update)){
					Management = ((Model)model).repaintMJTable(Management);
				}
				if(Action.equals(KeyWords._ShowImage)){
					if(((Model)model).getImage() != null){
						new ImageInJframe(((Model)model).getImage()).setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
						}
						else{
							JOptionPane.showMessageDialog(table, "no image");
						}
				}
				if(Action.equals(KeyWords._ShowVideo)){
					JOptionPane.showMessageDialog(table, "not implemented, experimentation in Package Media (MediaPanel and MediaTest");
				}
			}
		}else{
			JOptionPane.showMessageDialog(table, "erreur!");
		}
		//Object o = table.getModel().getValueAt(row, 0);
	}
}