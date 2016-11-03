package io.hackathon.services;

import java.util.List;

import org.springframework.data.domain.Page;

import io.hackathon.entities.Transaction;

public interface TransactionService {
	
	public List<Transaction> getAllTransactions();
	
	public Page<Transaction> getAllTransactions(int page, int size);
	
	public Transaction getTransactionById(Long id);
	
	public Transaction createTransaction(Transaction review);
	
	public Transaction updateTransaction(Transaction review);
	
	public void deleteTransaction(Long id);

}
