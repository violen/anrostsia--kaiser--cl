package de.logit.kaiser_clone.view;

public class MarktView
{
	
	public static String getMarktKaufOptionen()
	{
		
		return "Was möchtest du kaufen?" + "\n" +
				"  " + "1: Titel" + "\t" + "2: Land" + "   " + "3: Kornspeicher" + "\n" +
				"  " + "4: Soldaten" + "\t" + "5: Korn" + "   " + "6: Mehl" +"\n" + 
				"  " + "7: Kornfeld" + "\t" + "8: Mühle" + "  " + "9: Dünger" + "\n";
	}
	
	public static String getMarktKaufVonKorn()
	{
		return "Wieviel Korn soll es sein?" + "\n";
	}
	
	public static String getMarktKaufVonMehl()
	{
		return "Wieviel Mehl soll es sein?"+"\n";
	}
	
	public static String getMarktKaufVonSoldaten()
	{
		return "Wieviele Einheiten sollen es sein?"+ "\n";
	}
	
	public static String getMarktKaufVonDuenger()
	{
		return "Wieviel Mist wird benötigt?"+"\n";
	}
	
	public static String getMarktKaufVonFeld()
	{
		return "Wieviele Ländereien werden eingenommen?"+"\n";
	}
	
	public static String getMarktKaufVonTitel()
	{
		return "Du möchtest also aufsteigen?" + "\n";
	}
	
	public static String getMarktVerkaufVonMehl()
	{
		return "Wieviel Mehl soll verkauft werden?" + "\n";
	}
	
	public static String getMarktVerkaufVonKorn()
	{
		return "Wieviel Korn soll verkauft werden?" + "\n";
	}
	
	public static String getMarktKaufVonGebaeude(int _anzahl)
	{
		return "Wieviele sollen errichtet werden?" + "\n";
	}
	
	public static String getTitelKaufErfolgreich(String _string)
	{
		return "Du erhälst den Titel: " + _string + "\n";
	}

	public static String getMarktVerkaufOptionen()
	{
		
		return "Was möchtest du verkaufen?" + "\n" +
				"  " + "1: Korn" + "\t" + "2: Mehl" + "\n";
	}

	public static String getTitelAuswahl()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public static String getMarktKaufVonFeld(int _i)
	{
		return "Es wurden " + _i + " Felder eingenommen." + "\n";
		
	}

	public static String getKaufErfolgreich()
	{
		return "Kauf erfolgreich";
	}







}
