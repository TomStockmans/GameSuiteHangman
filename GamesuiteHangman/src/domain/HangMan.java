package domain;

import domain.exceptions.DomainException;

/**
 * Created by Henok on 10/05/2017.
 */
public class HangMan {
    private Speler speler;
    private Tekening tekening;
    private String hint;
    private String woord;
    private WoordenLijst woordenLijst;
    private boolean gewonnen;
    private boolean gameOver;

    public HangMan(Speler geldigeSpeler, WoordenLijst woordenLijst) {
        setSpeler(geldigeSpeler);
        setWoordenLijst(woordenLijst);
        tekening = new Tekening("Hangman");
    }

    public Speler getSpeler() {
        return speler;
    }

    public void setSpeler(Speler speler) {
        if(null == speler) throw new DomainException("Speler kan niet null zijn");
        this.speler = speler;
    }

    public WoordenLijst getWoordenLijst() {
        return woordenLijst;
    }

    public void setWoordenLijst(WoordenLijst woordenLijst) {
        if(null == woordenLijst) throw new DomainException("Woordenlijst kan niet null of leeg zijn");
        this.woordenLijst = woordenLijst;
    }

    public Tekening getTekening() {
        return tekening;
    }

    public String getHint() {
        return hint;
    }

    public String getWoord() {
        return woord;
    }

    public void setWoord(String woord) {
        if(null == woord || woord.isEmpty()) throw new DomainException("Woord kan niet null of leeg zijn");
        this.woord = woord;
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
