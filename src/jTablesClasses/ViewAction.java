package jTablesClasses;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JTable;

class ViewAction extends AbstractAction {
	private final JTable table;

	public ViewAction(JTable table) {
		super("vdit");
		this.table = table;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(table, "Viewing");
	}
}