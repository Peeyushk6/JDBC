package fileSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadDataFromFile {
	public static void main(String[] args) {
		File f = new File("E:\\java 2023 - revision\\JDBCProject\\src\\files\\p.txt");
		
		try {
			FileReader reader = new FileReader(f);
			
			//read the data char by char
			
			try {
				int asciiData = reader.read();
				String allData = "";
				while(asciiData != -1) {
					char data = (char)asciiData;
					System.out.println(data);
					allData = allData + data;
					asciiData = reader.read();
					System.out.println(asciiData);
				}
				System.out.println(allData);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		
//		//Read the data line by line
//		try {
//		 Scanner myReader = new Scanner(f);
//	          while (myReader.hasNextLine()) {
//	            String data = myReader.nextLine();
//	            System.out.println(data);
//	                }
//	        myReader.close();
//	    } 
//		
//		catch (FileNotFoundException e) {
//	      System.out.println("An error occurred.");
//	      e.printStackTrace();
//	   }
		
	}
}
