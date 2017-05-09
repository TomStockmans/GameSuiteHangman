package domain;

public class Cirkel extends Vorm{



	int radius;
	Punt middelpunt;

	public Cirkel(Punt middelpunt, int radius){

	}

	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		//if()
		this.radius = radius;
	}
	public Punt getMiddelpunt() {
		return middelpunt;
	}

	public void setMiddelpunt(Punt middelpunt) {
		this.middelpunt = middelpunt;
	}
	
}
