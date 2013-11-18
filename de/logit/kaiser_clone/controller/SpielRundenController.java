package de.logit.kaiser_clone.controller;

import java.util.ArrayList;

import de.logit.kaiser_clone.model.Spielrunde;

public class SpielRundenController
{
	private ArrayList<Spielrunde> spielrunden = new ArrayList<>();
	private Spielrunde aktuelleRunde;
	private MasterController masterController;
	
	public SpielRundenController(MasterController _masterController) {
		this.setMasterController(_masterController);
	}
	
	public MasterController getMasterController() {
		return masterController;
	}
	
	public void setMasterController(MasterController masterController) {
		this.masterController = masterController;
	}

	public Spielrunde getAktuelleRunde() {
		return aktuelleRunde;
	}

	public void setAktuelleRunde(Spielrunde aktuelleRunde) {
		this.aktuelleRunde = aktuelleRunde;
	}

}
