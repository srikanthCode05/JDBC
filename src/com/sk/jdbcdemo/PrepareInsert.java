package com.sk.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepareInsert 
{
	public static void main(String[] args) 
	{
		String url="jdbc:mysql://localhost:3306/School";
		String user="root";
		String pwd="SQLdeveloper@05";
	 try
		{
		 	Class.forName("com.mysql.cj.jdbc.Driver");
		 	Connection con=DriverManager.getConnection(url,user,pwd);
		 	String sql="insert into Student values(?,?,?)";
		 	PreparedStatement statement=con.prepareStatement(sql);
		 	statement.setInt(1, 1);
		 	statement.setString(2, "ronaldo");
		 	statement.setInt(3, 98);
		 	int i=statement.executeUpdate();
		 	if(i>0)
		 	{
		 		System.out.println("updated");
		 	}
		}
	 catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}
