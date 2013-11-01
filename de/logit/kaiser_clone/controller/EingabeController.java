/**
 * 
 */
package de.logit.kaiser_clone.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author nepo aka. André Hauser
 *
 */
public class EingabeController {
	
	private InputStreamReader isr = new InputStreamReader(System.in);
	private BufferedReader br = new BufferedReader(isr);
	private String eingabe;
	
	public EingabeController(){
		
	}

	public String getEingabe() {
		
		try {
			this.eingabe = br.readLine();
		} catch (IOException e) {
		}
		
		return eingabe;
	}

}
