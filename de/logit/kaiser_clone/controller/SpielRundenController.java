package de.logit.kaiser_clone.controller;

import java.util.ArrayList;

import de.logit.kaiser_clone.model.Markt;
import de.logit.kaiser_clone.model.Spieler;
import de.logit.kaiser_clone.model.Spielrunde;
import de.logit.kaiser_clone.model.Startmenue;
import de.logit.kaiser_clone.model.Titel;
import de.logit.kaiser_clone.view.AusgabeView;

public class SpielRundenController
{
	private ArrayList<Spielrunde> spielrunden = new ArrayList<>();
	private Spielrunde aktuelleRunde;
	private MasterController masterController;
	
	public SpielRundenController(MasterController _masterController) {
		this.masterController = _masterController;
	}

	public Spielrunde getAktuelleRunde() {
		return aktuelleRunde;
	}

	public void setAktuelleRunde(Spielrunde aktuelleRunde) {
		this.aktuelleRunde = aktuelleRunde;
	}
	
	public void initNeueRunde(Spielrunde _spielrunde){
		for(Spieler _gewinner : masterController.getSpiel().getSpieler()){
			if(_gewinner.getTitel() == Titel.KÖNIG){
				for(Spieler _spieler : masterController.getSpiel().getSpieler()){
					masterController.getAusgabeHandler().gibStringAnKonsole(AusgabeView.getGewonnenHatSpieler(_gewinner.getName()), _spieler);
				}
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Startmenue.beendeSpiel();
			}
		}
		this.spielrunden.add(_spielrunde);
		this.aktuelleRunde = new Spielrunde(masterController.getSpiel().getNextSpieler(
				masterController.getAktiverSpieler(), masterController.getSpiel().getSpieler()));
		masterController.setAktiverSpieler(aktuelleRunde.getAktiverspieler());
		Markt.getInstance().erhoeheBestaende();
	}

}
