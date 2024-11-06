package first_Advaned_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 

public class ConnectionWithDb
{
	 public static void main(String[] args) 
	 {
		 try 
		 {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Mouse","Password");
			System.out.println("Connection Successful...");
			Statement ste= conn.createStatement();
		
			ResultSet result= ste.executeQuery("select * from hyd");
			
			while(result.next())
			{
				System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

}
