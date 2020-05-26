
public class CavalliInGara implements Runnable {
	Cavallo Cav;
	GaraCavalli campo;
	int velocita;
	Thread t;
	int conta;
	int posizione;
	
	public CavalliInGara(Cavallo c, GaraCavalli g) {
		Cav=c;
		campo=g;
		conta=0;
		velocita=2;
		t = new Thread(this);
		t.start();
		posizione=0;
	}
	
	@Override
	public void run() {
		int dimImmagine=79;
		int dimPista=960;
		//while((Cav.))
		while((Cav.getX()+dimImmagine)<dimPista) {
			if ((conta%10)==0)
				velocita=(int)(Math.random()*10+1);
			Cav.setX(Cav.getX()+velocita);
			conta++;
			try {Thread.sleep(75);}
			catch (Exception e) {}
			campo.repaint();
		}
		
		posizione=campo.getPosizione();
		campo.controllaArrivi();
	}
	
}