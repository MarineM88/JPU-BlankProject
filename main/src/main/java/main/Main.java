package main;

import javax.swing.Timer;

public abstract class Main {
	public static void main(String[] args) {
		Model md = new Model();
		md.init(); // on initialise le model
		View v = new View(md); // on crée la vue en lui passant le model en paramètre
		v.init(); // on initialise la vue
		
		Controller controller = new Controller(v , md); // on crée le controller en lui passant en paramètre la vue et le model
		v.getFrame().addKeyListener(controller); // on ajoute le controller à la frame
		v.getFrame().setFocusable(true); // pour dire à java d'enregistrer les évènements claviers
		
		
		Timer t = new Timer(80 , new TimerListener(md, v));
		t.start();
	}
}