package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.frames;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Auteur;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Est_Ecrit;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Etudiant;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Exemplaire;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Livre;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Model;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Validations;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.utilities.ConnectionClass;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.utilities.KeyWords;
import jTablesClasses.ButtonsEditor;
import jTablesClasses.ButtonsRenderer;
import jTablesClasses.DeleteAction;
import jTablesClasses.ShowImageAction;
import jTablesClasses.UpdateAction;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Component;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JTextField;
import javax.swing.JLabel;

import com.toedter.calendar.JDateChooser;


public class Show {

	private JFrame frame;
	private JTable AuteurJT;
	private JTable EtudiantJT;
	private JTable LivreJT;
	private JTable ManagementAuteurJT;
	JButton ImageAuteurJB;
	JButton VideoAuteurJB;
	private JTable ManagementEtudiantJT;
	private JDateChooser DateValiditeCarte;
	JButton CancelEtudiantJB;
	JButton FilterEtudiantJB;
	JButton AddEtudiantJB;
	JButton UpdateEtudiantJB;
	private JTable ManagementLivreJT;
	private JDateChooser DatePublicationJB;
	JButton CancelLivreJB;
	JButton FilterLivreJB;
	JButton AddLivreJB;
	JButton UpdateLivreJB;


	public static void main(String[] args) {
		            new ConnectionClass();
					Show window = new Show();
	}


	public Show() {
		initialize();
		frame.setVisible(true);
	    Thread repainter = new Thread(new Runnable() {
	        @Override
	        public void run() {
	            while (true) { // I recommend setting a condition for your panel being open/visible
	                frame.repaint();
	                try {
	                    Thread.sleep(30);
	                } catch (InterruptedException ignored) {
	                }
	            }
	        }
	    });
	    repainter.start();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 532, 658);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ManagementAuteurJT = new Auteur().makeMJTable();
		ManagementEtudiantJT = new Etudiant().makeMJTable();
		ManagementLivreJT = new Livre().makeMJTable();
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JPanel AuteursJPanel = new JPanel();
		tabbedPane.addTab("Auteurs", null, AuteursJPanel, null);
		
		AuteurJT = makeJTable(new Auteur(),ManagementAuteurJT);
		JScrollPane AuteursJScrollPane = new JScrollPane(AuteurJT);
		
