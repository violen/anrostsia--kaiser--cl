/**
 * 
 */
package de.logit.kaiser_clone.view;

/**
 * @author nepo aka. André Hauser
 *
 */
public class PolitikView {
	
	public static String getSteuernMenue()
	{
		return "Finanzbelange können hier reguliert werden:" + "\n" +
				"  " + "1: Steuern erhöhen" + "\t" + "2: Steuern senken" + "\n";
	}
	
	public static String getNahrungsrationsMenue()
	{
		return "Versorgung deiner Bevölkerung:" + "\n" +
				"  " + "1: Ration erhöhen" + "\t" + "2: Ration senken" + "\n";
	}

}
