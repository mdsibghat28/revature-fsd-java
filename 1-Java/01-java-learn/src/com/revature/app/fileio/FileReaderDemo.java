package com.revature.app.fileio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderDemo {

	public static void main(String[] args) throws IOException{
		FileReader reader = new FileReader("G://File.txt");
//		FileWriter writer = new FileWriter("G://File-copy.txt");
		
		int character = reader.read();
		
		while (character != -1) {
			System.out.print((char) character);
			character = reader.read();
		}
		
//		writer.close();
		reader.close();

		


	}

}
