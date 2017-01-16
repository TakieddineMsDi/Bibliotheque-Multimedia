package jTablesClasses;
import java.awt.Component;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ButtonsRenderer extends ButtonsPanel implements TableCellRenderer {


	public ButtonsRenderer(List<JButton> jbuttons,List<String> ButtonName) {
		super(jbuttons,ButtonName);
		setName("Table.cellRenderer");
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		this.setBackground(isSelected ? table.getSelectionBackground() : table
				.getBackground());
		return this;
	}
}