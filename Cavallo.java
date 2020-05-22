import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.applet.*;

import javax.swing.JPanel;

public class Cavallo extends JPanel {
	int x;
	int y;
	Image img;

	public Cavallo(int yy, int xx) {
		x = 0;
		y = yy;
		setSize(80, 81);
		Toolkit tk = Toolkit.getDefaultToolkit();

		switch (xx) {
		case 1: {
			img = tk.getImage(getClass().getResource("Cavallo1.jpg"));
			break;
		}
		case 2: {
			img = tk.getImage(getClass().getResource("Cavallo2.jpg"));
			break;
		}
		case 3: {
			img = tk.getImage(getClass().getResource("Cavallo3.jpg"));
			break;
		}
		case 4: {
			img = tk.getImage(getClass().getResource("Cavallo4.jpg"));
			break;
		}
		case 5: {
			img = tk.getImage(getClass().getResource("Cavallo5.jpg"));
			break;
		}
		case 6: {
			img = tk.getImage(getClass().getResource("Cavallo6.jpg"));
			break;
		}
		case 7: {
			img = tk.getImage(getClass().getResource("Cavallo7.jpg"));
			break;
		}
		case 8: {
			img = tk.getImage(getClass().getResource("Cavallo8.jpg"));
			break;
		}
		case 9: {
			img = tk.getImage(getClass().getResource("Cavallo9.jpg"));
			break;
		}
		case 10: {
			img = tk.getImage(getClass().getResource("Cavallo10.jpg"));
			break;
		}
		}
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(img, 1);
		try {
			mt.waitForID(1);
		} catch (Exception e) {
		}
	}
	
	public void setX(int n) {
		x = n;
	}
	
	public int getX() {
		return x;
	}
	
	
	public void paint(Graphics g) {
		g.drawImage(img,  x,  y, null);
	}
}