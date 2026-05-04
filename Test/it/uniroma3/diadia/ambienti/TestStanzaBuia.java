package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class TestStanzaBuia {

	@Test
	public void testNonSiAccendeLaLuceConAttrezzoSbagliato() {
	final StanzaBuia temp = new StanzaBuia("temp");
	Attrezzo osso = new Attrezzo("osso",1);
	temp.addAttrezzo(osso);
	assertTrue(temp.getDescrizione().equals("qui c'è buio pesto..."));
	}
	@Test
	public void testSiAccendeLaLuceConAttrezzoGiusto() {
	final StanzaBuia temp = new StanzaBuia("temp");
	Attrezzo lanterna = new Attrezzo("lanterna",3);
	temp.addAttrezzo(lanterna);
	assertFalse(temp.getDescrizione().equals("qui c'è buio pesto..."));
	}
	@Test
	public void testSenzaLuceTornaBuio() {
	final StanzaBuia temp = new StanzaBuia("temp");
	Attrezzo lanterna = new Attrezzo("lanterna",3);
	temp.addAttrezzo(lanterna);
	assertFalse(temp.getDescrizione().equals("qui c'è buio pesto..."));
	temp.removeAttrezzo(lanterna);
	assertTrue(temp.getDescrizione().equals("qui c'è buio pesto..."));
	}
}
