package de.logit.kaiser_clone.GitTest;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class KonsolenManipulierer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//Process proc = Runtime.getRuntime().exec("cmd /c start");
			ProcessBuilder pb = new ProcessBuilder("cmd.exe");
			pb.start().getOutputStream();
			Process prog = Runtime.getRuntime().exec("cmd /c start");
			OutputStream os = prog.getOutputStream();
			new PrintStream(os).println("huhu");
			
//			Console con = prog.;
//			con.writer().print("huhu");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
