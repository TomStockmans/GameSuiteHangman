package db;

import domain.DomainException;

/**
 * Created by Henok on 10/05/2017.
 */
public class WoordenSchrijver {


    private String naam;
    public WoordenSchrijver(String bestand) {
        this.setNaam(bestand);
    }
    public void schrijf(String woord){

    }
    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) throws DomainException {
        if(null==naam || naam.trim().isEmpty()) throw new DomainException("");
        this.naam = naam;
    }

}
