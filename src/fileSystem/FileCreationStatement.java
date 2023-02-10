package fileSystem;

import java.io.File;
import java.io.IOException;

public class FileCreationStatement {
	public static void main(String[] args) throws IOException{
		File f = new File("E:\\java 2023 - revision\\JDBCProject\\src\\files\\file.txt");
		
		boolean isCreated = f.createNewFile();
		
		if(isCreated) {
			System.out.println("New file created");
		}
		else {
			System.out.println("File not created");
		}
		
	}
}
