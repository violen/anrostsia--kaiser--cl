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

import de.logit.kaiser_clone.model.Spiel;
import de.logit.kaiser_clone.model.Spieler;
import de.logit.kaiser_clone.view.HauptmenueView;
import de.logit.kaiser_clone.view.StartmenueView;

/**
 * @author nepo aka. André Hauser
 *
 */


public class MasterController {

	private Spieler aktiverSpieler;
	private Spiel spiel;
	private EingabeController eingabecontroller;
	private MarktController marktcontroller;
	private SpielController spielController;
	private SpielRundenController spielRundencontroller;
	private SabotageController sabotageController;
	private PolitikController politikController;
	private ProduzierenController produzierenController;
	private StatistikController statistikcontroller;
	private StartMenueController startmenueController;
	private AusgabeHandler ausgabeHandler;
	
	
	public void printStream()
	{
	//@Stephan --> laut Lukas wird die Main als separates Programm "Hauptprogramm" aus dem Paket "main" gestartet und 
		//erzeugt nur den MasterController und ruft die Methode "spielStarten" auf.
		
		//public static void main(String[] args) {
		/*
		 * Zeichenausgabe Umlaute etc. für Windows CMD
		 */
		if(System.getProperty("file.encoding").equalsIgnoreCase("Cp1252")){
			try {
				System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out),true,"Cp850"));
			} 
			catch (UnsupportedEncodingException e) {
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
	
	public void spielStarten()
	{
		spielController.gameLoop();
	}
	
	
	public void setAktiverSpieler(Spieler _aktiverSpieler)
	{
		aktiverSpieler = _aktiverSpieler;
	}
	
	public Spieler getAktiverSpieler()
	{
		return aktiverSpieler;
	}

	/**
	 * @return the spiel
	 */
	public Spiel getSpiel()
	{
		return this.spiel;
	}

	/**
	 * @return the eingabecontroller
	 */
	public EingabeController getEingabecontroller()
	{
		return this.eingabecontroller;
	}

	/**
	 * @return the marktcontroller
	 */
	public MarktController getMarktcontroller()
	{
		return this.marktcontroller;
	}

	/**
	 * @return the spielController
	 */
	public SpielController getSpielController()
	{
		return this.spielController;
	}

	/**
	 * @return the spielRundencontroller
	 */
	public SpielRundenController getSpielRundencontroller()
	{
		return this.spielRundencontroller;
	}

	/**
	 * @return the sabotageController
	 */
	public SabotageController getSabotageController()
	{
		return this.sabotageController;
	}

	/**
	 * @return the politikController
	 */
	public PolitikController getPolitikController()
	{
		return this.politikController;
	}

	/**
	 * @return the statistikcontroller
	 */
	public StatistikController getStatistikcontroller()
	{
		return this.statistikcontroller;
	}

	/**
	 * @return the ausgabeHandler
	 */
	public AusgabeHandler getAusgabeHandler()
	{
		return this.ausgabeHandler;
	}

	/**
	 * @return the startmenueController
	 */
	public StartMenueController getStartmenueController()
	{
		return this.startmenueController;
	}

	/**
	 * @return the produzierenController
	 */
	public ProduzierenController getProduzierenController()
	{
		return this.produzierenController;
	}
	
	

}
