package ui;

import javax.swing.JOptionPane;

import domain.Speler;

public class Launcher {

	public static void main(String[] args) {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);

		JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		String xwaarde = JOptionPane.showInputDialog("Wat is de x-waarde van je punt?");
		int x = Integer.valueOf(xwaarde);
		String ywaarde= JOptionPane.showInputDialog("Wat is de y-waarde van je punt?");
		int y = Integer.valueOf(ywaarde);
	}

}
