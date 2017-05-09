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

		JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		try
		{
			int x = maakxwaardevoorpunt();
			int y = maakywaardevoorpunt();
			
			Punt punt = new Punt(x, y);
			
			Cirkel cirkel = new Cirkel(punt, Integer.parseInt(JOptionPane.showInputDialog("Hoe groot moet de straal van de cirkel zijn?")));
			
			
			
			JOptionPane.showMessageDialog(null, "U hebt een correcte cirkel aangemaakt: " + cirkel.toString());
			
		}
		catch (DomainException e)
		{
            JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
	
	private static int maakxwaardevoorpunt(){
		while(true){
			try{
				return Integer.valueOf(JOptionPane.showInputDialog("Wat is de x-waarde van je punt?"));
			}catch(NumberFormatException e){
				if(JOptionPane.showConfirmDialog(null, "Wil je stoppen?") == 0) throw new DomainException("Ik wil stoppen, x-waarde was ongeldig");
			}
		}
	}
	
	private static int maakywaardevoorpunt() throws DomainException{
		 return Integer.valueOf(JOptionPane.showInputDialog("Wat is de y-waarde van je punt?"));
	}
}
