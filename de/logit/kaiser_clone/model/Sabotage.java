package de.logit.kaiser_clone.model;

public class Sabotage
{

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

	public int unruhe(Spieler _gegner) {

		int erfolg =0;
		int schutz = _gegner.getSchutzFaktor();
		
		int power = (int) (Math.random()+(1+1000));
		
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

}
