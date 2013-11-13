package de.logit.kaiser_clone.controller;

import de.logit.kaiser_clone.model.Markt;
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
	
	public MarktController(){
		this.markt = Markt.getInstance();
	}
	
	public void auswertenEingabeMarkt(String _param)
	{
		if(_param =="1")
		{
			ausgabeHandler.gibStringAnKonsole(MarktView.getMarktKaufOptionen());
			String param_1 = eingabeController.getEingabe();
			auswertenKaufoptionen(param_1);
						
		}
		else if (_param == "2")
		{	
			ausgabeHandler.gibStringAnKonsole(MarktView.getMarktVerkaufOptionen());
			String param_2 = eingabeController.getEingabe();
			auswertenVerkaufoptionen(param_2);
		}
		
		
	}

	private void auswertenVerkaufoptionen(String _param_2)
	{
		// TODO Auto-generated method stub
		
	}

	private void auswertenKaufoptionen(String _param_1)
	{
		if(_param_1 == "1")
		{
			ausgabeHandler.gibStringAnKonsole(MarktView.getTitelAuswahl());
			String param_2 = eingabeController.getEingabe();
			Titel titel = waehlenTitel(param_2);
			markt.kaufeTitel(titel);
			//Baustelle
			//IntegerArray zum Aufnehmen der Fehlercodes
			int[] fehlercode=new int[2];
			analysiereFehlerCode(fehlercode);
		}
		
		else if(_param_1 == "2")
		{
			analysiereKauf(markt.kaufeFeld(masterController.getSpielController().anzahlHolen(), 
					masterController.getAktiverSpieler()));
		}
		
		else if(_param_1 == "3")
		{
			analysiereKauf(markt.kaufeKornspeicher(masterController.getSpielController().anzahlHolen(), 
					masterController.getAktiverSpieler()));
		}
		
		else if(_param_1 == "4")
		{
			analysiereKauf(markt.kaufeSoldaten(masterController.getSpielController().anzahlHolen(), 
					masterController.getAktiverSpieler()));
		}
		
		else if(_param_1 == "5")
		{
			analysiereKauf(markt.kaufeKorn(masterController.getSpielController().anzahlHolen(), 
					masterController.getAktiverSpieler()));
		}
		
		else if(_param_1 == "6")
		{
			analysiereKauf(markt.kaufeMehl(masterController.getSpielController().anzahlHolen(), 
					masterController.getAktiverSpieler()));
		}
		
		else if(_param_1 == "7")
		{
			analysiereKauf(markt.kaufeKornfeld(masterController.getSpielController().anzahlHolen(), 
					masterController.getAktiverSpieler()));
		}
		
		else if(_param_1 == "8")
		{
			analysiereKauf(markt.kaufeMuehle(masterController.getSpielController().anzahlHolen(), 
					masterController.getAktiverSpieler()));
		}
		
		else if(_param_1 == "9")
		{
			analysiereKauf(markt.kaufeDuenger(masterController.getSpielController().anzahlHolen(), 
					masterController.getAktiverSpieler()));
		}
		
		
		
	}

	private void analysiereKauf(int[] _fehlercode)
	{
		//Fehlercodes
		String nachricht ="";
		
		if(_fehlercode[0] == 10)
		{
			nachricht = FehlerView.getGoldReichtNichtAus();
			
			nachricht +=  MarktView.getMarktKaufVonFeld(_fehlercode[1]);
			
		}
		else if (_fehlercode[0] == 11)
		{
			nachricht = MarktView.getKaufErfolgreich();
			nachricht +=  MarktView.getMarktKaufVonFeld(_fehlercode[1]);
			
		}
		 masterController.getAusgabeHandler().gibStringAnKonsole(nachricht);
	}
	

	
	
	private void analysiereFehlerCode(int[] _fehlercode)
	{
		// TODO Auto-generated method stub
		
	}

	private Titel waehlenTitel(String _param_2)
	{
		return null;
		// TODO Auto-generated method stub
		
	}
	
	
	

}
