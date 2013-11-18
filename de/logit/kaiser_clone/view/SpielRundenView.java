package de.logit.kaiser_clone.view;

public class SpielRundenView


{

	public static String getGuteErnte(int _menge)
	{
		return "Glückwunsch ! Sie hatten eine gute Ernte und konnten zusätzlich " + _menge + " Einheiten Korn erntent. \n" ;
	}
	
	public static String getsMaeusePlage(int _menge)
	{
		return "Ohhh Schade ! Sie hat die Mäuseplage erwischt. Sie haben " + _menge + " Einheiten Korn verloren. \n" ;
	}
	
	public static String getPest(int _menge)
	{
		return "Herzliches Beileid! Die Pest hat " + _menge + " Opfer gefordert. \n" ;
	}
	
	public static String getKeinEreigniss()
	{
		return "Dieses war ein ruhiges Jahr! Keine besonderen Vorkommnisse. \n";
	}
}
