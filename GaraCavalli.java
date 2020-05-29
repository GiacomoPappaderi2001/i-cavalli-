import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GaraCavalli extends JFrame {
	int posizione;
	Cavallo[] partecipanti;
	CavalliInGara[] thread_partecipanti;
	Campo pista;
	Graphics offscreen;
	Image buffer_virtuale;
	int nCav=2;
	
	public GaraCavalli() {
		super("Gara Cavalli");
		setSize(1000, 1645);
		setLocation(10, 40);
		pista = new Campo();
		do {
			Scanner in=new Scanner(System.in);
			System.out.println("inserisci il numero di cavalli da gareggiare: ");
			nCav=in.nextInt();
		}while(nCav<2 || nCav>10);
		
		partecipanti = new Cavallo[nCav];
		thread_partecipanti = new CavalliInGara[nCav];
		posizione = 1;
		
		int partenza = 15;
		for (int xx=0; xx<nCav; xx++) {
			partecipanti[xx] = new Cavallo(partenza,  xx+1);
			thread_partecipanti[xx] = new CavalliInGara(partecipanti[xx], this);
			partenza = partenza+100;			
		}
		// visualizza la gara
		this.add(pista);
		setVisible(true);
	}
	
	public synchronized int getPosizione() {
		return posizione++;
	}
	
	public synchronized void controllaArrivi() {
		boolean arrivati=true;
		for (int xx=0; xx<nCav; xx++) {
			if (thread_partecipanti[xx].posizione==0) {
				arrivati=false;
			}
		}
		if(arrivati) {
			visualizzaClassifica();
		}
	}
	
	public void visualizzaClassifica() {
		JLabel[] arrivi;
		arrivi = new JLabel[10];
		JFrame classifica = new JFrame("Classifica");
		classifica.setSize(500, 500);
		classifica.setLocation(280, 130);
		classifica.setDefaultCloseOperation(EXIT_ON_CLOSE);
		classifica.getContentPane().setLayout(new GridLayout(5,1 ));
		
		for(int xx=1; xx<nCav+1; xx++) {
			for (int yy=0; yy<nCav; yy++) {
				if (thread_partecipanti[yy].posizione==1){
					arrivi[yy]=new JLabel("1' classificato in " + (yy+1)+"' corsia");
					arrivi[yy].setFont(new Font("times New Roman", Font.ITALIC, 20));
					arrivi[yy].setForeground(Color.RED);
					classifica.getContentPane().add(arrivi[yy]);
					yy=10;
					xx=11;
				}
			}
		}
		classifica.setVisible(true);
		
	}
	public void update(Graphics g) {
		paint(g);
	}
	
	public void paint(Graphics g) {
		if (partecipanti != null) {
			Graphics2D screen = (Graphics2D) g;
			buffer_virtuale= createImage(1000, 1645);
			offscreen = buffer_virtuale.getGraphics();
			Dimension d=getSize();
			pista.paint(offscreen);
			for (int xx=0; xx<nCav; xx++) {
				partecipanti[xx].paint(offscreen);
			}
			screen.drawImage(buffer_virtuale, 0, 30, this);
			offscreen.dispose();
		}
	}
	
	public static void main(String[] a) {
		GaraCavalli m=new GaraCavalli();
	}
}