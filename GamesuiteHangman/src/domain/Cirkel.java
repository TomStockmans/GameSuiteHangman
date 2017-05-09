package domain;

public class Cirkel extends Vorm {
	
	int radius;
	Punt middelpunt;
	
	public Cirkel(Punt middelpunt, int radius){
		setMiddelpunt(middelpunt);
		setRadius(radius);
		
	}
	
	public int getRadius() {
		return radius;
	}
	
	private void setRadius(int radius) {
		if(radius <= 0){throw new DomainException("ongeldige radius!");}
		this.radius = radius;
	}
	
	public Punt getMiddelpunt() {
		return middelpunt;
	}
	
	public void setMiddelpunt(Punt middelpunt) {
		if(middelpunt == null){throw new DomainException("ongeldig middelpunt!");}
		this.middelpunt = middelpunt;
	}
	
	@Override
	
	public boolean equals(Object o){
		if(o instanceof Cirkel){
			Cirkel cirkel = (Cirkel)o;
			
			if(cirkel.getMiddelpunt() == this.middelpunt && cirkel.getRadius() == this.radius){
				return true;
			}
			
			
		}
		return false;
	}

	@Override
	public String toString() {
		return "Cirkel : middelPunt: " +middelpunt.toString() + " - straal: " + radius ;
	}
	
	
	
	
}
