package db;

import domain.WoordenLijst;
import domain.exceptions.DomainException;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class WoordenLezer {
	
	private String naam;
	
	public WoordenLezer(String bestand) {
		this.setNaam(bestand);
	}
	
	public WoordenLijst lees(){
		WoordenLijst woordenlijst = new WoordenLijst();
		try {
			File file = new File(this.naam);
			Scanner text = new Scanner(file);
			while (text.hasNextLine()) {
				String lijn = text.nextLine();
				woordenlijst.voegToe(lijn);
				//System.out.println(lijn);
			}
			text.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
        return woordenlijst;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) throws DomainException {
		if(null==naam || naam.trim().isEmpty()) throw new DomainException("");
		this.naam = naam;
	}
	
	

}
