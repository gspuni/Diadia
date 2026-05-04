package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia1.IO;
import it.uniroma3.diadia1.Partita;

public interface Comando {

		/**
		* esecuzione del comando
		*/
		public void esegui(Partita partita, IO io);

		/**
		* set parametro del comando
		*/
		public void setParametro(String parametro);

		}

