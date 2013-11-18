package de.logit.kaiser_clone.controller;

import de.logit.kaiser_clone.view.AusgabeView;
import de.logit.kaiser_clone.view.StartmenueView;

public class StartMenueController
{
	private MasterController masterController;
	/**
	 * @param _masterController
	 */
	public StartMenueController(MasterController _masterController) {
		this.masterController = _masterController;
	}

	public void auswertenEingabeStartmenue(String _parameter)
	{
		switch (_parameter) {
		case "1":
			masterController.getAusgabeHandler().gibStringAnKonsole(AusgabeView.getBestaetigeAbbrechen("ein Neues Spiel beginnen"), masterController.getAktiverSpieler());
			if(EingabeController.getEingabe().equalsIgnoreCase("1")){
				this.masterController.spielStarten();
			}
			
			break;
			
		case "2":
			masterController.getAusgabeHandler().gibStringAnKonsole(AusgabeView.getBestaetigeAbbrechen("das laufende Spiel beenden"), masterController.getAktiverSpieler());
			if(EingabeController.getEingabe().equalsIgnoreCase("1")){
				masterController.getAusgabeHandler().gibStringAnKonsole(StartmenueView.getSpielBeenden(), masterController.getAktiverSpieler());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
			break;
		default:
			
			break;
		}
		
	}

}
