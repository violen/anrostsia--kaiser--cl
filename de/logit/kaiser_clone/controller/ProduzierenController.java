package de.logit.kaiser_clone.controller;

import de.logit.kaiser_clone.view.ProduzierenView;

public class ProduzierenController
{
	private MasterController masterController;

	public ProduzierenController(MasterController _masterController)
	{
		masterController = _masterController;
	}

	public void produzieren(int _parameter)
	{
		if (masterController.getAktiverSpieler().getKorn() >= _parameter * 2)
		{
			masterController.getAktiverSpieler().setKorn(
					masterController.getAktiverSpieler().getKorn() - _parameter * 2);
			masterController.getAktiverSpieler().setMehl(masterController.getAktiverSpieler().getMehl()+_parameter);
			
			masterController.getAusgabeHandler().gibStringAnKonsole(ProduzierenView.getMehlProduziert(_parameter));
		}

	}

}
