package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia1.Partita;
import it.uniroma3.diadia1.IO;

public class ComandoPosa implements Comando{
	private String nomeAttrezzo;
	public ComandoPosa() {
	}
	@Override
	public void esegui(Partita partita, IO io){
		if(nomeAttrezzo==null) {
		io.mostraMessaggio("hai dimenticato l'attrezzo!");
		return;
	}
	else {
		Stanza temp = partita.getLabirinto().getStanzaCorrente();
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if(attrezzo != null) {
		boolean result=temp.addAttrezzo(attrezzo);
		if(result==true) {
			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
			io.mostraMessaggio("Attrezzo posato con successo");
		}
				else
					io.mostraMessaggio("Impossibile posare l'attrezzo, Stanza piena");
		
	}
		else
			io.mostraMessaggio("Impossibile posare un attrezzo che non esiste");
	}
	}
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
}
