package com.nullhawk.inventory.repositories;

import com.nullhawk.inventory.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction save(Transaction supplier);
}
