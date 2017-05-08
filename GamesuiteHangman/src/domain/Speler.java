
public class Speler {
	
	private String naam;
	private int score = 0;
	
	public Speler(String naam){
		this.setNaam(naam);
	}
	
	public String getNaam(){
		return this.naam;
	}
	
	public int getScore(){
		return this.score;
	}
	
	private void setNaam(String naam) throws DomainException{
		if(naam.equals("")){
			throw new DomainException("BOOS, Naam moet letters bevatten");
		}
		this.naam = naam;
	}
	
	public void addToScore(int score) throws DomainException{
		if(score<0){
			throw new DomainException("BOOS, niet negatief!");
		}
		this.score = this.score + score;
	}
	
	public boolean equals(Object object){
		if (object instanceof Speler){
	     Speler nieuw = (Speler) object;
	     if (nieuw.getNaam().equals(this.getNaam())){
	    	 return true;
	     }
		}
		return false;
	}
	
	public String toString(){
		return this.naam + " heeft als score " + this.score;
	}

}
