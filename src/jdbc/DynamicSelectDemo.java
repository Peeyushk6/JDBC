package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class DynamicSelectDemo {
	public static void main(String[] args) {
		PreparedStatement PSTMT = null;
		Connection CON = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);
			
			String dburl = "jdbc:mysql://localhost:3306/StudInfo";
			
			CON = DriverManager.getConnection(dburl,"root","root");
			
			String query = "Select * from studentsinfo where id = ?";
			PSTMT = CON.prepareStatement(query);
			System.out.println("Enter the Id to fetch");
			PSTMT.setInt(1,sc.nextInt());
			
			ResultSet rs = PSTMT.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(CON != null)
				CON.close();
			if(PSTMT!=null)
				PSTMT.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
