package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	final static private String luce_facente = "lanterna";
	public StanzaBuia(String nome) {
		super(nome);
	}
	@Override
	public String getDescrizione() {
		if (!this.hasAttrezzo(luce_facente)) {
			return ("qui c'è buio pesto...");
		}
		else
			return super.getDescrizione();
	}
}
