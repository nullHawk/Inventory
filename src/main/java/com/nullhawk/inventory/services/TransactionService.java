package com.nullhawk.inventory.services;


import com.nullhawk.inventory.enums.UserType;
import com.nullhawk.inventory.exceptions.UnauthorizedAccessExcpetion;
import com.nullhawk.inventory.models.Transaction;
import java.util.List;

public interface TransactionService {
    public List<Transaction> getAllTransactions();
    public Transaction getTransaction(Long id);
    public Transaction createTransaction(UserType user, Transaction transaction) throws UnauthorizedAccessExcpetion;
    public Transaction updateTransaction(UserType user, Long id, Transaction transactionDetails) throws UnauthorizedAccessExcpetion;
    public void deleteTransaction(UserType user, Long id)throws UnauthorizedAccessExcpetion;
}