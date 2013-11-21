package de.logit.kaiser_clone.controller;

import de.logit.kaiser_clone.model.Gebaeude;
import de.logit.kaiser_clone.model.Kornfeld;
import de.logit.kaiser_clone.model.Kornspeicher;
import de.logit.kaiser_clone.model.Muehle;
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
	
	/*
	 * Karte des Spieler soll in ein StringArray gespeichert werden.
	 */
	public String[] getLandschaft()
	{
		// Die Map
		String[] karte;
		// anzahl Zeilen
		int arrayRows = 0;
		// anzahl zeichen pro Zeile
		final int zeichenProZeile = 15;
		// speicher einer Zeile
		String zeile = "";
		// Zeilenzähler um die Position im Array anzusprechen
		int lineZaehler = 0;
		// Gesamtegröße der Ländereien
		int landGroesse = masterController.getAktiverSpieler().getFelder().size();
		
		arrayRows = landGroesse / zeichenProZeile;
		if(landGroesse%zeichenProZeile!=0){
			arrayRows++;
		}
		karte = new String[arrayRows];
		for(int i = 0 ; i < landGroesse ; i++)
		{
			if(i % zeichenProZeile == 0 && i != 0){
				zeile = zeile + "\n";
				karte[lineZaehler] = zeile;
				lineZaehler++;
				zeile = "";
			}
			if(masterController.getAktiverSpieler().getFelder().get(i).getGebaeude() != null){
				if(masterController.getAktiverSpieler().getFelder().get(i).getGebaeude() instanceof Kornfeld){
					zeile = zeile + "ß";
				} else if (masterController.getAktiverSpieler().getFelder().get(i).getGebaeude() instanceof Kornspeicher) {
					zeile = zeile + "O";
				} else if (masterController.getAktiverSpieler().getFelder().get(i).getGebaeude() instanceof Muehle) {
					zeile = zeile + "X";
				}
			} else {
				zeile = zeile + "#";
			}
			if (zeichenProZeile > landGroesse && landGroesse-1 == i) {
				zeile = zeile + "\n";
				karte[lineZaehler] = zeile;
			} else if ((arrayRows - 1) == lineZaehler && landGroesse-1 == i) {
				zeile = zeile + "\n";
				karte[lineZaehler] = zeile;
			}
		}
		
		
		
		return karte;
	}

}
