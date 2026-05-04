package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
private String chiave;
private String direz_bloccata;
public StanzaBloccata(String nome, String direzione, String nomeAttrezzoChiave) {
	super(nome);
	this.direz_bloccata = direzione;
	this.chiave = nomeAttrezzoChiave;
}
@Override
public Stanza getStanzaAdiacente(String direzione) {
	if(!this.hasAttrezzo(chiave) && direzione.equals(direz_bloccata)) {
        return this;
	}
	else
		return super.getStanzaAdiacente(direzione);
}

@Override
public String getDescrizione() {
	String blocco = "\n La porta in direzione " + direz_bloccata + "\n è chiusa a chiave e non smuove di un millimetro! \nMagari avessi " + chiave + "...";
	String sblocco = "\nutilizzando " + chiave + " la porta in direzione " + direz_bloccata + " si è aperta! Ora puoi proseguire!";
	if(!this.hasAttrezzo(chiave)) {
		return super.getDescrizione() + blocco;
	}
	else
		return super.getDescrizione() + sblocco;
}
}
