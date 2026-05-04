package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia1.Partita;
import it.uniroma3.diadia1.IO;
public class ComandoNonValido implements Comando{

	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("Comando sconosciuto");
	}
	@Override
	public void setParametro(String parametro) {
		
	}
}
