package isamm.ingenieur.deuxieme.bdmm.bibliothequemultimédia.Media;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImageImplement extends JPanel {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image img;


	  public ImageImplement(Image img) {
	    this.img = img.getScaledInstance(300, 300, 300);
	    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
	    setPreferredSize(size);
	    setMinimumSize(size);
	    setMaximumSize(size);
	    setSize(size);
	    setLayout(null);
	    Thread repainter = new Thread(new Runnable() {
	        @Override
	        public void run() {
	            while (true) { // I recommend setting a condition for your panel being open/visible
	                repaint();
	                try {
	                    Thread.sleep(30);
	                } catch (InterruptedException ignored) {
	                }
	            }
	        }
	    });
	    repainter.setName("Panel repaint");
	    repainter.setPriority(Thread.MIN_PRIORITY);
	    repainter.start();
	  }

	  public void paintComponent(Graphics g) {
	    g.drawImage(img, 0, 0, null);
	  }

	}