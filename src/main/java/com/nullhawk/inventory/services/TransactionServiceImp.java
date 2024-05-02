package com.nullhawk.inventory.services;

import com.nullhawk.inventory.enums.UserType;
import com.nullhawk.inventory.exceptions.TransactionException;
import com.nullhawk.inventory.exceptions.UnauthorizedAccessExcpetion;
import com.nullhawk.inventory.models.Transaction;
import com.nullhawk.inventory.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class TransactionServiceImp implements TransactionService{
    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImp.class);

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
        logger.info("creating transaction");
        if(user == UserType.ADMIN || user == UserType.MANAGER){
            return transactionRepository.save(transaction);
        }else{
            logger.error("Not authorized to create transaction");
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        }
    }

    @Override
    public Transaction updateTransaction(UserType user,Long id, Transaction transactionDetails) throws UnauthorizedAccessExcpetion {
        logger.info("updating transaction");
        if(user == UserType.ADMIN || user == UserType.MANAGER){
            Transaction transaction = getTransaction(id);
            transaction.setId(transactionDetails.getId());
            transaction.setTransactionType(transactionDetails.getTransactionType());
            transaction.setAmount(transactionDetails.getAmount());
            transaction.setDate(transactionDetails.getDate());
            return transactionRepository.save(transaction);
        }else{
            logger.error("Not authorized to update transaction");
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        } 
    }

    @Override
    public void deleteTransaction(UserType user, Long id) throws UnauthorizedAccessExcpetion {
        logger.info("deleting transaction");
        if(user == UserType.ADMIN || user == UserType.MANAGER){
            Transaction transaction = getTransaction(id);
            transactionRepository.delete(transaction);
            logger.info("Transaction deleted");
        }else{
            logger.error("Not authorized to delete transaction");
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        }
    }
}
