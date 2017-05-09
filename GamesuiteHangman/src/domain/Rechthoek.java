package domain;

public class Rechthoek extends Vorm {

	private Punt punt;
	private int breedte;
	private int hoogte;

	public Rechthoek(Punt linkerBovenhoek, int breedte, int hoogte) {
		setBreedte(breedte);
		setHoogte(hoogte);
		setLinkerBovenhoek(linkerBovenhoek);
	}

	// getters en setters

	public Punt getLinkerBovenhoek() {
		return punt;
	}

	private void setLinkerBovenhoek(Punt punt) {
		if(punt == null){throw new DomainException("");}
		this.punt = punt;
	}

	public int getBreedte() {
		return breedte;
	}

	private void setBreedte(int breedte) {
		if (breedte <= 0) {
			throw new DomainException("breedte is niet correct!");
		}
		this.breedte = breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	private void setHoogte(int hoogte) {
		if (hoogte <= 0) {
			throw new DomainException("hoogte rechthoek is niet correct!");
		}
		this.hoogte = hoogte;
	}

	// methodes

	@Override
	public boolean equals(Object o) {
		if (o instanceof Rechthoek) {
			Rechthoek rechthoek = (Rechthoek)o;
			if (this.getLinkerBovenhoek() == rechthoek.getLinkerBovenhoek() && this.getBreedte() == rechthoek.getBreedte() && this.hoogte == rechthoek.getHoogte()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Rechthoek: " + punt.toString() + " - breedte: " + breedte + " - hoogte: " + hoogte;
	}

}
