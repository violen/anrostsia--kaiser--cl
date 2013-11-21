/**
 * 
 */
package de.logit.kaiser_clone.view;

import de.logit.kaiser_clone.model.Spieler;
import de.logit.kaiser_clone.model.Titel;

/**
 * @author nepo aka. André Hauser
 *
 */
public class StatistikView 
{

	public static String getStatistik(Titel titel, int korn, int  mehl,int  duenger,
										int  gold,int bevoelkerung,int  kornspeicher,int freieFelder,
											int  muehlen,int  moral, String nachricht)
	{
		
		// TODO Auto-generated method stub
		return "im moment keine statistik da" + "\n";
	}
	
	public static String getStatistikDesSpielers(String[] _karteDesSpielers, Spieler _aktiverSpieler)
	{
		String string = "";
		string = string + "Die Landschaft:" + "\n";
		for(int i = 0 ; i < _karteDesSpielers.length ; i++)
		{
			string = string + "\t" + _karteDesSpielers[i];
		}
		string = string + "Deine Spielstatistik:" + "\n"+
				"  " + "Titel: " + _aktiverSpieler.getTitel() + " || " + "Gold: " + _aktiverSpieler.getGold() +" || " + "Moral: " +_aktiverSpieler.getMoral() + "\n" +
				"  " + "Bevölkerung: " + _aktiverSpieler.getBevoelkerung() + " || " + "Korn: " + _aktiverSpieler.getKorn() + " || " + "Mehl: " + _aktiverSpieler.getMehl() + "\n" +
				"  " + "Dünger: " + _aktiverSpieler.getDuenger() + " || " + "Kornspeicher: " + _aktiverSpieler.getKornspeicher() + " || " + "Mühlen: " + _aktiverSpieler.getMuehlen() + "\n" +
				"  " + "Unbebautes land: " + _aktiverSpieler.getFreieFelder() + " || " + "Deine Nachrichten: " +"\n"+ _aktiverSpieler.getNachricht() + "\n";
		return string;
	}

}
