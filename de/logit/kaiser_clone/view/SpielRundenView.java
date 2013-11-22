package de.logit.kaiser_clone.view;

public class SpielRundenView


{

	public static String getGuteErnte()
	{
		return "Glückwunsch ! Sie hatten eine gute Ernte und konnten einmal zusätzlich produzieren. \n" ;
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

	public static String getKornVerfault(int _menge) {
		
		return "Es ist " + _menge + " Korn verfault. \n";
	}

	public static String getKornProduktion(int _menge) {
		
		return "Es wurde " + _menge + " Korn produziert. \n";
	}

	public static String getNeueMoral(int _moral) {
		
		return "Die neue Moral beträgt " + _moral + " . \n";
	}

	public static String getHungersnot() {
		
		return "Es gab eine Hungersnot die hälfte Deiner Einwohner sind verhungert. \n";
	}

	public static String getHungerKatastrophe() {
		
		return "Hungerkatastrophe die keine Rationen hatten Soldaten und 50% der Einwohner sind verhungert. \n";
	}

	public static String getGenugNahrung() {
		
		return "Gute Arbeit es sind keine Einwohner verhungert. \n";
	}

	public static String getSteuereinnahmen(int _einnahmen) {
		
		return "Sir wir haben " + _einnahmen + " Gold an Steuern kassiert. \n";
	}

	public static String getWachstum(int _wachsen) {
	
		return "Sir es sind " + _wachsen + " Menschen zugewandert. \n";
	}
	
	
}
