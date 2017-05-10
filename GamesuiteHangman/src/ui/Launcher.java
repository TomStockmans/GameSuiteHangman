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
			String[] keuzes = {"cirkel", "rechthoek", "lijnstuk"};
			String keuze = (String) JOptionPane.showInputDialog(null, "Wat wilt u tekenen:", null, JOptionPane.QUESTION_MESSAGE, null, keuzes, keuzes[0]);
			switch (keuze) {
				case "cirkel": maakcirkel();
					break;
				case "rechthoek": maakrechthoek();
					break;
				case "lijnstuk": maaklijnstuk();
					break;
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
	
	private static void maakcirkel(){
		JOptionPane.showMessageDialog(null, "U moet een middepunt aanmaken voor de cirkel.");
		
		int x = maakwaarde("x coordinaat van het punt");
		int y = maakwaarde("y coordinaat van het punt");
		Punt punt = new Punt(x, y);
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString());
		
		Cirkel cirkel = new Cirkel(punt, maakwaarde("raduis van de cirkel"));
		JOptionPane.showMessageDialog(null, "U hebt een correcte cirkel aangemaakt: " + cirkel.toString());
	}
	
	private static void maakrechthoek(){
		JOptionPane.showMessageDialog(null, "U moet een linkerbovenhoek aanmaken voor de rechthoek.");
		
		int x = maakwaarde("x coordinaat van het punt");
		int y = maakwaarde("y coordinaat van het punt");
		Punt punt = new Punt(x, y);
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString());
		
		Rechthoek rechthoek = new Rechthoek(punt, maakwaarde("breedte van de rechthoek:"), maakwaarde("hoogte van de rechthoek:"));
		JOptionPane.showMessageDialog(null, "U hebt een correcte rechthoek aangemaakt: " + rechthoek.toString());
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

}
