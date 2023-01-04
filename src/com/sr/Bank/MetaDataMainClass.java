package com.sr.Bank;

import java.sql.SQLException;

public class MetaDataMainClass
{
	public static void main(String[] args) throws SQLException 
	{
		ResultsetMetaData rmd=new ResultsetMetaData();
		rmd.resultSetMetaData();
	}
}
