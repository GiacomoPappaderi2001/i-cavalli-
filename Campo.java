import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Campo extends JPanel {
	public void paint(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(0, 0, 1000, 1645);
		//Linee laterali
		g.setColor(Color.black);
		g.fillRect(0, 0, 1000, 10);
		g.fillRect(0, 100, 1000, 10);
		g.fillRect(0, 200, 1000, 10);
		g.fillRect(0, 300, 1000, 10);
		g.fillRect(0, 400, 1000, 10);
		g.fillRect(0, 500, 1000, 10);
		g.fillRect(0, 600, 1000, 10);
		g.fillRect(0, 700, 1000, 10);
		g.fillRect(0, 800, 1000, 10);
		g.fillRect(0, 900, 1000, 10);
		g.fillRect(0, 1000, 1000, 10);
		// Traguardo
		g.fillRect(960, 0, 5, 1645);
		g.fillRect(970, 0, 5, 1645);
		g.fillRect(980, 0, 5, 1645);
	}
}