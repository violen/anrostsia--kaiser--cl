/**
 * 
 */
package de.logit.kaiser_clone.view;

import de.logit.kaiser_clone.model.Statistik;
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
	
	public static String testeKarteDesSpielers(String[] _karteDesSpielers){
		String string = "";
		for(int i = 0 ; i < _karteDesSpielers.length ; i++){
			string = string + _karteDesSpielers[i];
		}
		
		return string;
	}

}
