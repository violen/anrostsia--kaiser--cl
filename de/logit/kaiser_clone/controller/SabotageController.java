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
			int _parameter3 = auswertenZerstoerenOptionen(gegner.get(_parameter2));
			
			analysiereSabotage(_parameter3);
		}
		
		if (_parameter == "3")
		{
			
		}
		
		if (_parameter == "4")
		{
			
		}
		
	}



	public int soldatenEinsetzen()
	{
		Spieler aktiverSpieler = masterController.getAktiverSpieler();
		if (aktiverSpieler.getSoldaten() < 10)
		{
			return 1;
		}
		else 
		{
			return (int) aktiverSpieler.getSoldaten()/10;
		}
		
	}
	


	private void analysiereSabotage(int _parameter3) {
		
		AusgabeHandler ausgabeHandler = masterController.getAusgabeHandler();
		Spieler aktiverSpieler = masterController.getAktiverSpieler();
		String nachrichtAnGegner = "";
		sabotage.setEingesetzteSoldaten(soldatenEinsetzen());

		
		if(_parameter3 == 1)
		{
			// Unruhe erfolgreich
			ausgabeHandler.gibStringAnKonsole(SabotageView.getUnruheSchuehrenErfolgreich());
			nachrichtAnGegner = SabotageView.getEsWurdeUnruheGeschuehrt(masterController.getAktiverSpieler().getName());
			aktiverSpieler.setGold(aktiverSpieler.getGold()-sabotage.getUnruheKosten());
		}
		else if(_parameter3 == 2)
		{
			// Unruhe nicht erfolgreich
			ausgabeHandler.gibStringAnKonsole(SabotageView.getUnsereUnruhestifterWurdenGefangenGenommen());
			nachrichtAnGegner = SabotageView.getWirHabenUnruhestifterGefangenGenommen(masterController.getAktiverSpieler().getName());
			aktiverSpieler.setGold(aktiverSpieler.getGold()-2*sabotage.getUnruheKosten());
			aktiverSpieler.setSoldaten(aktiverSpieler.getSoldaten()-sabotage.getEingesetzteSoldaten());
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


		if (masterController.getAktiverSpieler().getGold() >= 2*sabotage.getUnruheKosten())
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
	
	private int auswertenZerstoerenOptionen(Spieler _gegner) {
		
		if (masterController.getAktiverSpieler().getGold() >= 2*sabotage.getZerstoerenKosten())
		{
			
			if(masterController.getAktiverSpieler().getSoldaten() >= sabotage.getSoldatenMinimum())
			{
				int erfolg =sabotage.zerstoeren(_gegner);
				
				return erfolg;// 5 bei erfolg 6 bei misserfolg
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
