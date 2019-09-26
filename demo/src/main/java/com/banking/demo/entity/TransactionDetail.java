package com.banking.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="transaction_detail")
public class TransactionDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="tx_id")
	private int id;
	
	@Column(name="tx_date_time")
	private Date date;
	
	@Column(name="tx_type")
	private String type;
	
	@Column(name="tx_amount")
	private double amount;
	
	@OneToOne(mappedBy="transaction")
	@Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Payee payee;
	
	private int payee_id;
	
	@ManyToOne
	@JoinColumn(name="customer_id", nullable=false)
	private Customer customer;
	
	@Column(name="customer_id",  insertable = false, updatable = false)
	private int customerId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Payee getPayee() {
		return payee;
	}
	public void setPayee(Payee payee) {
		this.payee = payee;
	}
	public int getPayee_id() {
		return payee_id;
	}
	public void setPayee_id(int payee_id) {
		this.payee_id = payee_id;
	}
	
	public TransactionDetail(){}
	
	public TransactionDetail(Date date, String method, double amount) {
		this.date = date;
		this.type = method;
		this.amount = amount;
	}
		
}
