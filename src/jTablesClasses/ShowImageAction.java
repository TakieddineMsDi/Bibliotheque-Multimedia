package jTablesClasses;

import isamm.ingenieur.deuxieme.bdmm.bibliothequemultim�dia.Media.ImageInJframe;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultim�dia.models.Auteur;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultim�dia.models.Etudiant;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultim�dia.models.Livre;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultim�dia.models.Model;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class ShowImageAction extends AbstractAction {
	private final JTable table;
	private Model Model = null;

	public ShowImageAction(JTable table,Model model,String ButtonName) {
		super(ButtonName);
		this.table = table;
		Model = model;
	}

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
		}
		if(model != null){
			if(((Model)model).getImage() != null){
			new ImageInJframe(((Model)model).getImage()).setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			}
			else{
				JOptionPane.showMessageDialog(table, "erreur!");
			}
		}else{
			JOptionPane.showMessageDialog(table, "erreur!");
		}
		//Object o = table.getModel().getValueAt(row, 0);
	}
}