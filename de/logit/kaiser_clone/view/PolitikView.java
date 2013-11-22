/**
 * 
 */
package de.logit.kaiser_clone.view;

import de.logit.kaiser_clone.controller.MarktController;
import de.logit.kaiser_clone.controller.MasterController;
import de.logit.kaiser_clone.controller.PolitikController;
import de.logit.kaiser_clone.model.Politik;
import de.logit.kaiser_clone.model.Spieler;

/**
 * @author nepo aka. André Hauser
 *
 */
public class PolitikView
{
	
	public static String getSteuernMenue(int _steuern)
	{
		return "Finanzbelange können hier reguliert werden:" +  " Der aktuelle Steuersatz beträgt: " + _steuern + "% " + "\n" +
				"  " + "1: Steuern erhöhen" + "\t" + "2: Steuern senken" + "\n";
	}
	
	public static String getSteuernHoch(int _steuern)
	{
		return "Die Steuern wurden erhoeht! "  + " Der aktuelle Steuersatz beträgt: " + _steuern + "% " + " \n";
	}
	
	public static String getSteuernRunter(int _steuern)
	{
		return "Die Steuern wurden gesenkt! " +  " Der aktuelle Steuersatz beträgt: " + _steuern + "% " + "\n";
	}
	
	public static String getSteuernNormal(int _steuern)
	{
		return "Die Steuern konnten nicht verändert werden! " + " \n" + " Der aktuelle Steuersatz beträgt: " + _steuern + "% " +"\n";
	}
	
		
	public static String getNahrungsrationsMenue(int _ration)
	{
		return "Versorgung deiner Bevölkerung:" + "\n" +  " Die aktuelle Nahrungsration beträgt: " + _ration  +"\n" +
				"  " + "1: Ration erhöhen" + "\t" + "2: Ration senken" + "\n";
	}
	
	public static String getNahrungWurdeErhoeht(int _ration)
	{
		return "Die Nahrungsration wurde verdoppelt! "  + " Die aktuelle Nahrungsration beträgt: " + _ration +  " \n";
	}
	
	public static String getNahrungWurdeGesenkt(int _ration)
	{
		return "Die Nahrungsration wurde halbiert! "  + " Die aktuelle Nahrungsration beträgt: " + _ration  + " \n";
	}
	
	public static String getNahrungBleibtGleich(int _ration)
	{
		return "Die Nahrungsration konnte nicht verändert werden! "  + " Die aktuelle Nahrungsration beträgt: " + _ration +  " \n";
	}
	
	
	

}
