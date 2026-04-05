package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;


import org.junit.Test;

public class LabirintoTest {

	@Test
	public void testSetStanzaCorrente() {
	final Labirinto labirinto = new Labirinto();
	Stanza mensa = new Stanza("mensa");
	labirinto.setStanzaCorrente(mensa);
	assertTrue(labirinto.getStanzaCorrente().equals(mensa));
	}
	@Test
	public void testGetStanzaCorrente() {
	final Labirinto labirinto = new Labirinto();
	Stanza mensa = new Stanza("mensa");
	assertFalse(labirinto.getStanzaCorrente().equals(mensa));
	}
	@Test
	public void testFunzionamentoLabirinto() {
	final Labirinto labirinto = new Labirinto();
	assertTrue(labirinto.getStanzaCorrente().getNome().equals("Atrio"));
	assertTrue(labirinto.getStanzaVincente().getNome().equals("Biblioteca"));
	}
}
