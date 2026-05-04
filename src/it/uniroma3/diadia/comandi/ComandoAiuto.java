package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia1.Partita;
import it.uniroma3.diadia1.IO;

public class ComandoAiuto implements Comando{
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	@Override
	public void esegui(Partita partita, IO io) {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
	}
	@Override
	public void setParametro(String parametro) {
		
	}
}
