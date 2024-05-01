package com.nullhawk.inventory.services;

import com.nullhawk.inventory.exceptions.TransactionException;
import com.nullhawk.inventory.models.Transaction;
import com.nullhawk.inventory.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImp implements TransactionService{
    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionServiceImp(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransaction(Long id) {
        return transactionRepository.findById(id).orElseThrow(() -> new TransactionException("Transaction not found"));
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(Long id, Transaction transactionDetails) {
        Transaction transaction = getTransaction(id);
        transaction.setTransactionId(transactionDetails.getTransactionId());
        transaction.setTransactionType(transactionDetails.getTransactionType());
        transaction.setQuantity(transactionDetails.getQuantity());
        transaction.setTransactionDate(transactionDetails.getTransactionDate());
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long id) {
        Transaction transaction = getTransaction(id);
        transactionRepository.delete(transaction);
    }
}
