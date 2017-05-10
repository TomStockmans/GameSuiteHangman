package domain;

import domain.exceptions.DomainException;

public class WoordenLezer {
	
	private String naam;
	
	public WoordenLezer(String bestand) {
		this.setNaam(bestand);
	}
	
	public WoordenLijst lees(){
		WoordenLijst woordenlijst = new WoordenLijst();
		return woordenlijst;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) throws DomainException {
		if(null==naam || naam.trim().isEmpty()) throw new DomainException("");
		this.naam = naam;
	}
	
	

}
