package it.uniroma3.diadia.ambienti;


import it.uniroma3.diadia.attrezzi.Attrezzo;


public class Labirinto {
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;

	public Labirinto() {
		creaStanze();
	}
	/**
     * Crea tutte le stanze e le porte di collegamento
     */
    private void creaStanze() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo piede_di_porco = new Attrezzo("piede_di_porco", 4);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza aulaN12 = new StanzaBuia("Aula N12");
		Stanza aulaN13 = new StanzaBloccata("Aula N13", "sud", "piede_di_porco");
		Stanza mensa = new StanzaMagica("Mensa");
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN10.impostaStanzaAdiacente("sud", aulaN12);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);
		aulaN12.impostaStanzaAdiacente("nord", aulaN10);
		aulaN12.impostaStanzaAdiacente("ovest", aulaN13);
		aulaN12.impostaStanzaAdiacente("est", mensa);
		aulaN13.impostaStanzaAdiacente("est", aulaN12);
		aulaN13.impostaStanzaAdiacente("ovest", mensa);
		mensa.impostaStanzaAdiacente("ovest", aulaN12);
		mensa.impostaStanzaAdiacente("est", aulaN13);
		
		
		
        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		aulaN11.addAttrezzo(piede_di_porco);

		// il gioco comincia nell'atrio
        stanzaCorrente = atrio;  
		stanzaVincente = biblioteca;
    }
	public Stanza getStanzaVincente() {
		return this.stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
}

