/**
 * 
 */
package de.logit.kaiser_clone.view;

/**
 * @author nepo aka. André Hauser
 *
 */
public class HauptmenueView 
{
	
	public static String getHauptmenue()
	{
		return "Du befindest dich im Hauptmenü. Du kannst nun Folgendes tun... "+"\n" +
				"  "+"1: Zum Marktplatz"+"\t"+"2: Sabotiere jemanden"+"\t"+"3: Das Spielmenü zeigen"+"\n"+
				"  "+"4: Zur Mühle"+"\t\t"+"5: Politik"+"\t\t"+"6: Spielstatistik anzeigen"+"\n"+
				"  "+"7: Spielzug beenden" + "\n";
	}
	
	public static String getMarktMenue(){
		return "Du befindest dich auf dem Marktplatz. " +
				"Hier kannst du Kaufen und Verkaufen! \n" +
				"  "+"1: Kaufen "+"\t"+"2: Verkaufen"+"\n";
	}
	
	public static String getSabotierenMenue()
	{
		return "Du befindest dich nun in der Kaserne. " +
				"Hier kannst du deine Soldaten befehligen!\n" +
				"  "+"1: Rauben"+"\t"+"2: Zerstören"+"\n"+
				"  "+"3: Vergiften"+"\t"+"4: Unruhe"+"\n";
	}
	
	public static String getPolitikMenue()
	{
		return "Du befindest dich im Parlament. "+"\n" +
				"Hier können die belange des Volkes und des Staates reguliert werden." +"\n"+
				"  "+ "1: Steuern"+"\t"+"2: Nahrungsrationen"+"\n";
	}
	
	
	public static String getProduzierenMenue()
	{
		return "Du befindest dich in der Mühle. " +
				"Hier kannst du Mehl zur Versorgung mahlen." + "\n";
		
	}
	

}
