package de.logit.kaiser_clone.controller;

public class SpielRundenController
{
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

}
