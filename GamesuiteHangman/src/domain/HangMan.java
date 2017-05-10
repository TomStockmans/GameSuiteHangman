package domain;

/**
 * Created by Henok on 10/05/2017.
 */
public class HangMan {
    public HangMan(Speler geldigeSpeler, WoordenLijst legeWoordenlijst) {
    }

    public Tekening getSpeler() {
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
