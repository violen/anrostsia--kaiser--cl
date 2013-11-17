/**
 * 
 */
package de.logit.kaiser_clone.model;

import java.util.LinkedList;

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
	private ChatServer chatServer;
	private ChatClient chatClient;
	
	
	public Spiel()
	{
		
	}
	
	public void fuegeSpielerHinzu(Spieler _spieler)
	{
		spieler.add(_spieler);
	}
	
	public Spieler neueRunde()
	{
		Spielrunde spielrunde = new Spielrunde(spieler.getFirst());
		
		return spielrunde.getAktiverspieler();
	}
	
	public void anlegenMenues()
	{
		
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
	

}
