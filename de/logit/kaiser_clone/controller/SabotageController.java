/**
 * 
 */
package de.logit.kaiser_clone.controller;

import java.util.LinkedList;

import de.logit.kaiser_clone.model.Sabotage;
import de.logit.kaiser_clone.model.Spieler;
import de.logit.kaiser_clone.view.AusgabeHandler;
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
		// hier wird die liste der spieler außer dema ktiven spieler ausgegeben.
		LinkedList<Spieler> gegner = gegnerWaehlen(masterController.getAktiverSpieler());
		
		masterController.getAusgabeHandler().gibStringAnKonsole(SabotageView.getGegnerWaehlen(gegner));
		
		int _parameter2 = Integer.parseInt(masterController.getEingabecontroller().getEingabe());
		
		if (_parameter == "1")
		{
			int _parameter3 = auswertenUnruheOptionen(gegner.get(_parameter2));
			
			analysiereSabotage(_parameter3);
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



	private void analysiereSabotage(int _parameter3) {
		
		AusgabeHandler ausgabeHandler = masterController.getAusgabeHandler();
		
		String nachrichtAnGegner = "";

		
		if(_parameter3 == 1)
		{
			ausgabeHandler.gibStringAnKonsole(SabotageView.getUnruheSchuehrenErfolgreich());
			nachrichtAnGegner = SabotageView.getEsWurdeUnruheGeschuehrt(masterController.getAktiverSpieler().getName());
		}
		
	}



	private int auswertenUnruheOptionen(Spieler _gegner) {


		if (masterController.getAktiverSpieler().getGold() >= sabotage.getUnruheKosten())
		{
			//TODO
			if(masterController.getAktiverSpieler().getSoldaten() >= sabotage.getSoldatenMinimum())
			{
				sabotage.unruhe(_gegner);
				
				return 1;
			}
			
			return 2;
			
		}
		
		return 3;
		
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
