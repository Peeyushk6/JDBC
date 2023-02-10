package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class InsertData {
	public static void insert() {
		PreparedStatement PSTMT = null;
		Connection CON = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);
			
			String dburl = "jdbc:mysql://localhost:3306/StudInfo";
			
			CON = DriverManager.getConnection(dburl,"root","root");
			
			String query = "Insert into studentsinfo values (?,?,?)";
			
			PSTMT = CON.prepareStatement(query);
			System.out.println("Enter the ID");
			PSTMT.setInt(1, sc.nextInt());
			System.out.println("Enter the Name");
			PSTMT.setString(2, sc.next());
			System.out.println("Enter the Marks");
			PSTMT.setDouble(3, sc.nextDouble());
			
			int res = PSTMT.executeUpdate();
			
			if(res!=0) {
				System.out.println("Data is Inserted");
			}
			else
			{
				System.out.println("Data is not Inserted");
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
		catch(Exception e){
			e.printStackTrace();
		}
		sc.close();
	}
}
