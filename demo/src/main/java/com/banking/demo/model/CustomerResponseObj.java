package com.banking.demo.model;

import java.util.Date;

/**
 * @author user
 *
 */
public class CustomerResponseObj {

	private String name;
	private Date lastLogin;
	private Double balance;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	
}
