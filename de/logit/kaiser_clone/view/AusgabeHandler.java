package de.logit.kaiser_clone.view;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;

import de.logit.kaiser_clone.model.Spieler;
/**
 * @author André Hauser
 * Dieser handler macht es möglich Auf der Konsole wie cmd.exe zu schreiben.
 * Besonderheiten stellen Sonderzeichen da wo dieser Handler seine Muskeln spielen lässt.
 */
public class AusgabeHandler {
	private PrintWriter pw;
	private Spieler spieler;
	private HashMap<Spieler, PrintWriter> outputStream = new HashMap<>();
	
	public AusgabeHandler(){
		if(System.console() != null){
			this.pw = System.console().writer();
		}
	}
	
	public AusgabeHandler(OutputStream _outputStream){
		this.pw = new PrintWriter(_outputStream);
	}
	
	public void gibStringAnKonsole(String _string){
		if(this.pw != null){
			pw.print(_string);
			pw.flush();
		} else {
			System.out.print(_string);
		}
	}
	
	public void gibStringAnKonsole(String _string, Spieler _spieler){
		this.outputStream.get(_spieler).print(_string);
		this.outputStream.get(_spieler).flush();
	}
	
	public void linkSpielerMitOutputStream(Spieler _spieler, PrintWriter _printWriter){
		this.outputStream.put(_spieler, _printWriter);
	}

}
