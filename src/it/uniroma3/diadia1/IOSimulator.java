package it.uniroma3.diadia1;

public class IOSimulator implements IO{
	private String[] RigheDaInserire;
	private int indiceRigheDaInserire;
	public IOSimulator(String[] comandi) {
		this.RigheDaInserire = comandi;
		this.indiceRigheDaInserire = 0;
	}
@Override
public void mostraMessaggio(String msg) {
		System.out.println(msg);
}
@Override
public String leggiRiga() {
	String comando = new String (RigheDaInserire[indiceRigheDaInserire]);
	indiceRigheDaInserire++;
	System.out.println("\ncomando inserito: " + comando);
	return comando;
}
}