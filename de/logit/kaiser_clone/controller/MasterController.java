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
import de.logit.kaiser_clone.view.AusgabeHandler;
import de.logit.kaiser_clone.view.FehlerView;
import de.logit.kaiser_clone.view.HauptmenueView;
import de.logit.kaiser_clone.view.StartmenueView;

/**
 * @author nepo aka. André Hauser
 *
 */


public class MasterController 
{

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
	
	public MasterController()
	{
		this.ausgabeHandler = new AusgabeHandler();
		this.eingabecontroller = new EingabeController();
		
	}
	
	public void spielStarten()
	{
		String eingabe = "";
		
		do {
			ausgabeHandler.gibStringAnKonsole(StartmenueView.getStartmenue());
			eingabe = eingabecontroller.getEingabe();
			if(eingabe.equalsIgnoreCase("1"))
			{			
			spielController.gameLoop();
			}
			else if(eingabe.equalsIgnoreCase("2"))// Spiel beenden.
			{
				ausgabeHandler.gibStringAnKonsole(StartmenueView.getSpielBeenden());
				System.exit(0);
			}
			//Fehlermeldung
				ausgabeHandler.gibStringAnKonsole(FehlerView.getKeineGueltigeEingabe());
				
		}
		while((eingabe != "1") || (eingabe !="2"));
		
		
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
