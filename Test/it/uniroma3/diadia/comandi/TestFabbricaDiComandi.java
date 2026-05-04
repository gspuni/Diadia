package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import it.uniroma3.diadia1.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia1.IOConsole;
import it.uniroma3.diadia1.IO;
public class TestFabbricaDiComandi {
private Partita partita;
private IO io;
@Before
public void setUp() {
	this.partita = new Partita();
	this.io = new IOConsole();
}
	@Test
	public void testComandoFine() {
		final FabbricaDiComandi fab = new FabbricaDiComandiFisarmonica();
		fab.costruisciComando("fine").esegui(partita, io);;
		assertTrue(partita.isFinita());
	}
	@Test
	public void testComandoVai() {
		final Stanza mensa = new Stanza("Mensa");
		final Stanza aulaN777 = new Stanza("Aula777");
		aulaN777.impostaStanzaAdiacente("est", mensa);
		partita.setStanzaCorrente(aulaN777);
		final FabbricaDiComandi fab = new FabbricaDiComandiFisarmonica();
		fab.costruisciComando("vai est").esegui(partita, io);
		assertTrue(partita.getStanzaCorrente().getNome().equals("Mensa"));
	}
	@Test
	public void testComandoNonValidoNonCrashaGioco() {
		final FabbricaDiComandi fab = new FabbricaDiComandiFisarmonica();
		fab.costruisciComando("teletrasportami a las vegas").esegui(partita, io);;
		assertFalse(partita.isFinita());
	}
}
