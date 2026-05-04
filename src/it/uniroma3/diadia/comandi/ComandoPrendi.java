package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia1.Partita;
import it.uniroma3.diadia1.IO;

public class ComandoPrendi implements Comando{
	private String nomeAttrezzo;
	public ComandoPrendi() {
	}
	@Override
public void esegui(Partita partita, IO io) {

	if(nomeAttrezzo==null) {
		io.mostraMessaggio("hai dimenticato l'attrezzo!");
		return;
	}
	else {
	Stanza temp = partita.getLabirinto().getStanzaCorrente();
	Attrezzo attrezzo = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
	if(attrezzo != null) {
		if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
			if(temp.removeAttrezzo(attrezzo)) {
				io.mostraMessaggio("Attrezzo aggiunto alla borsa");
			}
			else
				io.mostraMessaggio("Impossibile togliere attrezzo da stanza");
		}
		else
		io.mostraMessaggio("Impossibile prendere attrezzo, borsa piena o troppo pesante");
	}
	else 
		io.mostraMessaggio("oggetto inesistente");
	}
}
	@Override
public void setParametro(String parametro) {
	this.nomeAttrezzo = parametro;
}
}
