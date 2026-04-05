package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class BorsaTest {

	@Test
	public void testGetPeso() {
		final Borsa borsa = new Borsa();
		boolean test = false;
		if(borsa.getPeso() == 0)
			test = true;
		assertTrue(test);
	}
	@Test
	public void testAddAttrezzo() {
		final Borsa borsa = new Borsa();
		final Attrezzo martello = new Attrezzo("martello", 9);
		assertTrue(borsa.addAttrezzo(martello));
	}
	@Test
	public void testRemoveAttrezzo() {
		final Borsa borsa = new Borsa();
		final Attrezzo martello = new Attrezzo("martello", 9);
		borsa.addAttrezzo(martello);
		assertTrue(borsa.removeAttrezzo("martello").equals(martello));
}
}
