/**
 * Dieses Wirtschaftsspiel ist bestand einer Prüfungsarbeit 
 * Beteiligt an diesem Projekt sind / waren:
 * André Hauser, Stephan Landsiedel, Robert Burdorf und Siamak Hamidi.
 */
package de.logit.kaiser_clone.controller;

import java.io.FileDescriptor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Scanner;

import de.logit.kaiser_clone.model.Spiel;
import de.logit.kaiser_clone.model.Spieler;
import de.logit.kaiser_clone.network.ChatServer;
import de.logit.kaiser_clone.view.AusgabeHandler;
import de.logit.kaiser_clone.view.AusgabeView;
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
		Socket client;
		this.spiel = new Spiel();
		ChatServer server = new ChatServer();
		String eingabe = "";
		do {
			ausgabeHandler.gibStringAnKonsole(StartmenueView.getStartmenue());
			eingabe = eingabecontroller.getEingabe();
			if(eingabe.equalsIgnoreCase("1"))
			{			
				ausgabeHandler.gibStringAnKonsole(AusgabeView.wievieleSpieler());
				int anzahlSpieler = 0;
				do {
					eingabe = eingabecontroller.getEingabe();
					try {
						anzahlSpieler = Integer.parseInt(eingabe);
					} catch (NumberFormatException e) {
						
					}
				} while (anzahlSpieler<=0);
				for(int i = 0 ; i < anzahlSpieler ; i++){
					Spieler spieler = new Spieler();
					this.spiel.getSpieler().add(spieler);
					if(i==0){
						Scanner in = new Scanner(System.in);
						PrintWriter out = new PrintWriter(System.out,true);
						this.eingabecontroller.linkSpielerMitInputStream(spieler, in);
						this.ausgabeHandler.linkSpielerMitOutputStream(spieler, out);
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
					ausgabeHandler.gibStringAnKonsole(AusgabeView.gibEinenNamenEin(),this.spiel.getSpieler().get(i));
					this.spiel.getSpieler().get(i).setName(eingabecontroller.getEingabe(this.spiel.getSpieler().get(i)));
				}
				this.spiel.erzeugeLandkarten();
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
