package model;

abstract class Mobile extends Entity{
	public int x = 0;
	public int y = 0;
	public int height = 0;
	public int width = 0;

	public boolean isAlive = true;
	
	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public int getHeight(){
		return height;
	}

	public int getWidth(){
		return width;
	}

	public abstract void nextTurn();
	
	public boolean getIsAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}
