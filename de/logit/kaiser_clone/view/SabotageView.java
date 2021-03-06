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
		
		String liste ="Bitte Einen Gegner wählen. \n ";
		int i=0;
		for (Spieler s : _gegner)
		{
			liste += s.getName()+ " = " + i +  "\n";
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

	public static String getPluendernFehlgeschlagen() {
		
		return "Pluendern fehlgeschlagen. \n";
	}

	public static String getWirHabenEinePluendererCrewGefangenGenommen(
			String _name) {
		
		return "Wir haben eine Pluenderercrew von Spieler " + _name + " gefangengenommen. \n ";
	}

	public static String getGoldGepluendert(int _neuesGold) {
		
		return "Sie haben " + _neuesGold + " Gold gepluendert. \n";
	}

	public static String getEsWurdeGoldGepluendert(String _name,int _menge) {
	
		return "Es wurde " + _menge + " Gold von Spieler " + _name + " gepluendert. \n";
	}

	public static String getKornGepluendert(int _neuesKorn) {
		
		return "Sie haben " + _neuesKorn + " Korn gepluendert. \n";
	}

	public static String getEsWurdeKornGepluendert(String _name,int _menge) {
		
		return "Es wurde " + _menge + " Korn von Spieler " + _name + " gepluendert. \n";
	}

	public static String getWirHabenEineVergifterCrewGefangenGenommen(
			String _name) {
		
		return "Wir haben eine Vergiftercrew von Spieler " + _name + " gefangengenommen. \n ";
	}

	public static String getVergiftenFehlgeschlagen() {
		
		return "Vergiften fehlgeschlagen.  \n"  ;
	}

	public static String getKornVergiftet(int _neuesKorn) {
	
		return "Es wurde " + _neuesKorn + " Vetgiftet. \n ";
	}

	public static String getEsWurdeKornVergiftet(String _name, int _neuesKorn) {
	
		return "Es wurde " + _neuesKorn + " von Spieler " + _name + " Vetgiftet. \n ";
	}

}
