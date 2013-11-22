package de.logit.kaiser_clone.model;

import de.logit.kaiser_clone.controller.SabotageController;

public class Hauptmenue
{

	private Markt markt;
	private Sabotage sabotage;
//	private Politik politik;//wird nicht verwendet
//	private Statistik statistik;//wird nicht verwendet
//	private Produzieren produzieren;//wird nicht verwendet

	public Hauptmenue()
	{
		this.markt = Markt.getInstance();
		this.sabotage = new Sabotage();
//		this.politik = new Politik();//wird nicht verwendet
//		this.statistik = new Statistik();//wird nicht verwendet
//		this.produzieren = new Produzieren();//wird nicht verwendet
	}

	public Markt getMarkt()
	{
		return markt;
	}

	public void setMarkt(Markt _markt)
	{
		markt = _markt;
	}

	/**
	 * @return the sabotage
	 */
	public Sabotage getSabotage()
	{
		return sabotage;
	}

	public void setSabotage(Sabotage _sabotage)
	{
		sabotage = _sabotage;
	}

	//Die Models: Politik, Statistik, Produzieren, chatten und produziereMehl sind aus dem ersten Entwurf und werden nicht mehr verwendet.
//	public Politik getPolitik()
//	{
//		return politik;
//	}
//
//	public void setPolitic(Politik _politic)
//	{
//		politik = _politic;
//	}
//
//	public Statistik getStatistik()
//	{
//		return statistik;
//	}
//
//	public void setStatistik(Statistik _statistik)
//	{
//		statistik = _statistik;
//	}
//
//	public Produzieren getProduzieren()
//	{
//		return produzieren;
//	}
//
//	public void setProduzieren(Produzieren _produzieren)
//	{
//		produzieren = _produzieren;
//	}

//	public void chatten()
//	{
//	}
//
//	public void produziereMehl()
//	{
//		
//	}

}
