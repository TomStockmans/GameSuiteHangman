package domain;

import domain.exceptions.DomainException;

public class HintWoord {

	private String woord;
	private String geradenwoord;

	public HintWoord(String pwoord) {
		setWoord(pwoord);
	}

	public String getWoord() {
		return woord;
	}

	private void setWoord(String woord) {
		if (woord == null || woord.trim().isEmpty()) {
			throw new DomainException("Woord is ongeldig");
		}
		this.woord = woord;
		// this.geradenwoord = geradenwoord.replaceAll("/ /", " ");
		// this.geradenwoord = woord.replaceAll("/[^\s]/", " _");
		char[] letters = woord.toCharArray();
		for (int i = 0; i < letters.length; i++) {

			if (letters[i] == ' ') {
				geradenwoord += "  ";
			} 
			
			else {
				if (i == 0) {
					geradenwoord += "_";
				} else {
					if (letters[i - 1] != ' ') {
						geradenwoord += " _";
					} else {
						geradenwoord += "_";
					}
				}
			}

		}

	}

	public boolean raad(char letter) {
		
		
		
		return (woord.charAt(letter) >= 0);
	}

	public boolean komtWoordOvereen(){
		String teradenwoord = "";
		for(int i = 0; i<geradenwoord.length(); i++){
			if(geradenwoord.indexOf(i-1) == ' ' && geradenwoord.indexOf(i) == ' ' ){
				
			}
			else{
				teradenwoord += geradenwoord.indexOf(i);
			}
		}
		return false;
	}
	
	public boolean isGeraden() {
		return geradenwoord == woord;	
	}

	@Override
	public String toString() {
		return null;
	}

}
