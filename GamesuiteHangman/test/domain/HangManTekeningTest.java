package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HangManTekeningTest {
	Vorm galgBodem;
	Vorm galgStaaf;
	Vorm hangbar;
	Vorm koord;
	
	@Before
	public void setup() {
		//galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);
	    galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));
	    hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));
	    koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));

	}
	@Test
	public void basisvormen_worden_toegevoegd() {
		HangManTekening tekening = new HangManTekening("tekening");
		System.out.println(tekening.getAantalVormen());
		assertTrue(tekening.bevat(galgStaaf));
		assertTrue(tekening.bevat(hangbar));
		assertTrue(tekening.bevat(koord));
		//assertTrue(tekening.bevat(galgBodem));

	}

}
