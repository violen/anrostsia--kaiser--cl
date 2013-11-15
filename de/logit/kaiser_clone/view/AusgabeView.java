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
	

}
