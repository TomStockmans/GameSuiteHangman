package domain;

/**
 * Created by Henok on 10/05/2017.
 */
public class HangMan {
    private Speler speler;
    private Tekening tekening;
    private HintWoord hintWoord;
    private WoordenLijst woordenLijst;
    private boolean gewonnen;
    private boolean gameOver;
    private int fails;
    public HangMan(Speler geldigeSpeler, WoordenLijst woordenLijst) {
        setSpeler(geldigeSpeler);
        setWoordenLijst(woordenLijst);
        tekening = new HangManTekening("Hangman");
        setWoord(woordenLijst.getRandomWoord());
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
        if(null == woordenLijst || woordenLijst.getAantalWoorden() == 0) throw new DomainException("Woordenlijst kan niet null of leeg zijn");
        this.woordenLijst = woordenLijst;
    }

    public Tekening getTekening() {
        return tekening;
    }

    public String getHint() {
        return hintWoord.getHint();
    }

    public String getWoord() {
        return hintWoord.getWoord();
    }

    private void setWoord(String woord) {
        if(null == woord || woord.isEmpty()) throw new DomainException("Woord kan niet null of leeg zijn");
        this.hintWoord = new HintWoord(woord);
    }

    public boolean isGewonnen() {
        return gewonnen;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean raad(char letter) {
        boolean ok = hintWoord.raad(letter);
        if(!ok) extraVormen();
        if(hintWoord.isGeraden()) gewonnen = true;
        return ok;
    }

    public void extraVormen(){
        if(fails == 0){
            Vorm hoofd = new Cirkel(new Punt(280, 125), 25);
            getTekening().voegToe(hoofd);
        }else if(fails == 1){
            Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);
            getTekening().voegToe(oogLinks);
        }else if(fails == 2){
            Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);
            getTekening().voegToe(oogRechts);
        }else if(fails == 3){
            Vorm neus = new Cirkel(new Punt(280, 128), 2);
            getTekening().voegToe(neus);
        }else if(fails == 4){
            Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
            getTekening().voegToe(mond);
        }else if(fails == 5){
            Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
            getTekening().voegToe(lijf);
        }else if(fails == 6){
            Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
            getTekening().voegToe(beenLinks);
        }else if(fails == 7){
            Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
            getTekening().voegToe(beenRechts);
        }else if(fails == 8){
            Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
            getTekening().voegToe(voetLinks);
        }else if(fails == 9){
            Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
            getTekening().voegToe(voetRechts);
        }else if(fails == 10){
            Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
            getTekening().voegToe(armLinks);
        }else if(fails == 11){
            Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
            getTekening().voegToe(armRechts);
        }else if(fails == 12){
            Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
            getTekening().voegToe(handLinks);
        }else if(fails == 13){
            Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
            getTekening().voegToe(handRechts);
            gameOver = true;
        }else if(fails == 14){
            gameOver = true;
        }
        fails++;
    }
}
