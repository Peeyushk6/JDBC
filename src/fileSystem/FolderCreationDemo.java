package fileSystem;

import java.io.File;

public class FolderCreationDemo {
	public static void main(String[] args) {
		File f = new File("E:\\java 2023 - revision\\JDBCProject\\src\\files\\peeyush");
		
		boolean isCreated = f.mkdir();
		
		if(isCreated) {
			System.out.println("Folder created");
		}
		else
		{
			System.out.println("Folder not created");
		}
		
		
	}
}
