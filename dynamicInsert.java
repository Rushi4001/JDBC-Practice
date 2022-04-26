//prepared statement:insert

import java.sql.*;
import java.io.*;

class dynamicInsert
{
	public static void main(String args[])
	{
		try
		{
			//Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			  
			//creating a connection 
			
			String url = "jdbc:mysql://localhost:3306/youtube";
			
			String username= "root";
			
			String password="admin";
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			//create  a query
			
			String q = "insert into table1(tName , tCity) values(?,?)";
			
			// get the prepared statemnt object
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Name :");
			String name = br.readLine();
			
			System.out.println("Enter City :");
			String city = br.readLine();
			
			
			//set value to query
			
			pstmt.setString(1,name);
			
			pstmt.setString(2,city);
			
			pstmt.executeUpdate();
			
			System.out.println("Inserted...");
			
			con.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
}