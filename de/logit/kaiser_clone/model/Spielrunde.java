/**
 * 
 */
package de.logit.kaiser_clone.model;


import de.logit.kaiser_clone.view.SpielRundenView;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;


/**
 * @author nepo aka. André Hauser
 *
 */
public class Spielrunde 
{
	private Spieler aktiverspieler;	 
	private String nachrichtAnSpieler="";

	public Spielrunde(Spieler _aktiverSpieler)
	{
		aktiverspieler = _aktiverSpieler;
	}

	/**
	 * @return the aktiverspieler
	 */
	public Spieler getAktiverspieler()
	{
		return this.aktiverspieler;
	}

	/**
	 * @param _aktiverspieler the aktiverspieler to set
	 */
	public void setAktiverspieler(Spieler _aktiverspieler)
	{
		this.aktiverspieler = _aktiverspieler;
	}

	public void berechneWerte()
	{
		nachrichtAnSpieler = "";
		berechneKornverfall();
		berechneProduktion(aktiverspieler.getMoral(),aktiverspieler.getGeduengteFelder());
		berechneEreignisse();
		
		int wert =berechneHunger();
		berechneSteuern();
		berechneMoral(wert);
		wachsen();
		aktiverspieler.setNachricht(aktiverspieler.getNachricht()+nachrichtAnSpieler);
		aktiverspieler.setMehl(0);
		// Der duengerverbrauch ist noch nicht implementiert
	}

	private void berechneSteuern() {
		
		int einnahmen = aktiverspieler.getBevoelkerung()*(aktiverspieler.getSteuersatz());
		aktiverspieler.setGold(aktiverspieler.getGold()+einnahmen);
		nachrichtAnSpieler += SpielRundenView.getSteuereinnahmen(einnahmen);
		
	}

	private int berechneHunger() {


		int soldaten = aktiverspieler.getSoldaten();
		int bevoelkerung = aktiverspieler.getBevoelkerung();
		int ration = aktiverspieler.getRation();
		
		int mehl = aktiverspieler.getMehl();
		
		int verbrauch1 = soldaten * 20;
		
		int verbrauch2 = bevoelkerung * ration;
		
		int wert = 0;
		
		
		
		if ( verbrauch1 > mehl )// Das Mehl reicht nicht fuer die soldaten
		{
			int verluste = soldaten;
			soldaten = (int) (soldaten * (mehl / verbrauch1));
			// Hungerkatastrophe
			verluste = verluste - soldaten;
			aktiverspieler.setSoldaten(soldaten);
			aktiverspieler.setMehl(0);//Kein mehl mehr da
			int verhungerte = (int) (bevoelkerung/2);
			aktiverspieler.setBevoelkerung(bevoelkerung-verhungerte);//Die bevoelkerung wir ebenfalls dezimiert
			nachrichtAnSpieler += SpielRundenView.getHungerKatastrophe(verluste,verhungerte);
			wert = 0;
		}
		else if ( verbrauch1 <= mehl)//Das Mehl reicht fuer die soldaten
		{
			int mehl2 = mehl - verbrauch1;
			aktiverspieler.setMehl(mehl2);//das mehl was dem spieler noch bleibt nachdem die soldaten gegessen haben.
		
			if ( verbrauch2 >  mehl2)//Das mehl reicht nicht fuer die einwohner
			{
				//Hungersnot
				int verhungerte = (int)(bevoelkerung/2);
				aktiverspieler.setBevoelkerung(bevoelkerung-verhungerte);
				aktiverspieler.setMehl(0);
				wert =  50;
				nachrichtAnSpieler += SpielRundenView.getHungersnot(verhungerte);
			}
			else if ( verbrauch2 <= mehl2)//Das mehl reicht fuer die einwohner
			{
				aktiverspieler.setMehl(mehl2-verbrauch2);
				wert =  100;
				nachrichtAnSpieler += SpielRundenView.getGenugNahrung();
			}
		}
		return wert;
		
	}

	private void berechneMoral(int _wert) {

		// _wert ist der Rückgabewert der HungerMethode entweder 0,50 oder 100
		// Wenn es nix zu essen gab soll auch die moral runter gehen!
		int moral = aktiverspieler.getMoral();
		int steuer = aktiverspieler.getSteuersatz();
		
		moral = 100 - steuer * (_wert/100);
		
		if (moral < 0)
		{
			moral=0;
		}
		else if (moral > 100)
		{
			moral = 100;
		}
		aktiverspieler.setMoral(moral);
		
		nachrichtAnSpieler += SpielRundenView.getNeueMoral(moral);
	}

