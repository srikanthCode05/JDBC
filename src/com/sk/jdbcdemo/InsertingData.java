package com.sk.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertingData 
{
	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/School","root","SQLdeveloper@05");
			Statement statement=con.createStatement();
			int i=statement.executeUpdate("insert into Student values(5,'james',87)");
			System.out.println(i);
			if(i>=0)
			{
				System.out.println("data inserted");
			}
			else
			{
				System.out.println("not inserted");
			}
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}
