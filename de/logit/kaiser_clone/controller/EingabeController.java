/**
 * 
 */
package de.logit.kaiser_clone.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

import de.logit.kaiser_clone.model.Spieler;

/**
 * @author nepo aka. André Hauser
 *
 */
public class EingabeController {
	
	private InputStreamReader isr;
	private BufferedReader br;
	private String eingabe;
	
	private HashMap<Spieler, Scanner> inputStream = new HashMap<>();
	
	public EingabeController(){
		this.isr = new InputStreamReader(System.in);
		this.br = new BufferedReader(isr);
	}
	
	public EingabeController(InputStream _inputStream){
		this.isr = new InputStreamReader(_inputStream);
		this.br = new BufferedReader(isr);
	}

	public String getEingabe() {
		try {
			this.eingabe = br.readLine();
		} catch (IOException e) {
		}
		return eingabe;
	}
	
	public String getEingabe(Spieler _spieler){
		return inputStream.get(_spieler).nextLine();
	}
	
	public void linkSpielerMitInputStream(Spieler _spieler, Scanner _scanner){
		this.inputStream.put(_spieler, _scanner);
	}
}
