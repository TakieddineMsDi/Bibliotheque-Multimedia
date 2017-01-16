package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.frames;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Choice;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;

public class Update extends JFrame {

	public static void main(String[] args) {
		new Update();
	}

	public Update() {
		paintLivre();
	}

	public void paintLivre() {
		String ImageURL = null;
		JPanel contentPane = new JPanel();
		JLabel ImageJL = new JLabel("No File Chosen !");
		JLabel ISBNJL = new JLabel("ISBN : ");
		JLabel TitreJL = new JLabel("Titre : ");
		JLabel DatePublicationJL = new JLabel("Date Publication : ");
		JLabel EditeurJL = new JLabel("Editeur : ");
		JLabel LotsClesJL = new JLabel("Lots Cl\u00E9s");
		JLabel ActionJL = new JLabel("Livre Action : ");
		JLabel NombreDexemplairesJL = new JLabel("Nombre d'exemplaires : ");
		JLabel AuteurJL = new JLabel("Auteurs : ");
		JTextField TitreJTF;
		JDateChooser DatePublicationJDC;
		JTextField EditeurJTF;
		JTextField LotsClesJTF;
		JTextField NombreExemplaireJTF;
		JTextField ISBNJTF;
		DatePublicationJDC = new JDateChooser();
		EditeurJTF = new JTextField();
		LotsClesJTF = new JTextField();
		JButton CancelJB = new JButton("Cancel");
		JButton UpdateJB = new JButton("Add/Update/Search");
		NombreExemplaireJTF = new JTextField();
		ISBNJTF = new JTextField();
		TitreJTF = new JTextField();
		JButton ImageIB = new JButton("Choose Image");

		ImageIB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String URL = chooser.getSelectedFile().getPath().toString();
					// ImageJL.setText(URL.substring(URL.lastIndexOf("\\") + 1,
					// URL.length()));
					// ImageURL = URL;
				}

			}
		});
		TitreJTF.setColumns(10);
		ISBNJTF.setColumns(10);
		LotsClesJTF.setColumns(10);
		EditeurJTF.setColumns(10);
		NombreExemplaireJTF.setColumns(10);
		CancelJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		UpdateJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 100, 582, 375);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JScrollPane AuteursJScrollPane = new JScrollPane();


		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addContainerGap()
											.addComponent(AuteursJScrollPane, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addContainerGap()
											.addComponent(ISBNJTF, 120, 120, 120))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(39)
											.addComponent(ImageJL)
											.addGap(13))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(59)
											.addComponent(ISBNJL)
											.addGap(38))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(29)
											.addComponent(ImageIB, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))
									.addGap(39))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(50)
									.addComponent(AuteurJL)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(DatePublicationJL)
									.addPreferredGap(ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
									.addComponent(DatePublicationJDC, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(LotsClesJL)
										.addComponent(EditeurJL))
									.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(EditeurJTF, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
										.addComponent(LotsClesJTF, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(NombreDexemplairesJL)
									.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
									.addComponent(NombreExemplaireJTF, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(TitreJL)
									.addPreferredGap(ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
									.addComponent(TitreJTF, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
									.addComponent(CancelJB)
									.addGap(18)
									.addComponent(UpdateJB))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(243)
							.addComponent(ActionJL)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(ActionJL)
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(ImageIB)
								.addComponent(TitreJL)
								.addComponent(TitreJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(ImageJL)
								.addComponent(DatePublicationJDC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(DatePublicationJL))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(EditeurJL)
						.addComponent(ISBNJL)
						.addComponent(EditeurJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ISBNJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(LotsClesJL)
								.addComponent(LotsClesJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(NombreDexemplairesJL)
								.addComponent(NombreExemplaireJTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(CancelJB)
								.addComponent(UpdateJB)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(11)
							.addComponent(AuteurJL)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(AuteursJScrollPane, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))
					.addGap(18))
		);
		
		JList AuteurJList = new JList();
		AuteurJList.setModel(new AbstractListModel() {
			String[] values = new String[] {"----", "dfsdfsd", "dsfsdf", "sdfsdf", "dsds", "dsf", "sd", "fs", "df", "sdf", "sd", "f"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		AuteurJList.setSelectedIndex(0);
		AuteursJScrollPane.setViewportView(AuteurJList);
		contentPane.setLayout(gl_contentPane);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addComponent(contentPane,
				GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addComponent(contentPane, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);
		setVisible(true);
	}

	public void paintEtudiant() {
		JPanel contentPane = new JPanel();
		JLabel Num_PersonneJL = new JLabel("Numero : ");
		JTextField Num_PersonneJTF;
		JTextField NomJTF;
		JTextField PrenomJTF;
		JTextField AdresseJTF;
		JTextField MailJTF;
		JTextField LoginJTF;
		JPasswordField PasswordJTF;
		JTextField Nb_EmpruntJTF;
		Num_PersonneJTF = new JTextField();
		JLabel NomJL = new JLabel("Nom : ");

		JLabel PrenomJL = new JLabel("Prenom : ");

		JLabel AdresseJL = new JLabel("Adresse : ");

		JLabel MailJL = new JLabel("Mail : ");

		JLabel LoginJL = new JLabel("Login : ");

		JLabel PasswordJL = new JLabel("Password : ");

		JLabel Date_Validite_CarteJL = new JLabel("Date Validit\u00E9 Carte : ");

		JLabel Nb_EmpruntJL = new JLabel("Nombre d'emprunt : ");

		NomJTF = new JTextField();
		PrenomJTF = new JTextField();
		AdresseJTF = new JTextField();
		MailJTF = new JTextField();
		LoginJTF = new JTextField();
		PasswordJTF = new JPasswordField();
		Nb_EmpruntJTF = new JTextField();
		contentPane = new JPanel();
		JLabel ActionJL = new JLabel("Etudiant Action : ");
		JDateChooser DateValiditeCarteJDC;
		DateValiditeCarteJDC = new JDateChooser();
		DateValiditeCarteJDC.setDate(new Date(500));
		JButton CancelJB = new JButton("Cancel");
		JButton UpdateJB = new JButton("Add/Update/Search");
		Num_PersonneJTF.setEditable(false);
		Num_PersonneJTF.setEnabled(false);
		Num_PersonneJTF.setColumns(10);
		NomJTF.setColumns(10);

		PrenomJTF.setColumns(10);

		AdresseJTF.setColumns(10);

		MailJTF.setColumns(10);

		LoginJTF.setColumns(10);

		Nb_EmpruntJTF.setColumns(10);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 100, 527, 459);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		java.sql.Date sqldate = new java.sql.Date(DateValiditeCarteJDC
				.getDate().getTime());
		System.out.println(sqldate.toString());
		CancelJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		
		UpdateJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		// DateValiditeCarteJTF.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_contentPane.createSequentialGroup()
										.addContainerGap(198, Short.MAX_VALUE)
										.addComponent(ActionJL).addGap(190))
						.addGroup(
								Alignment.LEADING,
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																Num_PersonneJTF,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(16)
																		.addComponent(
																				Num_PersonneJL)))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				Nb_EmpruntJL)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				Nb_EmpruntJTF,
																				GroupLayout.PREFERRED_SIZE,
																				200,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								NomJL)
																						.addComponent(
																								PrenomJL)
																						.addComponent(
																								AdresseJL)
																						.addComponent(
																								MailJL)
																						.addComponent(
																								LoginJL)
																						.addComponent(
																								PasswordJL)
																						.addComponent(
																								Date_Validite_CarteJL))
																		.addGap(2)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								LoginJTF,
																								GroupLayout.DEFAULT_SIZE,
																								200,
																								Short.MAX_VALUE)
																						.addComponent(
																								MailJTF,
																								GroupLayout.DEFAULT_SIZE,
																								200,
																								Short.MAX_VALUE)
																						.addComponent(
																								AdresseJTF,
																								GroupLayout.DEFAULT_SIZE,
																								200,
																								Short.MAX_VALUE)
																						.addComponent(
																								PrenomJTF,
																								GroupLayout.DEFAULT_SIZE,
																								200,
																								Short.MAX_VALUE)
																						.addComponent(
																								NomJTF,
																								GroupLayout.DEFAULT_SIZE,
																								200,
																								Short.MAX_VALUE)
																						.addComponent(
																								PasswordJTF)
																						.addComponent(
																								DateValiditeCarteJDC,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))))
										.addContainerGap(63, Short.MAX_VALUE))
						.addGroup(
								gl_contentPane.createSequentialGroup()
										.addContainerGap(281, Short.MAX_VALUE)
										.addComponent(CancelJB).addGap(18)
										.addComponent(UpdateJB)
										.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								Alignment.LEADING,
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(ActionJL)
										.addGap(33)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				Num_PersonneJL)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				Num_PersonneJTF,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(5)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								NomJL)
																						.addComponent(
																								NomJTF,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(18)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								PrenomJL)
																						.addComponent(
																								PrenomJTF,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(AdresseJL)
														.addComponent(
																AdresseJTF,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(MailJL)
														.addComponent(
																MailJTF,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(LoginJL)
														.addComponent(
																LoginJTF,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																PasswordJL)
														.addComponent(
																PasswordJTF,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																Date_Validite_CarteJL)
														.addComponent(
																DateValiditeCarteJDC,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																Nb_EmpruntJL)
														.addComponent(
																Nb_EmpruntJTF,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(UpdateJB)
														.addComponent(CancelJB))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addComponent(contentPane, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				Alignment.LEADING).addComponent(contentPane,
				GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE));
		getContentPane().setLayout(groupLayout);
		setVisible(true);
	}

	public void paintAuteur() {
		String ImageURL = null;
		String VideoURL;
		JPanel contentPane;
		JTextField Num_PersonneJTF;
		JTextField NomJTF;
		JTextField PrenomJTF;
		JTextField AdresseJTF;
		JTextField MailJTF;
		JLabel VideoJL = new JLabel("No File Chosen !");
		JLabel Num_PersonneJL = new JLabel("Numero : ");
		JLabel NomJL = new JLabel("Nom : ");
		JLabel PrenomJL = new JLabel("Prenom : ");
		JLabel AdresseJL = new JLabel("Adresse");
		JLabel MailJL = new JLabel("Mail : ");
		Num_PersonneJTF = new JTextField();
		NomJTF = new JTextField();
		PrenomJTF = new JTextField();
		AdresseJTF = new JTextField();
		MailJTF = new JTextField();
		JLabel ActionJL = new JLabel("Auteur Action : ");
		JButton ImageJB = new JButton("Choose Image");
		JLabel ImageJL = new JLabel("No File Chosen !");
		JButton VideoJB = new JButton("Choose Video");
		JButton CancelJB = new JButton("Cancel");
		JButton UpdateJB = new JButton("Add/Update/Search");
		ImageJB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String URL = chooser.getSelectedFile().getPath().toString();
					// ImageJL.setText(URL.substring(URL.lastIndexOf("\\") + 1,
					// URL.length()));
					// ImageURL = URL;
				}

			}
		});
		VideoJB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String URL = chooser.getSelectedFile().getPath().toString();
					// VideoJL.setText(URL.substring(URL.lastIndexOf("\\") + 1,
					// URL.length()));
					// VideoURL = URL;
				}

			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 100, 457, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		Num_PersonneJTF.setEnabled(false);
		Num_PersonneJTF.setEditable(false);
		Num_PersonneJTF.setColumns(10);
		NomJTF.setColumns(10);
		PrenomJTF.setColumns(10);
		AdresseJTF.setColumns(10);
		MailJTF.setColumns(10);

		CancelJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		UpdateJB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(164)
																		.addComponent(
																				ActionJL))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_contentPane
																										.createSequentialGroup()
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																ImageJB)
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addGap(10)
																																		.addComponent(
																																				ImageJL))
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addGap(10)
																																		.addGroup(
																																				gl_contentPane
																																						.createParallelGroup(
																																								Alignment.LEADING)
																																						.addGroup(
																																								gl_contentPane
																																										.createSequentialGroup()
																																										.addGap(19)
																																										.addComponent(
																																												Num_PersonneJL))
																																						.addGroup(
																																								gl_contentPane
																																										.createParallelGroup(
																																												Alignment.TRAILING)
																																										.addComponent(
																																												Num_PersonneJTF,
																																												GroupLayout.PREFERRED_SIZE,
																																												75,
																																												GroupLayout.PREFERRED_SIZE)
																																										.addComponent(
																																												VideoJL)))))
																										.addGap(33)
																										.addGroup(
																												gl_contentPane
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addGroup(
																																				gl_contentPane
																																						.createParallelGroup(
																																								Alignment.LEADING)
																																						.addComponent(
																																								AdresseJL)
																																						.addComponent(
																																								MailJL))
																																		.addGap(18)
																																		.addGroup(
																																				gl_contentPane
																																						.createParallelGroup(
																																								Alignment.LEADING)
																																						.addComponent(
																																								MailJTF,
																																								GroupLayout.PREFERRED_SIZE,
																																								194,
																																								GroupLayout.PREFERRED_SIZE)
																																						.addComponent(
																																								AdresseJTF,
																																								GroupLayout.PREFERRED_SIZE,
																																								194,
																																								GroupLayout.PREFERRED_SIZE)))
																														.addGroup(
																																gl_contentPane
																																		.createSequentialGroup()
																																		.addGroup(
																																				gl_contentPane
																																						.createParallelGroup(
																																								Alignment.LEADING)
																																						.addComponent(
																																								PrenomJL)
																																						.addComponent(
																																								NomJL))
																																		.addPreferredGap(
																																				ComponentPlacement.UNRELATED)
																																		.addGroup(
																																				gl_contentPane
																																						.createParallelGroup(
																																								Alignment.LEADING)
																																						.addComponent(
																																								NomJTF,
																																								GroupLayout.PREFERRED_SIZE,
																																								194,
																																								GroupLayout.PREFERRED_SIZE)
																																						.addComponent(
																																								PrenomJTF,
																																								GroupLayout.PREFERRED_SIZE,
																																								194,
																																								GroupLayout.PREFERRED_SIZE)))))
																						.addComponent(
																								VideoJB))))
										.addContainerGap(31, Short.MAX_VALUE))
						.addGroup(
								Alignment.TRAILING,
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap(259, Short.MAX_VALUE)
										.addComponent(CancelJB)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(UpdateJB)
										.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								Alignment.LEADING,
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(ActionJL)
										.addGap(18)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				ImageJB)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				ImageJL))
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addGap(23)
																		.addGroup(
																				gl_contentPane
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								NomJL)
																						.addComponent(
																								NomJTF,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))))
										.addGap(24)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(PrenomJL)
														.addComponent(
																PrenomJTF,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(5)
										.addComponent(VideoJB)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(VideoJL)
														.addComponent(AdresseJL)
														.addComponent(
																AdresseJTF,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(32)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																Num_PersonneJL)
														.addComponent(MailJL)
														.addComponent(
																MailJTF,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(Num_PersonneJTF,
												GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED, 8,
												Short.MAX_VALUE)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(CancelJB)
														.addComponent(UpdateJB))
										.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}
}
