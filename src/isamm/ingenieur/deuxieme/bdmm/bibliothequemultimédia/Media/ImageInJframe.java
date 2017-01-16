package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.Media;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import oracle.ord.im.OrdImage;

public class ImageInJframe extends JFrame {
	private static final long serialVersionUID = 762500635345178864L;

	public ImageInJframe(OrdImage image) {
		start(image);
	}

	public void start(OrdImage image) {
		ImageImplement panel = null;
		try {
			panel = new ImageImplement(
					new ImageIcon(image.getDataInByteArray()).getImage());
		} catch (OutOfMemoryError | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(panel);
		setVisible(true);
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}