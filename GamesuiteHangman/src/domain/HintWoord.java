package domain;

import java.util.ArrayList;
import domain.exceptions.*;

public class HintWoord {

	private String woord;
	private String geradenwoord = "";

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

		char[] letters = woord.toCharArray();
		for (int i = 0; i < letters.length; i++) {

			if (i == 0) {
				geradenwoord += "_";
			} else if (letters[i] == ' ') {
				geradenwoord += "  ";
			} else {
				geradenwoord += " _";
			}

		}

	}

	public boolean raad(char letter) {
		letter = Character.toLowerCase(letter);
		char[] letterswoord = woord.toCharArray();
		boolean geraden = false;
		String a = ""+letter;
		if(geradenwoord.contains(a)){return false;}
		for (int i=0; i<letterswoord.length; i++) {
			if (letterswoord[i] == letter) {
				
				geradenwoord = geradenwoord.substring(0, i*2) + letter + geradenwoord.substring(i*2+1);
				
				
				geraden = true;
			}
		}
		return geraden;
	}

	public boolean isGeraden() {
		if(!geradenwoord.contains("_")){return true;}
		return false;
	}

	@Override
	public String toString() {
		return geradenwoord;
	}

}
