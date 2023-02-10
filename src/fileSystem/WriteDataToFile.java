package fileSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataToFile {
	public static void main(String[] args) throws IOException {
//		File f = new File("E:\\java 2023 - revision\\JDBCProject\\src\\files\\p.txt");
		
		FileWriter writer = new FileWriter("E:\\java 2023 - revision\\JDBCProject\\src\\files\\p.txt");
		
		writer.write('c');
		writer.append('D');
		writer.append("This is a data written");
		writer.flush();
		writer.close();
	}
}
