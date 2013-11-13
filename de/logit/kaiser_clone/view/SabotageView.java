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

}
