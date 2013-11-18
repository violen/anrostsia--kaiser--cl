/**
 * 
 */
package de.logit.kaiser_clone.model;


import de.logit.kaiser_clone.view.AusgabeView;
import de.logit.kaiser_clone.view.SpielRundenView;

import java.util.Hashtable;


/**
 * @author nepo aka. André Hauser
 *
 */
public class Spielrunde 
{
	private Spieler aktiverspieler;
	
	/*
	 * Zustände ob ein Spieler in eine bestimmte Aktion gemacht hat.
	 */
	 //boolean[] zustaende = { true };
	 private Hashtable<String, Boolean> zustaendeTabelle = new Hashtable<>();

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
		berechneKornverfall();
		berechneProduktion(aktiverspieler.getMoral(),aktiverspieler.getGeduengteFelder());
		berechneEreignisse();
		berechneMoral();
		berechneHunger();
		
	}

	private void berechneHunger() {


		int soldaten = aktiverspieler.getSoldaten();
		int bevoelkerung = aktiverspieler.getBevoelkerung();
		int ration = aktiverspieler.getRation();
		
		int mehl = aktiverspieler.getMehl();
		
		int verbrauch1 = soldaten * 2;
		
		int verbrauch2 = bevoelkerung * ration;
		
		if ( verbrauch1 > mehl )
		{
			soldaten = (int) (soldaten * (mehl / (soldaten * 2)));
			//Ausgabe
			aktiverspieler.setSoldaten(soldaten);
			aktiverspieler.setMehl(0);
		}
		else if ( verbrauch1 <= mehl)
		{
			int mehl2 = mehl - verbrauch1;
			aktiverspieler.setMehl(mehl-mehl2);
		
			if ( verbrauch2 >  mehl2)
			{
				//Hungersnot
				aktiverspieler.setBevoelkerung((int)(bevoelkerung/2));
			}
		}
		
	}

	private void berechneMoral() 
	{
		
		// TODO Auto-generated method stub
		
	}

	private String berechneEreignisse() 
	{
//		String guteErnte= "1";
//		int maeusePlage=2;
//		int pest=2;
		
		
		
		
		while(true)
		{
			int menge=((int) (Math.random()+(1+5)));
			
			if (menge == 1 ) //Ereigniss ist gutErnte - erhöht Kornbestand
				
			{
				//Das Ereigniss erhöht die Produktion zusätzlich zur normalen Produktion um den Ertrag einer optimalen Produktion
				berechneProduktion(100,aktiverspieler.getKornfelder());//100 % Moral und alle Felder gedüngt
				return SpielRundenView.getGuteErnte(menge);
			}
			
			else if  (menge == 2 ) //Ereigniss ist mauesePlage - verringert Kornbestand
			{
				menge = ((int) aktiverspieler.getKorn() /2);//Der Speiler verliert 50% seines Kornbestandes
				aktiverspieler.setKorn(menge);
				return SpielRundenView.getsMaeusePlage(menge);
			}
			
			else if (menge == 3 )//Ereigniss ist Pest - verringert Bevölkerung
			{
				menge = ((int) aktiverspieler.getBevoelkerung()/100*75);//Der Spieler verliert 50% seines Kornbestandes
				aktiverspieler.setKorn(menge);
				return SpielRundenView.getPest(menge);
			}
			else if ( menge > 3) //kein Ereigniss eingetreten.
			{
				return SpielRundenView.getKeinEreigniss();
			}
		}
		
		
		
		
		
		
		
	}

	private void berechneProduktion(int _i, int _i2) 
	{
		// TODO Auto-generated method stub
		
	}

	private void berechneKornverfall() 
	{
		// TODO Auto-generated method stub
		
	}
	
	public void setzeDieGrundwerteDerTabelle(){
		this.zustaendeTabelle.put("KornHandel", false);
		this.zustaendeTabelle.put("MehlHandel", false);
		this.zustaendeTabelle.put("DüngerGekauft", false);
		this.zustaendeTabelle.put("GebäudeGekauft", false);
		this.zustaendeTabelle.put("FeldGekauft", false);
		this.zustaendeTabelle.put("TitelGekauft", false);
		this.zustaendeTabelle.put("SoldatenGekauft", false);
		this.zustaendeTabelle.put("hatSabotiert", false);
	}
	
	
}
