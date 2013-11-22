/**
 * 
 */
package de.logit.kaiser_clone.model;

/**
 * @author nepo aka. André Hauser
 *
 */
public class Kornfeld extends Gebaeude 
{

	private int ertragKorn=1000;

	public Kornfeld() {
	}
	
	public int getErtragKorn() {
		return ertragKorn;
	}

	public void setErtragKorn(int ertragKorn) {
		this.ertragKorn = ertragKorn;
	}


	
}
