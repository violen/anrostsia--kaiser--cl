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
	private Spieler spielerAmServer;
	private HashMap<Spieler, PrintWriter> outputStream = new HashMap<>();
	
	public AusgabeHandler(){
		if(System.console() != null){
			this.pw = System.console().writer();
		}
	}
	
	public AusgabeHandler(OutputStream _outputStream){
		this.pw = new PrintWriter(_outputStream);
	}
	
	public void gibStringAnKonsole(String _string)//lokaler Aufruf - Solange Spieler keinem Stream zugeordnet sind
	{
		if(this.pw != null){
			pw.print(_string);
			pw.flush();
		} else {
			System.out.print(_string);
		}
	}
	
	public void gibStringAnKonsole(String _string, Spieler _spieler)// überladen - Wird genutzt sobald Spieler einem Stream zugeordnet sind
	{
		if(istSpielerKeinServerSpieler(_spieler)){
			String[] array = _string.split("\n");
			for(int i = 0 ; i < array.length ; i++){
				erfordereRichtung("out", _spieler);
				this.outputStream.get(_spieler).println(array[i]);
			}
		}
		this.outputStream.get(_spieler).print(_string);
		this.outputStream.get(_spieler).flush();
	}
	
	public void linkSpielerMitOutputStream(Spieler _spieler, PrintWriter _printWriter){
		this.outputStream.put(_spieler, _printWriter);
	}
	
	public void erfordereRichtung(String _richtung, Spieler _spieler){
		if(istSpielerKeinServerSpieler(_spieler)){
			this.outputStream.get(_spieler).println(_richtung);
		}
			
	}
	
	private boolean istSpielerKeinServerSpieler(Spieler _spieler){
		if(!spielerAmServer.equals(_spieler)){
			return true;
		}
		return false;
	}

	public Spieler getSpielerAmServer() {
		return spielerAmServer;
	}

	public void setSpielerAmServer(Spieler spielerAmServer) {
		this.spielerAmServer = spielerAmServer;
	}

}
