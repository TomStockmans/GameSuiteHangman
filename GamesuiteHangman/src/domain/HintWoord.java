package domain;

import java.util.ArrayList;

public class HintWoord {

	private String woord;
	private String geradenwoord = "";
	private ArrayList<HintLetter> letters = new ArrayList<>();

	public HintWoord(String pwoord) {
	    HintLetter hintLetter;
        setWoord(pwoord);
		for (char letter: pwoord.toCharArray()) {
		    hintLetter = new HintLetter(letter);
		    if(!letters.contains(hintLetter) && letter != ' ') letters.add(hintLetter);
		}
        System.out.println(getWoord());
	}

	public String getWoord() {
		return woord;
	}

	private void setWoord(String woord) {
		if (woord == null || woord.isEmpty()) {
			throw new DomainException("Woord is ongeldig");
		}
		this.woord = woord;

	}
	
	public String getHint(){
	    geradenwoord = "";
        char[] letters = getWoord().toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if (i == 0) {
                int index = this.letters.indexOf(new HintLetter(letters[i]));
                if(this.letters.get(index).isGeraden()) geradenwoord += letters[i];
                else geradenwoord += "_";
            } else if (letters[i] == ' ') {
                geradenwoord += "  ";
            }else if (letters[i] == '-') {
                geradenwoord += " -";
            } else {
                int index = this.letters.indexOf(new HintLetter(letters[i]));
                if(this.letters.get(index).isGeraden()) geradenwoord += " "+letters[i];
                else geradenwoord += " _";
            }

        }
		return geradenwoord;
	}

	public boolean raad(char letter) {
		letter = Character.toLowerCase(letter);
        for (HintLetter hintLetter: letters) {
            if(hintLetter.isGeraden()) return false;
            if(hintLetter.raad(letter)){
                return true;
            }
        }
        return false;
	}

	public boolean isGeraden() {
	    return !getHint().contains("_");
	}

	@Override
	public String toString() {
		return getHint();
	}

}
