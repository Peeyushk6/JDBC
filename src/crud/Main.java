package crud;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

			System.out.println("Enter your choice");
			System.out.println("1.Display \n2.Add Data \n3.Update Data \n4.Delete Data \n5.Exit");
			int choice = sc.nextInt();
			switch(choice) {
			
			case 1 :  DisplayData.display();
			break;
			case 2 : InsertData.insert();
			break;
			case 3 : UpdateData.update();
			break ;
			case 4 : DeleteData.delete();
			break;
			case 5 : System.exit(0);			
			default : System.out.println("Enter the correct number");
			
			sc.close();
			}
		
				
	}
}
