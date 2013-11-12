/**
 * Dieses Wirtschaftsspiel ist bestand einer Prüfungsarbeit 
 * Beteiligt an diesem Projekt sind / waren:
 * André Hauser, Stephan Landsiedel, Robert Burdorf und Siamak Hamidi.
 */
package de.logit.kaiser_clone.controller;

import java.io.FileDescriptor;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import de.logit.kaiser_clone.view.HauptmenueView;
import de.logit.kaiser_clone.view.StartmenueView;

/**
 * @author nepo aka. André Hauser
 *
 */
public class MasterController {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Zeichenausgabe Umlaute etc. für Windows CMD
		 */
		if(System.getProperty("file.encoding").equalsIgnoreCase("Cp1252")){
			try {
				System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out),true,"Cp850"));
			} catch (UnsupportedEncodingException e) {
			}
		}
		/*
		 * Grundvorraussetzungen um mit Usereingaben umzugehen.
		 */
		int anzahl = 0;
		EingabeController eingabeController = new EingabeController();
		String eingabe = "";
		AusgabeHandler ausgabeHandler = new AusgabeHandler();
		//Beispielausgabe Markt:

		ausgabeHandler.gibStringAnKonsole(HauptmenueView.getHauptmenue());
		ausgabeHandler.gibStringAnKonsole(HauptmenueView.getMarktMenue());
		ausgabeHandler.gibStringAnKonsole(HauptmenueView.getSabotierenMenue());
		ausgabeHandler.gibStringAnKonsole(StartmenueView.getStartmenue());

	}

}
