package domain;

public class HintLetter {
    private char letter;
    private boolean geraden;
    public HintLetter(char letter) {
    }

    public boolean isGeraden() {
        return geraden;
    }

    public boolean raad(char x) {
        return false;
    }

    public char toChar() {
        return letter;
    }

    public char getLetter() {
        return letter;
    }
}
