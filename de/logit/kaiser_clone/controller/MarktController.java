package de.logit.kaiser_clone.controller;

import de.logit.kaiser_clone.model.Markt;
import de.logit.kaiser_clone.model.Spieler;
import de.logit.kaiser_clone.model.Titel;
import de.logit.kaiser_clone.view.AusgabeHandler;
import de.logit.kaiser_clone.view.FehlerView;
import de.logit.kaiser_clone.view.MarktView;

public class MarktController
{
	//Der "Eine" Markt der für alle gilt.
	private Markt markt;
	private MasterController masterController;
	
	private EingabeController eingabeController;
	private AusgabeHandler ausgabeHandler;
	
	public MarktController()
	{
		this.markt = Markt.getInstance();
	}
	
	public MarktController(MasterController _masterController) 
	{
		this.masterController = _masterController;
		this.eingabeController = _masterController.getEingabecontroller();
		this.ausgabeHandler = _masterController.getAusgabeHandler();
		this.markt = Markt.getInstance();
	}

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
				analysiereVerkauf(markt.verkaufeKorn(masterController.getSpielController().anzahlHolen(), 
						masterController.getAktiverSpieler()));
				break;
			case "2":
				analysiereVerkauf(markt.verkaufeMehl(masterController.getSpielController().anzahlHolen(), 
						masterController.getAktiverSpieler()));
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
			nachricht = FehlerView.getTransaktionErfolgreich();
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
		Spieler aktiverSpieler = masterController.getAktiverSpieler();
		switch (_param_1) {
			case "1":
				if(markt.kaufeTitel(aktiverSpieler)){
					ausgabeHandler.gibStringAnKonsole(
							MarktView.getTitelKaufErfolgreich(
									aktiverSpieler.getTitel().toString()), aktiverSpieler);
				} else {
					ausgabeHandler.gibStringAnKonsole(FehlerView.getTitelNichtverfuegbar(), aktiverSpieler);
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
				analysiereKauf(markt.kaufeKorn(masterController.getSpielController().anzahlHolen(), 
						masterController.getAktiverSpieler()));
				break;
			case "6":
				analysiereKauf(markt.kaufeMehl(masterController.getSpielController().anzahlHolen(), 
						masterController.getAktiverSpieler()));
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
			nachricht = FehlerView.getTransaktionErfolgreich();
			
			nachricht +=  MarktView.getMarktKaufVonFeld(_fehlercode[1]);
			
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
			nachricht = FehlerView.getTransaktionErfolgreich();
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
