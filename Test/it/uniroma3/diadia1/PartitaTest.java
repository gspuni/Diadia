package it.uniroma3.diadia1;

import it.uniroma3.diadia.ambienti.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class PartitaTest {

	@Test
	public void testSetStanza() {
		final Partita partita = new Partita();
		Stanza cucina = new Stanza("cucina");
	 partita.getLabirinto().setStanzaCorrente(cucina);
	 assertTrue(partita.getLabirinto().getStanzaCorrente().equals(cucina));
	}

	@Test
	public void testVinta() {
		final Partita partita = new Partita();

		Stanza vincente = partita.getLabirinto().getStanzaVincente();
		partita.getLabirinto().setStanzaCorrente(vincente);
		assertTrue(partita.vinta());
	}
	
	@Test
	public void testSetFinitaPos() {
		final Partita partita = new Partita();
		partita.setFinita();
		assertTrue(partita.isFinita());
	}
	@Test
	public void testSetFinitaNeg() {
		final Partita partita = new Partita();
		assertFalse(partita.isFinita());
	}
	@Test
	public void testIsFinita() {
		final Partita partita = new Partita();
		partita.getGiocatore().setCfu(0);
		assertTrue(partita.isFinita());
	}
}
