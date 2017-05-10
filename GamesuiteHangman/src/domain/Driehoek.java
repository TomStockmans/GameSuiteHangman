package domain;

import domain.exceptions.DomainException;

public class Driehoek extends Vorm{
	
	private Punt hoekpunt1;
	private Punt hoekpunt2;
	private Punt hoekpunt3;

	public Driehoek(Punt punt1, Punt punt2, Punt punt3) {
		this.setHoekPunten(punt1, punt2, punt3);
	}
	
	public void setHoekPunten(Punt punt1, Punt punt2, Punt punt3) throws DomainException {
		if (punt1==null || punt2==null || punt3==null){
			throw new DomainException("Hoeken mogen niet null zijn");
		}
		if (punt1.equals(punt2)||punt1.equals(punt3)||punt2.equals(punt3)){
			throw new DomainException("Hoeken mogen niet gelijk zijn");
		}
		if(opZelfdeLijn(punt1, punt2, punt3)){
			throw new DomainException("Hoeken op zelfde lijn");
		}
		this.hoekpunt1=punt1;
		this.hoekpunt2=punt2;
		this.hoekpunt3=punt3;
	}

	public Punt getHoekPunt1() {
		return hoekpunt1;
	}

	public Punt getHoekPunt2() {
		return hoekpunt2;
	}

	public Punt getHoekPunt3() {
		return hoekpunt3;
	}
	
	public boolean equals (Object object){
	if(!(object instanceof Driehoek)) return false;
	Driehoek driehoek = (Driehoek) object;
	if(this.getHoekPunt1() == driehoek.getHoekPunt1() && this.getHoekPunt2() == driehoek.getHoekPunt2() && this.getHoekPunt3()==driehoek.getHoekPunt3()) return true;
	return false;
	}

	@Override
	public Omhullende getOmhullende() {
		int xmin = Math.min(Math.min(getHoekPunt1().getX(), getHoekPunt2().getX()), getHoekPunt3().getX());
		int ymin = Math.min(Math.min(getHoekPunt1().getY(), getHoekPunt2().getY()), getHoekPunt3().getY());
		int xmax = Math.max(Math.max(getHoekPunt1().getX(), getHoekPunt2().getX()), getHoekPunt3().getX());
		int ymax = Math.max(Math.max(getHoekPunt1().getY(), getHoekPunt2().getY()), getHoekPunt3().getY());
		return new Omhullende(new Punt(xmin, ymin), xmax-xmin, ymax-ymin);
	}

	@Override
	public String toString() {
		return "Driehoek: hoekpunt1: "+this.getHoekPunt1().toString()+" - hoekpunt2: "+this.getHoekPunt2().toString()+" - hoekpunt3: "+this.getHoekPunt3();
	}
	
	private boolean opZelfdeLijn(Punt punt1, Punt punt2, Punt punt3){
		return (punt2.getX()-punt1.getX())*(punt3.getY()-punt1.getY())==((punt3.getX()-punt1.getX())*(punt2.getY()-punt1.getY()));
	}

}
