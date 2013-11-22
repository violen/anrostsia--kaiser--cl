/**
 * 
 */
package de.logit.kaiser_clone.model;

/**
 * @author nepo aka. André Hauser
 *
 */
public class Kornspeicher extends Gebaeude 
{
	private final int lagerKapazitaet=5000; 
	private int bestand;
	
	public Kornspeicher() 
	{
	}

	public int getLagerKapazitaet() {
		return lagerKapazitaet;
	}
	
	public int getBestand() {
		return bestand;
	}

	public void setBestand(int bestand) {
		this.bestand = bestand;
	}
	
	
	
	

}
