/**
 * 
 */
package de.logit.kaiser_clone.controller;

import java.util.LinkedList;

import de.logit.kaiser_clone.model.Spieler;
import de.logit.kaiser_clone.view.HauptmenueView;

/**
 * @author nepo aka. André Hauser
 *
 */
public class SabotageController {
	
	private MasterController masterController;
	
	

	/**
	 * @param _masterController
	 */
	public SabotageController(MasterController _masterController) {
		masterController = _masterController;
	}



	public void auswertenEingabeSabotage(String _parameter)
	{
		gegnerWaehlen(masterController.getAktiverSpieler());
		masterController.getAusgabeHandler().gibStringAnKonsole(HauptmenueView.getSabotierenMenue());
		
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
