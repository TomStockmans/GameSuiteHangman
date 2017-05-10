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

		for (int i : woord.toCharArray()) {
			if (i == letter) {
				return true;
			}
		}

		return false;
	}

	public boolean isGeraden() {
		return geradenwoord == woord;
	}

	@Override
	public String toString() {
		return geradenwoord;
	}

}
