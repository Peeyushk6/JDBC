package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class UpdateData {
	public static void update() {
		PreparedStatement PSTMT = null;
		Connection CON = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);
			
			String dburl = "jdbc:mysql://localhost:3306/StudInfo";
			
			CON = DriverManager.getConnection(dburl,"root","root");
			
			String query = "Update StudentsInfo set name=? where id=?";
			
			PSTMT = CON.prepareStatement(query);
			System.out.println("Enter the Name of the employee to be updated");
			PSTMT.setString(1, sc.next());
			System.out.println("Enter the Id of the employee to be updated");
			PSTMT.setInt(2, sc.nextInt());
			
			int rs = PSTMT.executeUpdate();
			if(rs!=0)
				System.out.println("Updated Succesfully");
			else
				System.out.println("Not updated");
			
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
