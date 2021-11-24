package com.example.prashant.entity;

public class Account {

	private int accountId;
	private String accountName;
	private String accountPassword;
	private int accountBalance;

	public Account() {
	}

	public Account(String accountName, String accountPassword) {
		this.accountName = accountName;
		this.accountPassword = accountPassword;
	}

	public Account(String accountName, String accountPassword, int accountBalance) {
		this.accountName = accountName;
		this.accountPassword = accountPassword;
		this.accountBalance = accountBalance;
	}

	public Account(int accountId, String accountName, String accountPassword, int accountBalance) {
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountPassword = accountPassword;
		this.accountBalance = accountBalance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", accountPassword="
				+ accountPassword + ", accountBalance=" + accountBalance + "]";
	}

}
