package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.frames;

import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Est_Ecrit;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Fields;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Livre;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Model;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Validations;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JComboBox;

public class AddLivreForAuteur extends JFrame {

	private JPanel contentPane;
	JComboBox AuteurJCB;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLivreForAuteur frame = new AddLivreForAuteur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public AddLivreForAuteur(final Model auteur) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 307, 134);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JButton AddLivreForAuteurJB = new JButton("Add");
		AddLivreForAuteurJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(auteur != null){
					
					if(AuteurJCB.getSelectedItem() != null){
						System.out.println(auteur);
							int x = new Est_Ecrit(((Model)AuteurJCB.getSelectedItem()).get(), auteur.get()).add();
							if(x == 1){
								JOptionPane.showMessageDialog(rootPane, "added successfully");
								dispose();
							}else{
								JOptionPane.showMessageDialog(rootPane, "erreur!");
							}
					}
				}
			}
		});
		
		AuteurJCB = new JComboBox();
		Object[] items = new Livre().getArray();
		
		DefaultComboBoxModel mod=new DefaultComboBoxModel(items);
		AuteurJCB.setModel(mod);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(AddLivreForAuteurJB)
						.addComponent(AuteurJCB, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(AuteurJCB, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(AddLivreForAuteurJB)
					.addContainerGap(97, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
}
