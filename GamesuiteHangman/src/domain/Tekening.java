package domain;

import java.util.ArrayList;

public class Tekening {

	private String naam;
    private ArrayList<Vorm> vormen = new ArrayList<>();
    private static final int MIN_X = 0;
    private static final int MIN_Y = 0;
    private static final int MAX_X = 399;
    private static final int MAX_Y = 399;

    public Tekening(String naam) {
        setNaam(naam);
	}

    public void setNaam(String naam) {
        if(null == naam || naam.isEmpty()) throw new IllegalArgumentException("Naam kan niet leeg of null zijn");
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
	}

	public int getAantalVormen() {
		return vormen.size();
	}

	public boolean bevat(Vorm vorm) {
		return vormen.contains(vorm);
	}

	public void verwijder(Vorm vorm) {
		vormen.remove(vorm);
		
	}

	public void voegToe(Vorm vorm) {
		vormen.add(vorm);
		
	}

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Tekening)) return false;
        Tekening tekening = (Tekening) obj;
        return (arraysEqual(this.vormen, tekening.vormen));
    }
    private boolean arraysEqual(ArrayList<Vorm> list1, ArrayList<Vorm> list2){
    	
        if(list1 == null && list2 == null) return true;
        if(list1 == null || list2 == null) return false;
        if(list1.size() == 0 || list2.size() == 0) return true;
        if(list1.size() != list2.size()) return false;      
        return (list1.containsAll(list2));
    }
}