	private void berechneEreignisse() 
	{			
		
			int param=((int) (Math.random()*5+1));
			int menge=0;
			
			if (param == 1 ) //Ereigniss ist gutErnte - erhöht Kornbestand
				
			{
				//Das Ereigniss erhöht die Produktion zusätzlich zur normalen Produktion 
				//um den Ertrag einer optimalen Produktion(in diesem Fall wir die berechneProduktion Methode ein 2. mal aufgerufen)
				berechneProduktion(100,aktiverspieler.getKornfelder());//100 % Moral und alle Felder gedüngt
				nachrichtAnSpieler += SpielRundenView.getGuteErnte();
				
			}
			
			else if  (param == 2 ) //Ereigniss ist mauesePlage - verringert Kornbestand
			{
				menge = ((int) aktiverspieler.getKorn() /2);//Der Spieler verliert 50% seines Kornbestandes
				aktiverspieler.setKorn(menge);
				nachrichtAnSpieler += SpielRundenView.getsMaeusePlage(menge);
				
			}
			
			else if (param == 3 )//Ereigniss ist Pest - verringert Bevölkerung
			{
				menge = ((int) (aktiverspieler.getBevoelkerung()*75/100));//Der Spieler verliert 25% seine Bevölkerung
				aktiverspieler.setBevoelkerung(menge);
				nachrichtAnSpieler += SpielRundenView.getPest(menge);
				
			}
			else 
			//kein Ereigniss eingetreten.
			{
				nachrichtAnSpieler += SpielRundenView.getKeinEreigniss();
			
			}
	}
		
		
	

	private int berechneProduktion(int _moral, int _geduengteFelder) 
	{
		if (_moral == 0)
		{
			_moral =1;
		}
		int kornfelder = aktiverspieler.getKornfelder();
		int korn = (kornfelder*_moral*_geduengteFelder)+(kornfelder*50);
		aktiverspieler.setKorn(aktiverspieler.getKorn()+korn);
		
		nachrichtAnSpieler += SpielRundenView.getKornProduktion(korn);
		return korn;
	}

	private void berechneKornverfall() 
	{
		int[] bestaende = aktiverspieler.getKornBestaende();
		
		int z1 =(int) (Math.random()*99+90);// korn im kornspeicher
		int z2 =(int) (Math.random()*80+50);// korn ausserhalb gelagert
		
		int neuerBestand = (int)(bestaende[0]*(z1/100)+bestaende[1]*(z2/100));
		
		nachrichtAnSpieler += SpielRundenView.getKornVerfault(bestaende[0]+bestaende[1]-neuerBestand);
		
		aktiverspieler.setKorn(neuerBestand);
		
		
		
	}
	
	private void wachsen()
	{
		int wachstum = (int) (aktiverspieler.getMoral()/100);
		int wachsen = aktiverspieler.getBevoelkerung()*wachstum;
		
		nachrichtAnSpieler += SpielRundenView.getWachstum(wachsen);
// Wenn bevölkerung 0 ist kann sie nicht mehr wachsen .. muss noch ausbalanciert werden		
		aktiverspieler.setBevoelkerung(aktiverspieler.getBevoelkerung()+wachsen);
	}
	
	public void setzeDieGrundwerteDerSpielerZustandsTabelle(LinkedList<Spieler> _spielerListe)
	{	
		for(Spieler _spieler : _spielerListe)
		{
			Map<String, Boolean> zustaendeTabelle = new TreeMap<>();
			zustaendeTabelle.put("KornHandel", false);
			zustaendeTabelle.put("MehlHandel", false);
			zustaendeTabelle.put("DüngerGekauft", false);
			zustaendeTabelle.put("GebäudeGekauft", false);
			zustaendeTabelle.put("FeldGekauft", false);
			zustaendeTabelle.put("TitelGekauft", false);
			zustaendeTabelle.put("SoldatenGekauft", false);
			zustaendeTabelle.put("hatSabotiert", false);
			_spieler.setZustaendeTabelle(zustaendeTabelle);
		}
	}
	
	
}
