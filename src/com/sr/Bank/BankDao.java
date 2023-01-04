package com.sr.Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.qj.jdbcstudent.StudentDto;

public class BankDao 
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
	
	public void saveUser(BankDto bank) throws SQLException
	{
		Connection con=getConnection();
		String sql="insert into axis_bank values(?,?,?,?,?,?,?)";
		PreparedStatement prepareStatement=con.prepareStatement(sql);
		prepareStatement.setInt(1, bank.getId());
        prepareStatement.setString(2,bank.getName());
        prepareStatement.setDouble(3, bank.getBalance());
        prepareStatement.setLong(4, bank.getAccountNumber());
        prepareStatement.setInt(5, bank.getPenalty());
        prepareStatement.setString(6, bank.getPenaltyStatus());
        prepareStatement.setDouble(7, bank.getTotalAmount());
        int i=prepareStatement.executeUpdate();
        if(i>0)
        {
        	System.out.println("The Account holder details with Id "+bank.getId()+" is saved successfully");
        }
    }
	public void updateUser(int id,BankDto bank) throws SQLException
	{
		Connection con=getConnection();
		String sql="update axis_bank set name=?,balance=?,account_number=?,penalty=?,penalty_status=?,total_amount=? where id=?";
		
		PreparedStatement prepareStatement=con.prepareStatement(sql);
		
		prepareStatement.setString(1,bank.getName());
		prepareStatement.setDouble(2, bank.getBalance());
		prepareStatement.setLong(3, bank.getAccountNumber());
		prepareStatement.setInt(4, bank.getPenalty());
		prepareStatement.setString(5, bank.getPenaltyStatus());
		prepareStatement.setDouble(6, bank.getTotalAmount());
		prepareStatement.setInt(7, bank.getId());
		
		int i=prepareStatement.executeUpdate();
		if(i>0)
		{
			System.out.println("the axis bank with id "+bank.getId()+" is updated successfully");
		}
		else
		{
			System.out.println("axis bank is not updated");
		}
	}
	public void deleteAll() throws SQLException
	{
		Connection con=getConnection();
		String sql="delete from axis_bank";
		PreparedStatement prepareStatement=con.prepareStatement(sql);
		int i=prepareStatement.executeUpdate();
		if (i>0)
		{
			System.out.println("all the data has been deleted");
		}
		else
		{
			System.out.println("No data is to be deleted");
		}
	}
	public ArrayList<BankDto> getAllUsers() throws SQLException
	{
		ArrayList<BankDto> users=new ArrayList<BankDto>();
		Connection con=getConnection();
		String sql="select * from axis_bank";
		PreparedStatement preparedStatement=con.prepareStatement(sql);
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			BankDto user=new BankDto();
			user.setId(resultSet.getInt(1));
			user.setName(resultSet.getString(2));
			user.setBalance(resultSet.getDouble(3));
			user.setAccountNumber(resultSet.getLong(4));
			user.setPenalty(resultSet.getInt(5));
			user.setPenaltyStatus(resultSet.getString(6));
			user.setTotalAmount(resultSet.getDouble(7));
			users.add(user);			
		}
		return users;
	}
	
	public BankDto getUserById(int id) throws SQLException
	{
		Connection con=getConnection();
		String sql="select * from axis_bank where id=?";
		PreparedStatement prepareStatement=con.prepareStatement(sql);
		prepareStatement.setInt(1,id);
		ResultSet resultSet=prepareStatement.executeQuery();
		if(resultSet.next())
		{
			BankDto user=new BankDto();
			user.setId(resultSet.getInt(1));
			user.setName(resultSet.getString(2));
			user.setBalance(resultSet.getDouble(3));
			user.setAccountNumber(resultSet.getLong(4));
			user.setPenalty(resultSet.getInt(5));
			user.setPenaltyStatus(resultSet.getString(6));
			user.setTotalAmount(resultSet.getDouble(7));
			return user;			
		}
		else
		{
			return null;
		}
	}
	
	public boolean deleteUserById(int id) throws SQLException
	{
		Connection con=getConnection();
		String sql="delete from axis_bank where id=?";
		
		PreparedStatement prepareStatement=con.prepareStatement(sql);
		prepareStatement.setInt(1,id);
		int i=prepareStatement.executeUpdate();
		if(i>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
