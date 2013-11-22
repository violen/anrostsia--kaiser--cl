package de.logit.kaiser_clone.view;

public class ChattenView
{

	public static String getEmpfaengerWahl(String _parameter)
	{
		return _parameter;
	}
	
	public static String getGebeGewaehltenEmpfaengerAus(String _parameter)
	{
		return "\n" + "Auswertung: Du hast Spieler " + _parameter + " gewählt.";
	}

	public static String getEmpfaengerNichtInDerListe()
	{
		return "\n" + "Der gewählte Spieler befindet sich nicht in der Liste." + "\n";
		
	}

	public static String getNachrichtAnEmpfaengerEingeben(String _parameter)
	{
		return "\n" + "Bitte gibt die Nachricht an Spieler: " + _parameter + " ein und drücke die Entertaste"+ "\n \n \n";
		
	}

	public static String getGesendeteNachricht(String _parameter)
	{
		
		return " \n" + " Du hast die folgende Nachricht geschickt: " + "\n" +  _parameter + "\n";
	}
	
	
}
