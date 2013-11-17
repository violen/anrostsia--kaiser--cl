package de.logit.kaiser_clone.controller;

public class PolitikController
{
	private MasterController masterController;
	public PolitikController(MasterController _masterController) {
		this.setMasterController(_masterController);
	}

	public void auswertenEingabePolitik(String _parameter)
	{
		// TODO Auto-generated method stub
		
	}

	public MasterController getMasterController() {
		return masterController;
	}

	public void setMasterController(MasterController masterController) {
		this.masterController = masterController;
	}

}
