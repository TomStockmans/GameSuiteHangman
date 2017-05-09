package domain;

public class LijnStuk extends Vorm{

	
	private Punt startpunt;
	private Punt eindpunt;
	
	public LijnStuk(Punt startpunt, Punt eindpunt) {
		if(startpunt == null || eindpunt == null) throw new DomainException("Start of eindpunt is null");
		this.startpunt = startpunt;
		this.eindpunt = eindpunt;
	}

	public Object getStartPunt() {
		return this.startpunt;
	}

	public Object getEindPunt() {
		return this.eindpunt;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof LijnStuk)) return false;
		LijnStuk lijsntuk = (LijnStuk) obj;
		if(this.startpunt.equals(lijsntuk.startpunt) && this.eindpunt.equals(lijsntuk.eindpunt)) return true;
		return false;
	}

}
