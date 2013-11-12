/**
 * 
 */
package de.logit.kaiser_clone.model;

import java.util.LinkedList;

/**
 * @author nepo aka. André Hauser
 *
 */

public class Spieler 
{
	private Titel titel = Titel.BAUER;
	private int korn=1000;
	private int mehl=1000;
	private int soldaten=0;
	private int duenger=0;
	private int gold=1000;
	private int bevoelkerung=20;
	private LinkedList<Feld> felder = new LinkedList<Feld>();
	private Spiel spiel;
	private int freieFelder;
	private int kornfelder;
	private int kornspeicher;
	private int muehlen;
	//Startwert der Moral ist 70 Prozent --> max 100%
	private int moral=70;

	
	public Spieler(Spiel _spiel)
	{
		spiel = _spiel;
		
	}
	
	public void erzeugeStartfelder()
	{
		for(int i = 0; i<6; i++ )
		{
			fuegeFeldHinzu(new Feld());
		}
		
		fuegeGebaeudeHinzu(new Kornfeld());
		fuegeGebaeudeHinzu(new Kornspeicher());
		fuegeGebaeudeHinzu(new Muehle());
	}
	
	public void fuegeFeldHinzu(Feld _feld)
	{
		felder.add(_feld);
	}
	
	public void fuegeGebaeudeHinzu(Gebaeude _gebaeude )
	{
		for (Feld f: felder)
		{
			if(f.getGebaeude() == null)
			{
				f.setGebaeude(_gebaeude);
				freieFelder--;
				if(_gebaeude instanceof Kornspeicher)
				{
					kornspeicher ++;
				}
				else if(_gebaeude instanceof Kornfeld)
				{
					kornfelder ++;
				}
				else if(_gebaeude instanceof Muehle)
				{
					muehlen ++;
				}
				return;
			}
			
		}
		
	}
	//Getter und Setter

	/**
	 * @return the titel
	 */
	public Titel getTitel()
	{
		return this.titel;
	}

	/**
	 * @param _titel the titel to set
	 */
	public void setTitel(Titel _titel)
	{
		this.titel = _titel;
	}

	/**
	 * @return the korn
	 */
	public int getKorn()
	{
		return this.korn;
	}

	/**
	 * @param _korn the korn to set
	 */
	public void setKorn(int _korn)
	{
		this.korn = _korn;
	}

	/**
	 * @return the mehl
	 */
	public int getMehl()
	{
		return this.mehl;
	}

	/**
	 * @param _mehl the mehl to set
	 */
	public void setMehl(int _mehl)
	{
		this.mehl = _mehl;
	}

	/**
	 * @return the soldaten
	 */
	public int getSoldaten()
	{
		return this.soldaten;
	}

	/**
	 * @param _soldaten the soldaten to set
	 */
	public void setSoldaten(int _soldaten)
	{
		this.soldaten = _soldaten;
	}

	/**
	 * @return the duenger
	 */
	public int getDuenger()
	{
		return this.duenger;
	}

	/**
	 * @param _duenger the duenger to set
	 */
	public void setDuenger(int _duenger)
	{
		this.duenger = _duenger;
	}

	/**
	 * @return the gold
	 */
	public int getGold()
	{
		return this.gold;
	}

	/**
	 * @param _gold the gold to set
	 */
	public void setGold(int _gold)
	{
		this.gold = _gold;
	}

	/**
	 * @return the bevoelkerung
	 */
	public int getBevoelkerung()
	{
		return this.bevoelkerung;
	}

	/**
	 * @param _bevoelkerung the bevoelkerung to set
	 */
	public void setBevoelkerung(int _bevoelkerung)
	{
		this.bevoelkerung = _bevoelkerung;
	}

	/**
	 * @return the felder
	 */
	public LinkedList<Feld> getFelder()
	{
		return this.felder;
	}

	/**
	 * @param _felder the felder to set
	 */
	public void setFelder(LinkedList<Feld> _felder)
	{
		this.felder = _felder;
	}

	/**
	 * @return the freieFelder
	 */
	public int getFreieFelder()
	{
		return this.freieFelder;
	}

	/**
	 * @param _freieFelder the freieFelder to set
	 */
	public void setFreieFelder(int _freieFelder)
	{
		this.freieFelder = _freieFelder;
	}

	/**
	 * @return the kornfelder
	 */
	public int getKornfelder()
	{
		return this.kornfelder;
	}

	/**
	 * @param _kornfelder the kornfelder to set
	 */
	public void setKornfelder(int _kornfelder)
	{
		this.kornfelder = _kornfelder;
	}

	/**
	 * @return the kornspeicher
	 */
	public int getKornspeicher()
	{
		return this.kornspeicher;
	}

	/**
	 * @param _kornspeicher the kornspeicher to set
	 */
	public void setKornspeicher(int _kornspeicher)
	{
		this.kornspeicher = _kornspeicher;
	}

	/**
	 * @return the muehlen
	 */
	public int getMuehlen()
	{
		return this.muehlen;
	}

	/**
	 * @param _muehlen the muehlen to set
	 */
	public void setMuehlen(int _muehlen)
	{
		this.muehlen = _muehlen;
	}

	/**
	 * @return the moral
	 */
	public int getMoral()
	{
		return this.moral;
	}

	/**
	 * @param _moral the moral to set
	 */
	public void setMoral(int _moral)
	{
		this.moral = _moral;
	}

	/**
	 * @return the spiel
	 */
	public Spiel getSpiel()
	{
		return this.spiel;
	}
	
}
