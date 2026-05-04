package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia1.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia1.IO;

public class ComandoVai implements Comando {
private String direzione;
/**
* esecuzione del comando
*/
@Override
public void esegui(Partita partita, IO io) {
Stanza stanzaCorrente = partita.getStanzaCorrente();
Stanza prossimaStanza = null;
if (this.direzione==null) {

io.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
return;
}
prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione); 
if (prossimaStanza==null) {

	io.mostraMessaggio("Direzione inesistente"); 
return;
}
partita.getLabirinto().setStanzaCorrente(prossimaStanza);
partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
io.mostraMessaggio(partita.getStanzaCorrente().getNome());
}
@Override
public void setParametro(String parametro) {
	this.direzione = parametro;
}
}
