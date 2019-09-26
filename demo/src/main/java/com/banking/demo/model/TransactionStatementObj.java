package com.banking.demo.model;

import java.util.Date;

public class TransactionStatementObj {
	private int transactionid;
	private Date time;
	private String methodType;
	private int payeeId;
	private Double amount;
	public int getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getMethodType() {
		return methodType;
	}
	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}
	public int getPayeeId() {
		return payeeId;
	}
	public void setPayeeId(int payeeId) {
		this.payeeId = payeeId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public TransactionStatementObj(int transactionid, Date time, String methodType, int payeeId, Double amount) {
		this.transactionid = transactionid;
		this.time = time;
		this.methodType = methodType;
		this.payeeId = payeeId;
		this.amount = amount;
	}
	
	
}
