package de.logit.kaiser_clone.controller;

import de.logit.kaiser_clone.model.Politik;
import de.logit.kaiser_clone.model.Spieler;
import de.logit.kaiser_clone.view.PolitikView;

public class PolitikController
{
	private MasterController masterController;
	private Politik politik;
	
	public PolitikController(MasterController _masterController) 
	{
		this.setMasterController(_masterController);
		this.politik = masterController.getSpiel().getHauptmenue().getPolitik();
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
			
			//Menü Steuern ausgeben
			case "1":
				masterController.getAusgabeHandler().gibStringAnKonsole(PolitikView.getSteuernMenue(), aktiverSpieler);
				if(masterController.getEingabecontroller().getEingabe(aktiverSpieler).equalsIgnoreCase("1"))
				{
					PolitikView.getSteuernRunter();
					politik.setSteuersatz(politik.getSteuersatz()/2);
				}
				else if(masterController.getEingabecontroller().getEingabe(aktiverSpieler).equalsIgnoreCase("2"))
				{
					PolitikView.getSteuernHoch();
					politik.setSteuersatz(politik.getSteuersatz()*2);
				}
				else
				{
					PolitikView.getSteuernNormal();
				}
				break;
				
			// Menü Nahrungsration ausgeben
			case "2":
				PolitikView.getNahrungsrationsMenue();
				
				break;
			
			}
		
		
	}

	public MasterController getMasterController() 
	{
		return masterController;
	}

	public void setMasterController(MasterController masterController) 
	{
		this.masterController = masterController;
	}

}
