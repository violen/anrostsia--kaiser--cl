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
import de.logit.kaiser_clone.view.AusgabeHandler;

/**
 * @author nepo aka. André Hauser
 *
 */
public class EingabeController {
	
	private InputStreamReader isr;
	private BufferedReader br;
		
	AusgabeHandler ausgabeHandler;
	private HashMap<Spieler, Scanner> inputStream = new HashMap<>();
	
	public EingabeController(){
	}
	
	public EingabeController(InputStream _inputStream){
		this.isr = new InputStreamReader(_inputStream);
		this.br = new BufferedReader(isr);
	}

	public AusgabeHandler getAusgabeHandler() {
		return ausgabeHandler;
	}

	public void setAusgabeHandler(AusgabeHandler _ausgabeHandler) {
		ausgabeHandler = _ausgabeHandler;
	}

	public static String getEingabe() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public String getEingabe(Spieler _spieler){
		ausgabeHandler.erfordereRichtung("in", _spieler);
		return inputStream.get(_spieler).nextLine();
	}
	
	public void linkSpielerMitInputStream(Spieler _spieler, Scanner _scanner){
		this.inputStream.put(_spieler, _scanner);
	}
}
