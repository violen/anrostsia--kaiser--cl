package de.logit.kaiser_clone.main;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import de.logit.kaiser_clone.network.ChatClient;

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
		chatClient.startClient();

	}

}
