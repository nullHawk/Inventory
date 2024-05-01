package com.nullhawk.inventory.services;

import com.nullhawk.inventory.models.Transaction;

import java.util.List;

public interface TransactionService {
    public List<Transaction> getAllTransactions();
    public Transaction getTransaction(Long id);
    public Transaction createTransaction(Transaction transaction);
    public Transaction updateTransaction(Long id, Transaction transactionDetails);
    public void deleteTransaction(Long id);
}
