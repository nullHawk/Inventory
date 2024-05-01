package com.nullhawk.inventory.services;

import com.nullhawk.inventory.models.Supplier;

import java.util.List;

public interface SupplierService {
    public List<Supplier> getAllSuppliers();
    public Supplier getSupplier(Long id);
    public Supplier createSupplier(Supplier supplier);
    public Supplier updateSupplier(Long id, Supplier supplierDetails);
    public void deleteSupplier(Long id);
}
