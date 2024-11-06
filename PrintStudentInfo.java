package first_Advaned_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PrintStudentInfo 
{

	public static void main(String[] args) 
	{
		  try {
			  // : Loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//: Creating connection
			
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","AdvancedJava","Ajay");
			System.out.println("Connection Successful..");
			
			
			//creating JDBC statement
			Statement ste=conn.createStatement();
			
			//Executing query
			ResultSet result=ste.executeQuery("select * from student");
			
			while(result.next())
			{
				System.err.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
			}
			
			//Closing Connection
			result.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
