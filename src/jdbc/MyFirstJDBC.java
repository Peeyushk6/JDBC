package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class MyFirstJDBC {
	
	public static void main(String[] args) {
		Connection CON = null;
		Statement STMT = null;
		ResultSet RS = null;
		try {
			Driver dref = new Driver();		
			DriverManager.registerDriver(dref);
			
			String dburl = "jdbc:mysql://localhost:3306/StudInfo";
			
			String query = "Select * from StudentsInfo";
			 CON = DriverManager.getConnection(dburl,"root","root");
			
			STMT = CON.createStatement();
			RS = STMT.executeQuery(query);
			
			while(RS.next()) {
				System.out.println(RS.getInt("id")+" "+RS.getString("name")+" "+RS.getDouble("marks"));
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		try {
			if(CON != null) 
				CON.close();
			if(STMT != null)
				STMT.close();
			if(RS!=null)
				RS.close();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
