/**
 * 
 */
package de.logit.kaiser_clone.model;

import java.util.Map;

/**
 * @author nepo aka. André Hauser
 * 
 */
public class Markt
{

	private final int BESTAND = 20000;
	private final int ERHOEHUNG = 500;

	private int bestandKorn = BESTAND;
	private int bestandMehl = BESTAND;

	private static Markt instance;

	private int feldEK = 50;
	private int kornspeicherEK = 100;
	private int kornfeldEK = 30;
	private int muehleEK = 120;
	private int soldatEK = 40;
	private int kornEK = 1;
	private int duengerEK = 1;
	private int mehlEK = 2;

	private Markt()
	{

	}

	// Singleton -- Wir brauchen nur EINEN Markt
	public static Markt getInstance()
	{
		if (instance == null)
		{
			instance = new Markt();
		}
		return instance;
	}

	public void erhoeheBestaende()
	{
		this.bestandKorn += ERHOEHUNG;
		this.bestandMehl += ERHOEHUNG;
	}

	public boolean kaufeTitel(Spieler _aktiverSpieler)
	{
		Titel aktuellerTitel = _aktiverSpieler.getTitel();
		Titel titel = null;
		
		switch (aktuellerTitel) {
		case BAUER:
			
			titel = Titel.RITTER;
			if(_aktiverSpieler.getGold() >= 3000 && _aktiverSpieler.getFelder().size() >= 12){
				_aktiverSpieler.setTitel(titel);
				_aktiverSpieler.setGold(_aktiverSpieler.getGold() - 3000);
			}
			
			break;
			
		case RITTER:
			
			titel = Titel.BARON;
			if(_aktiverSpieler.getGold() >= 4500 && _aktiverSpieler.getFelder().size() >= 18){
				_aktiverSpieler.setTitel(titel);
				_aktiverSpieler.setGold(_aktiverSpieler.getGold() - 4500);
			}
			
			break;
			
		case BARON:
			titel = Titel.GRAF;
			if(_aktiverSpieler.getGold() >= 7500 && _aktiverSpieler.getFelder().size() >= 32){
				_aktiverSpieler.setTitel(titel);
				_aktiverSpieler.setGold(_aktiverSpieler.getGold() - 7500);
			}
			
			break;
			
		case FÜRST:
			titel = Titel.HERZOG;
			if(_aktiverSpieler.getGold() >= 12500 && _aktiverSpieler.getFelder().size() >= 60){
				_aktiverSpieler.setTitel(titel);
				_aktiverSpieler.setGold(_aktiverSpieler.getGold() - 12500);
			}
			break;
			
		case HERZOG:
			titel = Titel.KÖNIG;
			if(_aktiverSpieler.getGold() >= 20500 && _aktiverSpieler.getFelder().size() >= 90){
				_aktiverSpieler.setTitel(titel);
				_aktiverSpieler.setGold(_aktiverSpieler.getGold() - 20500);
			}
			break;
			
		case GRAF:
			titel = Titel.FÜRST;
			if(_aktiverSpieler.getGold() >= 9000 && _aktiverSpieler.getFelder().size() >= 45){
				_aktiverSpieler.setTitel(titel);
				_aktiverSpieler.setGold(_aktiverSpieler.getGold() - 9000);
			}
			break;
			
		default:
			break;
		}
		if(_aktiverSpieler.getTitel().equals(titel)){
			for(Map.Entry<String, Boolean> entry: _aktiverSpieler.getZustaendeTabelle().entrySet()){
				if(entry.getKey().equalsIgnoreCase("TitelGekauft")){
					entry.setValue(true);
				}
			}
			return true;
		}
		return false;
	}

	public int[] kaufeFeld(int _anzahlHolen, Spieler aktiverSpieler)
	{
		int[] parameters = new int[2];
		int i = 0;
		for (i = 0; i < _anzahlHolen; i++)
		{
			if (aktiverSpieler.getGold() >= feldEK)
			{
				aktiverSpieler.fuegeFeldHinzu(new Feld());
				aktiverSpieler.setGold(aktiverSpieler.getGold() - feldEK);
				aktiverSpieler.setFreieFelder(aktiverSpieler.getFreieFelder() + 1);

			} else if (aktiverSpieler.getGold() < feldEK)
			{
				parameters[0] = 10;// wenn zu wenig Gold, wird Fehlermeldung
									// ausgegeben
				parameters[1] = i; // Anzahl gekaufte Felder
				return parameters;
			}
		}
		parameters[0] = 11;// wenn Gold genug, wird erfolgsmeldung ausgegeben
		parameters[1] = i;// Anzahl gekaufte Felder
		return parameters;

	}

