/**
 * 
 */
package de.logit.kaiser_clone.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import de.logit.kaiser_clone.controller.SpielController;
import de.logit.kaiser_clone.network.ChatClient;
import de.logit.kaiser_clone.network.ChatServer;

/**
 * @author nepo aka. André Hauser
 *
 */
public class Spiel 
{
	private LinkedList<Spieler> spieler = new LinkedList<Spieler>();
	private Startmenue startmenue;
	private Hauptmenue hauptmenue;
	private Spielrunde spielrunde;	
	
	public Spiel()
	{
		
	}
	
	public void fuegeSpielerHinzu(Spieler _spieler)
	{
		spieler.add(_spieler);
	}
	
	public Spieler neueRunde()
	{
		this.spielrunde = new Spielrunde(spieler.getFirst());
		
		return this.spielrunde.getAktiverspieler();
	}
	
	public void anlegenMenues()
	{
		this.setStartmenue(new Startmenue());
		this.setHauptmenue(new Hauptmenue());
	}

	/**
	 * @return the spielrunde
	 */
	public Spielrunde getSpielrunde()
	{
		return this.spielrunde;
	}

	/**
	 * @param _spielrunde the spielrunde to set
	 */
	public void setSpielrunde(Spielrunde _spielrunde)
	{
		this.spielrunde = _spielrunde;
	}

	/**
	 * @return the spieler
	 */
	public LinkedList<Spieler> getSpieler()
	{
		return this.spieler;
	}
	
	public void erzeugeLandkarten(){
		for(Spieler spieler : this.spieler){
			spieler.erzeugeStartfelder();
		}
	}

	public Startmenue getStartmenue() {
		return startmenue;
	}

	public void setStartmenue(Startmenue startmenue) {
		this.startmenue = startmenue;
	}

	public Hauptmenue getHauptmenue() {
		return hauptmenue;
	}

	public void setHauptmenue(Hauptmenue hauptmenue) {
		this.hauptmenue = hauptmenue;
	}
	
	public Spieler getNextSpieler(Spieler _spieler, LinkedList<Spieler> _spielerListe)
	{
		Spieler neuerAktiverSpieler = null;
		try {
			neuerAktiverSpieler = _spielerListe.get(_spielerListe.indexOf(_spieler)+1);
		} catch (IndexOutOfBoundsException e) {
			if(_spieler == _spielerListe.getLast()){
				neuerAktiverSpieler = _spielerListe.getFirst();
			}
		}
		return neuerAktiverSpieler;
	}

}
