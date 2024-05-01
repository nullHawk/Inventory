package com.nullhawk.inventory.services;

import com.nullhawk.inventory.exceptions.SupplierNotFoundException;
import com.nullhawk.inventory.models.Supplier;
import com.nullhawk.inventory.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImp implements SupplierService{
    @Autowired
    private SupplierRepository supplierRepository;

    public SupplierServiceImp(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier getSupplier(Long id) {
        return supplierRepository.findById(id).orElseThrow(() -> new SupplierNotFoundException("Supplier not found"));
    }

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier updateSupplier(Long id, Supplier supplierDetails) {
        Supplier supplier = getSupplier(id);
        supplier.setName(supplierDetails.getName());
        supplier.setContactInformation(supplierDetails.getContactInformation());
        supplier.setDescription(supplierDetails.getDescription());
        return supplierRepository.save(supplier);
    }

    @Override
    public void deleteSupplier(Long id) {
        Supplier supplier = getSupplier(id);
        supplierRepository.delete(supplier);
    }

}
