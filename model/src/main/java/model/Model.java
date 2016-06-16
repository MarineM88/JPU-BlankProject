package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import contract.IModel;

public class Model extends Observable implements IModel {
	
	private List<Monster> monsters;
	private Hero hero;
	
	public Model() {
		monsters = new ArrayList<Monster>();
	}
	
	void createMonster(int x, int y, boolean dir) {
		monsters.add(new Golem(x, y, dir));
		monsters.add(new Masked(x, y, dir));
		monsters.add(new Zombie(x, y, dir));
		monsters.add(new RedHorns(x, y, dir));
	}
	
	public void init() {
		hero = new Hero(Worldmap.HERO_START_X , Worldmap.HERO_START_Y);
		createMonster(100,Worldmap.MONSTER_START_Y,true);
	}

	public void moveMonsters() {
		for (Monster m : monsters) m.nextTurn();
	}

	public List<Monster> getMonsters() {
		return monsters;
	}

	public Hero getHero() {
		return hero;
	}
	
	public Observable getObservable() {
		return null;
	}
}
