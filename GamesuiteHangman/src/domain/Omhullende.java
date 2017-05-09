package domain;

public class Omhullende extends Vorm{

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
		if(breedte < 0) throw new DomainException("Punt kan niet null zijn");
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
		if(hoogte < 0) throw new DomainException("Punt kan niet null zijn");
		this.hoogte = hoogte;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Omhullende)) return false;
		Omhullende omhullende = (Omhullende) obj;
		return (this.linkerbovenhoek.equals(omhullende.linkerbovenhoek) && this.breedte == omhullende.breedte &&  this.hoogte == omhullende.hoogte);
	}
	
}
