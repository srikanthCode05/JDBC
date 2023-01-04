package com.sk.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrieveById 
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
		String sql="select * from Student";
		Statement statement=con.createStatement();
		
		ResultSet rs=statement.executeQuery(sql);		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		}
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	 }
}

