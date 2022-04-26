//program for jdbc 1 :

import java.sql.*;
class firstJdbc
{ 
	public static void main(String arg[])
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
			
			if(con.isClosed())
			{
				System.out.println("Connection is closed");
			}
			else
			{
				System.out.println("Connection is created");
			}
			  
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
