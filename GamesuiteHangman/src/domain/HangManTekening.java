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
    private void onzichtbareVormen(){
            Vorm hoofd = new Cirkel(new Punt(280, 125), 25);
            voegToe(hoofd);

            Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);
            voegToe(oogLinks);

            Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);
            voegToe(oogRechts);

            Vorm neus = new Cirkel(new Punt(280, 128), 2);
            voegToe(neus);

            Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
            voegToe(mond);

            Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
            voegToe(lijf);

            Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
            voegToe(beenLinks);

            Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
            voegToe(beenRechts);

            Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
            voegToe(voetLinks);

            Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
            voegToe(voetRechts);

            Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
            voegToe(armLinks);

            Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
            voegToe(armRechts);

            Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
            voegToe(handLinks);

            Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
            voegToe(handRechts);

    }
}
