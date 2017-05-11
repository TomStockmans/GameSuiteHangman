package ui;

import javax.swing.JOptionPane;

import db.WoordenLezer;
import domain.*;
import domain.exceptions.DomainException;

public class Launcher {

	public static void main(String[] args) {

	    hangman();
		
	}

    /*private static void launch(){
        GameHoofdScherm hoofdScherm = new GameHoofdScherm(getSpeler().getNaam(), new Tekening("hoofdscherm"));
        hoofdScherm.teken();
    }*/
	private static void hangman(){
        WoordenLijst woordenLijst = new WoordenLezer("woordenlijst.txt").lees();
        HangMan spel = new HangMan(getSpeler(), woordenLijst);
        basisVormen(spel.getTekening());
        extraVormen(spel.getTekening());
        HangmanPaneel paneel = new HangmanPaneel(spel);
        HangManHoofdScherm hoofdScherm = new HangManHoofdScherm(spel, paneel);
        hoofdScherm.start();
    }
    private static Speler getSpeler(){
        String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
        Speler speler = new Speler(naam);

        JOptionPane.showMessageDialog(null, speler.getNaam() + " zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
        return speler;
    }
    private static void basisVormen(Tekening tekening){
        Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);
        Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));
        Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));
        Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));
        tekening.voegToe(galgBodem);
        tekening.voegToe(galgStaaf);
        tekening.voegToe(hangbar);
        tekening.voegToe(koord);
    }
    private static void extraVormen(Tekening tekening){
        Vorm hoofd = new Cirkel(new Punt(280, 125), 25);
        tekening.voegToe(hoofd);
        Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);
        tekening.voegToe(oogLinks);
        Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);
        tekening.voegToe(oogRechts);
        Vorm neus = new Cirkel(new Punt(280, 128), 2);
        tekening.voegToe(neus);
        Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
        tekening.voegToe(mond);
        Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
        tekening.voegToe(lijf);
        Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
        tekening.voegToe(beenLinks);
        Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
        tekening.voegToe(beenRechts);
        Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
        tekening.voegToe(voetLinks);
        Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
        tekening.voegToe(voetRechts);
        Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
        tekening.voegToe(armLinks);
        Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
        tekening.voegToe(armRechts);
        Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
        tekening.voegToe(handLinks);
        Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
        tekening.voegToe(handRechts);
    }

	
	private static int maakwaarde(String boodschap){
		while(true){
			try{
				return Integer.valueOf(JOptionPane.showInputDialog(boodschap + ":"));
			}catch(NumberFormatException e){
				if(JOptionPane.showConfirmDialog(null, "\"" + boodschap + "\" was ongeldig, Wil je stoppen?") == 0) throw new DomainException("Ik wil stoppen, \"" + boodschap + "\" was ongeldig");
			}
		}
	}
	
	private static void maakcirkel(Speler speler){
		JOptionPane.showMessageDialog(null, "U moet een middepunt aanmaken voor de cirkel.");
		
		int x = maakwaarde("x coordinaat van het punt");
		int y = maakwaarde("y coordinaat van het punt");
		Punt punt = new Punt(x, y);
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString());
		
		Cirkel cirkel = new Cirkel(punt, maakwaarde("raduis van de cirkel"));
		JOptionPane.showMessageDialog(null, "U hebt een correcte cirkel aangemaakt: " + cirkel.toString());
		
		WoordenLijst woordenLijst = new WoordenLijst();
        HangMan spel = new HangMan(speler, woordenLijst);
        HangmanPaneel paneel = new HangmanPaneel(spel);
        HangManHoofdScherm hoofdScherm = new HangManHoofdScherm(spel, paneel);
        spel.getTekening().voegToe(cirkel);
		hoofdScherm.start();
	}
	
	private static void maakrechthoek(Speler speler){
		JOptionPane.showMessageDialog(null, "U moet een linkerbovenhoek aanmaken voor de rechthoek.");
		
		int x = maakwaarde("x coordinaat van het punt");
		int y = maakwaarde("y coordinaat van het punt");
		Punt punt = new Punt(x, y);
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString());
		
		Rechthoek rechthoek = new Rechthoek(punt, maakwaarde("breedte van de rechthoek:"), maakwaarde("hoogte van de rechthoek:"));
		JOptionPane.showMessageDialog(null, "U hebt een correcte rechthoek aangemaakt: " + rechthoek.toString());
		
		WoordenLijst woordenLijst = new WoordenLezer("C:\\Users\\Tom Stockmans\\Documents\\GameSuiteHangman\\GamesuiteHangman\\src\\db\\woordenlijst.txt").lees();
        HangMan spel = new HangMan(speler, woordenLijst);
        HangmanPaneel paneel = new HangmanPaneel(spel);
        HangManHoofdScherm hoofdScherm = new HangManHoofdScherm(spel, paneel);
        spel.getTekening().voegToe(rechthoek);
		hoofdScherm.start();
	}
	
	private static void maaklijnstuk(){
		JOptionPane.showMessageDialog(null, "U moet 2 punten aanmaken voor het lijnstuk.");
		
		int x1 = maakwaarde("x coordinaat van het eerste punt");
		int y1 = maakwaarde("y coordinaat van het eerste punt");
		Punt punt1 = new Punt(x1, y1);
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt1.toString());
		
		int x2 = maakwaarde("x coordinaat van het tweede punt");
		int y2 = maakwaarde("y coordinaat van het tweede punt");
		Punt punt2 = new Punt(x2, y2);
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt2.toString());
		
		LijnStuk lijnstuk = new LijnStuk(punt1, punt2);
		JOptionPane.showMessageDialog(null, "U hebt een correct lijnstuk aangemaakt: " + lijnstuk.toString());
	}
	
	private static void maakdriehoek(){
		JOptionPane.showMessageDialog(null, "U moet 3 punten aanmaken voor de driehoek.");
		
		int x1 = maakwaarde("x coordinaat van het eerste punt");
		int y1 = maakwaarde("y coordinaat van het eerste punt");
		Punt punt1 = new Punt(x1, y1);
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt1.toString());
		
		int x2 = maakwaarde("x coordinaat van het tweede punt");
		int y2 = maakwaarde("y coordinaat van het tweede punt");
		Punt punt2 = new Punt(x2, y2);
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt2.toString());
		
		int x3 = maakwaarde("x coordinaat van het derde punt");
		int y3 = maakwaarde("y coordinaat van het derde punt");
		Punt punt3 = new Punt(x3, y3);
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt3.toString());
		
		Driehoek driehoek = new Driehoek(punt1, punt2, punt3);
		JOptionPane.showMessageDialog(null, "U hebt een correcte driehoek aangemaakt: " + driehoek.toString());
	}
	
	private static void maakhuismetboom(Speler speler){
		HangMan spel = new HangMan(speler, new WoordenLijst());
        HangManHoofdScherm hoofdScherm = new HangManHoofdScherm(spel, new HangmanPaneel(spel));
		hoofdScherm.start();
	}

}
