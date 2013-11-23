package de.logit.kaiser_clone.controller;

import de.logit.kaiser_clone.model.Markt;
import de.logit.kaiser_clone.model.Spieler;
import de.logit.kaiser_clone.view.AusgabeHandler;
import de.logit.kaiser_clone.view.AusgabeView;
import de.logit.kaiser_clone.view.FehlerView;
import de.logit.kaiser_clone.view.MarktView;
/**
 * Der Spieler darf nur einmal Pro zug im Titel aufsteigen,
 * Sabotieren
 * und Mehl kaufen oder verkaufen
 * und Korn kaufen oder verkaufen
 * 
 */
public class MarktController
{
	//Der "Eine" Markt der für alle gilt.
	private Markt markt;
	private MasterController masterController;
	
	private EingabeController eingabeController;
	private AusgabeHandler ausgabeHandler;
	
	public MarktController(MasterController _masterController) 
	{
		this.masterController = _masterController;
		this.eingabeController = _masterController.getEingabecontroller();
		this.ausgabeHandler = _masterController.getAusgabeHandler();
		this.markt = Markt.getInstance();
	}
	/*
	 * Wertet aus ob etwas gekauft oder verkauft wird
	 */
	public void auswertenEingabeMarkt(String _param)
	{
		Spieler aktiverSpieler = masterController.getAktiverSpieler();
		switch (_param) 
		{
			case "1":
				ausgabeHandler.gibStringAnKonsole(MarktView.getMarktKaufOptionen(),aktiverSpieler);
				String param_1 = eingabeController.getEingabe(aktiverSpieler);
				auswertenKaufoptionen(param_1);
				break;
	
			case "2":
				ausgabeHandler.gibStringAnKonsole(MarktView.getMarktVerkaufOptionen(),aktiverSpieler);
				String param_2 = eingabeController.getEingabe(aktiverSpieler);
				auswertenVerkaufoptionen(param_2);
				break;
				
			default:
				break;
		}		
	}

	private void auswertenVerkaufoptionen(String _param_1)
	{
		
		switch (_param_1) 
		{
			case "1":
				if(!masterController.getAktiverSpieler().getZustaendeTabelle().get("KornHandel").booleanValue()){
					analysiereVerkauf(markt.verkaufeKorn(masterController.getSpielController().anzahlHolen(), 
							masterController.getAktiverSpieler()));
				} else {
					ausgabeHandler.gibStringAnKonsole(FehlerView.getAusfuehrenDieserAktionInDieserRundeNichtMoeglich(), masterController.getAktiverSpieler());
				}
				break;
			case "2":
				if(!masterController.getAktiverSpieler().getZustaendeTabelle().get("MehlHandel").booleanValue()){	
					analysiereVerkauf(markt.verkaufeMehl(masterController.getSpielController().anzahlHolen(), 
							masterController.getAktiverSpieler()));
				} else {
					ausgabeHandler.gibStringAnKonsole(FehlerView.getAusfuehrenDieserAktionInDieserRundeNichtMoeglich(), masterController.getAktiverSpieler());
				}
				break;
			default:
				break;
		}
		
	}

	private void analysiereVerkauf(int _fehlercode) 
	{
		
		String nachricht = "";

		if (_fehlercode == 1)
		{
			nachricht = AusgabeView.getTransaktionErfolgreich();
		}
		else if (_fehlercode == 2)
		{
			nachricht = FehlerView.getMengeNichtVerfügbar();
		}
		else if (_fehlercode == 3)
		{
			nachricht = FehlerView.getKeineGueltigeEingabe();
		}
		
		
	}

