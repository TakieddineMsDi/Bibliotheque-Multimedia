package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.frames;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShowMessage extends JFrame {
	private static final long serialVersionUID = 2279086524818510018L;

	public ShowMessage(String Source,String Message,Exception E) {
		if(E!=null){
			E.printStackTrace();	
		}
		JOptionPane.showMessageDialog(rootPane, Source+"\n"+Message);
		this.dispose();
	}

}
