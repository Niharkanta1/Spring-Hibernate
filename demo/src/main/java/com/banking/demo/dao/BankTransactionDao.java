package com.banking.demo.dao;

import javax.transaction.Transactional;

import com.banking.demo.entity.TransactionDetail;

public interface BankTransactionDao {

	public TransactionDetail transferFund(TransactionDetail details);
}
