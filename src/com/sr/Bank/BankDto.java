package com.sr.Bank;

public class BankDto 
{
	private int id;
	private String name;
	private double balance;
	private long accountNumber;
	private int penalty;
	private String penaltyStatus;
	private double totalAmount;
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getPenalty() {
		return penalty;
	}
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
	public String getPenaltyStatus() {
		return penaltyStatus;
	}
	public void setPenaltyStatus(String penaltyStatus) {
		this.penaltyStatus = penaltyStatus;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "BankDto [id=" + id + ", name=" + name + ", balance=" + balance + ", accountNumber=" + accountNumber
				+ ", penalty=" + penalty + ", penaltyStatus=" + penaltyStatus + ", totalAmount=" + totalAmount + "]";
	}

}
