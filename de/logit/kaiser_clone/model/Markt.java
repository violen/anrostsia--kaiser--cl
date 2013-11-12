/**
 * 
 */
package de.logit.kaiser_clone.model;

/**
 * @author nepo aka. André Hauser
 *
 */
public class Markt {
	 
	private final int BESTAND = 20000;
	private final int ERHOEHUNG = 500;
	
	private int bestandKorn = BESTAND;
	private int bestandMehl = BESTAND;
	
	private static Markt instance;
	
	private Markt(){
		
	}
	
	//Singleton -- Wir brauch nur EINEN Markt
	public static Markt getInstance(){
		if(instance == null){
			instance = new Markt();
		}
		return instance;
	}
	
	private void erhoeheBestaende(){
		this.bestandKorn+= ERHOEHUNG;
		this.bestandMehl+= ERHOEHUNG;
	}
	
	public Titel kaufeTitel(Titel _titel){
		//TODO
		return null;
	}

}
