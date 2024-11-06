package first_Advaned_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

 
public class BankCustomerDetails 
{

	public static void main(String[] args) 
	{
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "AdvancedJava", "Ajay");
			
			Statement ste= conn.createStatement();
			
			ResultSet result= ste.executeQuery("Select * from bankcustomer");
			
			while(result.next())
			{
				System.out.println(result.getDouble(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getDouble(4)+"\t"+result.getString(5));
			}
			
			result.close();
		}
		catch (Exception e) {
			 
		}
		 
	}

}
