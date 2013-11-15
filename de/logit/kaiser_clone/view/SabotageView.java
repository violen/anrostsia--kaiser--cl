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

}
