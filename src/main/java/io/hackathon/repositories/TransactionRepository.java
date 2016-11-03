package io.hackathon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.hackathon.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
