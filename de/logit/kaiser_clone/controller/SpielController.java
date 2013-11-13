package de.logit.kaiser_clone.controller;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter;

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
	
	public void gameLoop()
	{
		masterController.setAktiverSpieler(game.neueRunde());
		
		for(int i = 0; i < 4; i++)
		{
			game.getSpielrunde().berechneWerte();
			masterController.getStatistikcontroller().berechneStatistik();
			while(true)
			{
				
				ausgabeHandler.gibStringAnKonsole(HauptmenueView.getHauptmenue());
				String parameter = eingabeController.getEingabe();
				
				if(parameter == "1")
				{
					ausgabeHandler.gibStringAnKonsole(HauptmenueView.getMarktMenue());
					parameter = eingabeController.getEingabe();
					masterController.getMarktcontroller().auswertenEingabeMarkt(parameter);
										
				}
				else if(parameter == "2")
				{
					ausgabeHandler.gibStringAnKonsole(HauptmenueView.getSabotierenMenue());
					parameter = eingabeController.getEingabe();
					masterController.getSabotageController().auswertenEingabeSabotage(parameter);
					
				}
				else if(parameter == "3")
				{
					ausgabeHandler.gibStringAnKonsole(StartmenueView.getStartmenue());
					parameter = eingabeController.getEingabe();
					masterController.getStartmenueController().auswertenEingabeStartmenue(parameter);
					
				}
				else if(parameter == "4")
				{
					ausgabeHandler.gibStringAnKonsole(HauptmenueView.getProduzierenMenue());
					parameter = eingabeController.getEingabe();
					masterController.getProduzierenController().auswertenEingabeProduzieren(parameter);
					
				}
				else if(parameter == "5")
				{
					ausgabeHandler.gibStringAnKonsole(HauptmenueView.getPolitikMenue());
					parameter = eingabeController.getEingabe();
					masterController.getPolitikController().auswertenEingabePolitik(parameter);
					
				}
				else if(parameter == "6")
				{
					masterController.getStatistikcontroller().berechneStatistik();
					
				}
				else if (parameter == "7")
				{
					break;
				}
			}
			
			if( i < 3)
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
				anzahl = Integer.parseInt(eingabeController.getEingabe());
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
