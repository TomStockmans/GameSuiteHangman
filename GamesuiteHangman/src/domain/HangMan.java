package domain;

/**
 * Created by Henok on 10/05/2017.
 */
public class HangMan {
    private Speler speler;
    private Tekening tekening;
    private String hint;
    private boolean gewonnen;
    private boolean gameOver;

    public HangMan(Speler geldigeSpeler, WoordenLijst legeWoordenlijst) {
    }

    public Speler getSpeler() {
        return speler;
    }

    public Tekening getTekening() {
        return tekening;
    }

    public String getHint() {
        return hint;
    }

    public boolean isGewonnen() {
        return gewonnen;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void raad(char letter) {

    }
}
