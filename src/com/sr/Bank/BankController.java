package com.sr.Bank;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BankController
{
	public static void main(String[] args) throws Exception
	{	
		BankDto dto=new BankDto();
		dto.setId(3);
		dto.setName("Rahul");
		dto.setAccountNumber(1212442774);
		dto.setBalance(1200); 
		
		BankService service=new BankService();
//		System.out.println(service.getUserById(2));
		service.updateUser(3, dto);
		
//		BankDao dao=new BankDao();
//		System.out.println(dao.deleteUserById(4));
		
//		ArrayList<BankDto> users=dao.getAllUsers();
//		System.out.println(users);
//		dao.deleteUserById(1);
		
		
	}
}