	public int[] kaufeKornspeicher(int _anzahlHolen, Spieler _aktiverSpieler)
	{
		int[] parameters = new int[2];
		int i = 0;
		
		for(i = 0; i< _anzahlHolen; i++)
		{
			if(_aktiverSpieler.getFreieFelder() > 0 ) 
			{
				if(_aktiverSpieler.getGold() >= kornspeicherEK)	
				{
					_aktiverSpieler.fuegeGebaeudeHinzu(new Kornspeicher());
					_aktiverSpieler.setGold(_aktiverSpieler.getGold() - kornspeicherEK);
				}
				else if (_aktiverSpieler.getGold() < kornspeicherEK)
				{
					parameters[0]=8;//Gold reicht nicht aus
					parameters[1]=i;//Anzahl gekaufte kornspeicher
					return parameters;
				}
				
			}
			else if(_aktiverSpieler.getFreieFelder() < 1)
			{
				parameters[0]=9;//kein freies Feld mehr
				parameters[1]=i;//Anzahl gekaufte kornspeicher
				return parameters;
			}
			
		}
		parameters[0]=7;//Transaktion Erfolgreich
		parameters[1]=i;//Anzahl gekaufte kornspeicher
		return parameters;
		
		
		

		
	}

	public int[] kaufeSoldaten(int _anzahlHolen, Spieler _aktiverSpieler) {
		
		int[] parameters = new int[2];
		
		if (_aktiverSpieler.getGold() >= _anzahlHolen*soldatEK)
		{
			_aktiverSpieler.setSoldaten(_aktiverSpieler.getSoldaten()+_anzahlHolen);
			_aktiverSpieler.setGold(_aktiverSpieler.getGold()-(_anzahlHolen*soldatEK));
			parameters[0]=1;
			
		}
		else if(_aktiverSpieler.getGold() < _anzahlHolen*soldatEK)
		{
			parameters[0]=2;
		}
		return parameters;
	}

	public int[] kaufeKorn(int _anzahlHolen, Spieler _aktiverSpieler) {
		int[] parameters = new int[2];
		
		if (bestandKorn >= _anzahlHolen)
		{
		
			if (_aktiverSpieler.getGold() >= _anzahlHolen*kornEK)
			{
				_aktiverSpieler.setKorn(_aktiverSpieler.getKorn()+_anzahlHolen);
				_aktiverSpieler.setGold(_aktiverSpieler.getGold()-(_anzahlHolen*kornEK));
				parameters[0]=1;// Transaktion durchgefuehrt
				kornEK+= (kornEK/2)+_anzahlHolen;
				for(Map.Entry<String, Boolean> entry: _aktiverSpieler.getZustaendeTabelle().entrySet()){
					if(entry.getKey().equalsIgnoreCase("KornHandel")){
						entry.setValue(true);
					}
				}
			}
			else if(_aktiverSpieler.getGold() < _anzahlHolen*kornEK)
			{
				parameters[0]=2;//Zu wenig Gold
			}
			
		}
		else if(bestandKorn < _anzahlHolen)
		{
			parameters[0]=3;//Menge nicht verfuegbar
		}
		return parameters;
		
	}

	public int[] kaufeMehl(int _anzahlHolen, Spieler _aktiverSpieler) {
		int[] parameters = new int[2];
		
		if (bestandMehl >= _anzahlHolen)
		{
		
			if (_aktiverSpieler.getGold() >= _anzahlHolen*mehlEK)
			{
				_aktiverSpieler.setMehl(_aktiverSpieler.getMehl()+_anzahlHolen);
				_aktiverSpieler.setGold(_aktiverSpieler.getGold()-(_anzahlHolen*mehlEK));
				parameters[0]=1;
				mehlEK+= (mehlEK/2)+_anzahlHolen;
				for(Map.Entry<String, Boolean> entry: _aktiverSpieler.getZustaendeTabelle().entrySet()){
					if(entry.getKey().equalsIgnoreCase("MehlHandel")){
						entry.setValue(true);
					}
				}
			}
			else if(_aktiverSpieler.getGold() < _anzahlHolen*mehlEK)
			{
				parameters[0]=2;
			}
			
		}
		else if (bestandMehl < _anzahlHolen)
		{
			parameters[0]=3;
		}
		return parameters;
	}

