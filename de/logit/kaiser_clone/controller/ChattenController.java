package de.logit.kaiser_clone.controller;

import de.logit.kaiser_clone.view.ChattenView;
/**
 * 
 * @author Nepu
 *	Chatten ist noch nicht konsistent implementiert
 * d.h. Es kann sich nicht ingame Unterhalten werden ;(
 */
public class ChattenController
{
	private MasterController masterController;
	private ChattenController chatten; // ?

	public ChattenController(MasterController _masterController) 
	{
		this.masterController =_masterController;
	}
	
	public void auswertenChattenMenue(String _parameter)
	{
		
		return ;// soll ein eListe der verfügbaren spieler zum chatten anzeigen...
		
	}

	public void getAuswertenEmpfaenger(String _parameter)
	{
		int param = masterController.getSpiel().getSpieler().size();//anzahl elememte in der Liste der Spieler
		int inputZahl = 0;
			try
			{
				inputZahl = Integer.parseInt(_parameter);//parsen auf Interger der Eingabe (_parameter) "welcher Empfänger"
			} 
			catch (NumberFormatException e)
			{
			}
				
			if(  inputZahl <= param )
			{
				masterController.getAusgabeHandler().gibStringAnKonsole(ChattenView.getNachrichtAnEmpfaengerEingeben(_parameter), masterController.getAktiverSpieler());
				String parameter = this.masterController.getEingabecontroller().getEingabe(masterController.getAktiverSpieler());
				masterController.getAusgabeHandler().gibStringAnKonsole(ChattenView.getGesendeteNachricht(parameter), masterController.getAktiverSpieler());
			}
			else
			{
				masterController.getAusgabeHandler().gibStringAnKonsole(ChattenView.getEmpfaengerNichtInDerListe(), masterController.getAktiverSpieler());
			}
		
	}

	public void getAuswertenNachricht(String _parameter)
	{
		// TODO Auto-generated method stub
		
	}

	

}
