package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia1.Partita;
import it.uniroma3.diadia1.IO;
public class ComandoFine implements Comando{

	
	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
		partita.setFinita();
	}
	
	
	
	@Override
	public void setParametro(String parametro) {
		
	}
}
