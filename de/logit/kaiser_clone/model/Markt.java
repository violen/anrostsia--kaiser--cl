/**
 * 
 */
package de.logit.kaiser_clone.model;

/**
 * @author nepo aka. André Hauser
 * 
 */
public class Markt
{

	private final int BESTAND = 20000;
	private final int ERHOEHUNG = 500;

	private int bestandKorn = BESTAND;
	private int bestandMehl = BESTAND;

	private static Markt instance;

	private int feldEK = 50;
	private int kornspeicherEK = 100;

	private Markt()
	{

	}

	// Singleton -- Wir brauchen nur EINEN Markt
	public static Markt getInstance()
	{
		if (instance == null)
		{
			instance = new Markt();
		}
		return instance;
	}

	private void erhoeheBestaende()
	{
		this.bestandKorn += ERHOEHUNG;
		this.bestandMehl += ERHOEHUNG;
	}

	public String kaufeTitel(Titel _titel)
	{
		// TODO
		return null;
	}

	public int[] kaufeFeld(int _anzahlHolen, Spieler aktiverSpieler)
	{
		int[] parameters = new int[2];
		int i = 0;
		for (i = 0; i < _anzahlHolen; i++)
		{
			if (aktiverSpieler.getGold() >= feldEK)
			{
				aktiverSpieler.fuegeFeldHinzu(new Feld());
				aktiverSpieler.setGold(aktiverSpieler.getGold() - feldEK);
				aktiverSpieler.setFreieFelder(aktiverSpieler.getFreieFelder() + 1);

			} else if (aktiverSpieler.getGold() < feldEK)
			{
				parameters[0] = 10;// wenn zu wenig Gold, wird Fehlermeldung
									// ausgegeben
				parameters[1] = i; // Anzahl gekaufte Felder
				return parameters;
			}
		}
		parameters[0] = 11;// wenn Gold genug, wird erfolgsmeldung ausgegeben
		parameters[1] = i;// Anzahl gekaufte Felder
		return parameters;

	}

	public int[] kaufeKornspeicher(int _anzahlHolen, Spieler _aktiverSpieler)
	{
		int[] parameters = new int[2];
		int i = 0;
		
		for(i = 0; i< _anzahlHolen; i++)
		{
			if(_aktiverSpieler.getFreieFelder() > 0 ) 
			{
				if(_aktiverSpieler.getGold() >= kornspeicherEK)	
				{
					_aktiverSpieler.fuegeGebaeudeHinzu(new Kornspeicher());
					_aktiverSpieler.setGold(_aktiverSpieler.getGold() - kornspeicherEK);
				}
				else if (_aktiverSpieler.getGold() < kornspeicherEK)
				{
					parameters[0]=8;//Gold reicht nicht aus
					parameters[1]=i;//Anzahl gekaufte kornspeicher
					return parameters;
				}
				
			}
			else if(_aktiverSpieler.getFreieFelder() < 1)
			{
				parameters[0]=9;//kein freies Feld mehr
				parameters[1]=i;//Anzahl gekaufte kornspeicher
				return parameters;
			}
			
		}
		parameters[0]=7;//Transaktion Erfolgreich
		parameters[1]=i;//Anzahl gekaufte kornspeicher
		return parameters;
		
		
		

		
	}
}
