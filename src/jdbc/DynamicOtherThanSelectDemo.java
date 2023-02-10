package jdbc;

import com.mysql.jdbc.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DynamicOtherThanSelectDemo {
	public static void main(String[] args) {
		PreparedStatement PSTMT = null;
		Connection CON = null;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			String dburl = "jdbc:mysql://localhost:3306/StudInfo";
			CON = DriverManager.getConnection(dburl,"root","root");
			
			String query = "Insert into StudentsInfo values(?,?,?)";
			
			PSTMT = CON.prepareStatement(query);
			
			System.out.println("Enter the ID");
			PSTMT.setInt(1, sc.nextInt());
			System.out.println("Enter the name");
			PSTMT.setString(2, sc.next());
			System.out.println("Enter the Marks");
			PSTMT.setDouble(3, sc.nextDouble());
			int res = PSTMT.executeUpdate();
			
			if(res!=0)
				System.out.println("Data inserted");
			else
				System.out.println("Data not inserted");
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
