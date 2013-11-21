/**
 * 
 */
package de.logit.kaiser_clone.model;

/**
 * @author nepo aka. André Hauser
 *
 */
public class Politik 
{
	
	private int steuersatz=40; 	// normal= 40%, hoch=80%. niedrig=20%
	private int nahrungsration=10;	//normal = 10, halb=5, doppelt=20; soldaten erhalten immer 10.
	/**
	 * @param _steuersatz
	 * @param _nahrungsration
	 */
	public Politik()
	{
		
	}
	/**
	 * @return the steuersatz
	 */
	public int getSteuersatz()
	{
		return this.steuersatz;
	}
	/**
	 * @param _steuersatz the steuersatz to set
	 */
	public void setSteuersatz(int _steuersatz)
	{
		this.steuersatz = _steuersatz;
	}
	/**
	 * @return the nahrungsration
	 */
	public int getNahrungsration()
	{
		return this.nahrungsration;
	}
	/**
	 * @param _nahrungsration the nahrungsration to set
	 */
	public void setNahrungsration(int _nahrungsration)
	{
		this.nahrungsration = _nahrungsration;
	}
	
	
	
	
	

}
