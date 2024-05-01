package com.nullhawk.inventory.services;

import com.nullhawk.inventory.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

//    public List<Transaction> getAllTransactions() {
//        return transactionRepository.findAll();
//    }
//
//    public Transaction getTransaction(Long id) {
//        return transactionRepository.findById(id).orElseThrow(() -> new TransactionException("Transaction not found"));
//    }
//
//    public Transaction createTransaction(Transaction transaction) {
//        return transactionRepository.save(transaction);
//    }
//
//    public Transaction updateTransaction(Long id, Transaction transactionDetails) {
//        Transaction transaction = getTransaction(id);
//        transaction.setItemId(transactionDetails.getItemId());
//        transaction.setTransactionType(transactionDetails.getTransactionType());
//        transaction.setQuantity(transactionDetails.getQuantity());
//        transaction.setTransactionDate(transactionDetails.getTransactionDate());
//        return transactionRepository.save(transaction);
//    }
//
//    public void deleteTransaction(Long id) {
//        Transaction transaction = getTransaction(id);
//        transactionRepository.delete(transaction);
//    }
}
