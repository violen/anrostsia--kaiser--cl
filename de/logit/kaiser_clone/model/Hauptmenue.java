package de.logit.kaiser_clone.model;

import de.logit.kaiser_clone.controller.SabotageController;

public class Hauptmenue
{

	private Markt markt;
	private Sabotage sabotage;
	private Politik politic;
	private Statistik statistik;
	private Produzieren produzieren;

	public Hauptmenue()
	{
		this.markt = Markt.getInstance();
		this.sabotage = new Sabotage();
		this.politic = new Politik();
		this.statistik = new Statistik();
		this.produzieren = new Produzieren();
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

	public Politik getPolitic()
	{
		return politic;
	}

	public void setPolitic(Politik _politic)
	{
		politic = _politic;
	}

	public Statistik getStatistik()
	{
		return statistik;
	}

	public void setStatistik(Statistik _statistik)
	{
		statistik = _statistik;
	}

	public Produzieren getProduzieren()
	{
		return produzieren;
	}

	public void setProduzieren(Produzieren _produzieren)
	{
		produzieren = _produzieren;
	}

	public void chaten()
	{
	}

	public void produziereMehl()
	{
		
	}

}
