package com.sk.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreation
{

	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/School","root","SQLdeveloper@05");
			Statement statement=con.createStatement();
			int i=statement.executeUpdate("create table Student(id integer,name varchar(40),marks integer)");
			if(i>=0)
			{
				System.out.println("Table Created");
			}
			else
			{
				System.out.println("Not Created");
			}
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
}
