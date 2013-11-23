package de.logit.kaiser_clone.controller;

import de.logit.kaiser_clone.model.Spieler;
import de.logit.kaiser_clone.view.PolitikView;

public class PolitikController
{
	private MasterController masterController;
	//private Politik politik;

	public PolitikController(MasterController _masterController) 
	{
		this.masterController = _masterController;
	}

	public void auswertenEingabePolitik(String _parameter)
	{
		
		Spieler aktiverSpieler = masterController.getAktiverSpieler();
		
		// 1= Steuern
		//
		//analysiere Steuern
		
		//2= Nahrungsration
		//
		//analysiere Nahrungsration
		
		
			switch (_parameter)
			{
			
			//Menü Steuern ausgeben und prüfen, ob die Steuern schon erhöht oder gesenkt wurden.
			case "1":
				//prüfen ob Steuern (40) bereits gesenkt (20) oder erhöht (80) wurden
				//wenn gesenkt, dann nur noch auf Normal oder hoch
				//wenn errhöht, dann nur noch auf Normal oder runter
				masterController.getAusgabeHandler().gibStringAnKonsole(PolitikView.getSteuernMenue(aktiverSpieler.getSteuersatz()), aktiverSpieler);
				String steuern = masterController.getEingabecontroller().getEingabe(aktiverSpieler);
				if(steuern.equalsIgnoreCase("1") && ((aktiverSpieler.getSteuersatz() == 20) ||(aktiverSpieler.getSteuersatz() == 40)))
				{	
					aktiverSpieler.setSteuersatz(aktiverSpieler.getSteuersatz()*2);			
					masterController.getAusgabeHandler().gibStringAnKonsole(PolitikView.getSteuernHoch(aktiverSpieler.getSteuersatz()), aktiverSpieler);
					
					
				}
				else if(steuern.equalsIgnoreCase("2") && ((aktiverSpieler.getSteuersatz() == 40) ||(aktiverSpieler.getSteuersatz() == 80)))
				{
					aktiverSpieler.setSteuersatz(aktiverSpieler.getSteuersatz()/2);
					masterController.getAusgabeHandler().gibStringAnKonsole(PolitikView.getSteuernRunter(aktiverSpieler.getSteuersatz()), aktiverSpieler);
					
					
				}
				else
				{	
					masterController.getAusgabeHandler().gibStringAnKonsole(PolitikView.getSteuernNormal(aktiverSpieler.getSteuersatz()), aktiverSpieler);									}
				
				break;
				
			
			
			// Menü Nahrungsration ausgeben und prüfen, ob die Nahrung schon erhöht oder gesenkt wurden.
			case "2":

				//prüfen ob Nahrung (10) bereits gesenkt (5) oder erhöht (20) wurden
				//wenn gesenkt, dann nur noch auf Normal oder hoch
				//wenn erhöht, dann nur noch auf Normal oder runter
				
				masterController.getAusgabeHandler().gibStringAnKonsole(PolitikView.getNahrungsrationsMenue(aktiverSpieler.getRation()), aktiverSpieler);
				String nahrung = masterController.getEingabecontroller().getEingabe(aktiverSpieler);
				if(nahrung.equalsIgnoreCase("1") && ((aktiverSpieler.getRation() == 5) ||(aktiverSpieler.getRation() == 10)) )
				{
					aktiverSpieler.setRation(aktiverSpieler.getRation()*2);
					masterController.getAusgabeHandler().gibStringAnKonsole(PolitikView.getNahrungWurdeErhoeht(aktiverSpieler.getRation()), aktiverSpieler);
					
				}
				else if(nahrung.equalsIgnoreCase("2") && ((aktiverSpieler.getRation() == 10) ||(aktiverSpieler.getRation() == 20)))
				{
					aktiverSpieler.setRation(aktiverSpieler.getRation()/2);
					masterController.getAusgabeHandler().gibStringAnKonsole(PolitikView.getNahrungWurdeGesenkt(aktiverSpieler.getRation()), aktiverSpieler);
					
				}
				else
				{
					masterController.getAusgabeHandler().gibStringAnKonsole(PolitikView.getNahrungBleibtGleich(aktiverSpieler.getRation()), aktiverSpieler);		
				}
				
				break;
				}
		
			}

//	public Politik getPolitik() 
//	{
//		return politik;
//	}
//
//	public void setPolitik(Politik _politik) 
//	{
//		politik = _politik;
//	}
}
