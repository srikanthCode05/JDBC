package com.sr.Bank;

public class NotEnoughFundsException extends Exception
{
	NotEnoughFundsException(String str)
	{
		super(str);
	}
}