	public int[] kaufeKornfeld(int _anzahlHolen, Spieler _aktiverSpieler) {
		int[] parameters = new int[2];
		int i = 0;
		
		for(i = 0; i< _anzahlHolen; i++)
		{
			if(_aktiverSpieler.getFreieFelder() > 0 ) 
			{
				if(_aktiverSpieler.getGold() >= kornfeldEK)	
				{
					_aktiverSpieler.fuegeGebaeudeHinzu(new Kornfeld());
					_aktiverSpieler.setGold(_aktiverSpieler.getGold() - kornfeldEK);
				}
				else if (_aktiverSpieler.getGold() < kornfeldEK)
				{
					parameters[0]=8;//Gold reicht nicht aus
					parameters[1]=i;//Anzahl gekaufte kornfelder
					return parameters;
				}
				
			}
			else if(_aktiverSpieler.getFreieFelder() < 1)
			{
				parameters[0]=9;//kein freies Feld mehr
				parameters[1]=i;//Anzahl gekaufte kornfelder
				return parameters;
			}
			
		}
		parameters[0]=7;//Transaktion Erfolgreich
		parameters[1]=i;//Anzahl gekaufte kornfelder
		return parameters;
	}

	public int[] kaufeMuehle(int _anzahlHolen, Spieler _aktiverSpieler) {
		int[] parameters = new int[2];
		int i = 0;
		
		for(i = 0; i< _anzahlHolen; i++)
		{
			if(_aktiverSpieler.getFreieFelder() > 0 ) 
			{
				if(_aktiverSpieler.getGold() >= muehleEK)	
				{
					_aktiverSpieler.fuegeGebaeudeHinzu(new Muehle());
					_aktiverSpieler.setGold(_aktiverSpieler.getGold() - muehleEK);
				}
				else if (_aktiverSpieler.getGold() < muehleEK)
				{
					parameters[0]=8;//Gold reicht nicht aus
					parameters[1]=i;//Anzahl gekaufte muehlen
					return parameters;
				}
				
			}
			else if(_aktiverSpieler.getFreieFelder() < 1)
			{
				parameters[0]=9;//kein freies Feld mehr
				parameters[1]=i;//Anzahl gekaufte muehlen
				return parameters;
			}
			
		}
		parameters[0]=7;//Transaktion Erfolgreich
		parameters[1]=i;//Anzahl gekaufte muehlen
		return parameters;
	}

	public int[] kaufeDuenger(int _anzahlHolen, Spieler _aktiverSpieler) {
		int[] parameters = new int[2];
		
		if (_aktiverSpieler.getGold() >= _anzahlHolen*duengerEK)
		{
			_aktiverSpieler.setDuenger(_aktiverSpieler.getDuenger()+_anzahlHolen);
			_aktiverSpieler.setGold(_aktiverSpieler.getGold()-(_anzahlHolen*duengerEK));
			parameters[0]=1;
			
		}
		else if(_aktiverSpieler.getGold() < _anzahlHolen*duengerEK)
		{
			parameters[0]=2;
		}
		return parameters;
	}

	public int verkaufeKorn(int _anzahlHolen, Spieler _aktiverSpieler) {

		if(_aktiverSpieler.getKorn() >= _anzahlHolen)
		{
			_aktiverSpieler.setKorn(_aktiverSpieler.getKorn()- _anzahlHolen);
			bestandKorn += _anzahlHolen;
			kornEK-= (kornEK/2)+_anzahlHolen;
			for(Map.Entry<String, Boolean> entry: _aktiverSpieler.getZustaendeTabelle().entrySet()){
				if(entry.getKey().equalsIgnoreCase("KornHandel")){
					entry.setValue(true);
				}
			}
			return 1;
		}
		else if(_aktiverSpieler.getKorn() < _anzahlHolen)
		{
			return 2;
		}
		else return 3;
		
	}

	public int verkaufeMehl(int _anzahlHolen, Spieler _aktiverSpieler) {
		if(_aktiverSpieler.getMehl() >= _anzahlHolen)
		{
			_aktiverSpieler.setMehl(_aktiverSpieler.getMehl()- _anzahlHolen);
			bestandMehl += _anzahlHolen;
			mehlEK-= (mehlEK/2)+_anzahlHolen;
			for(Map.Entry<String, Boolean> entry: _aktiverSpieler.getZustaendeTabelle().entrySet()){
				if(entry.getKey().equalsIgnoreCase("MehlHandel")){
					entry.setValue(true);
				}
			}
			return 1;
		}
		else if(_aktiverSpieler.getMehl() < _anzahlHolen)
		{
			return 2;
		}
		else return 3;
	}
}
