package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia1.Partita;
import it.uniroma3.diadia1.IO;
public class ComandoGuarda implements Comando{

	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("" + partita.getGiocatore().getCfu());
	}
	@Override
	public void setParametro(String parametro) {
		
	}
}
