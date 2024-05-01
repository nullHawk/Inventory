package com.nullhawk.inventory.controller;

import com.nullhawk.inventory.models.Transaction;
import com.nullhawk.inventory.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

//    @GetMapping("/)
//    public List<Transaction> getAllTransactions() {
//        return TransactionService.getAllTransactions();
//    }
//
//    @GetMapping("/{id}")
//    public Transaction getTransaction(@PathVariable Long id) {
//        return TransactionService.getTransaction(id);
//    }
//
//    @PostMapping
//    public Transaction createTransaction(@RequestBody Transaction transaction) {
//        return TransactionService.createTransaction(transaction);
//    }
//
//    @PutMapping("/{id}")
//    public Transaction updateTransaction(@PathVariable Long id, @RequestBody Transaction transaction) {
//        return TransactionService.updateTransaction(id, transaction);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteTransaction(@PathVariable Long id) {
//        TransactionService.deleteTransaction(id);
//    }
}
