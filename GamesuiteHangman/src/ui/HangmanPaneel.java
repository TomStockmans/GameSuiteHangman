package ui;

import java.awt.BorderLayout;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import db.WoordenLezer;
import domain.HangMan;
import domain.WoordenLijst;


public class HangmanPaneel extends JPanel {

	private static final long serialVersionUID = 1L;	
	
	private JTextField letter;	
	private JLabel woord;
	
	private TekenVenster tekenVenster;
	private HangMan spel;
	private GameHoofdScherm hoofdScherm;
	
	public HangmanPaneel(HangMan spel){
		super();
		setSpel(spel);
		init();
	}

	private void init(){
		letter = new JTextField("",5);
		woord = new JLabel("");
		
		this.setLayout(new BorderLayout());
		this.add(letter, BorderLayout.EAST);
		this.add(woord, BorderLayout.CENTER);
		
		letter.addKeyListener(new RaadLuisteraar());
	}
	
	private void reset() {
		woord.setText(getSpel().getHint());
		getTekenVenster().teken();
	}
	
	public class RaadLuisteraar implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode()== KeyEvent.VK_ENTER){
				String input = letter.getText();
				char guess = '\u0000';
				if(input.length() > 0){
					guess = input.charAt(0);
					if(!spel.raad(guess));
				}
				woord.setText(getSpel().getHint());
				letter.setText("");
				getTekenVenster().teken();

                if(spel.isGewonnen()){
                    quitDialog("You won\n");
                }else if(spel.isGameOver()){
                    quitDialog("You lost\n");
                }
			}
		}
		public void quitDialog(String boodschap){
            if(JOptionPane.showConfirmDialog(null, boodschap+="Want to play again?") == 0){
                WoordenLijst woordenLijst = new WoordenLezer("woordenlijst.txt").lees();
                HangMan spel = new HangMan(getSpel().getSpeler(), woordenLijst);
                HangmanPaneel paneel = new HangmanPaneel(spel);
                HangManHoofdScherm hoofdScherm = new HangManHoofdScherm(spel, paneel);
                getHoofdScherm().setVisible(false);
                getHoofdScherm().dispose();
                hoofdScherm.start();
            }else{
                System.exit(0);
            }
		}
		@Override
		public void keyReleased(KeyEvent arg0) {/* Niet nodig*/}
		@Override
		public void keyTyped(KeyEvent arg0) {/* Niet nodig*/}
	}
	
	private void setSpel(HangMan spel){
		this.spel = spel;
	}

	private HangMan getSpel() {
		return spel;
	}
	

	private TekenVenster getTekenVenster() {
		return tekenVenster;
	}

	 public void setTekenVenster(TekenVenster tekenVenster) {
		this.tekenVenster = tekenVenster;

		reset();
	}

    public GameHoofdScherm getHoofdScherm() {
        return hoofdScherm;
    }

    public void setHoofdScherm(GameHoofdScherm hoofdScherm) {
        this.hoofdScherm = hoofdScherm;
    }
}