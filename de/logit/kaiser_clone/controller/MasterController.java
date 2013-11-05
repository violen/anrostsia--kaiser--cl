/**
 * Dieses Wirtschaftsspiel ist bestand einer Prüfungsarbeit 
 * Beteiligt an diesem Projekt sind / waren:
 * André Hauser, Stephan Landsiedel, Robert Burdorf und Siamak Hamidi.
 */
package de.logit.kaiser_clone.controller;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * @author nepo aka. André Hauser
 *
 */
public class MasterController {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		/*
		 * Zeichenausgabe Umlaute etc. für Windows CMD
		 */
		if(System.getProperty("file.encoding") == "Cp1252"){
				System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out),true,"Cp850"));
		}
		
		/*
		 * Grundvorraussetzungen um mit Usereingaben umzugehen.
		 */
		int anzahl = 0;
		EingabeController eingabeController = new EingabeController();
		String eingabe = "";
		

	}

}
