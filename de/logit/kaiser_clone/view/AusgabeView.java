/**
 * 
 */
package de.logit.kaiser_clone.view;

/**
 * @author nepo aka. André Hauser
 * 
 * Die Ausgabeview beinhaltet alle Ausgaben die immerwieder gebraucht werden können,
 * und nicht in eine Spezielle View müssen.
 */
public class AusgabeView 
{
	
	public static String getFrageNachAnzahl()
	{
		return "bitte eine Anzahl eingeben..." + "\n";
	}
	
	public static String getBestaetigeAbbrechen(String _aktionsName)
	{
		return "möchtest du wirklich " + _aktionsName +"?" + "\n" 
				+ "  " + "1: Bestätigen" + "\t" +"2: Abbrechen" + "\n";
	}
	
	public static String waehleServerIP(){
		return "Gib bitte den Host eines Mehrspieler spiels ein."+"\n";
	}
	
	public static String wievieleSpieler(){
		return "Wieviele Spieler nehmen teil?" + "\n";
	}
	
	public static String verbindeMitServer(){
		return "Du bist nun mit dem Server verbunden." +"\n";
	}
	
	public static String warteAufSpieler(){
		return "Bitte habe etwas Geduld es wird auf Mitspieler gewartet." + "\n";
	}
	
	public static String gibEinenNamenEin(){
		return "Bitte geb einen namen ein." + "\n";
	}
	
	public static String verlierenDerServerVerbindungBeimClient(){
		return "Server verbindung verloren."+"\n";
	}

}
