package domain;

import domain.exceptions.DomainException;

import java.awt.*;

public class LijnStuk extends Vorm{

	
	private Punt startpunt;
	private Punt eindpunt;
	
	public LijnStuk(Punt startpunt, Punt eindpunt) {
		if(startpunt == null || eindpunt == null) throw new DomainException("Start of eindpunt is null");
		this.startpunt = startpunt;
		this.eindpunt = eindpunt;
	}

	public Punt getStartPunt() {
		return this.startpunt;
	}

	public Punt getEindPunt() {
		return this.eindpunt;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof LijnStuk)) return false;
		LijnStuk lijsntuk = (LijnStuk) obj;
		if(this.startpunt.equals(lijsntuk.startpunt) && this.eindpunt.equals(lijsntuk.eindpunt)) return true;
		return false;
	}

    @Override
    public Omhullende getOmhullende() {
        int xmin = Math.min(getStartPunt().getX(), getEindPunt().getX());
        int ymin = Math.min(getStartPunt().getY(), getEindPunt().getY());
        int xmax = Math.max(getStartPunt().getX(), getEindPunt().getX());
        int ymax = Math.max(getStartPunt().getY(), getEindPunt().getY());
        return new Omhullende(new Punt(xmin, ymin), xmax-xmin, ymax-ymin);
    }

	public void teken(Graphics graphics){
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setStroke(new BasicStroke(5));
        graphics.drawLine(getStartPunt().getX(), getStartPunt().getY(), getEindPunt().getX(), getEindPunt().getY());
	}
	@Override
	public String toString() {
		return "LijnStuk:" + startpunt + ", " + eindpunt;
	}


}
