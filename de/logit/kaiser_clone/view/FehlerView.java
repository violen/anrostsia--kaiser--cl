/**
 * 
 */
package de.logit.kaiser_clone.view;

/**
 * @author nepo aka. André Hauser
 *
 */
public class FehlerView 
{
	public static String getGoldReichtNichtAus()
	{
		return "Gold reicht nicht aus.\n";
		
	}

	public static String getTransaktionErfolgreich() {
		
		return "Transaktion erfolgreich.\n";
	}

	public static String getMengeNichtVerfügbar() {
		
		return "Menge nicht verfügbar.\n";
	}

	public static String getUnkorrekteEingabe() {
		
		return "Das war keine korrekte Eingabe.\n";
	}

	public static String getTitelNichtverfuegbar() {
		
		return "Titel nicht verfügbar.\n";
	}

	public static String getKeinFreiesFeldVorhanden() {
		
		return "Kein freies Feld vorhanden.\n";
	}

	public static String getKeineGueltigeEingabe() {
		
		return "Das war keine gültige Eingabe. \n";
	}

	public static String getSoldatenReichenNichtAus() {
	
		return "Soldaten reichen nicht aus. \n";
	}

	public static String getDasWarKeineZahl()
	{
		return "Das war keine Zahl \n";
	}

	public static String getSpielerNichtInListe() {
		
		return "Spieler nicht in Liste. \n";
	}

	public static String verlierenDerServerVerbindungBeimClient(){
		return "Server verbindung verloren."+"\n";
	}

	public static String ausfuehrenDieserAktionInDieserRundeNichtMoeglich(){
		return "Du hast diese Aktion bereits getätigt!" + "\n" +
				"Du darfst diesen Bereich erst in der neuen Runde wieder betreten!" + "\n";
	}
}
