package com.nullhawk.inventory.controller;

import com.nullhawk.inventory.services.TransactionServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.nullhawk.inventory.dtos.TransactionDto;
import com.nullhawk.inventory.exceptions.UnauthorizedAccessExcpetion;
import com.nullhawk.inventory.models.*;
import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionServiceImp TransactionService;

    public TransactionController(TransactionServiceImp service) {
        this.TransactionService = service;
    }

   @GetMapping("/")
    public List<TransactionDto> getAllTransactions() {
        List<Transaction> transactions = this.TransactionService.getAllTransactions();
        List<TransactionDto> transactionDtos = convertToTransactionDtos(transactions);
        return transactionDtos;
    }

   @GetMapping("/{id}")
   public TransactionDto getTransaction(@PathVariable Long id) {
        Transaction transaction = this.TransactionService.getTransaction(id);
        TransactionDto transactionDto = convertToTransactionDto(transaction);
        return transactionDto;
   }

   @PostMapping
   public TransactionDto createTransaction(@RequestBody TransactionDto transactionDto) {
        try {
            Transaction transaction = convertToTransaction(transactionDto);
            Transaction createdTransaction;
            createdTransaction = this.TransactionService.createTransaction(transactionDto.getUser(),transaction);
            TransactionDto createdTransactionDto = convertToTransactionDto(createdTransaction);
            return createdTransactionDto;
        } catch (UnauthorizedAccessExcpetion e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unauthorized Access", e);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating item", e);
        }
   }

   @PutMapping("/{id}")
   public TransactionDto updateTransaction(@PathVariable Long id, @RequestBody TransactionDto transactionDto) {
    try {
        Transaction transaction = convertToTransaction(transactionDto);
        Transaction updatedTransaction = this.TransactionService.updateTransaction(transactionDto.getUser(),id, transaction);
        return convertToTransactionDto(updatedTransaction);
    } catch (UnauthorizedAccessExcpetion e) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unauthorized Access", e);
    } catch (Exception e){
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating item", e);
    }
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteTransaction(@PathVariable Long id, @RequestBody TransactionDto transactionDto) {
        try{
            this.TransactionService.deleteTransaction(transactionDto.getUser(),id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UnauthorizedAccessExcpetion e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unauthorized Access", e);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating item", e);
        }
   }

   private Transaction convertToTransaction(TransactionDto transactionDto) {
    Transaction transaction = new Transaction(transactionDto.getItem(), transactionDto.getTransactionType(), transactionDto.getAmount(),transactionDto.getDate());
    transaction.setId(transactionDto.getId());
    transaction.setItem(transactionDto.getItem());
    transaction.setTransactionType(transactionDto.getTransactionType());
    transaction.setAmount(transactionDto.getAmount());
    transaction.setDate(transactionDto.getDate());
    return transaction;
}

private TransactionDto convertToTransactionDto(Transaction transaction) {
    TransactionDto transactionDto = new TransactionDto();
    transactionDto.setId(transaction.getId());
    transactionDto.setItem(transaction.getItem());
    transactionDto.setTransactionType(transaction.getTransactionType());
    transactionDto.setAmount(transaction.getAmount());
    transactionDto.setDate(transaction.getDate());
    return transactionDto;
}
private List<TransactionDto> convertToTransactionDtos(List<Transaction> transactions) {
    List<TransactionDto> transactonDtos = new ArrayList<>();
    for (Transaction transaction : transactions) {
        TransactionDto transactionDto = convertToTransactionDto(transaction);
        transactonDtos.add(transactionDto);
    }
    return transactonDtos;
}
}
