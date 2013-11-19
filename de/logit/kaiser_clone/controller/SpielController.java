package de.logit.kaiser_clone.controller;

import de.logit.kaiser_clone.model.Spiel;
import de.logit.kaiser_clone.model.Spieler;
import de.logit.kaiser_clone.model.Spielrunde;
import de.logit.kaiser_clone.view.AusgabeHandler;
import de.logit.kaiser_clone.view.AusgabeView;
import de.logit.kaiser_clone.view.FehlerView;
import de.logit.kaiser_clone.view.HauptmenueView;
import de.logit.kaiser_clone.view.StartmenueView;
import de.logit.kaiser_clone.view.StatistikView;

public class SpielController
{

	private Spiel game;
	private AusgabeHandler ausgabeHandler;
	private EingabeController eingabeController;
	private MasterController masterController;
		
	
	
	public SpielController(MasterController _masterController, Spiel _game, AusgabeHandler _ausgabeHandler, EingabeController _eingabeController)
	{
		masterController =_masterController;
		game = _game;
		ausgabeHandler = _ausgabeHandler;
		eingabeController =_eingabeController;
		
	}
	
	public SpielController(MasterController _masterController) {
		this.masterController = _masterController;
		this.ausgabeHandler = _masterController.getAusgabeHandler();
		this.eingabeController = _masterController.getEingabecontroller();
	}

	public void gameLoop()
	{
		
		this.game = masterController.getSpiel();
		masterController.setAktiverSpieler(game.neueRunde());
		Spieler aktiverSpieler = masterController.getAktiverSpieler();
		
		for(int i = 0; i < masterController.getSpiel().getSpieler().size(); i++)
		{
			game.getSpielrunde().berechneWerte();
			masterController.getStatistikcontroller().berechneStatistik();
			while(true)
			{
				
				ausgabeHandler.gibStringAnKonsole(HauptmenueView.getHauptmenue(),masterController.getAktiverSpieler());
				String parameter = this.eingabeController.getEingabe(aktiverSpieler);
				
				if(parameter.equalsIgnoreCase("1"))
				{
					ausgabeHandler.gibStringAnKonsole(HauptmenueView.getMarktMenue(), aktiverSpieler);
					parameter = this.eingabeController.getEingabe(aktiverSpieler);
					
					masterController.getMarktcontroller().auswertenEingabeMarkt(parameter);
										
				}
				else if(parameter.equalsIgnoreCase("2"))
				{
					ausgabeHandler.gibStringAnKonsole(HauptmenueView.getSabotierenMenue(), aktiverSpieler);
					parameter = this.eingabeController.getEingabe(aktiverSpieler);
					masterController.getSabotageController().auswertenEingabeSabotage(parameter);
					
				}
				else if(parameter.equalsIgnoreCase("3"))
				{
					ausgabeHandler.gibStringAnKonsole(StartmenueView.getStartmenue(), aktiverSpieler);
					parameter = this.eingabeController.getEingabe(aktiverSpieler);
					masterController.getStartmenueController().auswertenEingabeStartmenue(parameter);
					
				}
				else if(parameter.equalsIgnoreCase("4"))
				{
					ausgabeHandler.gibStringAnKonsole(HauptmenueView.getProduzierenMenue(), aktiverSpieler);
					int menge = Integer.parseInt(this.eingabeController.getEingabe(aktiverSpieler));
					masterController.getProduzierenController().produzieren(menge);
					
				}
				else if(parameter.equalsIgnoreCase("5"))
				{
					ausgabeHandler.gibStringAnKonsole(HauptmenueView.getPolitikMenue(), aktiverSpieler);
					parameter = this.eingabeController.getEingabe(aktiverSpieler);
					masterController.getPolitikController().auswertenEingabePolitik(parameter);
					
				}
				else if(parameter.equalsIgnoreCase("6"))
				{
					masterController.getStatistikcontroller().berechneStatistik();
					
				}
				else if (parameter.equalsIgnoreCase("7"))
				{
					break;
				}
			}
			
			if( i < masterController.getSpiel().getSpieler().size()-1)
			{
				game.getSpielrunde().setAktiverspieler(game.getSpieler().get(i+1));
				masterController.setAktiverSpieler(game.getSpieler().get(i+1));
			}
			
		}
		
		
		
		
		
		//break;
	}
	
//	public void beendenZug()
//	{
//		//PlatzhalterS
//		System.out.println("Zug wurde beendet.");
//	}
	
	public int anzahlHolen()
	{ 
		Spieler aktiverSpieler = masterController.getAktiverSpieler();
		int anzahl=0;
		while (true)
		{
			ausgabeHandler.gibStringAnKonsole(AusgabeView.getFrageNachAnzahl(), aktiverSpieler);
			
			try
			{
				anzahl = Integer.parseInt(this.eingabeController.getEingabe(aktiverSpieler));
				break;
				
			} 
			
			catch (NumberFormatException e)
			{
				ausgabeHandler.gibStringAnKonsole(FehlerView.getDasWarKeineZahl(), aktiverSpieler);
			}
				
		}
		return anzahl;
	}
}
