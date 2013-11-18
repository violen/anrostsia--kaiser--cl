package de.logit.kaiser_clone.model;

public class Startmenue
{

	public Startmenue()
	{
	}

	public static Spiel neueSpielStarten()
	{
		Spiel spiel = new Spiel();
		return spiel;
	}

	public static  void beendeSpiel()
	{
		System.exit(0);
	}
}
