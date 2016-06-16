package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class TimerListener implements ActionListener{
	Model md;
	View v;
	
	public TimerListener(Model md , View v) {
		this.md = md;
		this.v = v;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		md.moveMonsters();
		v.refresh();
	}
}
