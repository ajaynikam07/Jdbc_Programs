package first_Advaned_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class RetriveDataOnAccountNo 
{

	public static void main(String[] args) 
	{
		 
		Scanner sc= new Scanner(System.in);
		
		try(sc;) 
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "AdvancedJava", "Ajay");
			System.out.println("Connected succesfully");
			Statement sta= conn.createStatement();
			
			System.out.println("Enter Account Number: ");
			long accNo = Long.parseLong(sc.nextLine());
			
			ResultSet result= sta.executeQuery("select * from bankcustomer where ACCOUNTNO ="+accNo+"");
			
		     if(result.next())
		     {
		    	 
				System.out.println(result.getLong(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getLong(4)+"\t"+result.getString(5));
				
			}
		     else {
		    	 System.err.println("Data Not Found ");
		     }
			
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Error to connect....");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
