package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Driver;


public class DisplayData {
	public static void display() {
		Statement STMT = null;
		Connection CON = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);
			
			String dburl = "jdbc:mysql://localhost:3306/StudInfo";
			
			CON = DriverManager.getConnection(dburl,"root","root");
			
			String query = "Select * from StudentsInfo";
			STMT =  CON.createStatement();
			
			ResultSet RS = STMT.executeQuery(query);
			
			while(RS.next()) {
				System.out.println(RS.getInt(1)+" "+RS.getString(2)+" "+RS.getDouble(3));
			}
			
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
		catch(Exception e){
			e.printStackTrace();
		}
		
		sc.close();
	}

}
