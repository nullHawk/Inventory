package com.nullhawk.inventory.services;


import com.nullhawk.inventory.enums.UserType;
import com.nullhawk.inventory.exceptions.UnauthorizedAccessExcpetion;
import com.nullhawk.inventory.models.Supplier;

import java.util.List;

public interface SupplierService {
    public List<Supplier> getAllSuppliers();
    public Supplier getSupplier(Long id);
    public Supplier createSupplier(UserType user, Supplier supplier) throws UnauthorizedAccessExcpetion;
    public Supplier updateSupplier(UserType user, Long id, Supplier supplierDetails) throws UnauthorizedAccessExcpetion;
    public void deleteSupplier(UserType user, Long id) throws  UnauthorizedAccessExcpetion;
}
