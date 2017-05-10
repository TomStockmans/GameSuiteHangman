package domain;

import domain.exceptions.DomainException;

import java.util.ArrayList;

/**
 * Created by Henok on 10/05/2017.
 */
public class WoordenLijst {
    private int aantalWoorden;
    private ArrayList<String> woorden = new ArrayList<>();

    public WoordenLijst() {
        this.aantalWoorden = aantalWoorden;
    }

    public void voegToe(String woord) {
        if(null == woord || woord.isEmpty()) throw new DomainException("Woord kan niet null of leeg zijn");
        if(woorden.contains(woord)) throw new DomainException("Woord is reeds in lijst");
        woorden.add(woord);
    }

    public int getAantalWoorden() {
        return woorden.size();
    }
}
