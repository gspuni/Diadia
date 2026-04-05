package it.uniroma3.diadia1;



import it.uniroma3.diadia.attrezzi.Attrezzo;

import it.uniroma3.diadia.ambienti.Stanza;



/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	
	private IOConsole io;

	public DiaDia() {
		this.partita = new Partita();
		this.io = new IOConsole();
	}

	public void gioca() {
		String istruzione; 

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		
		do		
		istruzione = this.io.leggiRiga(); //rimosso scanner a favore di IOConsole;
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			{
			if(comandoDaEseguire.getParametro()==null)
				this.io.mostraMessaggio("cosa prendi?");
			else {
			Attrezzo temp = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(comandoDaEseguire.getParametro());
			this.prendi(temp);
			}
			}
		else if (comandoDaEseguire.getNome().equals("posa"))
		{
			if(comandoDaEseguire.getParametro()==null)
				this.io.mostraMessaggio("cosa posi?");
			else {
			Attrezzo temp = this.partita.getGiocatore().getBorsa().getAttrezzo(comandoDaEseguire.getParametro());
			this.posa(temp);
			}
		}
		else
			this.io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			this.io.mostraMessaggio("Hai vinto!");
			return true;
		} 
		else if(this.partita.getGiocatore().getCfu()==0) {
			this.io.mostraMessaggio("Hai perso!");
			return true;
		}
			else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			this.io.mostraMessaggio(elencoComandi[i]+" ");
		this.io.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, la descrizione oltre al numero rimasto di CFU, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			this.io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(--cfu);
		}
		this.io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		this.io.mostraMessaggio("" + partita.getGiocatore().getCfu());
	}
	/**
	 * Prende un oggetto dalla stanza e lo mette nella borsa, se possibile
	 * @param attrezzo
	 */
	private void prendi(Attrezzo attrezzo) {
		if(attrezzo==null) {
			this.io.mostraMessaggio("hai dimenticato l'attrezzo!");
			return;
		}
		else {
		Stanza temp = partita.getLabirinto().getStanzaCorrente();
		if(temp.hasAttrezzo(attrezzo.getNome())==true) {
			boolean result = this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo) && temp.removeAttrezzo(attrezzo);
			if(result==true) {
				this.io.mostraMessaggio("Attrezzo aggiunto alla borsa");
			}
		}
		else
			this.io.mostraMessaggio("Impossibile prendere attrezzo");
	}
	}
	private void posa(Attrezzo attrezzo) {if(attrezzo==null) {
		this.io.mostraMessaggio("hai dimenticato l'attrezzo!");
		return;
	}
	else {
		Stanza temp = partita.getLabirinto().getStanzaCorrente();
		boolean result=temp.addAttrezzo(attrezzo);
		if(result==true) {
			this.partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
			this.io.mostraMessaggio("Attrezzo posato con successo");
		}
				else
					this.io.mostraMessaggio("Impossibile posare l'attrezzo, Stanza piena");
		
	}
	}
	
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}