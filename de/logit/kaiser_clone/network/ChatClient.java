package de.logit.kaiser_clone.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import de.logit.kaiser_clone.controller.EingabeController;
import de.logit.kaiser_clone.view.AusgabeHandler;
import de.logit.kaiser_clone.view.AusgabeView;

public class ChatClient
{
	private Socket socket;
	
	public ChatClient(){
		
	}
	
	public void startClient(){
		Socket server;
		
		AusgabeHandler ausgabeHandler = new AusgabeHandler();
		ausgabeHandler.gibStringAnKonsole(AusgabeView.waehleServerIP());
		EingabeController eingabeController = new EingabeController();
		try {
			server = new Socket(eingabeController.getEingabe(),40123);
			Scanner inputStream = new Scanner(server.getInputStream());
			PrintWriter outputStream = new PrintWriter(server.getOutputStream(), true);
			boolean stop = false;
			while (!stop) {
				String action = inputStream.nextLine();
				if(action.equalsIgnoreCase("in")){
					outputStream.println(eingabeController.getEingabe());
				} else if(action.equals("out")) {
					ausgabeHandler.gibStringAnKonsole(inputStream.nextLine());
				}
				
			}
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
}
