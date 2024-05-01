package com.nullhawk.inventory.repositories;

import com.nullhawk.inventory.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
