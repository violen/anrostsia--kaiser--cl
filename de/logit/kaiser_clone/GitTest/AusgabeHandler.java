package de.logit.kaiser_clone.GitTest;

import java.io.PrintWriter;
/**
 * @author André Hauser
 * Dieser handler macht es möglich Auf der Konsole wie cmd.exe zu schreiben.
 * Besonderheiten stellen Sonderzeichen da wo dieser Handler seine Muskeln spielen lässt.
 */
public class AusgabeHandler {
	private PrintWriter pw;
	
	public AusgabeHandler(){
		if(System.console() != null){
			this.pw = System.console().writer();
		}
	}
	
	public void gibStringAnKonsole(String _string){
		if(this.pw != null){
			pw.print(_string);
		} else {
			System.out.print(_string);
		}
	}

}
