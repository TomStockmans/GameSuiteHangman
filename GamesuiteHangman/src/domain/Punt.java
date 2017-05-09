package domain;

public class Punt {
	
	private int x;
	private int y;
	
	public Punt(int x, int y){
		
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return x;
	}

	private void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	private void setY(int y) {
		this.y = y;
	}
	
	public boolean equals(Object object){
		if(!(object instanceof Punt)) return false;
		Punt punt = (Punt) object;
		if(this.getX() == punt.getX() && this.getY() == punt.getY()) return true;
		return false;
	}

	@Override
	public String toString() {
		return "Punt [x=" + x + ", y=" + y + "]";
	}
	
}
