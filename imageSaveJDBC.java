
import java.sql.*;

import java.io.*;

class imageSaveJDBC
{
	public static void main(String argv[])
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtube","root","admin");
			
			String q = "insert into images(pic) values(?)";
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			FileInputStream fis = new FileInputStream("logo.jpg");
			
			pstmt.setBinaryStream(1,fis,fis.available());
			
			pstmt.executeUpdate();
			
			System.out.println("Done...");
			
		}
		catch(Exception e)
		{
			
			System.out.println("Error..!!");
		}
	}
}
		