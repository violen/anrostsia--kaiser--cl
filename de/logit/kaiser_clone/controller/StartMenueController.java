package de.logit.kaiser_clone.controller;

import de.logit.kaiser_clone.model.Spieler;
import de.logit.kaiser_clone.model.Startmenue;
import de.logit.kaiser_clone.view.AusgabeView;
import de.logit.kaiser_clone.view.StartmenueView;

public class StartMenueController
{
	private MasterController masterController;
	/**
	 * @param _masterController
	 */
	public StartMenueController(MasterController _masterController) 
	{
		this.masterController = _masterController;
	}

	public void auswertenEingabeStartmenue(String _parameter)
	{
		Spieler aktiverSpieler = masterController.getAktiverSpieler();
		switch (_parameter) 
		{
		case "1":
			/*
			 * Ein Clientspieler kann zur zeit nicht das Spiel neu starten VORSICHT BUG ;(
			 */
			masterController.getAusgabeHandler().gibStringAnKonsole(AusgabeView.getBestaetigeAbbrechen("ein Neues Spiel beginnen"), aktiverSpieler);
			if(masterController.getEingabecontroller().getEingabe(aktiverSpieler).equalsIgnoreCase("1"))
			{
				Startmenue.neuesSpiel(masterController);
			}
			
			break;
			
		case "2":
			masterController.getAusgabeHandler().gibStringAnKonsole(AusgabeView.getBestaetigeAbbrechen("das laufende Spiel beenden"), aktiverSpieler);
			if(masterController.getEingabecontroller().getEingabe(aktiverSpieler).equalsIgnoreCase("1")){
				masterController.getAusgabeHandler().gibStringAnKonsole(StartmenueView.getSpielBeenden(), masterController.getAktiverSpieler());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Startmenue.beendeSpiel();
			}
			break;
		default:
			
			break;
		}
		
	}

}
