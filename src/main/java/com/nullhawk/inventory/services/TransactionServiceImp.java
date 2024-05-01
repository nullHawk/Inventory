package com.nullhawk.inventory.services;

import com.nullhawk.inventory.enums.UserType;
import com.nullhawk.inventory.exceptions.TransactionException;
import com.nullhawk.inventory.exceptions.UnauthorizedAccessExcpetion;
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
    public Transaction createTransaction(UserType user,Transaction transaction) throws UnauthorizedAccessExcpetion {
        if(user == UserType.ADMIN || user == UserType.MANAGER){
            return transactionRepository.save(transaction);
        }else{
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        }
    }

    @Override
    public Transaction updateTransaction(UserType user,Long id, Transaction transactionDetails) throws UnauthorizedAccessExcpetion {
        if(user == UserType.ADMIN || user == UserType.MANAGER){
            Transaction transaction = getTransaction(id);
            transaction.setId(transactionDetails.getId());
            transaction.setTransactionType(transactionDetails.getTransactionType());
            transaction.setAmount(transactionDetails.getAmount());
            transaction.setDate(transactionDetails.getDate());
            return transactionRepository.save(transaction);
        }else{
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        } 
    }

    @Override
    public void deleteTransaction(UserType user, Long id) throws UnauthorizedAccessExcpetion {
        if(user == UserType.ADMIN || user == UserType.MANAGER){
            Transaction transaction = getTransaction(id);
            transactionRepository.delete(transaction);
        }else{
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        }
    }
}
