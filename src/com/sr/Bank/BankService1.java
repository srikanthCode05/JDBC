package com.sr.Bank;

import java.sql.SQLException;

public class BankService1 
{
	public int penalty(BankDto bank)
	{
		double value=bank.getBalance();
		if(value>0 && value<1000)
		{
			return -25;
		}
		else if(value>1000)
		{
			return +10;
		}
		else
		{
			return 0;
		}
	}
	public double totalAmount(BankDto bank)
	{
		return bank.getBalance()+penalty(bank);
	}
	public String penaltyStatus(BankDto bank)
	{
		double totalAmount=totalAmount(bank);
		if(totalAmount<1000)
		{
			return "Yes";
		}
		else
		{
			return "No";
		}
	}
	public void saveUser(BankDto bank) throws SQLException 
	{
		int penalty=penalty(bank);
		String penaltyStatus=penaltyStatus(bank);
		double totalAmount=totalAmount(bank);
		bank.setPenalty(penalty);
		bank.setPenaltyStatus(penaltyStatus);
		bank.setTotalAmount(totalAmount);
		
		BankDao dao=new BankDao();
		dao.saveUser(bank);
				
	}
}
