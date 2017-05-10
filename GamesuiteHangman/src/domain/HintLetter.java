package domain;

public class HintLetter {
    private char letter;
    private boolean geraden;
    public HintLetter(char letter) {
    	this.letter = Character.toLowerCase(letter);
    }

    public boolean isGeraden() {
        return geraden;
    }

    public boolean raad(char x) {
    	x = Character.toLowerCase(x);
    	
    	if(geraden == true){return false;}
    	if(letter == x){
    		geraden = true;
    		return true;
    	}
    	
        return false;
    }

    public char toChar() {
    	if(isGeraden() == false){return '_';}
        return letter;
    }

    public char getLetter() {
        return letter;
    }
}