	private void auswertenKaufoptionen(String _param_1)
	{
		Spieler _aktiverSpieler = masterController.getAktiverSpieler();
		switch (_param_1) {
			case "1":
				if(!_aktiverSpieler.getZustaendeTabelle().get("TitelGekauft").booleanValue()){	
					if(markt.kaufeTitel(_aktiverSpieler)){
						ausgabeHandler.gibStringAnKonsole(
								MarktView.getTitelKaufErfolgreich(
										_aktiverSpieler.getTitel().toString()), _aktiverSpieler);
					} else {
						ausgabeHandler.gibStringAnKonsole(FehlerView.getTitelNichtverfuegbar(), _aktiverSpieler);
					}
				} else {
					ausgabeHandler.gibStringAnKonsole(FehlerView.getAusfuehrenDieserAktionInDieserRundeNichtMoeglich(), _aktiverSpieler);
				}
				break;
			case "2":
				analysiereKauf(markt.kaufeFeld(masterController.getSpielController().anzahlHolen(), 
						masterController.getAktiverSpieler()));
				break;
			case "3":
				analysiereKauf(markt.kaufeKornspeicher(masterController.getSpielController().anzahlHolen(), 
						masterController.getAktiverSpieler()));
				break;
			case "4":
				analysiereKauf(markt.kaufeSoldaten(masterController.getSpielController().anzahlHolen(), 
						masterController.getAktiverSpieler()));
				break;
			case "5":
				if(!_aktiverSpieler.getZustaendeTabelle().get("KornHandel").booleanValue()){
					analysiereKauf(markt.kaufeKorn(masterController.getSpielController().anzahlHolen(), 
							masterController.getAktiverSpieler()));
				} else {
					ausgabeHandler.gibStringAnKonsole(FehlerView.getAusfuehrenDieserAktionInDieserRundeNichtMoeglich(), _aktiverSpieler);
				}
				break;
			case "6":
				if(!_aktiverSpieler.getZustaendeTabelle().get("MehlHandel").booleanValue()){
					analysiereKauf(markt.kaufeMehl(masterController.getSpielController().anzahlHolen(), 
							masterController.getAktiverSpieler()));
				} else {
					ausgabeHandler.gibStringAnKonsole(FehlerView.getAusfuehrenDieserAktionInDieserRundeNichtMoeglich(), _aktiverSpieler);
				}
				break;
			case "7":
				analysiereKauf(markt.kaufeKornfeld(masterController.getSpielController().anzahlHolen(), 
						masterController.getAktiverSpieler()));
				break;
			case "8":
				analysiereKauf(markt.kaufeMuehle(masterController.getSpielController().anzahlHolen(), 
						masterController.getAktiverSpieler()));
				break;
			case "9":
				analysiereKauf(markt.kaufeDuenger(masterController.getSpielController().anzahlHolen(), 
						masterController.getAktiverSpieler()));
				break;
					
			default:
				break;
		}		
	}

	private void analysiereKauf(int[] _fehlercode)
	{
		Spieler aktiverSpieler = masterController.getAktiverSpieler();
		//Fehlercodes
		String nachricht ="";
		
		if(_fehlercode[0] == 1)
		{
			nachricht = AusgabeView.getTransaktionErfolgreich();
			
			//nachricht +=  MarktView.getMarktKaufVonFeld(_fehlercode[1]);
			
		}
		
		else if(_fehlercode[0] == 2)
		{
			nachricht = FehlerView.getGoldReichtNichtAus();
			
		}
		
		else if(_fehlercode[0] == 3)
		{
			nachricht = FehlerView.getMengeNichtVerfügbar();
			
		}
		
		else if(_fehlercode[0] == 4)
		{
			nachricht = FehlerView.getUnkorrekteEingabe();
			
		}
		
		else if(_fehlercode[0] == 5)
		{
			nachricht = FehlerView.getTitelNichtverfuegbar();
			
		}
		
		else if(_fehlercode[0] == 6)
		{
			nachricht = FehlerView.getKeinFreiesFeldVorhanden();
			
		}
		
		else if(_fehlercode[0] == 7)
		{
			nachricht = AusgabeView.getTransaktionErfolgreich();
			nachricht += MarktView.getMarktKaufVonGebaeude(_fehlercode[1]);
			
		}
		
		else if(_fehlercode[0] == 8)
		{
			nachricht = FehlerView.getGoldReichtNichtAus();
			nachricht += MarktView.getMarktKaufVonGebaeude(_fehlercode[1]);
		}
		
		else if(_fehlercode[0] == 9)
		{
			nachricht = FehlerView.getKeinFreiesFeldVorhanden();
			nachricht += MarktView.getMarktKaufVonGebaeude(_fehlercode[1]);
		}
		
		else if(_fehlercode[0] == 10)
		{
			nachricht = FehlerView.getGoldReichtNichtAus();
			
			nachricht +=  MarktView.getMarktKaufVonFeld(_fehlercode[1]);
			
		}
		else if (_fehlercode[0] == 11)
		{
			nachricht = MarktView.getKaufErfolgreich();
			nachricht +=  MarktView.getMarktKaufVonFeld(_fehlercode[1]);
			
		}
		 masterController.getAusgabeHandler().gibStringAnKonsole(nachricht, aktiverSpieler);
	}
	
	private void analysiereFehlerCode(int[] _fehlercode)
	{
		// TODO Auto-generated method stub
		
	}

}
