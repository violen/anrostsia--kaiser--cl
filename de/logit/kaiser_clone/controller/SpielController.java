package de.logit.kaiser_clone.controller;

import de.logit.kaiser_clone.model.Spiel;
import de.logit.kaiser_clone.model.Spielrunde;
import de.logit.kaiser_clone.view.AusgabeHandler;
import de.logit.kaiser_clone.view.AusgabeView;
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
		
		for(int i = 0; i < masterController.getSpiel().getSpieler().size(); i++)
		{
			game.getSpielrunde().berechneWerte();
			masterController.getStatistikcontroller().berechneStatistik();
			while(true)
			{
				
				ausgabeHandler.gibStringAnKonsole(HauptmenueView.getHauptmenue(),masterController.getAktiverSpieler());
				String parameter = EingabeController.getEingabe();
				
				if(parameter.equalsIgnoreCase("1"))
				{
					ausgabeHandler.gibStringAnKonsole(HauptmenueView.getMarktMenue());
					parameter = EingabeController.getEingabe();
					masterController.getMarktcontroller().auswertenEingabeMarkt(parameter);
										
				}
				else if(parameter.equalsIgnoreCase("2"))
				{
					ausgabeHandler.gibStringAnKonsole(HauptmenueView.getSabotierenMenue());
					parameter = EingabeController.getEingabe();
					masterController.getSabotageController().auswertenEingabeSabotage(parameter);
					
				}
				else if(parameter.equalsIgnoreCase("3"))
				{
					ausgabeHandler.gibStringAnKonsole(StartmenueView.getStartmenue());
					parameter = EingabeController.getEingabe();
					masterController.getStartmenueController().auswertenEingabeStartmenue(parameter);
					
				}
				else if(parameter.equalsIgnoreCase("4"))
				{
					ausgabeHandler.gibStringAnKonsole(HauptmenueView.getProduzierenMenue());
					int menge = Integer.parseInt(EingabeController.getEingabe());
					masterController.getProduzierenController().produzieren(menge);
					
				}
				else if(parameter.equalsIgnoreCase("5"))
				{
					ausgabeHandler.gibStringAnKonsole(HauptmenueView.getPolitikMenue());
					parameter = EingabeController.getEingabe();
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
		int anzahl=0;
		while (true)
		{
			ausgabeHandler.gibStringAnKonsole(AusgabeView.getFrageNachAnzahl());
			
			try
			{
				anzahl = Integer.parseInt(EingabeController.getEingabe());
				//return anzahl;
				break;
				
			} 
			
			catch (NumberFormatException e)
			{
				// TODO Auto-generated catch block
				System.out.println("Das war keine Zahl!\n Bitte wiederholen Sie Ihre Eingabe!");
				//Aufruf FehlerView mit Fehlercode folgt...
				//fehlerView.getFehlercode......
			}
				
		}
		return anzahl;
	}
}
