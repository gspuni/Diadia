package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class StanzaTest {

	@Test
	public void testLeStanzeVuoteNonHannoAttrezzi() {
	final	Stanza vuota = new Stanza("vuota");
		assertFalse(vuota.hasAttrezzo("martello"));
	}
	@Test
	public void testStanzaConUnAttrezzo() {
	final Stanza piena = new Stanza("piena");
		piena.addAttrezzo(new Attrezzo("martello", 8));
		assertTrue(piena.hasAttrezzo("martello"));
	}
	
	@Test
	public void testMassimo10Attrezzi() {
		final Stanza piena = new Stanza("piena");
		 for(int i=0; i<10; i++)
			 assertTrue(piena.addAttrezzo(new Attrezzo("attrezzo" + i, i)));
	}
	@Test
	public void testNonPuoiRimuovereUnAttrezzoNonPresente() {
		final Stanza devroom = new Stanza("devroom");
		final Attrezzo devstick = new Attrezzo("devstick", 9);
		assertFalse(devroom.removeAttrezzo(devstick));
	}
	@Test
	public void testPuoiRimuovereUnAttrezzoPresente() {
		final Stanza devroom = new Stanza("devroom");
		final Attrezzo devstick = new Attrezzo("devstick", 9);
		devroom.addAttrezzo(devstick);
		assertTrue(devroom.removeAttrezzo(devstick));
	}
}
