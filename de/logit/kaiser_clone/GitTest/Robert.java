package de.logit.kaiser_clone.GitTest;

public class Robert {
	/**
	 * @author Robert
	 *
	 */
	
	private String rostansia;
	

	/**
	 * @param _rostansia
	 */
	public Robert(String _rostansia) {
		rostansia = _rostansia;
	}

	public String getRostansia() {
		return rostansia;
	}

	
	
	public double TaxameterLaeuft(double _dauer,double _aufschlag){
		
		double gebuehr = (_dauer * 400) + _aufschlag;
		return gebuehr;
		
	}
}
