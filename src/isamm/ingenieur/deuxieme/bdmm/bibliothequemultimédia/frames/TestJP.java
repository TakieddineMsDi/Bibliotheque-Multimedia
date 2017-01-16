package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.frames;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;

import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Auteur;
import isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.models.Model;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class TestJP extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public TestJP() {
		super(new BorderLayout());
		JTable table = makeTable(new Auteur().getFieldsToShow(),new Auteur().getPreparedDataToshow());
		add(new JScrollPane(table));
		setBorder(BorderFactory
				.createTitledBorder("Multiple Buttons in a Table Cell"));
		setPreferredSize(new Dimension(320, 240));
		try {
			System.out.println("do you want to change data");
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private JTable makeTable(String[] columnNames,Object[][] data) {
		Model Entity = new Auteur();
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		final JTable table = new JTable(model);
		table.setRowHeight(36);
		table.setAutoCreateRowSorter(true);
		return table;
	}
	
	public static void main(String... args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	public static void createAndShowGUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException ex) {
			ex.printStackTrace();
		}
		JFrame frame = new JFrame("MultipleButtonsInTableCell");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TestJP());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}


}
