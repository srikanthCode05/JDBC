package com.sr.Bank;

import java.sql.SQLException;
import java.util.ArrayList;

public class BankService
{
	BankDao dao=new BankDao();
	public	int penalty(BankDto bank) throws NotEnoughFundsException
	{
		if(bank.getBalance()>=25 && bank.getBalance()<1000)
		{	
			return -25;
		}
		else if(bank.getBalance()>1000)
		{
			return +10;
		}
		else if(bank.getBalance()==1000)
		{
			return 0;
		}
		else
		{
			 throw new NotEnoughFundsException("Not enough funds to deduct");
		}
	}
	public Double totalAmount(BankDto bank) throws Exception
	{
		 double totalAmount = bank.getBalance()+penalty(bank);
		 return totalAmount;
	}
	public String penaltyStatus(BankDto bank) throws Exception
	{
		if(totalAmount(bank)<1000)
		{
			return "YES";
		}
		else
		{
			return "NO";
		}
	}
	public void saveUser(BankDto bank) throws Exception
	{
		int penalty=penalty(bank);
		String penaltyStatus=penaltyStatus(bank);
		Double totalAmount=totalAmount(bank);
		bank.setPenalty(penalty);
		bank.setPenaltyStatus(penaltyStatus);
		bank.setTotalAmount(totalAmount);
		dao.saveUser(bank);
	}
	public void updateUser(int id,BankDto bank) throws Exception
	{
		int penalty=penalty(bank);
		String penaltyStatus=penaltyStatus(bank);
		Double totalAmount=totalAmount(bank);
		bank.setPenalty(penalty);
		bank.setPenaltyStatus(penaltyStatus);
		bank.setTotalAmount(totalAmount);
		dao.updateUser(id,bank);
	}
	public ArrayList<BankDto> getAllUsers() throws SQLException
	{
		return dao.getAllUsers();
	}
	public BankDto getUserById(int id) throws SQLException
	{
		return dao.getUserById(id);
	}
}
