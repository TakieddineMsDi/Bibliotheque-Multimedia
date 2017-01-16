package jTablesClasses;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

class ButtonsPanel extends JPanel {
	public List<JButton> buttons/* = Arrays.asList(new JButton())*/;

	public ButtonsPanel(List<JButton> jbuttons,List<String> ButtonName) {
		super();
		setOpaque(true);
		buttons = jbuttons;
		int i=0;
		for (JButton b : buttons) {
			b.setText(ButtonName.get(i));
			i++;
			b.setFocusable(false);
			b.setRolloverEnabled(false);
			add(b);
		}
	}
}