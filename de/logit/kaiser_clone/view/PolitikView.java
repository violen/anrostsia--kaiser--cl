/**
 * 
 */
package de.logit.kaiser_clone.view;

/**
 * @author nepo aka. André Hauser
 *
 */
public class PolitikView
{
	
	public static String getSteuernMenue()
	{
		return "Finanzbelange können hier reguliert werden:" + "\n" +
				"  " + "1: Steuern erhöhen" + "\t" + "2: Steuern senken" + "\n";
	}
	
	public static String getSteuernHoch()
	{
		return "Die Steuern wurden erhoeht! " + " \n";
	}
	
	public static String getSteuernRunter()
	{
		return "Die Steuern wurden gesenkt! " + " \n";
	}
	
	public static String getSteuernNormal()
	{
		return "Die Steuern konnten nicht verändert werden! " + " \n";
	}
	
		
	public static String getNahrungsrationsMenue()
	{
		return "Versorgung deiner Bevölkerung:" + "\n" +
				"  " + "1: Ration erhöhen" + "\t" + "2: Ration senken" + "\n";
	}
	
	public static String getNahrungWurdeErhoeht()
	{
		return "Die Nahrungsration wurde verdoppelt! "  + " \n";
	}
	
	public static String getNahrungWurdeGesenkt()
	{
		return "Die Nahrungsration wurde halbiert! "  + " \n";
	}
	
	public static String getNahrungBleibtGleich()
	{
		return "Die Nahrungsration konnte nicht verandert werden! "  + " \n";
	}
	
	
	

}
