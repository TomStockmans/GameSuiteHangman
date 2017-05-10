package ui;

import javax.swing.JOptionPane;

import domain.Cirkel;
import domain.DomainException;
import domain.Punt;
import domain.Speler;

public class Launcher {

	public static void main(String[] args) {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);

		JOptionPane.showMessageDialog(null, speler.getNaam() + " zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		try
		{
			String[] keuzes = {"cirkel", "rechthoek"};
			String keuze = (String) JOptionPane.showInputDialog(null, "Wat wilt u tekenen:", null, JOptionPane.QUESTION_MESSAGE, null, keuzes, keuzes[0]);
			switch (keuze) {
				case "cirkel": maakcirkel();
					break;
				case "rechthoek": 
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
		
		int x = maakwaarde("x coordinaat van het punt");
		int y = maakwaarde("y coordinaat van het punt");
		Punt punt = new Punt(x, y);
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt.toString());
		
		Cirkel cirkel = new Cirkel(punt, maakwaarde("raduis van de cirkel"));
		JOptionPane.showMessageDialog(null, "U hebt een correcte cirkel aangemaakt: " + cirkel.toString());
	}
	
	private static void maakrechthoek(){
		
	}

}
