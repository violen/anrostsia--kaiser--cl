/**
 * 
 */
package de.logit.kaiser_clone.model;

/**
 * @author nepo aka. André Hauser
 *
 */
public class Spielrunde 
{
	private Spieler aktiverspieler;

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
		berechneProduktion();
		berechneEreignisse();
		
		int wert =berechneHunger();
		berechneSteuern();
		berechneMoral(wert);
	}

	private int berechneSteuern() {
		return 0;
		// TODO Auto-generated method stub
		
	}

	private int berechneHunger() {


		int soldaten = aktiverspieler.getSoldaten();
		int bevoelkerung = aktiverspieler.getBevoelkerung();
		int ration = aktiverspieler.getRation();
		
		int mehl = aktiverspieler.getMehl();
		
		int verbrauch1 = soldaten * 2;
		
		int verbrauch2 = bevoelkerung * ration;
		
		int wert = 0;
		
		String nachricht = "";
		
		if ( verbrauch1 > mehl )
		{
			soldaten = (int) (soldaten * (mehl / (soldaten * 2)));
			//Ausgabe Hungersnot
			aktiverspieler.setSoldaten(soldaten);
			aktiverspieler.setMehl(0);
			wert = 0;
		}
		else if ( verbrauch1 <= mehl)
		{
			int mehl2 = mehl - verbrauch1;
			aktiverspieler.setMehl(mehl2);
		
			if ( verbrauch2 >  mehl2)
			{
				//Hungersnot
				aktiverspieler.setBevoelkerung((int)(bevoelkerung/2));
				aktiverspieler.setMehl(0);
				wert =  50;
			}
			else if ( verbrauch2 >= mehl2)
			{
				aktiverspieler.setMehl(mehl2-verbrauch2);
				wert =  100;
			}
		}
		return wert;
		
	}

	private void berechneMoral(int _wert) {

		int moral = aktiverspieler.getMoral();
		int steuer = aktiverspieler.getSteuersatz();
		
		moral = moral - steuer * (_wert/100);
		
	}

	private void berechneEreignisse() {
		// TODO Auto-generated method stub
		
	}

	private void berechneProduktion() {
		// TODO Auto-generated method stub
		
	}

	private void berechneKornverfall() {
		// TODO Auto-generated method stub
		
	}
	
	
}
