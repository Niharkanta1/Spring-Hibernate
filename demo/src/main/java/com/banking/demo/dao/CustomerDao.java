package com.banking.demo.dao;


import java.util.List;

import com.banking.demo.entity.Customer;
import com.banking.demo.entity.Payee;
import com.banking.demo.entity.TransactionDetail;

public interface CustomerDao {

	public Customer getCustomer(int id);

	public boolean addPayee(Payee payee);

	public boolean addPayee(Payee payee, int customer_id);

	public List getTransactionDetails(int id);
}
