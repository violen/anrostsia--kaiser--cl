/**
 * 
 */
package de.logit.kaiser_clone.model;

/**
 * @author nepo aka. André Hauser
 *
 */
public class Muehle extends Gebaeude 
{
	private int ertragMehl=500;

	public Muehle() {
	}

	public int getErtragMehl() {
		return ertragMehl;
	}

	public void setErtragMehl(int ertragMehl) {
		this.ertragMehl = ertragMehl;
	}
	

}
