/**
 * 
 */
package de.logit.kaiser_clone.controller;

import java.util.LinkedList;

import de.logit.kaiser_clone.model.Sabotage;
import de.logit.kaiser_clone.model.Spieler;
import de.logit.kaiser_clone.view.AusgabeHandler;
import de.logit.kaiser_clone.view.FehlerView;
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
			// Unruhe erfolgreich
			ausgabeHandler.gibStringAnKonsole(SabotageView.getUnruheSchuehrenErfolgreich());
			nachrichtAnGegner = SabotageView.getEsWurdeUnruheGeschuehrt(masterController.getAktiverSpieler().getName());
		}
		else if(_parameter3 == 2)
		{
			// Unruhe nicht erfolgreich
			ausgabeHandler.gibStringAnKonsole(SabotageView.getUnsereUnruhestifterWurdenGefangenGenommen());
			nachrichtAnGegner = SabotageView.getWirHabenUnruhestifterGefangenGenommen(masterController.getAktiverSpieler().getName());
		}
		else if (_parameter3 == 4)
		{
			//Gold reicht nicht aus
			ausgabeHandler.gibStringAnKonsole(FehlerView.getGoldReichtNichtAus());
		}
		else if (_parameter3 == 3)
		{
			// Soldaten reichen nicht aus
			ausgabeHandler.gibStringAnKonsole(FehlerView.getSoldatenReichenNichtAus());
		}
		
	}



	private int auswertenUnruheOptionen(Spieler _gegner) {


		if (masterController.getAktiverSpieler().getGold() >= sabotage.getUnruheKosten())
		{
			
			if(masterController.getAktiverSpieler().getSoldaten() >= sabotage.getSoldatenMinimum())
			{
				int erfolg =sabotage.unruhe(_gegner);
				
				return erfolg;// 1 bei erfolg 2 bei misserfolg
			}
			
			return 3;
			
		}
		
		return 4;
		
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
