package com.qj.jdbcstudent;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetMeta 
{
	String url="jdbc:mysql://localhost:3306/school_project";
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
//		Connection con=DriverManager.getConnection(url,user,pwd);
		return DriverManager.getConnection(url,user,pwd);
	}
	public void resultSetMetaData() throws SQLException
	{
		Connection con=getConnection();
		String sql="call getAllStudents";
		CallableStatement cs=con.prepareCall(sql);
		ResultSet set=cs.executeQuery();
		ResultSetMetaData rm=set.getMetaData();
		System.out.println(rm.getColumnCount());
		System.out.println(rm.getColumnName(3));
		System.out.println(rm.getColumnTypeName(2));
		System.out.println(rm.getColumnType(2));
		System.out.println(rm.getPrecision(3));
		
	}

}
