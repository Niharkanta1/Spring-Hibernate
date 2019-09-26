package com.banking.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	@Column(name="name")
	private String name;
	
	@Column(name="last_login")
	private Date lastLogin;
	
	@Column(name="balance")
	private double balance;
	
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private List<Payee> payee;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public List<Payee> getPayee() {
		return payee;
	}
	public void setPayee(List<Payee> payee) {
		this.payee = payee;
	}
	public Customer() {}
	public Customer(String name, Date lastLogin, double balance) {
		this.name = name;
		this.lastLogin = lastLogin;
		this.balance = balance;
	}
	
	public Customer(int id, String password, String name, Date lastLogin, double balance) {
		this.id = id;
		this.name = name;
		this.lastLogin = lastLogin;
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", lastLogin=" + lastLogin + ", balance=" + balance + "]";
	}
	
	public void addPayee(String name, String nickname, String accountno, String ifsc){
		this.payee.add(new Payee(name, nickname, accountno, ifsc));
	}
	
	public void addPayee(Payee payee){
		this.payee.add(payee);
	}
}
