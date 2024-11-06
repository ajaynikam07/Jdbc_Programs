package first_Advaned_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class RetriveEmployeeInfo
{
	public static Scanner sc= new Scanner(System.in);
	public static Statement returnstament()
	{
		Statement ste=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","AdvancedJava","Ajay");
			
			  ste=conn.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ste;
		
	}
	
	// inserting data 
	public void insertdata()
	{
		try {
			Statement ste=returnstament();
			
			System.out.println("Enter emp id : ");
			long id=sc.nextLong();
			System.out.println("Enter emp name: ");
			String name= sc.next();
			System.out.println("Enter emp salary: ");
			long salary=sc.nextLong();
			System.out.println("Enter emp Address: ");
			String address=sc.next();
			System.out.println("Enter emp email : ");
			String email=sc.next();
			System.out.println("Enter emp PhoneNO: ");
			Long Pno=sc.nextLong();
			
			int result=ste.executeUpdate("insert into Employee_Info values("+id+",'"+name+"',"+salary+",'"+address+"','"+email+"',"+Pno+")");
			
			if(result>0)
			{
				System.out.println("Data Inserted Successfully...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	//Retrive data
	
	public void retriveData()
	{
		try {
			Statement ste=returnstament();
			
			ResultSet result=ste.executeQuery("select * from Employee_Info");
			
			while(result.next())
			{
				System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getDouble(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getLong(6));
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	public void Statwiths()
	{
		try {
			Statement ste=returnstament();
			
			ResultSet result=ste.executeQuery("select * from Employee_Info where EMPNAME LIKE 'M%'");
			
			while(result.next())
			{
				System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getDouble(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getLong(6));
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	public void RetriveSalary()
	{
		try {
			Statement ste=returnstament();
			
			ResultSet result=ste.executeQuery("select * from Employee_Info where EMPSALARY between 10000 and 20000");
			
			while(result.next())
			{
				System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getDouble(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getLong(6));
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	public void updateSalary()
	{
		try {
			Statement ste=returnstament();
			
			System.out.println("Enter emp id : ");
			long id=sc.nextLong();
			System.out.println("Enter emp salary: ");
			long salary=sc.nextLong();
			
			int result=ste.executeUpdate("update Employee_Info set EMPSALARY = ("+salary+")where EMPID= ("+id+")");
			
			if (result>0) 
			{
				System.out.println("DataUpdated Successfuly....");
			}
			else 
			{
				System.out.println("Id Not found ");
			}
			
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	public void DeleteMaxSalary() {
	    try {
	        Statement ste = returnstament();

	        // Corrected query using a subquery to get the maximum salary
	        int result = ste.executeUpdate("DELETE FROM Employee_Info WHERE EMPSALARY = (SELECT MAX(EMPSALARY) FROM Employee_Info)");

	        if (result > 0) {
	            System.out.println("Data deleted successfully...");
	        } else {
	            System.err.println("No matching data found to delete.");
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	public void Endwitha()
	{
		try {
			Statement ste=returnstament();
			
			int result = ste.executeUpdate("Delete from Employee_Info where EMPNAME like '%a'");
			
			if(result>0)
			{
				System.out.println("Data deleted Successfully....");
			}
			else
			{
				System.err.println("Something error");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		RetriveEmployeeInfo obj= new RetriveEmployeeInfo();
		
		 do {
			System.out.println("1.Insert Data into Employee Table");
			System.out.println("2.Retrieve all Employee data.");
			System.out.println("3.Retrieve employee whose name stats with 'S'.");
			System.out.println("4.Retrieve employees whose salary between 10000 to 20000.");
			System.out.println("5.Update employee salary with the help of eid.");
			System.out.println("6.delete employee who is getting maximum salary.");
			System.out.println("7.delete employee whose name ends with 'a'");
			System.out.println("8.Exit.");		
			
			 int choice= sc.nextInt();
			
				switch (choice) 
				{
				case 1: 
					{
						obj.insertdata();
					}
					break;
				case 2:
				{
					obj.retriveData();
				}
				 
					break;
				case 3:
				{
					obj.Statwiths();
				}
					break;
				case 4:
				{
					obj.RetriveSalary();
				}
					break;
				case 5:
				{
					obj.updateSalary();
				}
					break;
				case 6:
				{
					obj.DeleteMaxSalary();
				}
				break;
				
				case 7:{
					obj.Endwitha();
				}
				break;
				case 8:
				{
					return;
				}
				
				default:
					System.out.println("Wrong Input Entered...");
				}
			
		} while (true);
	}

}
