/**
 * 
 */
package de.logit.kaiser_clone.controller;

import java.util.LinkedList;

import de.logit.kaiser_clone.model.Sabotage;
import de.logit.kaiser_clone.model.Spieler;
import de.logit.kaiser_clone.view.HauptmenueView;
import de.logit.kaiser_clone.view.SabotageView;

/**
 * @author nepo aka. André Hauser
 *
 */
public class SabotageController {
	
	private MasterController masterController;
	private Sabotage sabotage;
	
	

	/**
	 * @param _masterController
	 */
	public SabotageController(MasterController _masterController,Sabotage _sabotage) {
		masterController = _masterController;
		sabotage = _sabotage;
	}



	public void auswertenEingabeSabotage(String _parameter)
	{
		// hier wird die liste der spieler außer dema ktiven spieler ausgegeben
		masterController.getAusgabeHandler().gibStringAnKonsole(SabotageView.getGegnerWaehlen(gegnerWaehlen(masterController.getAktiverSpieler())));
		
		String _parameter2 = masterController.getEingabecontroller().getEingabe();
		
		if (_parameter == "1")
		{
			auswertenUnruheOptionen();
		}
		
		if (_parameter == "2")
		{
			//TODO
		}
		
		if (_parameter == "3")
		{
			
		}
		
		if (_parameter == "4")
		{
			
		}
		
	}



	private void auswertenUnruheOptionen() {


		if (masterController.getAktiverSpieler().getGold() >= sabotage.getUnruheKosten())
		{
			//TODO
		}
		
	}



	private LinkedList<Spieler> gegnerWaehlen(Spieler _aktiverSpieler) {

		LinkedList<Spieler> gegner = new LinkedList<Spieler>();
		for (Spieler s : masterController.getSpiel().getSpieler())
		{
			if ( s != _aktiverSpieler)
			{
				gegner.add(s);
			}
		}
		return gegner;
	}

}
