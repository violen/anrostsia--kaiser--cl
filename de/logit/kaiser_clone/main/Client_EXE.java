package de.logit.kaiser_clone.main;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.NoSuchElementException;

import de.logit.kaiser_clone.network.ChatClient;
import de.logit.kaiser_clone.view.AusgabeHandler;
import de.logit.kaiser_clone.view.FehlerView;

public class Client_EXE {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Zeichenausgabe Umlaute etc. für Windows CMD.
		 * Bevor irgendwas anderes kommt den Windows Standard auf DOS umwandeln.
		 */
		if(System.getProperty("file.encoding").equalsIgnoreCase("Cp1252")){
			try {
				System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out),true,"Cp850"));
			} 
			catch (UnsupportedEncodingException e) {
			}
		}
		
		//SpielClient in den Speicher laden:
		ChatClient chatClient = new ChatClient();
		while (true) {
			try {
				chatClient.startClient();
			} catch (NoSuchElementException e) {
				AusgabeHandler ausgabeHandler = new AusgabeHandler();
				ausgabeHandler.gibStringAnKonsole(FehlerView.verlierenDerServerVerbindungBeimClient());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} 
				
			}
		}
		
		

	}

}
