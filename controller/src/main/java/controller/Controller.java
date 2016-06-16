package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;

public class Controller implements KeyListener {
	private JLabel heroLabel;
	private Model md;
	private View v;
	
	public Controller(View v , Model md) {
		this.md = md;
		this.v = v;
		this.heroLabel = v.getLabelHero();
	}
	
	private void moveRight() { 
		if (heroLabel.getBounds().getX() <= 820) {
		double x = heroLabel.getBounds().getX() + Worldmap.MOVE_HERO;
		double y = heroLabel.getBounds().getY();
		double width = heroLabel.getBounds().getWidth();
		double height = heroLabel.getBounds().getHeight();
		md.getHero().setX((int)x);
		heroLabel.setBounds((int)x, (int) y, (int)width, (int)height);
		}
	}
	
	private void moveLeft() { 
		if (heroLabel.getBounds().getX() > -20) {
		double x = heroLabel.getBounds().getX() - Worldmap.MOVE_HERO;
		double y = heroLabel.getBounds().getY();
		double width = heroLabel.getBounds().getWidth();
		double height = heroLabel.getBounds().getHeight();
		md.getHero().setX((int)x);
		heroLabel.setBounds((int)x, (int) y, (int)width, (int)height);
		}
	}
	
	private void moveUp() { 
		if (heroLabel.getBounds().getY() > 0) {
		double x = heroLabel.getBounds().getX();
		double y = heroLabel.getBounds().getY() - Worldmap.MOVE_HERO;
		double width = heroLabel.getBounds().getWidth();
		double height = heroLabel.getBounds().getHeight();
		md.getHero().setX((int)x);
		heroLabel.setBounds((int)x, (int) y, (int)width, (int)height);
		}
	}
	
	private void moveDown() { 
		if (heroLabel.getBounds().getY() < 580) {
		double x = heroLabel.getBounds().getX();
		double y = heroLabel.getBounds().getY() + Worldmap.MOVE_HERO;
		double width = heroLabel.getBounds().getWidth();
		double height = heroLabel.getBounds().getHeight();
		md.getHero().setX((int)x); // donne les nouvelles coordonnées au modèle
		heroLabel.setBounds((int)x, (int) y, (int)width, (int)height);	
		}
	}
	
	@Override
	public void keyPressed(KeyEvent kev) { // appuyez sur la touche
		switch (kev.getKeyCode()) {
			case KeyEvent.VK_LEFT: moveLeft();break;
			case KeyEvent.VK_RIGHT: moveRight();break;
			case KeyEvent.VK_UP: moveUp();break;
			case KeyEvent.VK_DOWN: moveDown();break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
