package com.jdbc.practice;

import java.awt.Image;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Helper {
	public static ImageIcon getImageIconById(int id , Connection con)
	{
		ImageIcon icon = null;
		
		try
		{
			String q = "select piv from images where id=?";
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setInt(1, id);
			ResultSet set = pstmt.executeQuery();
			
			if(set.next())
			{
				Blob b = set.getBlob("pic");
				InputStream is = b.getBinaryStream();
				
				Image image =ImageIO.read(is);
				
				ImageIcon icon = new ImageIcon(image);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return icon;
		
	}

}
