package com.nullhawk.inventory.services;

import com.nullhawk.inventory.exceptions.SupplierNotFoundException;
import com.nullhawk.inventory.models.Supplier;
import com.nullhawk.inventory.repositories.SupplierRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

//    public List<Supplier> getAllSuppliers() {
//        return supplierRepository.findAll();
//    }
//
//    public Supplier getSupplier(Long id) {
//        return supplierRepository.findById(id).orElseThrow(() -> new SupplierNotFoundException("Supplier not found"));
//    }
//
//    public Supplier createSupplier(Supplier supplier) {
//        return supplierRepository.save(supplier);
//    }
//
//    public Supplier updateSupplier(Long id, Supplier supplierDetails) {
//        Supplier supplier = getSupplier(id);
//        supplier.setName(supplierDetails.getName());
//        supplier.setContactInformation(supplierDetails.getContactInformation());
//        supplier.setDescription(supplierDetails.getDescription());
//        return supplierRepository.save(supplier);
//    }
//
//    public void deleteSupplier(Long id) {
//        Supplier supplier = getSupplier(id);
//        supplierRepository.delete(supplier);
//    }

}
