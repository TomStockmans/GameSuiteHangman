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
    	
    	if(geraden) return false;
    	if(letter == x){
    		geraden = true;
    		return true;
    	}
    	
        return false;
    }

    public char toChar() {
    	if(isGeraden())return letter;
        return '_';
    }

    public char getLetter() {
        return letter;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof HintLetter)) return false;
        HintLetter letter = (HintLetter) obj;
        return this.getLetter() == letter.getLetter();
    }
}
