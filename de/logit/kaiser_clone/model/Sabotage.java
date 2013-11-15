package de.logit.kaiser_clone.model;

public class Sabotage

{
	private int eingesetzteSoldaten;
	private int neuesGold;
	private int neuesKorn;

	public int getUnruheKosten() {
		
		return 300;
	}
	
	public int getZerstoerenKosten(){
		
		return 250;
	}
	
	public int getVergiftenKosten(){
		return 400;
	}
	
	public int getPluendernKosten(){
		return 500;
	}

	public int getSoldatenMinimum() {
		
		return 1;
	}
	
	

	public int getNeuesGold() {
		return neuesGold;
	}

	public void setNeuesGold(int _neuesGold) {
		neuesGold = _neuesGold;
	}

	public int getNeuesKorn() {
		return neuesKorn;
	}

	public void setNeuesKorn(int _neuesKorn) {
		neuesKorn = _neuesKorn;
	}

	public int getEingesetzteSoldaten() {
		return eingesetzteSoldaten;
	}

	public void setEingesetzteSoldaten(int _eingesetzteSoldaten) {
		eingesetzteSoldaten = _eingesetzteSoldaten;
	}

	public int unruhe(Spieler _gegner) {

		int erfolg =0;
		int schutz = _gegner.getSchutzFaktor();
		
		int power = ((int) (Math.random()+(1+1000)))-eingesetzteSoldaten;
		
		if ( schutz < power)
		{
			_gegner.setMoral(0);
			
			erfolg = 1;
			
		}
		
		else if (schutz >= power)
		{
			erfolg = 2;
		}
		
		return erfolg;
		
	}

	public int zerstoeren(Spieler _gegner) 
	{
		int erfolg = 0;
		
		int schutz = _gegner.getSchutzFaktor();
		int power = (int) (Math.random()+(1+1000));
		
		if ((_gegner.getKornfelder() == 0) && (_gegner.getKornspeicher()==0) && (_gegner.getMuehlen()==0))
		{
			return 9;
		}
		
		if (schutz < power)
		{
		
			while(true)
			{
				int gebaeude = (int) Math.random()+(1+3);
				
				if (gebaeude == 1)
				{
					for (Feld f : _gegner.getFelder())
					{
						if (f.getGebaeude() instanceof Kornspeicher)
						{
							f.setGebaeude(null);
							_gegner.setFreieFelder(_gegner.getFreieFelder()+1);
							_gegner.setKornspeicher(_gegner.getKornspeicher()-1);
							erfolg =5;
							return erfolg;
						}
					}
				}
				
				if (gebaeude == 2)
				{
					for (Feld f : _gegner.getFelder())
					{
						if (f.getGebaeude() instanceof Kornfeld)
						{
							f.setGebaeude(null);
							_gegner.setFreieFelder(_gegner.getFreieFelder()+1);
							_gegner.setKornfelder(_gegner.getKornfelder()-1);
							erfolg =6;
							return erfolg;
						}
					}
				}
				if (gebaeude == 3)
				{
					for (Feld f : _gegner.getFelder())
					{
						if (f.getGebaeude() instanceof Muehle)
						{
							f.setGebaeude(null);
							_gegner.setFreieFelder(_gegner.getFreieFelder()+1);
							_gegner.setMuehlen(_gegner.getMuehlen()-1);
							erfolg =7;
							return erfolg;
						}
					}
				}
			}
			
			
			
		}
		erfolg =8;
		
		return erfolg;
	}

	public int pluendern(Spieler _gegner)
	
	{
		
		int schutz = _gegner.getSchutzFaktor();
		
		int power = ((int) (Math.random()+(1+1000)))-eingesetzteSoldaten;
		
		int gut = (int) Math.random()+(1+2);
		
		if (schutz > power)
		{
			return 12;
		}
		
		while(true)
		{
			
			if (gut == 1)
			{
				 neuesGold =(int) _gegner.getGold()-(_gegner.getGold()/100*30);
				_gegner.setGold(neuesGold);
				return 10;
			}
			else if (gut == 2)
			{
				neuesKorn = (int) _gegner.getKorn()-(_gegner.getKorn()/100*50);
				_gegner.setKorn(neuesKorn);
				return 11;
			}
		}
		
		
	}

	public int vergiften(Spieler _gegner) 
	{
		int schutz = _gegner.getSchutzFaktor();
		
		int power = ((int) (Math.random()+(1+1000)))-eingesetzteSoldaten;
		
		
		if (schutz > power)
		{
			return 13;
					
		}
		neuesKorn = (int) _gegner.getKorn()-(_gegner.getKorn()/100*50);
		_gegner.setKorn(neuesKorn);
		return 14;
		
	}

}
