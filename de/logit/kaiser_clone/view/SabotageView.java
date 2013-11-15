/**
 * 
 */
package de.logit.kaiser_clone.view;

import java.util.LinkedList;

import de.logit.kaiser_clone.model.Spieler;

/**
 * @author nepo aka. André Hauser
 *
 */
public class SabotageView {

	public static String getGegnerWaehlen(LinkedList<Spieler> _gegner) {
		
		String liste ="";
		int i=0;
		for (Spieler s : _gegner)
		{
			liste += s.getName()+ " " + i +  "\n";
			i++;
		}
		return liste;
	}

	public static String getUnruheSchuehrenErfolgreich() {
		
		return "Unruhe Schuehren erfolgreich \n";
	}

	public static String getEsWurdeUnruheGeschuehrt(String _name) {
		
		return "Es wurde Unruhe geschuehrt von Spieler " + _name + " ! \n";
	}

	public static String getUnsereUnruhestifterWurdenGefangenGenommen() {
		
		return "Unsere Unruhestifter Wurden gefangengenommen \n";
	}

	public static String getWirHabenUnruhestifterGefangenGenommen(String _name) {
		
		return "Wir haben die Unruhestifter von Spieler " + _name + " gefangengenommen ! \n";
	}

	public static String getKornspeicherZerstoert() {
		
		return "Kornspeicher zerstoert. \n";
	}

	public static String getEsWurdeEinKornspeicherZerstoert(String _name) {
		
		return "Es wurde ein Kornspeicher von " + _name + " zerstoert. \n ";
	}
	
	public static String getKornfeldZerstoert() {
		
		return "Kornfeld zerstoert. \n";
	}

	public static String getEsWurdeEinKornfeldZerstoert(String _name) {
		
		return "Es wurde ein Kornfeld von " + _name + " zerstoert. \n ";
	}
	
	public static String getMuehleZerstoert() {
		
		return "Muehle zerstoert. \n";
	}

	public static String getEsWurdeEineMuehleZerstoert(String _name) {
		
		return "Es wurde eine Muehle von " + _name + " zerstoert. \n ";
	}

	public static String getZerstoerenFehlgeschlagen() {
		
		return "Zerstoeren fehlgeschlagen. \n ";
	}

	public static String getGegnerHatKeineGebaeude() {
		
		return "Gegner hat keine Gebaeude. \n";
	}

	public static String getWirHabenEineZerstoererCrewGefangenGenommen(
			String _name) {
		
		return "Wir haben eine ZerstoererCrew des Spielers " + _name + " gefangengenommen. \n";
	}

}
