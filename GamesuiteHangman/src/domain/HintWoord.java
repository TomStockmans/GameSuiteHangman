package domain;

/**
 * Created by Henok on 10/05/2017.
 */
public class HintWoord {
    private String woord;
    private boolean geraden;
    public HintWoord(String woord) {
        this.woord = woord;
    }

    public String getWoord() {
        return woord;
    }

    public boolean isGeraden() {
        return geraden;
    }

    public boolean raad(char a) {
        return false;
    }
}
