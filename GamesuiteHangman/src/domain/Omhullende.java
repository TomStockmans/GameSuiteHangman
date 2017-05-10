package domain;

import domain.exceptions.DomainException;

public class Omhullende{
	
	public Omhullende(Punt linkerBovenhoek, int breedte, int hoogte) {
		setLinkerBovenhoek(linkerBovenhoek);
		setBreedte(breedte);
		setHoogte(hoogte);
	}
	
	private Punt linkerbovenhoek;
	private int breedte;
	private int hoogte;
	/**
	 * @return the linkerbovenhoek
	 */
	public Punt getLinkerBovenhoek() {
		return linkerbovenhoek;
	}
	/**
	 * @param linkerbovenhoek the linkerbovenhoek to set
	 */
	public void setLinkerBovenhoek(Punt linkerbovenhoek) {
		if(linkerbovenhoek == null) throw new DomainException("Punt kan niet null zijn");
		this.linkerbovenhoek = linkerbovenhoek;
	}
	/**
	 * @return the breedte
	 */
	public int getBreedte() {
		return breedte;
	}
	/**
	 * @param breedte the breedte to set
	 */
	public void setBreedte(int breedte) {
		if(breedte < 0) throw new DomainException("Breedte kan niet negatief zijn");
		this.breedte = breedte;
	}
	/**
	 * @return the hoogte
	 */
	public int getHoogte() {
		return hoogte;
	}
	/**
	 * @param hoogte the hoogte to set
	 */
	public void setHoogte(int hoogte) {
		if(hoogte < 0) throw new DomainException("Hoogte kan niet negatief zijn");
		this.hoogte = hoogte;
	}
	
	public int getMinX(){
		return this.getLinkerBovenhoek().getX();
	}
	
	public int getMaxX(){
		return this.getMinX()+this.getBreedte();
	}
	
	public int getMinY(){
		return this.getLinkerBovenhoek().getY();
	}
	
	public int getMaxY(){
		return this.getMinY()+this.getHoogte();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Omhullende)) return false;
		Omhullende omhullende = (Omhullende) obj;
		return (this.linkerbovenhoek.equals(omhullende.linkerbovenhoek) && this.breedte == omhullende.breedte &&  this.hoogte == omhullende.hoogte);
	}

//	@Override
//	public Omhullende getOmhullende() {
//		return this;
//	}

	@Override
	public String toString(){
		return "Omhullende: "+this.getLinkerBovenhoek().toString()+" - "+this.getBreedte()+" - "+this.getHoogte();
	}
	
}
