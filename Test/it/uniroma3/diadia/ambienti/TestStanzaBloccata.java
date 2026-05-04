package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaBloccata {

	@Test
	public void testNonSiAprePortaSenzaChiave() {
	final StanzaBloccata temp = new StanzaBloccata("temp", "nord", "chiave");
	final Stanza AulaN777 = new Stanza("AulaN777");
	temp.impostaStanzaAdiacente("nord", AulaN777);
	Attrezzo chiave = new Attrezzo("chiave",1);
	assertFalse(temp.getStanzaAdiacente("nord").equals(AulaN777));
	}
	@Test
	public void testSiAprePortaConChiave() {
	final StanzaBloccata temp = new StanzaBloccata("temp", "nord", "chiave");
	final Stanza AulaN777 = new Stanza("AulaN777");
	temp.impostaStanzaAdiacente("nord", AulaN777);
	Attrezzo chiave = new Attrezzo("chiave",1);
	temp.addAttrezzo(chiave);
	assertTrue(temp.getStanzaAdiacente("nord").equals(AulaN777));
	}
	@Test
	public void testComeSiApreSiChiude() {
	final StanzaBloccata temp = new StanzaBloccata("temp", "nord", "chiave");
	final Stanza AulaN777 = new Stanza("AulaN777");
	temp.impostaStanzaAdiacente("nord", AulaN777);
	Attrezzo chiave = new Attrezzo("chiave",1);
	temp.addAttrezzo(chiave);
	assertTrue(temp.getStanzaAdiacente("nord").equals(AulaN777));
	temp.removeAttrezzo(chiave);
	assertFalse(temp.getStanzaAdiacente("nord").equals(AulaN777));
	}
}
