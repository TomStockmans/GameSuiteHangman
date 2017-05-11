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

	
	private static int maakwaarde(String boodschap){
		while(true){
			try{
				return Integer.valueOf(JOptionPane.showInputDialog(boodschap + ":"));
			}catch(NumberFormatException e){
				if(JOptionPane.showConfirmDialog(null, "\"" + boodschap + "\" was ongeldig, Wil je stoppen?") == 0) throw new DomainException("Ik wil stoppen, \"" + boodschap + "\" was ongeldig");
			}
		}
	}



}
