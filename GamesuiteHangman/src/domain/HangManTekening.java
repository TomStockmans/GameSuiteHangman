package domain;

/**
 * Created by Henok on 12/05/2017.
 */
public class HangManTekening extends Tekening {
    public HangManTekening(String naam) {
        super(naam);
        basisVormen();
    }
    private void basisVormen(){
        Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);
        Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));
        Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));
        Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));
        voegToe(galgBodem);
        voegToe(galgStaaf);
        voegToe(hangbar);
        voegToe(koord);
    }
}
