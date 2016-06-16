package model;

import contract.IMobile;
import model.Mobile;

public abstract class Monster extends Mobile implements IMobile{
	private boolean direction;//true means from the left to the right
	
	public Monster(int x, int y, boolean dir) {
		this.x = x;
		this.y = y;
		this.width = Worldmap.MONSTER_WIDTH;
		this.height = Worldmap.MONSTER_HEIGHT;
		this.direction=dir;
	}

	@Override
	public void nextTurn() { // permet de déplacer les monstres de la gauche vers la droite et de haut en bas
		int x_max = x +2* width + Worldmap.MOVE_MONSTER_X;
		int x_min = x - width - Worldmap.MOVE_MONSTER_X;
		
		if (isAlive) {		
			if (direction) {
				if (x_max < Worldmap.MAP_WIDTH) {
					x += Worldmap.MOVE_MONSTER_X;
				} else {
					y += Worldmap.MOVE_MONSTER_Y;
					direction=false;
				}
			} 
			else {
				if (x_min > 0) {
					x -= Worldmap.MOVE_MONSTER_X;
				} else {
					y += Worldmap.MOVE_MONSTER_Y;
					direction=true;
				}
			}
		}
	}
}

