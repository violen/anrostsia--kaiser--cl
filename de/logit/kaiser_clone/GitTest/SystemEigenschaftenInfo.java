package de.logit.kaiser_clone.GitTest;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
/**
 * @author André Hauser
 * Soll die SystemVariablen und Eigenschaften anzeigen
 */
public class SystemEigenschaftenInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(Map.Entry<String, String> entry : System.getenv().entrySet()){
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		try {
			System.getProperties().list(new PrintStream(new FileOutputStream(FileDescriptor.out),true, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}


	}

}
