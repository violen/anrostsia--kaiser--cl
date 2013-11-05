/**
 * 
 */
package de.logit.kaiser_clone.GitTest;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/**
 * @author nepo aka. André Hauser
 *
 */
public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Hallo Sia!!! \t Ein Vertikaler Tab " + System.getProperty("file.encoding"));
//		System.setProperty("file.encoding", "UTF8");
//		System.out.println(System.getProperty("file.encoding"));
		/*
		 * Windows CMD erwartet Zeichen im DOS-Zeichensatz "CP850"
		 */
	    try {
			System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out),true,"CP850"));
		} catch (UnsupportedEncodingException e) {
		}
		System.out.println("Hauptmenü:: Hi ich bin André");
	}

}
