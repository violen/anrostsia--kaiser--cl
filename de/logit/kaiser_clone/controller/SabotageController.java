/**
 * 
 */
package de.logit.kaiser_clone.controller;

import java.util.LinkedList;
import java.util.Map;

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



	public SabotageController(MasterController _masterController) {
		this.masterController = _masterController;
	}



	public void auswertenEingabeSabotage(String _parameter)
	{
		Spieler aktiverSpieler = masterController.getAktiverSpieler();
		// hier wird die liste der spieler außer dema ktiven spieler ausgegeben.
		LinkedList<Spieler> gegner = gegnerWaehlen(masterController.getAktiverSpieler());
		
		masterController.getAusgabeHandler().gibStringAnKonsole(SabotageView.getGegnerWaehlen(gegner),aktiverSpieler);
		
		Spieler derSabotierte;
		
		while (true)
		{
			try {
				int _parameter2 = Integer.parseInt(masterController.getEingabecontroller().getEingabe(aktiverSpieler));
				
				try {
					derSabotierte = gegner.get(_parameter2);
					break;
				} catch (IndexOutOfBoundsException e) {
					masterController.getAusgabeHandler().gibStringAnKonsole(FehlerView.getSpielerNichtInListe(), aktiverSpieler);
					
				}
				
			} catch (NumberFormatException ex) {
				masterController.getAusgabeHandler().gibStringAnKonsole(FehlerView.getDasWarKeineZahl(), aktiverSpieler);
			}
		}
		
		String nachrichtAnGegner ="";
		
		if (_parameter.equalsIgnoreCase("4"))
		{
			
			int[] _parameters = auswertenUnruheOptionen(derSabotierte);
			
			nachrichtAnGegner = analysiereSabotage(_parameters[0],_parameters[1]);
		}
		
		if (_parameter.equalsIgnoreCase("2"))
		{
			int _parameters[] = auswertenZerstoerenOptionen(derSabotierte);
			
			nachrichtAnGegner = analysiereSabotage(_parameters[0],_parameters[1]);
		}
		
		if (_parameter.equalsIgnoreCase("1"))
		{
			int _parameters[] = auswertenPluendernOptionen(derSabotierte);
			
			nachrichtAnGegner = analysiereSabotage(_parameters[0],_parameters[1]);
		}
		
		if (_parameter.equalsIgnoreCase("3"))
		{
			int _parameters[] = auswertenVergiftenOptionen(derSabotierte);
			
			nachrichtAnGegner = analysiereSabotage(_parameters[0],_parameters[1]);
		}
		
		derSabotierte.setNachricht(derSabotierte.getNachricht() + nachrichtAnGegner);
		
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
	


	private String analysiereSabotage(int _parameter3, int _kosten) {
		
		AusgabeHandler ausgabeHandler = masterController.getAusgabeHandler();
		Spieler aktiverSpieler = masterController.getAktiverSpieler();
		String nachrichtAnGegner = "";
		sabotage.setEingesetzteSoldaten(soldatenEinsetzen());
		int gold = aktiverSpieler.getGold();

		
		if(_parameter3 == 1)
		{
			// Unruhe erfolgreich
			ausgabeHandler.gibStringAnKonsole(SabotageView.getUnruheSchuehrenErfolgreich(),aktiverSpieler);
			nachrichtAnGegner = SabotageView.getEsWurdeUnruheGeschuehrt(masterController.getAktiverSpieler().getName());
			aktiverSpieler.setGold(gold- _kosten);
		}
		else if(_parameter3 == 2)
		{
			// Unruhe nicht erfolgreich
			ausgabeHandler.gibStringAnKonsole(SabotageView.getUnsereUnruhestifterWurdenGefangenGenommen(), aktiverSpieler);
			nachrichtAnGegner = SabotageView.getWirHabenUnruhestifterGefangenGenommen(masterController.getAktiverSpieler().getName());
			aktiverSpieler.setGold(gold-2*_kosten);
			aktiverSpieler.setSoldaten(aktiverSpieler.getSoldaten()-sabotage.getEingesetzteSoldaten());
		}
		else if (_parameter3 == 3)
		{
			// Soldaten reichen nicht aus
			ausgabeHandler.gibStringAnKonsole(FehlerView.getSoldatenReichenNichtAus(), aktiverSpieler);
		}
		else if (_parameter3 == 4)
		{
			//Gold reicht nicht aus
			ausgabeHandler.gibStringAnKonsole(FehlerView.getGoldReichtNichtAus(), aktiverSpieler);
		}
		
		else if (_parameter3 == 5)
		{
			//Kornspeicher zerstoert
			ausgabeHandler.gibStringAnKonsole(SabotageView.getKornspeicherZerstoert(),aktiverSpieler);
			nachrichtAnGegner = SabotageView.getEsWurdeEinKornspeicherZerstoert(aktiverSpieler.getName());
			aktiverSpieler.setGold(gold-_kosten);
		}
		
		else if (_parameter3 == 6)
		{
			//Kornfeld zerstoert
			ausgabeHandler.gibStringAnKonsole(SabotageView.getKornfeldZerstoert(),aktiverSpieler);
			nachrichtAnGegner = SabotageView.getEsWurdeEinKornfeldZerstoert(aktiverSpieler.getName());
			aktiverSpieler.setGold(gold-_kosten);
		}
		
		else if (_parameter3 == 7)
		{
			//Muehle zerstoert
			ausgabeHandler.gibStringAnKonsole(SabotageView.getMuehleZerstoert(),aktiverSpieler);
			nachrichtAnGegner = SabotageView.getEsWurdeEineMuehleZerstoert(aktiverSpieler.getName());
			aktiverSpieler.setGold(gold-_kosten);
		}
		
		else if (_parameter3 == 8)
		{
			//Zerstoeren fehlgeschlagen
			ausgabeHandler.gibStringAnKonsole(SabotageView.getZerstoerenFehlgeschlagen(),aktiverSpieler);
			nachrichtAnGegner = SabotageView.getWirHabenEineZerstoererCrewGefangenGenommen(aktiverSpieler.getName());
			aktiverSpieler.setGold(gold-2*_kosten);
			aktiverSpieler.setSoldaten(aktiverSpieler.getSoldaten()-sabotage.getEingesetzteSoldaten());
		}
		
		else if (_parameter3 == 9)
		{
			//Gegner hat keine Gebaeude
			ausgabeHandler.gibStringAnKonsole(SabotageView.getGegnerHatKeineGebaeude(),aktiverSpieler);
		}
		else if (_parameter3 == 10)
		{
			//Gold gepluendert
			ausgabeHandler.gibStringAnKonsole(SabotageView.getGoldGepluendert(sabotage.getGepluendertesGold()),aktiverSpieler);
			nachrichtAnGegner = SabotageView.getEsWurdeGoldGepluendert(aktiverSpieler.getName(),sabotage.getGepluendertesGold());
			aktiverSpieler.setGold(gold+sabotage.getGepluendertesGold()-_kosten);
			
		}
		else if (_parameter3 == 11)
		{
			//Korn gepluendert
			ausgabeHandler.gibStringAnKonsole(SabotageView.getKornGepluendert(sabotage.getGepluendertesKorn()),aktiverSpieler);
			nachrichtAnGegner = SabotageView.getEsWurdeKornGepluendert(aktiverSpieler.getName(),sabotage.getGepluendertesKorn());
			aktiverSpieler.setKorn(aktiverSpieler.getKorn()+sabotage.getGepluendertesKorn());
			aktiverSpieler.setGold(gold-_kosten);
			
		}
		else if (_parameter3 == 12)
		{
			//Pluendern fehlheschlagen
			ausgabeHandler.gibStringAnKonsole(SabotageView.getPluendernFehlgeschlagen(),aktiverSpieler);
			nachrichtAnGegner = SabotageView.getWirHabenEinePluendererCrewGefangenGenommen(masterController.getAktiverSpieler().getName());
			aktiverSpieler.setGold(gold-2*_kosten);
			aktiverSpieler.setSoldaten(aktiverSpieler.getSoldaten()-sabotage.getEingesetzteSoldaten());
			
		}
		else if (_parameter3 == 13)
		{
			//Vergiften fehlgeschlagen
			ausgabeHandler.gibStringAnKonsole(SabotageView.getVergiftenFehlgeschlagen(),aktiverSpieler);
			nachrichtAnGegner = SabotageView.getWirHabenEineVergifterCrewGefangenGenommen(masterController.getAktiverSpieler().getName());
			aktiverSpieler.setGold(gold-2*_kosten);
			aktiverSpieler.setSoldaten(aktiverSpieler.getSoldaten()-sabotage.getEingesetzteSoldaten());
		}
		else if (_parameter3 == 14)
		{
			//Vergiften erfolgreich
			ausgabeHandler.gibStringAnKonsole(SabotageView.getKornVergiftet(sabotage.getNeuesKorn()),aktiverSpieler);
			nachrichtAnGegner = SabotageView.getEsWurdeKornVergiftet(aktiverSpieler.getName(),sabotage.getNeuesKorn());
			aktiverSpieler.setKorn(aktiverSpieler.getKorn()+sabotage.getNeuesKorn());
			aktiverSpieler.setGold(gold-_kosten);
		}
		
		return nachrichtAnGegner;
		
	}



	private int[] auswertenUnruheOptionen(Spieler _gegner) {
		
		int[] parameters = new int[2];
		parameters[1]=sabotage.getUnruheKosten();
		Spieler aktiverSpieler = masterController.getAktiverSpieler();

		if (masterController.getAktiverSpieler().getGold() >= 2*parameters[1])
		{
			
			if(masterController.getAktiverSpieler().getSoldaten() >= sabotage.getSoldatenMinimum())
			{
				for(Map.Entry<String, Boolean> entry: aktiverSpieler.getZustaendeTabelle().entrySet()){
					if(entry.getKey().equalsIgnoreCase("hatsabotiert")){
						entry.setValue(true);
					}
				}
				parameters[0] =sabotage.unruhe(_gegner);
				
				return parameters;// 1 bei erfolg 2 bei misserfolg
			}
			parameters[0]=3;
			return parameters;
			
		}
		parameters[0]=4;
		return parameters;
		
	}
	
	private int[] auswertenZerstoerenOptionen(Spieler _gegner) {
		
		int[] parameters = new int[2];
		
		parameters[1]=sabotage.getZerstoerenKosten();
		Spieler aktiverSpieler = masterController.getAktiverSpieler();
		
		if (masterController.getAktiverSpieler().getGold() >= 2*parameters[1])
		{
			
			if(masterController.getAktiverSpieler().getSoldaten() >= sabotage.getSoldatenMinimum())
			{
				for(Map.Entry<String, Boolean> entry: aktiverSpieler.getZustaendeTabelle().entrySet()){
					if(entry.getKey().equalsIgnoreCase("hatSabotiert")){
						entry.setValue(true);
					}
				}
				
				parameters[0] =sabotage.zerstoeren(_gegner);
				
				return parameters;// 5,6,7 bei erfolg 8 bei misserfolg
			}
			parameters[0]=3;
			return parameters;
			
		}
		parameters[0]=4;
		return parameters;
	}

	private int[] auswertenPluendernOptionen(Spieler _gegner) {
		
		int[] parameters = new int[2];
		
		parameters[1]=sabotage.getPluendernKosten();
		Spieler aktiverSpieler = masterController.getAktiverSpieler();
		
		if (masterController.getAktiverSpieler().getGold() >= 2*parameters[1])
		{
			
			if(masterController.getAktiverSpieler().getSoldaten() >= sabotage.getSoldatenMinimum())
			{
				for(Map.Entry<String, Boolean> entry: aktiverSpieler.getZustaendeTabelle().entrySet()){
					if(entry.getKey().equalsIgnoreCase("hatSabotiert")){
						entry.setValue(true);
					}
				}
				
				parameters[0] =sabotage.pluendern(_gegner);
				
				return parameters;// 10,11 bei erfolg 12 bei misserfolg
			}
			parameters[0]=3;
			return parameters;
			
		}
		parameters[0] = 4;
		return parameters;
	}
	
	private int[] auswertenVergiftenOptionen(Spieler _gegner) 
	{
		int[] parameters = new int[2];
		
		parameters[1]=sabotage.getVergiftenKosten();
		Spieler aktiverSpieler = masterController.getAktiverSpieler();
		
		if (masterController.getAktiverSpieler().getGold() >= 2*sabotage.getVergiftenKosten())
		{
			
			if(masterController.getAktiverSpieler().getSoldaten() >= sabotage.getSoldatenMinimum())
			{
				for(Map.Entry<String, Boolean> entry: aktiverSpieler.getZustaendeTabelle().entrySet()){
					if(entry.getKey().equalsIgnoreCase("hatSabotiert")){
						entry.setValue(true);
					}
				}
				
				parameters[0] =sabotage.vergiften(_gegner);
				
				return parameters;// 14 bei erfolg 13 bei misserfolg
			}
			parameters[0]=3;
			return parameters;
			
		}
		parameters[0]=4;
		return parameters;
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



	public void setSabotage(Sabotage _sabotage) {
		sabotage = _sabotage;
	}
	
	

}