		JButton ShowAllAuteurJB = new JButton("Show All");
		ShowAllAuteurJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AuteurJT = new Auteur().repaint(AuteurJT,ManagementAuteurJT);
			}
		});
		
		JButton FilterAuteurJB = new JButton("Filter");
		FilterAuteurJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model auteur = new Auteur();
				auteur = auteur.getModelFromJTable(new Auteur(), ManagementAuteurJT, KeyWords._Filter);
				AuteurJT = auteur.repaint(AuteurJT, ManagementAuteurJT);
				ManagementAuteurJT = new Auteur().repaintMJTable(ManagementAuteurJT);
			}
		});
		
		JButton AddAuteurJB = new JButton("Add");
		AddAuteurJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model auteur = new Auteur();
				auteur = auteur.getModelFromJTable(new Auteur(), ManagementAuteurJT, KeyWords._Add);
				if(auteur.add() == 1){
					AuteurJT = new Auteur().repaint(AuteurJT, ManagementAuteurJT);
					ManagementAuteurJT = new Auteur().repaintMJTable(ManagementAuteurJT);
					JOptionPane.showMessageDialog(AuteurJT, "Added");
				}else{
					JOptionPane.showMessageDialog(AuteurJT, "Erreur! champs invalid");
				}
			}
		});
		
		JButton UpdateAuteurJB = new JButton("Update");
		UpdateAuteurJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model auteur = new Auteur();
				auteur = auteur.getModelFromJTable(new Auteur(), ManagementAuteurJT, KeyWords._Update);
				if(!Validations.NullFields(auteur)){
					Model old = new Auteur();
					if(auteur.getNum_Personne() > 0){
						old = new Auteur().setNum_Personne(auteur.getNum_Personne()).getOne();
						if(old != null){
							if(old.update(auteur) == 1){
								AuteurJT = new Auteur().repaint(AuteurJT, ManagementAuteurJT);
								ManagementAuteurJT = new Auteur().repaintMJTable(ManagementAuteurJT);
								JOptionPane.showMessageDialog(AuteurJT, "Updated :)");
							}
							AuteurJT = new Auteur().repaint(AuteurJT, ManagementAuteurJT);
							ManagementAuteurJT = new Auteur().repaintMJTable(ManagementAuteurJT);
							
						}else{
							JOptionPane.showMessageDialog(AuteurJT, "Erreur! no auteur with this id");
						}
					}
				}
			}
		});
		
		JButton CancelAuteurJB = new JButton("Cancel");
		CancelAuteurJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagementAuteurJT = new Auteur().repaintMJTable(ManagementAuteurJT);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		VideoAuteurJB = new JButton("Browse Video");
		VideoAuteurJB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String URL = chooser.getSelectedFile().getPath().toString();
					ManagementAuteurJT.setValueAt(URL, 0, 6);
					// ImageJL.setText(URL.substring(URL.lastIndexOf("\\") + 1,
					// URL.length()));
					// ImageURL = URL;
				}

			}
		});
		
		ImageAuteurJB = new JButton("Browse Image");
				ImageAuteurJB.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						JFileChooser chooser = new JFileChooser();
						int returnVal = chooser.showOpenDialog(null);
						if (returnVal == JFileChooser.APPROVE_OPTION) {
							String URL = chooser.getSelectedFile().getPath().toString();
							ManagementAuteurJT.setValueAt(URL, 0, 5);
							// ImageJL.setText(URL.substring(URL.lastIndexOf("\\") + 1,
							// URL.length()));
							// ImageURL = URL;
						}

					}
				});
		GroupLayout gl_AuteursJPanel = new GroupLayout(AuteursJPanel);
		gl_AuteursJPanel.setHorizontalGroup(
			gl_AuteursJPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_AuteursJPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(ShowAllAuteurJB)
					.addContainerGap(408, Short.MAX_VALUE))
				.addGroup(gl_AuteursJPanel.createSequentialGroup()
					.addContainerGap(185, Short.MAX_VALUE)
					.addComponent(CancelAuteurJB, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(UpdateAuteurJB)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(AddAuteurJB, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(FilterAuteurJB, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(AuteursJScrollPane, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
				.addGroup(gl_AuteursJPanel.createSequentialGroup()
					.addGap(299)
					.addComponent(ImageAuteurJB)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(VideoAuteurJB))
		);
		gl_AuteursJPanel.setVerticalGroup(
			gl_AuteursJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AuteursJPanel.createSequentialGroup()
					.addGap(6)
					.addComponent(ShowAllAuteurJB)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(AuteursJScrollPane, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addGroup(gl_AuteursJPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(VideoAuteurJB)
						.addComponent(ImageAuteurJB))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_AuteursJPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_AuteursJPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(AddAuteurJB)
							.addComponent(UpdateAuteurJB)
							.addComponent(CancelAuteurJB))
						.addComponent(FilterAuteurJB)))
		);
		
		
		scrollPane.setViewportView(ManagementAuteurJT);
		AuteursJPanel.setLayout(gl_AuteursJPanel);
		
		JPanel EtudiantsJPanel = new JPanel();
		tabbedPane.addTab("Etudiants", null, EtudiantsJPanel, null);
		
		EtudiantJT = makeJTable(new Etudiant(),ManagementEtudiantJT);
		
		JScrollPane EtudiantJScrollPane = new JScrollPane(EtudiantJT);
		
		JButton ShowAllEtudiantJB = new JButton("Show All");
		ShowAllEtudiantJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EtudiantJT = new Etudiant().repaint(EtudiantJT,ManagementEtudiantJT);
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		DateValiditeCarte = new JDateChooser();
		DateValiditeCarte.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent arg0) {
				if(DateValiditeCarte.getDate() != null){
					ManagementEtudiantJT.setValueAt(DateValiditeCarte.getDate(), 0, 7);
				}
				
			}
		});
		
		JLabel lblDateValiditeCarte = new JLabel("Date Validite Carte");
		
		FilterEtudiantJB = new JButton("Filter");

		FilterEtudiantJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model etudiant = new Etudiant();
				etudiant = etudiant.getModelFromJTable(new Etudiant(), ManagementEtudiantJT, KeyWords._Filter);
				EtudiantJT = etudiant.repaint(EtudiantJT, ManagementEtudiantJT);
				ManagementEtudiantJT = new Etudiant().repaintMJTable(ManagementEtudiantJT);
			}
		});
		
		AddEtudiantJB = new JButton("Add");
		AddEtudiantJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model Etudiant = new Etudiant();
				Etudiant = Etudiant.getModelFromJTable(new Etudiant(), ManagementEtudiantJT, KeyWords._Add);
				if(Etudiant.add() == 1){
					EtudiantJT = new Etudiant().repaint(EtudiantJT, ManagementEtudiantJT);
					ManagementEtudiantJT = new Etudiant().repaintMJTable(ManagementEtudiantJT);
					JOptionPane.showMessageDialog(EtudiantJT, "Added");
				}else{
					JOptionPane.showMessageDialog(EtudiantJT, "Erreur! champs invalid");
				}
			}
		});

		UpdateEtudiantJB = new JButton("Update");
		UpdateEtudiantJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model Etudiant = new Etudiant();
				Etudiant = Etudiant.getModelFromJTable(new Etudiant(), ManagementEtudiantJT, KeyWords._Update);
				if(!Validations.NullFields(Etudiant)){
					Model old = new Etudiant();
					if(Etudiant.getNum_Personne() > 0){
						old = new Etudiant().setNum_Personne(Etudiant.getNum_Personne()).getOne();
						if(old != null){
							if(old.update(Etudiant) == 1){
								EtudiantJT = new Etudiant().repaint(EtudiantJT, ManagementEtudiantJT);
								ManagementEtudiantJT = new Etudiant().repaintMJTable(ManagementEtudiantJT);
								JOptionPane.showMessageDialog(EtudiantJT, "Updated :)");
							}
							EtudiantJT = new Etudiant().repaint(EtudiantJT, ManagementEtudiantJT);
							ManagementEtudiantJT = new Etudiant().repaintMJTable(ManagementEtudiantJT);
							
						}else{
							JOptionPane.showMessageDialog(EtudiantJT, "Erreur! no auteur with this id");
						}
					}
				}
			}
		});

		CancelEtudiantJB = new JButton("Cancel");
		CancelEtudiantJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagementEtudiantJT = new Etudiant().repaintMJTable(ManagementEtudiantJT);
			}
		});
		GroupLayout gl_EtudiantsJPanel = new GroupLayout(EtudiantsJPanel);
		gl_EtudiantsJPanel.setHorizontalGroup(
			gl_EtudiantsJPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_EtudiantsJPanel.createSequentialGroup()
					.addGroup(gl_EtudiantsJPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_EtudiantsJPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDateValiditeCarte)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(DateValiditeCarte, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_EtudiantsJPanel.createSequentialGroup()
							.addContainerGap(239, Short.MAX_VALUE)
							.addComponent(CancelEtudiantJB)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(UpdateEtudiantJB)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(AddEtudiantJB)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(FilterEtudiantJB))
						.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
						.addComponent(EtudiantJScrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
						.addGroup(gl_EtudiantsJPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(ShowAllEtudiantJB, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_EtudiantsJPanel.setVerticalGroup(
			gl_EtudiantsJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_EtudiantsJPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(ShowAllEtudiantJB)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(EtudiantJScrollPane, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_EtudiantsJPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(DateValiditeCarte, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDateValiditeCarte))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_EtudiantsJPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(FilterEtudiantJB)
						.addComponent(AddEtudiantJB)
						.addComponent(UpdateEtudiantJB)
						.addComponent(CancelEtudiantJB)))
		);
		
		
		scrollPane_1.setViewportView(ManagementEtudiantJT);
	
		EtudiantsJPanel.setLayout(gl_EtudiantsJPanel);
		JPanel LivresJPanel = new JPanel();
		tabbedPane.addTab("Livres", null, LivresJPanel, null);
		LivreJT = makeJTable(new Livre(),ManagementLivreJT);
		JScrollPane LivreJScrollPane = new JScrollPane(LivreJT);
		
		JButton ShowAllLivreJB = new JButton("Show All");
		ShowAllLivreJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivreJT = new Livre().repaint(LivreJT,ManagementLivreJT);
			}
		});
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JButton ImageLivreJB = new JButton("Browse Image");
		ImageLivreJB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String URL = chooser.getSelectedFile().getPath().toString();
					ManagementLivreJT.setValueAt(URL, 0, 6);
					// ImageJL.setText(URL.substring(URL.lastIndexOf("\\") + 1,
					// URL.length()));
					// ImageURL = URL;
				}

			}
		});
		
		DatePublicationJB = new JDateChooser();
        DatePublicationJB.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent arg0) {
				if(DatePublicationJB.getDate() != null){
					ManagementLivreJT.setValueAt(DatePublicationJB.getDate(), 0, 2);
				}
				
			}
		});
		JLabel lblDatePublication = new JLabel("Date Publication");

		FilterLivreJB = new JButton("Filter");
		FilterLivreJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model Livre = new Livre();
				Livre = Livre.getModelFromJTable(new Livre(), ManagementLivreJT, KeyWords._Filter);
				LivreJT = Livre.repaint(LivreJT, ManagementLivreJT);
				ManagementLivreJT = new Livre().repaintMJTable(ManagementLivreJT);
			}
		});
		
		AddLivreJB = new JButton("Add");
		AddLivreJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model Livre = new Livre();
				Livre = Livre.getModelFromJTable(new Livre(), ManagementLivreJT, KeyWords._Add);
				if(Livre.add() == 1){
					LivreJT = new Livre().repaint(LivreJT, ManagementLivreJT);
					ManagementLivreJT = new Livre().repaintMJTable(ManagementLivreJT);
					JOptionPane.showMessageDialog(LivreJT, "Added");
				}else{
					JOptionPane.showMessageDialog(LivreJT, "Erreur! champs invalid");
				}
			}
		});
		
		UpdateLivreJB = new JButton("Update");
		UpdateEtudiantJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Model Livre = new Livre();
				Livre = Livre.getModelFromJTable(new Livre(), ManagementLivreJT, KeyWords._Update);
				if(!Validations.NullFields(Livre)){
					Model old = new Livre();
					if(Livre.getISBN() != null){
						old = new Livre().setISBN(Livre.getISBN()).getOne();
						if(old != null){
							if(old.update(Livre) == 1){
								LivreJT = new Livre().repaint(LivreJT, ManagementLivreJT);
								ManagementLivreJT = new Livre().repaintMJTable(ManagementLivreJT);
								JOptionPane.showMessageDialog(LivreJT, "Updated :)");
							}
							LivreJT = new Livre().repaint(LivreJT, ManagementLivreJT);
							ManagementLivreJT = new Livre().repaintMJTable(ManagementLivreJT);
							
						}else{
							JOptionPane.showMessageDialog(LivreJT, "Erreur! no auteur with this id");
						}
					}
				}
			}
		});
		
		
		CancelLivreJB = new JButton("Cancel");
		CancelLivreJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagementLivreJT = new Livre().repaintMJTable(ManagementLivreJT);
			}
		});
		GroupLayout gl_LivresJPanel = new GroupLayout(LivresJPanel);
		gl_LivresJPanel.setHorizontalGroup(
			gl_LivresJPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_LivresJPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(ShowAllLivreJB, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(417, Short.MAX_VALUE))
				.addGroup(gl_LivresJPanel.createSequentialGroup()
					.addContainerGap(107, Short.MAX_VALUE)
					.addComponent(CancelLivreJB)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(UpdateLivreJB)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(AddLivreJB)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(FilterLivreJB)
					.addContainerGap())
				.addGroup(gl_LivresJPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDatePublication)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(DatePublicationJB, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(ImageLivreJB)
					.addContainerGap())
				.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
				.addComponent(LivreJScrollPane, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
		);
		gl_LivresJPanel.setVerticalGroup(
			gl_LivresJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LivresJPanel.createSequentialGroup()
					.addGap(5)
					.addComponent(ShowAllLivreJB)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(LivreJScrollPane, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_LivresJPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ImageLivreJB)
						.addComponent(DatePublicationJB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDatePublication))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_LivresJPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(FilterLivreJB)
						.addComponent(AddLivreJB)
						.addComponent(UpdateLivreJB)
						.addComponent(CancelLivreJB)))
		);
		
		
		scrollPane_2.setViewportView(ManagementLivreJT);
	
		LivresJPanel.setLayout(gl_LivresJPanel);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private JTable makeJTable(final Model Model,JTable manage) {
		String empty = "";
		String[] columnNames = Model.getFieldsToShow();
		Object[][] data = Model.getPreparedDataToshow();
		DefaultTableModel model = new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column == 0){
					return false;
				}
				return super.isCellEditable(row, column);
			}
		};
		JTable AuteurJT = new JTable(model);
		AuteurJT.setAutoCreateRowSorter(true);
		
		AuteurJT = Model.setJTable(AuteurJT,manage);

		return AuteurJT;
	}
}
