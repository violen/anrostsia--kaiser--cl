package de.logit.kaiser_clone.controller;

import de.logit.kaiser_clone.model.Spieler;
import de.logit.kaiser_clone.model.Statistik;
import de.logit.kaiser_clone.model.Titel;
import de.logit.kaiser_clone.view.StatistikView;

public class StatistikController
{
	private MasterController masterController;
	
	public StatistikController(MasterController _masterController)
	{
		this.masterController = _masterController;
	}

	public void berechneStatistik()
	{
		Spieler spieler = masterController.getAktiverSpieler();
		
		Titel titel=spieler.getTitel();
		int korn=spieler.getKorn();
		int mehl=spieler.getMehl();
		int duenger=spieler.getDuenger();
		int gold=spieler.getGold();
		int bevoelkerung=spieler.getBevoelkerung();
		int freieFelder=spieler.getFreieFelder();
		int kornspeicher=spieler.getKornspeicher();
		int muehlen=spieler.getMuehlen();
		int moral=spieler.getMoral();
		String nachricht=spieler.getNachricht();
		
		spieler.setNachricht("");
		
		masterController.getAusgabeHandler().gibStringAnKonsole
									(StatistikView.getStatistik(titel, korn, mehl, duenger, gold, bevoelkerung, 
										freieFelder, kornspeicher, muehlen, moral, nachricht), spieler); 
		
	}

	public void holenStatistik()
	{
		// TODO Auto-generated method stub --> kann warscheinlich weg
		
		
	}

}
