package io.hackathon.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.hackathon.entities.Transaction;
import io.hackathon.services.TransactionService;

@RestController
@RequestMapping(value ="/transactions") 
public class TransactionController {
	
	@Resource
	private TransactionService transactionService;

	@RequestMapping(method = RequestMethod.POST)
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		transaction.setCreatedIn(new Date());
		return this.transactionService.createTransaction(transaction);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Page<Transaction> getPageableTransactions(@Param(value = "page") int page, @Param(value = "size") int size) {
		return this.transactionService.getAllTransactions(page, size);
	}
	
	@RequestMapping(value = "seller/{id}", method = RequestMethod.GET)
	public List<Transaction> getTransactionsBySeller(@PathVariable(value = "id") Long id) {
		List<Transaction> transactions = this.transactionService.getAllTransactions();
		return transactions.stream().filter(transaction -> transaction.getSeller().getId() == id).collect(Collectors.toList());
	}
	
	@RequestMapping(value = "buyer/{id}", method = RequestMethod.GET)
	public List<Transaction> getTransactionsByBuyer(@PathVariable(value = "id") Long id) {
		List<Transaction> transactions = this.transactionService.getAllTransactions();
		return transactions.stream().filter(transaction -> transaction.getBuyer().getId() == id).collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Transaction getTransactionById(@PathVariable(value = "id") Long id) {
		return this.transactionService.getTransactionById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE) 
	public void deleteTransaction(@PathVariable(value = "id") Long id) {
		this.transactionService.deleteTransaction(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Transaction updatePlace(@PathVariable(value = "id") Long id, @RequestBody Transaction transaction) {
		transaction.setId(id);
		transaction.setCreatedIn(new Date());
 		return this.transactionService.updateTransaction(transaction);
 	}
	
// Getter & Setter

	public TransactionService getTransactionService() {
		return transactionService;
	}

	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

}
