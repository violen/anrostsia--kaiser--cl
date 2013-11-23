package de.logit.kaiser_clone.controller;

import de.logit.kaiser_clone.model.Spieler;
import de.logit.kaiser_clone.view.AusgabeView;
import de.logit.kaiser_clone.view.FehlerView;
import de.logit.kaiser_clone.view.ProduzierenView;

public class ProduzierenController
{
	private MasterController masterController;

	public ProduzierenController(MasterController _masterController)
	{
		masterController = _masterController;
	}
	/**
	 * Produziert aus Korn Mehl 2:1
	 */
	public void produzieren()
	{
		Spieler aktiverSpieler = masterController.getAktiverSpieler();
		
		int _parameter =	masterController.getSpielController().anzahlHolen() ;

		if (aktiverSpieler.getKorn() >= _parameter * 2)
		{
			aktiverSpieler.setKorn(
			aktiverSpieler.getKorn() - _parameter * 2);
			aktiverSpieler.setMehl(aktiverSpieler.getMehl()+_parameter);
			
			masterController.getAusgabeHandler().gibStringAnKonsole(ProduzierenView.getMehlProduziert(_parameter),aktiverSpieler);
		}
		
		else
		{
			masterController.getAusgabeHandler().gibStringAnKonsole(FehlerView.getKornReichtNichtAus());
		}

	}

}
