package ui;

import javax.swing.JOptionPane;

import domain.Cirkel;
import domain.exceptions.DomainException;
import domain.Punt;
import domain.Speler;

public class Launcher {

	public static void main(String[] args) {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);

		JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		try
		{
			int x = maakwaardevoorpunt("x-waarde");
			int y = maakwaardevoorpunt("y-waarde");
			
			Punt punt = new Punt(x, y);
			Cirkel cirkel = new Cirkel(punt, maakwaardevoorpunt("cirkel"));
			
			
			
			JOptionPane.showMessageDialog(null, "U hebt een correcte cirkel aangemaakt: " + cirkel.toString());
			
		}
		catch (DomainException e)
		{
            JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	private static int maakwaardevoorpunt(String waarde){
		while(true){
			try{
				return Integer.valueOf(JOptionPane.showInputDialog("Wat is de "+waarde+" van je punt?"));
			}catch(NumberFormatException e){
				if(JOptionPane.showConfirmDialog(null, "De "+waarde+" is ongeldig, Wil je stoppen?") == 0) throw new DomainException("Ik wil stoppen, "+waarde+" was ongeldig");
			}
		}
	}
}
