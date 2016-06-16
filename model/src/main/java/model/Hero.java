package model;

import contract.IMobile;

public class Hero extends Entity implements IMobile{ // Position en x et en y de mon héro et sa hauteur et largeur

	public Hero(int x , int y) {
		this.x= x;
		this.y= y;
		this.width= Worldmap.HERO_WIDTH;
		this.height= Worldmap.HERO_HEIGHT;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}

