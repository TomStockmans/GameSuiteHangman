package domain;

import domain.exceptions.DomainException;

import java.util.ArrayList;
import java.util.Random;


public class WoordenLijst {
    private int aantalWoorden;
    private ArrayList<String> woorden = new ArrayList<>();
    private static Random random = new Random();

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
    public String getRandomWoord(){
        return woorden.get(random.nextInt(getAantalWoorden()));
    }
}
