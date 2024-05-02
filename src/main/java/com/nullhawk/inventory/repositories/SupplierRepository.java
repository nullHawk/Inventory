package com.nullhawk.inventory.repositories;

import com.nullhawk.inventory.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    Supplier save(Supplier supplier);
}
