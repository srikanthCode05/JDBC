package com.sk.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/School","root","SQLdeveloper@05");
			Statement statement=con.createStatement();
			int i=statement.executeUpdate("Delete from Student where id=1");
			
			if(i>=0)
			{
				System.out.println("data deleted");
			}
			else
			{
				System.out.println("Not deleted");
			}
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}
