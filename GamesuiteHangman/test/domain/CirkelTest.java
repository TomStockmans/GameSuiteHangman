package domain;

import domain.exceptions.DomainException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;



public class CirkelTest {
	private Punt punt1;
	private Punt punt2;
	private int radius;
	private Cirkel cirkel;
	
	@Before
	public void setUp() throws Exception {
		punt1 = new Punt(50, 30);
		punt2 = new Punt(30, 50);
		radius = 60;
		
	}

	@Test
	public void ik_kan_een_cirkel_aanmaken_met_geldig_middelpunt_en_geldige_straal() {
		
		cirkel = new Cirkel(punt1, radius);
		assertEquals(punt1, cirkel.getMiddelpunt());
		assertEquals(radius, cirkel.getRadius());
		
	}

	@Test (expected = DomainException.class)
	public void als_middelpunt_null_is_word_er_een_exception_gegooit() {
		
		cirkel = new Cirkel(null, 30);
		
	}

	@Test (expected = DomainException.class)
	public void als_radius_negatief_is_word_er_eenException_gegooit() {
		cirkel = new Cirkel(punt1, -20);
	}

	@Test (expected = DomainException.class)
	public void als_radius_0_is_word_er_eenException_gegooit() {
		cirkel = new Cirkel(punt1, 0);
	}

	@Test
	public void Equals_methode_geeft_true_terug_als_2_cirkels_Zelfde_middelpunt_en_straal_hebben() {
		Cirkel cirkel1 = new Cirkel(punt1, 30);
		Cirkel cirkel2 = new Cirkel(punt1, 30);
		assertTrue(cirkel1.equals(cirkel2));
	}

	@Test
	public void Equals_methode_geeft_false_terug_als_2de_cirkels_null_is() {
			
		Cirkel cirkel1 = new Cirkel(punt1, 20);
		Cirkel cirkel2 = null;
		
		assertFalse(cirkel1.equals(cirkel2));
		
	}

	@Test
	public void Equals_methode_geeft_false_terug_als_middelpunt_verschillend_is() {

		Cirkel cirkel1 = new Cirkel(punt1, 30);
		Cirkel cirkel2 = new Cirkel(punt2, 30);
		
		assertFalse(cirkel1.equals(cirkel2));
		
	}

	@Test
	public void Equals_methode_geeft_false_terug_als_radius_verschillend_is() {
		
		Cirkel cirkel1 = new Cirkel(punt1, 20);
		Cirkel cirkel2 = new Cirkel(punt1, 30);
		
		assertFalse(cirkel1.equals(cirkel2));
		
		
	}
	@Test
	public void Equals_methode_geeft_false_terug_als_omhullende_verschillend_is() {

		Cirkel cirkel1 = new Cirkel(new Punt(200,200), 20);

		Omhullende omhullende1 = cirkel1.getOmhullende();
		Omhullende omhullende2 = new Omhullende(new Punt(180,180), 40,40);

		assertTrue(omhullende1.equals(omhullende2));

	}

}
