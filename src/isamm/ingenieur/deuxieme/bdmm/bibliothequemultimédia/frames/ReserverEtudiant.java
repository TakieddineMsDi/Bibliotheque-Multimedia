package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.frames;

import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Est_Ecrit;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Etudiant;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Fields;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Livre;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Model;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Reservation;
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
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;

import oracle.sql.DATE;

import com.toedter.calendar.JDateChooser;

public class ReserverEtudiant extends JFrame {

	private JPanel contentPane;
	JComboBox AuteurJCB;
	private JDateChooser DateReservation;
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
	public ReserverEtudiant(final Model auteur) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 339, 168);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JButton AddLivreForAuteurJB = new JButton("Add");
		AddLivreForAuteurJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(auteur != null){
					if(AuteurJCB.getSelectedItem() != null){
						if(DateReservation.getDate() != null){
							Model reservation = null;
							int x = 0;
							if(auteur.isEtudiant()){
								if(auteur.getNb_Emprunt()>0){
							    reservation = new Reservation(((Model)AuteurJCB.getSelectedItem()).getOne(), auteur.getOne(),new Date(DateReservation.getDate().getDate()));
							    x = reservation.add();
								}else{
									JOptionPane.showMessageDialog(rootPane, "etudiant satureé");
								}
								}else{
								if(((Model)AuteurJCB.getSelectedItem()).getNb_Emprunt()>0){
									reservation = new Reservation(auteur.getOne(), ((Model)AuteurJCB.getSelectedItem()).getOne(),new Date(DateReservation.getDate().getDate()));
								x = reservation.add();
							}else{
								JOptionPane.showMessageDialog(rootPane, "etudiant satureé");
							}
							}
							System.out.println(reservation.getDate_Reservation());
							System.out.println(reservation.getRef_Etudiant());
							System.out.println(reservation.getRef_Livre());
							if(x == 1){
								auteur.update(auteur.setNb_Emprunt(auteur.getNb_Emprunt()-1));
								JOptionPane.showMessageDialog(rootPane, "added successfully");
								dispose();
							}else{
								JOptionPane.showMessageDialog(rootPane, "erreur!");
							}
						}else{
							JOptionPane.showMessageDialog(rootPane, "select a date");
						}
					}
				}
			}
		});
		
		AuteurJCB = new JComboBox();
		Object[] items = null;
		if(auteur.isEtudiant()){
		items = new Livre().getArray();
		}else{
			items = new Etudiant().getArray();
		}
		
		DefaultComboBoxModel mod=new DefaultComboBoxModel(items);
		AuteurJCB.setModel(mod);
		
		DateReservation = new JDateChooser();
		DateReservation.setDate(Calendar.getInstance().getTime());
		
		JLabel lblDateReservation = new JLabel("Date Reservation");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDateReservation)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(DateReservation)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(AddLivreForAuteurJB))
						.addComponent(AuteurJCB, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(AuteurJCB, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(AddLivreForAuteurJB)
						.addComponent(DateReservation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDateReservation))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
}
