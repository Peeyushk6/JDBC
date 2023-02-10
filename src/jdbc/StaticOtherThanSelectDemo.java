package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import com.mysql.*;

public class StaticOtherThanSelectDemo {
	public static void main(String[] args) {
		Connection CON = null;
		Statement STMT = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dburl = "jdbc:mysql://localhost:3306/StudInfo";
			
			CON = DriverManager.getConnection(dburl,"root","root");
			String query = "Insert into StudentsInfo value(2,'Amit',65.4)";
			STMT = CON.prepareStatement(query);
			int count = STMT.executeUpdate(query);
			if(count != 0) {
				System.out.println("Data Inserted!");
			}
			else
				System.out.println("Data not inserted");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			if(CON != null)
				CON.close();
			if(STMT != null)
				STMT.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
