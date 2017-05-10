package domain;

import domain.exceptions.DomainException;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class WoordenLezer {
	
	private String naam;
	
	public WoordenLezer(String bestand) {
		this.setNaam(bestand);
	}
	
	public WoordenLijst lees(){
		WoordenLijst woordenlijst = new WoordenLijst();
        try (BufferedReader br = new BufferedReader(new FileReader(WoordenLijst.class.getResource(naam).getPath()))) {
            String line;
            while ((line = br.readLine()) != null) {
                woordenlijst.voegToe(line.trim());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
