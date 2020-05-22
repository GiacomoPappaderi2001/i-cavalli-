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
	
	