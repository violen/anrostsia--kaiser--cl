/**
 * 
 */
package de.logit.kaiser_clone.view;

/**
 * @author nepo aka. André Hauser
 *
 */
public class StartmenueView 
{
	
	public static String getStartmenue()
	{

		return "Du befindest dich im Startmenü von \"Anrostsias Kaiser\"." +"\n"+
				"Möchtest du ein Neues Spiel beginnen oder die Anwendung beenden?"+"\n" +
				"  " + "1: Neues Spiel beginnen." + "\t"+"2: Das Spiel beenden."+"\n";
	}
	
	public static String getSpielBeenden()
	{
		return "Das Spiel wurde beendet!";
	}
	

}
