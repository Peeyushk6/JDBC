package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class StaticSelectDemo {
	public static void main(String[] args) {
		Statement STMT = null;
		Connection CON = null;
		
		try {
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);
			
			String dburl = "jdbc:mysql://localhost:3306/StudInfo";
			
			CON = DriverManager.getConnection(dburl,"root","root");
			
			String query = "Select * from StudentsInfo";
			
			STMT = CON.createStatement();
			ResultSet rs = STMT.executeQuery(query);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				double marks = rs.getDouble(3);
				
				System.out.print(id+"  ");
				System.out.print(name+"  ");
				System.out.print(marks);
				System.out.println();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(CON!=null)
				CON.close();
			if(STMT!=null)
			STMT.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
