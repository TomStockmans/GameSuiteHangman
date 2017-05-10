package ui;

import javax.swing.JOptionPane;

import domain.*;
import domain.exceptions.DomainException;

public class Launcher {

	public static void main(String[] args) {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);

		JOptionPane.showMessageDialog(null, speler.getNaam() + " zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		try
		{
			String[] keuzes = {"cirkel", "rechthoek", "lijnstuk", "driehoek", "huis met boom"};
			String keuze = (String) JOptionPane.showInputDialog(null, "Wat wilt u tekenen:", null, JOptionPane.QUESTION_MESSAGE, null, keuzes, keuzes[0]);
			switch (keuze) {
				case "cirkel": maakcirkel(speler);
					break;
				case "rechthoek": maakrechthoek(speler);
					break;
				case "lijnstuk": maaklijnstuk();
					break;
				case "driehoek": maakdriehoek();
					break;
				case "huis met boom": maakhuismetboom(speler);
				default:
					break;
			}
			
			
		}
		catch (DomainException e)
		{
            JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
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
		
		WoordenLijst woordenLijst = new WoordenLezer("woordenlijst.txt").lees();
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
