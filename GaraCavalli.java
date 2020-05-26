import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;

public class GaraCavalli extends JFrame {
	int posizione;
	Cavallo[] partecipanti;
	CavalliInGara[] thread_partecipanti;
	Campo pista;
	Graphics offscreen;
	Image buffer_virtuale;
	int nCav=2;
	
		public static void main(String[] a) {
		GaraCavalli m=new GaraCavalli();
	}
}