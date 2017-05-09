package ui;

import javax.swing.JOptionPane;

import domain.Cirkel;
import domain.Punt;
import domain.Rechthoek;
import domain.Speler;

public class Launcher {

	public static void main(String[] args) {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);

		JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		Object[] shapes = {"Cirkel","Rechthoek"};
		Object keuze = JOptionPane.showInputDialog(null, "wat wilt u tekenen?", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
		
		String xwaarde = JOptionPane.showInputDialog("Wat is de x-waarde van je punt?");
		int x = Integer.valueOf(xwaarde);
		
		String ywaarde= JOptionPane.showInputDialog("Wat is de y-waarde van je punt?");
		int y = Integer.valueOf(ywaarde);
		
		Punt punt = new Punt(x, y);
		
		String keuze1 = (String)keuze;
		switch(keuze1){
			case "Cirkel":
				Cirkel cirkel = new Cirkel(punt, Integer.parseInt(JOptionPane.showInputDialog("Hoe groot moet de straal van de cirkel zijn?")));
				JOptionPane.showMessageDialog(null, "U hebt een correcte cirkel aangemaakt: " + cirkel.toString());
				break;
			case "Rechthoek":
				Rechthoek rechthoek = new Rechthoek(punt, Integer.parseInt(JOptionPane.showInputDialog("welke breedte moet de rechthoek zijn?")), Integer.parseInt(JOptionPane.showInputDialog("welke lengte moet de rechthoek zijn?")));
				JOptionPane.showMessageDialog(null, "U hebt een correcte rechthoek aangemaakt: " + rechthoek.toString());
		}
		
	}

}
