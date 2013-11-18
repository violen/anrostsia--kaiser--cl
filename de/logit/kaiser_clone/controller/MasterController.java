/**
 * Dieses Wirtschaftsspiel ist bestand einer Prüfungsarbeit 
 * Beteiligt an diesem Projekt sind / waren:
 * André Hauser, Stephan Landsiedel, Robert Burdorf und Siamak Hamidi.
 */
package de.logit.kaiser_clone.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import de.logit.kaiser_clone.model.Spiel;
import de.logit.kaiser_clone.model.Spieler;
import de.logit.kaiser_clone.model.Startmenue;
import de.logit.kaiser_clone.network.ChatServer;
import de.logit.kaiser_clone.view.AusgabeHandler;
import de.logit.kaiser_clone.view.AusgabeView;
import de.logit.kaiser_clone.view.FehlerView;
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
		/*
		 * Der MasterController Initialisiert die Ein und Ausgabe und stellt sie bereit:
		 */
		this.ausgabeHandler = new AusgabeHandler();
		this.eingabecontroller = new EingabeController();
		eingabecontroller.setAusgabeHandler(ausgabeHandler);
		
	}
	/**
	 * die Methode spielStarten initialisiert den Server 
	 * und nimmt die Anzahl mitspieler entgegen die an einem Spiel teilnehmen.
	 */
	public void spielStarten()
	{
		// Socket um mitspieler zu Speichern
		Socket client;
		// beeinhaltet den ServerSocket um Mitspieler annhemen zu können.
		ChatServer server = new ChatServer();
		String eingabe = "";
		/*
		 * Solange die eingabe nich 1 oder 2 ist Wiederhole das "Startmenü"
		 */
		do {
			ausgabeHandler.gibStringAnKonsole(StartmenueView.getStartmenue());
			eingabe = EingabeController.getEingabe();
			if(eingabe.equalsIgnoreCase("1"))
			{			
				/*
				 * Möchte man das Spiel spielen muss mindestens ein Spieler vorhanden sein.
				 * Solange keine gültige eingabe gemacht worden ist wird die Frage nach der anzahl Spieler wiederholt.
				 */
				int anzahlSpieler = 0;
				do {
					ausgabeHandler.gibStringAnKonsole(AusgabeView.wievieleSpieler());
					eingabe = EingabeController.getEingabe();
					try {
						anzahlSpieler = Integer.parseInt(eingabe);
					} catch (NumberFormatException e) {
						// Nur für clowns die meinen man müsse quatsch in der Konsole treiben ;)
					}
				// mind ein max vier Spieler
				} while (anzahlSpieler<=0 | anzahlSpieler > 4);
				/*
				 * Spiel wird erzeugt um die Spieler bekannt zu machen.
				 */
				this.spiel = Startmenue.neueSpielStarten();
				/*
				 * Jeder Spieler wird erzeugt, bekannt gemacht 
				 * und seine Ein und AusgabeStreams miteinander verknüpft.
				 */
				for(int i = 0 ; i < anzahlSpieler ; i++){
					Spieler spieler = new Spieler();
					this.spiel.getSpieler().add(spieler);
					if(i==0){
						Scanner in = new Scanner(System.in);
						PrintWriter out = new PrintWriter(System.out,true);
						this.eingabecontroller.linkSpielerMitInputStream(spieler, in);
						this.ausgabeHandler.linkSpielerMitOutputStream(spieler, out);
						this.ausgabeHandler.setSpielerAmServer(spieler);
					} else {
						ausgabeHandler.gibStringAnKonsole(AusgabeView.warteAufSpieler(), this.spiel.getSpieler().getFirst());
						try {
							client = server.getSvrSocket().accept();
							Scanner in = new Scanner(client.getInputStream());
							PrintWriter out = new PrintWriter(client.getOutputStream(),true);
							this.eingabecontroller.linkSpielerMitInputStream(spieler, in);
							this.ausgabeHandler.linkSpielerMitOutputStream(spieler, out);
							ausgabeHandler.gibStringAnKonsole(AusgabeView.verbindeMitServer(), this.spiel.getSpieler().get(i));
						} catch (IOException e) {
							e.printStackTrace();
						} 						
					}
					/*
					 * Spieler werden aufgefordert zum Abschluss sich einen Namen zu geben.
					 */
					ausgabeHandler.gibStringAnKonsole(AusgabeView.gibEinenNamenEin(),this.spiel.getSpieler().get(i));
					this.spiel.getSpieler().get(i).setName(eingabecontroller.getEingabe(this.spiel.getSpieler().get(i)));
				}
				this.spiel.erzeugeLandkarten();
				
				/*
				 * Erzeuge Controller
				 */
				this.marktcontroller = new MarktController(this);
				this.politikController = new PolitikController(this);
				this.produzierenController = new ProduzierenController(this);
				this.sabotageController = new SabotageController(this);
				this.spielController = new SpielController(this);
				this.spielRundencontroller = new SpielRundenController(this);
				this.statistikcontroller = new StatistikController(this);
				this.startmenueController = new StartMenueController(this);
				
				this.spiel.anlegenMenues();
				
				this.spielController.gameLoop();
			}
			else if(eingabe.equalsIgnoreCase("2"))// Spiel beenden.
			{
				ausgabeHandler.gibStringAnKonsole(StartmenueView.getSpielBeenden());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Startmenue.beendeSpiel();
			}
			//Fehlermeldung
				ausgabeHandler.gibStringAnKonsole(FehlerView.getKeineGueltigeEingabe());
				/*
				 * Eine Sekunde die Fehlerausgabe zeigen
				 */
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		while(!eingabe.equalsIgnoreCase("1") || !eingabe.equalsIgnoreCase("2"));
		
		
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
