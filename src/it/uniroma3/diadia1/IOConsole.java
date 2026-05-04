package it.uniroma3.diadia1;
import java.util.Scanner;
public class IOConsole implements IO{
public void mostraMessaggio(String msg) {
System.out.println(msg);
}
public String leggiRiga() {
Scanner scannerDiLinee = new Scanner(System.in);
String riga = scannerDiLinee.nextLine();
return riga;
}
}