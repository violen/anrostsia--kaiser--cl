package de.logit.kaiser_clone.controller;

import de.logit.kaiser_clone.model.Spiel;
import de.logit.kaiser_clone.model.Spieler;
import de.logit.kaiser_clone.model.Spielrunde;
import de.logit.kaiser_clone.view.AusgabeHandler;
import de.logit.kaiser_clone.view.AusgabeView;
import de.logit.kaiser_clone.view.ChattenView;
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
	
	public SpielController(MasterController _masterController) 
	{
		this.masterController = _masterController;
		this.ausgabeHandler = _masterController.getAusgabeHandler();
		this.eingabeController = _masterController.getEingabecontroller();
	}

	public void gameLoop()
	{
		this.game = masterController.getSpiel();
		masterController.setAktiverSpieler(game.neueRunde());
		masterController.getSpielRundencontroller().setAktuelleRunde(game.getSpielrunde());
		masterController.getSpielRundencontroller().getAktuelleRunde().setzeDieGrundwerteDerSpielerZustandsTabelle(
				game.getSpieler());
		Spieler aktiverSpieler = masterController.getAktiverSpieler();
		
//		game.getSpielrunde().berechneWerte();
//		masterController.getStatistikcontroller().berechneStatistik();
		masterController.getSabotageController().setSabotage(masterController.getSpiel().getHauptmenue().getSabotage());
		//masterController.getPolitikController().setPolitik(masterController.getSpiel().getHauptmenue().getPolitik());
		
		/*
		 * Statistik für den ServerSpieler bei SPielstart
		 */
		ausgabeHandler.gibStringAnKonsole(StatistikView.getStatistikDesSpielers(masterController.getStatistikcontroller().getLandschaft(), aktiverSpieler), aktiverSpieler);
		
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
				if(!aktiverSpieler.getZustaendeTabelle().get("hatSabotiert").booleanValue()){
					if (game.getSpieler().size() > 1)
					{
						ausgabeHandler.gibStringAnKonsole(HauptmenueView.getSabotierenMenue(), aktiverSpieler);
						parameter = this.eingabeController.getEingabe(aktiverSpieler);
						masterController.getSabotageController().auswertenEingabeSabotage(parameter);
					}
					else
					{
						masterController.getAusgabeHandler().gibStringAnKonsole(FehlerView.getSabotageNurImMehrspielerModusVerfuegbar());
					}
				} 
				else 
				{
					ausgabeHandler.gibStringAnKonsole(FehlerView.getAusfuehrenDieserAktionInDieserRundeNichtMoeglich(), aktiverSpieler);
				}
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
				
				masterController.getProduzierenController().produzieren();
				
			}
			else if(parameter.equalsIgnoreCase("5"))
			{
				ausgabeHandler.gibStringAnKonsole(HauptmenueView.getPolitikMenue(), aktiverSpieler);
				parameter = this.eingabeController.getEingabe(aktiverSpieler);
				masterController.getPolitikController().auswertenEingabePolitik(parameter);
				
			}
			else if(parameter.equalsIgnoreCase("6"))
			{
//				masterController.getStatistikcontroller().berechneStatistik();
				ausgabeHandler.gibStringAnKonsole(StatistikView.getStatistikDesSpielers(masterController.getStatistikcontroller().getLandschaft(), aktiverSpieler), aktiverSpieler);
				masterController.getAktiverSpieler().setNachricht("");// Ereignisse loeschen nachdem sie ausgegeben wurden.
			}
			else if (parameter.equalsIgnoreCase("7"))
			{ 
				if(aktiverSpieler == game.getSpieler().getLast())
				{
					masterController.getSpielRundencontroller().initNeueRunde(game.getSpielrunde());
					game.setSpielrunde(masterController.getSpielRundencontroller().getAktuelleRunde());
					game.getSpielrunde().setzeDieGrundwerteDerSpielerZustandsTabelle(game.getSpieler());
					aktiverSpieler = masterController.getAktiverSpieler();
					ausgabeHandler.gibStringAnKonsole(":::NEUE RUNDE BEGINNT:::"+"\n", aktiverSpieler); // DEBUGGING Ausgabe !
					ausgabeHandler.gibStringAnKonsole(StatistikView.getStatistikDesSpielers(masterController.getStatistikcontroller().getLandschaft(), aktiverSpieler), aktiverSpieler);
				} 
				else 
				{
					Spieler spieler = game.getNextSpieler(aktiverSpieler, game.getSpieler());
					game.getSpielrunde().setAktiverspieler(spieler);
					masterController.setAktiverSpieler(spieler);
					aktiverSpieler = spieler;	
					ausgabeHandler.gibStringAnKonsole(StatistikView.getStatistikDesSpielers(masterController.getStatistikcontroller().getLandschaft(), aktiverSpieler), aktiverSpieler);
				}
			
			game.getSpielrunde().berechneWerte();
			}
			else if(parameter.equalsIgnoreCase("8"))
			{
						ausgabeHandler.gibStringAnKonsole(HauptmenueView.getChattenMenue(), aktiverSpieler);
						parameter = this.eingabeController.getEingabe(aktiverSpieler);
						ausgabeHandler.gibStringAnKonsole(ChattenView.getGebeGewaehltenEmpfaengerAus(parameter), aktiverSpieler);
						
						
						//ausgabeHandler.gibStringAnKonsole(ChattenView.getNachrichtAnEmpfaengerEingeben(parameter), aktiverSpieler);//jetzt im ChattenController
						masterController.getChattenController().getAuswertenEmpfaenger(parameter);
						
						
						
						//ausgabeHandler.gibStringAnKonsole(ChattenView.getGesendeteNachricht(parameter), aktiverSpieler);
			
						
			}
				
				
		}	
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
