package com.nullhawk.inventory.services;

import com.nullhawk.inventory.enums.UserType;
import com.nullhawk.inventory.exceptions.SupplierNotFoundException;
import com.nullhawk.inventory.exceptions.UnauthorizedAccessExcpetion;
import com.nullhawk.inventory.models.Supplier;
import com.nullhawk.inventory.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class SupplierServiceImp implements SupplierService{
    private static final Logger logger = LoggerFactory.getLogger(SupplierServiceImp.class);

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
    public Supplier createSupplier(UserType user, Supplier supplier) throws UnauthorizedAccessExcpetion {
        logger.info("creating supplier");
        if(user == UserType.ADMIN || user == UserType.MANAGER){
            return supplierRepository.save(supplier);
        }else{
            logger.error("Not authorized to create supplier");
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        }
    }

    @Override
    public Supplier updateSupplier(UserType user, Long id, Supplier supplierDetails) throws UnauthorizedAccessExcpetion {
        logger.info("updating supplier");
        if(user == UserType.ADMIN || user == UserType.MANAGER){
            Supplier supplier = getSupplier(id);
            supplier.setName(supplierDetails.getName());
            supplier.setContactInfo(supplierDetails.getContactInfo());
            supplier.setDescription(supplierDetails.getDescription());
            return supplierRepository.save(supplier);
        }else{
            logger.error("Not authorized to update supplier");
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        }
    }

    @Override
    public void deleteSupplier(UserType user, Long id) throws UnauthorizedAccessExcpetion {
        logger.info("deleting supplier");
        if(user == UserType.ADMIN || user == UserType.MANAGER){
            Supplier supplier = getSupplier(id);
            supplierRepository.delete(supplier);
            logger.info("Supplier deleted");
        }else{
            logger.error("Not authorized to delete supplier");
            throw new UnauthorizedAccessExcpetion("Not authorized to change item name");
        }
    }
}
