package com.qj.jdbcstudent;

import java.sql.SQLException;

public class metaDataMainClass 
{
	public static void main(String[] args) throws SQLException 
	{
		ResultSetMeta rsmd=new ResultSetMeta();
		rsmd.resultSetMetaData();
	}
}
