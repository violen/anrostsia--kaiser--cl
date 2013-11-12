package de.logit.kaiser_clone.controller;

import de.logit.kaiser_clone.model.Markt;
import de.logit.kaiser_clone.view.AusgabeHandler;

public class MarktController
{
	//Der "Eine" Markt der für alle gilt.
	private Markt markt;
	
	private EingabeController eingabeController;
	private AusgabeHandler ausgabeHandler;
	
	public MarktController(){
		this.markt = Markt.getInstance();
	}
	
	public void auswertenEingabeMarkt()
	{
		// TODO Auto-generated method stub
		
	}

}
