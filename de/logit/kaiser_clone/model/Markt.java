/**
 * 
 */
package de.logit.kaiser_clone.model;

/**
 * @author nepo aka. André Hauser
 *
 */
public class Markt {
	private int bestandKorn = 10000;
	private int bestandMehl = 10000;
	
	public Markt(){
		
	}
	
	private void erhoeheBestaende(){
		this.bestandKorn+= 500;
		this.bestandMehl+= 500;
	}
	
	public Titel kaufeTitel(Titel _titel){
		//TODO
		return null;
	}

}
