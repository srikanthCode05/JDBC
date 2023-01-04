package com.sr.Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultsetMetaData 
{
	String url="jdbc:mysql://localhost:3306/bank_project";
	String user="root";
	String pwd="SQLdeveloper@05";
	static {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
}
	
	public Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(url,user,pwd);
	}
	
	public void resultSetMetaData() throws SQLException
	{
		Connection con=getConnection();
		String sql="select * from axis_bank";
		PreparedStatement prepareStatement=con.prepareStatement(sql);
		ResultSet set=prepareStatement.executeQuery();
		ResultSetMetaData rmd=set.getMetaData();
		System.out.println(rmd.getColumnCount());
		System.out.println(rmd.getColumnName(2));
		System.out.println(rmd.getColumnLabel(3));
		System.out.println(rmd.getColumnType(2));
		System.out.println(rmd.getColumnTypeName(2));
	}


}

