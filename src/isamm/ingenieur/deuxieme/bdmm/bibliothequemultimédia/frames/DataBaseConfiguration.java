package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.frames;

import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.utilities.KeyWords;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class DataBaseConfiguration extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8497148557540223512L;
	private JPanel contentPane;
	private final ButtonGroup ConnectionType = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					DataBaseConfiguration frame = new DataBaseConfiguration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private JLabel UserLabel = new JLabel("User : ");
	private JLabel PassLabel = new JLabel("Pass : ");
	private JLabel HostLabel = new JLabel("Host : ");
	private JLabel PortLabel = new JLabel("Port : ");
	private JLabel DBNameLabel = new JLabel("DBName");
	private JLabel DriverTypeLabel = new JLabel("Driver Type");
	private JPanel LocalConnection = new JPanel();
	private JPanel RemoteConnection = new JPanel();
	private JRadioButton RemoteDataBase = new JRadioButton("Remote DataBase");
	private JRadioButton LocalDatabase = new JRadioButton("Local DataBase");
	private JTextField HostTextField = new JTextField();
	private JTextField PortTextField = new JTextField();
	private JTextField UserTextField = new JTextField();
	private JTextField PassTextField = new JTextField();
	private JTextField DBNameTextField = new JTextField();
	private JTextField DriverTypeTextField = new JTextField();
	private JButton SaveJButton = new JButton("Save");
	private JButton RePopulateJButton = new JButton("Repopulate");

	public void setActiveConnectionType(JPanel toActivate, JPanel toDeactivate) {
		toDeactivate.setEnabled(false);
		Component[] componentsR = toDeactivate.getComponents();

		for (int i = 0; i < componentsR.length; i++) {
			componentsR[i].setEnabled(false);
		}
		toActivate.setEnabled(true);
		Component[] componentsL = toActivate.getComponents();

		for (int i = 0; i < componentsL.length; i++) {
			componentsL[i].setEnabled(true);
		}
	}
	
	public DataBaseConfiguration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		ConnectionType.add(LocalDatabase);
		ConnectionType.add(RemoteDataBase);

		LocalDatabase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setActiveConnectionType(LocalConnection, RemoteConnection);
			}
		});

		RemoteDataBase.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setActiveConnectionType(RemoteConnection, LocalConnection);
				JOptionPane.showMessageDialog(rootPane,
						"Remote Configuration not ready");
			}
		});
		SaveJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrintWriter writer;
				if (LocalDatabase.isSelected()) {

					try {
						writer = new PrintWriter(KeyWords._DBConf, "UTF-8");
						writer.println(KeyWords._ConnectionType + "="
								+ KeyWords._Local);
						writer.println(KeyWords._User + "="
								+ UserTextField.getText());
						writer.println(KeyWords._Pass + "="
								+ PassTextField.getText());
						writer.println(KeyWords._Host + "="
								+ HostTextField.getText());
						writer.println(KeyWords._Port + "="
								+ PortTextField.getText());
						writer.println(KeyWords._DBName + "="
								+ DBNameTextField.getText());
						writer.println(KeyWords._DriverType + "="
								+ DriverTypeTextField.getText());
						writer.close();
						dispose();
					} catch (FileNotFoundException
							| UnsupportedEncodingException ex) {
						JOptionPane.showMessageDialog(rootPane, ex.getMessage());
					}

				} else {
					try {
						writer = new PrintWriter(KeyWords._DBConf, "UTF-8");
						writer.println(KeyWords._ConnectionType + "="
								+ KeyWords._Remote);
						writer.close();
					} catch (FileNotFoundException
							| UnsupportedEncodingException ex) {
						JOptionPane.showMessageDialog(rootPane, ex.getMessage());
					}
				}
			}
		});
		DriverTypeTextField.setColumns(10);
		DBNameTextField.setColumns(10);
		PortTextField.setColumns(10);
		HostTextField.setColumns(10);
		PassTextField.setColumns(10);
		UserTextField.setColumns(10);

		RePopulateJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PopulateFieldsFromFile();
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addGap(30)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.LEADING,
																false)
														.addComponent(
																LocalDatabase)
														.addComponent(
																LocalConnection,
																0, 0,
																Short.MAX_VALUE)
														.addComponent(
																RemoteDataBase)
														.addComponent(
																RemoteConnection,
																GroupLayout.DEFAULT_SIZE,
																251,
																Short.MAX_VALUE))
										.addContainerGap(50, Short.MAX_VALUE))
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap(158, Short.MAX_VALUE)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_contentPane
																		.createSequentialGroup()
																		.addComponent(
																				RePopulateJButton)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				SaveJButton))
														.addGroup(
																gl_contentPane
																		.createParallelGroup(
																				Alignment.LEADING,
																				false)
																		.addGroup(
																				gl_contentPane
																						.createSequentialGroup()
																						.addComponent(
																								PassLabel)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addComponent(
																								PassTextField,
																								0,
																								0,
																								Short.MAX_VALUE))
																		.addGroup(
																				gl_contentPane
																						.createSequentialGroup()
																						.addComponent(
																								UserLabel)
																						.addPreferredGap(
																								ComponentPlacement.RELATED)
																						.addComponent(
																								UserTextField,
																								GroupLayout.PREFERRED_SIZE,
																								72,
																								GroupLayout.PREFERRED_SIZE))))
										.addGap(21)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_contentPane
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(LocalDatabase)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(LocalConnection,
												GroupLayout.PREFERRED_SIZE,
												100, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(RemoteDataBase)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(RemoteConnection,
												GroupLayout.PREFERRED_SIZE,
												117, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(UserLabel)
														.addComponent(
																UserTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(PassLabel)
														.addComponent(
																PassTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_contentPane
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																SaveJButton)
														.addComponent(
																RePopulateJButton))
										.addContainerGap(29, Short.MAX_VALUE)));
		LocalConnection.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY,
				Color.DARK_GRAY));
		RemoteConnection.setBorder(new BevelBorder(BevelBorder.LOWERED,
				Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY,
				Color.DARK_GRAY));
		GroupLayout gl_RemoteConnection = new GroupLayout(RemoteConnection);
		gl_RemoteConnection.setHorizontalGroup(gl_RemoteConnection
				.createParallelGroup(Alignment.LEADING).addGap(0, 387,
						Short.MAX_VALUE));
		gl_RemoteConnection.setVerticalGroup(gl_RemoteConnection
				.createParallelGroup(Alignment.LEADING).addGap(0, 144,
						Short.MAX_VALUE));

		GroupLayout gl_LocalConnection = new GroupLayout(LocalConnection);
		gl_LocalConnection
				.setHorizontalGroup(gl_LocalConnection
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_LocalConnection
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_LocalConnection
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_LocalConnection
																		.createSequentialGroup()
																		.addComponent(
																				HostLabel)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				HostTextField,
																				GroupLayout.PREFERRED_SIZE,
																				69,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				PortLabel)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				PortTextField,
																				GroupLayout.PREFERRED_SIZE,
																				44,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_LocalConnection
																		.createSequentialGroup()
																		.addGroup(
																				gl_LocalConnection
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								DriverTypeLabel)
																						.addComponent(
																								DBNameLabel))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				gl_LocalConnection
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								DBNameTextField,
																								GroupLayout.PREFERRED_SIZE,
																								68,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								DriverTypeTextField,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(50, Short.MAX_VALUE)));
		gl_LocalConnection
				.setVerticalGroup(gl_LocalConnection
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_LocalConnection
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_LocalConnection
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(HostLabel)
														.addComponent(
																HostTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(PortLabel)
														.addComponent(
																PortTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_LocalConnection
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																DriverTypeLabel)
														.addComponent(
																DriverTypeTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_LocalConnection
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																DBNameLabel)
														.addComponent(
																DBNameTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(13, Short.MAX_VALUE)));

		RemoteConnection.setLayout(gl_RemoteConnection);
		LocalConnection.setLayout(gl_LocalConnection);
		contentPane.setLayout(gl_contentPane);
		PopulateFieldsFromFile();
	}

	public void populateLocalFields(String Key, String Value, boolean Default) {
		if (Default == false) {
			if (Key.equals(KeyWords._User)) {
				UserTextField.setText(Value);
			} else if (Key.equals(KeyWords._Pass)) {
				PassTextField.setText(Value);
			} else if (Key.equals(KeyWords._Host)) {
				HostTextField.setText(Value);
			} else if (Key.equals(KeyWords._Port)) {
				PortTextField.setText(Value);
			} else if (Key.equals(KeyWords._DBName)) {
				DBNameTextField.setText(Value);
			} else if (Key.equals(KeyWords._DriverType)) {
				DriverTypeTextField.setText(Value);
			}
		} else {
			UserTextField.setText(KeyWords._Default_User);

			PassTextField.setText(KeyWords._Default_Pass);

			HostTextField.setText(KeyWords._Default_Host);

			PortTextField.setText(KeyWords._Default_Port);

			DBNameTextField.setText(KeyWords._Default_DBName);

			DriverTypeTextField.setText(KeyWords._Default_DriverType);
		}
	}

	private void PopulateFieldsFromFile() {
		Path path = Paths.get(KeyWords._DBConf);
		if (Files.exists(path)) {
			try {
				Scanner fileScanner = new Scanner(new File(KeyWords._DBConf));
				while (fileScanner.hasNext()) {
					String Line = fileScanner.next();
					String Key = Line.split("=")[0], Value = Line.split("=")[1];
					if (Key.equals(KeyWords._ConnectionType)) {
						if (Value.equals("Local")) {

							LocalDatabase.setSelected(true);
							setActiveConnectionType(LocalConnection,
									RemoteConnection);
						} else {
							RemoteDataBase.setSelected(true);
							setActiveConnectionType(RemoteConnection,
									LocalConnection);
						}
					} else if (LocalDatabase.isSelected()) {
						populateLocalFields(Key, Value, false);
					} else {

					}
				}
				fileScanner.close();
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(rootPane, "File Access Problem!");
			}
		}

		if (Files.notExists(path)) {
			LocalDatabase.setSelected(true);
			setActiveConnectionType(LocalConnection, RemoteConnection);
			populateLocalFields(null, null, true);
		}
	}
}
