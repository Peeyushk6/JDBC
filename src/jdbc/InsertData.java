package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class InsertData {
	public static void main(String[] args) {
		Connection CON = null;
		PreparedStatement PSTMT = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			Driver dref = new Driver();
			
			DriverManager.registerDriver(dref);
			
			String dburl = "jdbc:mysql://localhost:3306/StudInfo";
			CON = DriverManager.getConnection(dburl,"root","root");
			
			String query="Insert into studentsInfo values(?,?,?)";
			
			PSTMT = CON.prepareStatement(query);
			
			System.out.println("Enter the ID");
			PSTMT.setInt(1, sc.nextInt());
			System.out.println("Enter the name");
			PSTMT.setString(2,sc.next());
			System.out.println("Enter the marks");
			PSTMT.setDouble(3, sc.nextDouble());
			int res = PSTMT.executeUpdate();
			
			if(res!=0) {
				System.out.println("Data is inserted");
			}
			else {
				System.out.println("Data is not inserted");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(CON != null)
				CON.close();
			if(PSTMT != null)
				PSTMT.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
