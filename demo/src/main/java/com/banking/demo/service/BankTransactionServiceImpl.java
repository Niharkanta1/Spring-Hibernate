package com.banking.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.demo.dao.BankTransactionDao;
import com.banking.demo.entity.TransactionDetail;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {
	@Autowired
	BankTransactionDao bankTransactionDao;
	@Override
	@Transactional
	public TransactionDetail transfer(TransactionDetail detail) {
		
		return bankTransactionDao.transferFund(detail);
	}

}
