package de.logit.kaiser_clone.network;

import java.io.IOException;
import java.net.ServerSocket;

public class ChatServer
{
	private ServerSocket svrSocket;
	
	public ChatServer(){
		try {
			this.svrSocket = new ServerSocket(40123);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ServerSocket getSvrSocket() {
		return svrSocket;
	}

	public void setSvrSocket(ServerSocket _svrSocket) {
		svrSocket = _svrSocket;
	}
	
	
}
