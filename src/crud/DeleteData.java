package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class DeleteData {
	public static void delete() {
		PreparedStatement PSTMT = null;
		Connection CON = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);
			
			String dburl = "jdbc:mysql://localhost:3306/StudInfo";
			
			CON = DriverManager.getConnection(dburl,"root","root");
			
			String query = "delete from StudentsInfo where id = ?";
			
			PSTMT = CON.prepareStatement(query);
			System.out.println("Enter the id to be deleted");
			PSTMT.setInt(1, sc.nextInt());
			
			int result = PSTMT.executeUpdate();
			if(result!=0)
				System.out.println("Data deleted");
			else
				System.out.println("Data not deleted");
			
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
