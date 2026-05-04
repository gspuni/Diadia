package it.uniroma3.diadia1;

import static org.junit.Assert.*;

import org.junit.Test;


public class IOSimulatorTest {
	private Partita partita;
	
	@Test
	public void testVittoria() {
		final String[] elenco = {"vai nord"};
		final IOSimulator iO = new IOSimulator(elenco); 
		DiaDia gioco = new DiaDia(iO);
		partita = gioco.getPartita();
		gioco.gioca();
		assertTrue(partita.isFinita());
	}
	@Test
	public void testTerminazionePartita() {
		final String[] elenco = {"fine"};
		final IOSimulator iO = new IOSimulator(elenco);

		DiaDia gioco = new DiaDia(iO);
		partita = gioco.getPartita();
		gioco.gioca();
		assertTrue(partita.isFinita());
	}
	@Test
	public void testPresaOggetto() {
		final String[] elenco = {"prendi osso", "fine"};
		final IOSimulator iO = new IOSimulator(elenco); 
		DiaDia gioco = new DiaDia(iO);
		partita = gioco.getPartita();
		gioco.gioca();
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}
}
