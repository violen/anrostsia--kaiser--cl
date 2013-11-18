package de.logit.kaiser_clone.model;

import de.logit.kaiser_clone.controller.MasterController;

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

	public static void neuesSpiel(MasterController _masterController){
		_masterController.spielStarten();
	}
	
	public static  void beendeSpiel()
	{
		System.exit(0);
	}
}
