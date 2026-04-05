package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

public class GiocatoreTest {

	@Test
	public void testControlloCfuIniziali() {
		final Giocatore giocatore = new Giocatore();
		boolean test = false;
		if(giocatore.getCfu() == 20)
			test = true;
		assertTrue(test);
	}
	
	@Test
	public void testSetCfu() {
		final Giocatore giocatore = new Giocatore();
		boolean test = false;
		giocatore.setCfu(1225);
		if(giocatore.getCfu() == 1225)
			test = true;
		assertTrue(test);
	}
	
	@Test
	public void testControlloBorsa() {
		final Giocatore giocatore = new Giocatore();
		assertNotNull(giocatore.getBorsa());
	}
}
