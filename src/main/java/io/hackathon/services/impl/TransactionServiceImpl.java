package io.hackathon.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import io.hackathon.entities.Transaction;
import io.hackathon.repositories.TransactionRepository;
import io.hackathon.services.TransactionService;

@Service(value = "transactionService")
public class TransactionServiceImpl implements TransactionService {
	
	@Resource
	private TransactionRepository transactionRepository;

	@Override
	public List<Transaction> getAllTransactions() {
		return this.transactionRepository.findAll();
	}

	@Override
	public Page<Transaction> getAllTransactions(int page, int size) {
		return this.transactionRepository.findAll(new PageRequest(page, size));
	}


	@Override
	public Transaction getTransactionById(Long id) {
		return this.transactionRepository.findOne(id);
	}

	@Override
	public Transaction createTransaction(Transaction transaction) {
		return this.transactionRepository.save(transaction);
	}

	@Override
	public Transaction updateTransaction(Transaction transaction) {
		return this.transactionRepository.save(transaction);
	}

	@Override
	public void deleteTransaction(Long id) {
		this.transactionRepository.delete(id);
		
	}
	
//	Getter & Setter
	
	public TransactionRepository getTransactionRepository() {
		return transactionRepository;
	}

	public void setTransactionRepository(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}


}
