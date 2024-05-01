package com.nullhawk.inventory.repositories;

import com.nullhawk.inventory.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.JavaBean;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {
}
