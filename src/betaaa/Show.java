package betaaa;
/*import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Auteur;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Est_Ecrit;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Etudiant;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Exemplaire;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Livre;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Model;
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
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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


public class Show {

	private JFrame frame;
	private JTable AuteurJT;
	private JTable EtudiantJT;
	private JTable LivreJT;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Show window = new Show();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Show() {
		initialize();
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
		frame.setBounds(100, 100, 532, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		AuteurJT = makeJTable(new Auteur());
		JScrollPane AuteursJScrollPane = new JScrollPane(AuteurJT);

		JButton AddAuteurJB = new JButton("Add");
		AddAuteurJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		
		JButton FilterAuteurJB = new JButton("Filter");
		FilterAuteurJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton ShowAllAuteurJB = new JButton("Show All");
		ShowAllAuteurJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AuteurJT = new Auteur().repaint(AuteurJT);
			}
		});
		GroupLayout gl_AuteursJPanel = new GroupLayout(AuteursJPanel);
		gl_AuteursJPanel.setHorizontalGroup(
			gl_AuteursJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AuteursJPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(AddAuteurJB)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(FilterAuteurJB)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ShowAllAuteurJB)
					.addContainerGap(288, Short.MAX_VALUE))
				.addComponent(AuteursJScrollPane, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
		);
		gl_AuteursJPanel.setVerticalGroup(
			gl_AuteursJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_AuteursJPanel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_AuteursJPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(AddAuteurJB)
						.addComponent(FilterAuteurJB)
						.addComponent(ShowAllAuteurJB))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(AuteursJScrollPane, GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
		);
		AuteursJPanel.setLayout(gl_AuteursJPanel);
		
		JPanel EtudiantsJPanel = new JPanel();
		tabbedPane.addTab("Etudiants", null, EtudiantsJPanel, null);
		
		EtudiantJT = makeJTable(new Etudiant());
		
		JScrollPane EtudiantJScrollPane = new JScrollPane(EtudiantJT);
		
		JButton ShowAllEtudiantJB = new JButton("Show All");
		ShowAllEtudiantJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EtudiantJT = new Etudiant().repaint(EtudiantJT);
			}
		});
		
		JButton FilterEtudiantJB = new JButton("Filter");
		FilterEtudiantJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton AddEtudiantJB = new JButton("Add");
		AddEtudiantJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout gl_EtudiantsJPanel = new GroupLayout(EtudiantsJPanel);
		gl_EtudiantsJPanel.setHorizontalGroup(
			gl_EtudiantsJPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_EtudiantsJPanel.createSequentialGroup()
					.addGroup(gl_EtudiantsJPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_EtudiantsJPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(AddEtudiantJB, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(FilterEtudiantJB, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(ShowAllEtudiantJB, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
						.addComponent(EtudiantJScrollPane, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_EtudiantsJPanel.setVerticalGroup(
			gl_EtudiantsJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_EtudiantsJPanel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_EtudiantsJPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(AddEtudiantJB)
						.addComponent(FilterEtudiantJB)
						.addComponent(ShowAllEtudiantJB))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(EtudiantJScrollPane, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
		);
	
		EtudiantsJPanel.setLayout(gl_EtudiantsJPanel);
		JPanel LivresJPanel = new JPanel();
		tabbedPane.addTab("Livres", null, LivresJPanel, null);
		LivreJT = makeJTable(new Livre());
		JScrollPane LivreJScrollPane = new JScrollPane(LivreJT);
		
		JButton ShowAllLivreJB = new JButton("Show All");
		ShowAllLivreJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LivreJT = new Livre().repaint(LivreJT);
			}
		});
		
		JButton FilterLivreJB = new JButton("Filter");
		FilterLivreJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton AddLivreJB = new JButton("Add");
		AddLivreJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GroupLayout gl_LivresJPanel = new GroupLayout(LivresJPanel);
		gl_LivresJPanel.setHorizontalGroup(
			gl_LivresJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LivresJPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(AddLivreJB, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(FilterLivreJB, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ShowAllLivreJB, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(249, Short.MAX_VALUE))
				.addComponent(LivreJScrollPane, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
		);
		gl_LivresJPanel.setVerticalGroup(
			gl_LivresJPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LivresJPanel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_LivresJPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(AddLivreJB)
						.addComponent(FilterLivreJB)
						.addComponent(ShowAllLivreJB))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(LivreJScrollPane, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
		);
	
		LivresJPanel.setLayout(gl_LivresJPanel);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	private JTable makeJTable(final Model Model) {
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
		
		AuteurJT = Model.setJTable(AuteurJT);

		return AuteurJT;
		return null;
	}
}
*/