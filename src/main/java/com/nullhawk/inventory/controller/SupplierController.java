package com.nullhawk.inventory.controller;

import com.nullhawk.inventory.services.SupplierServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierServiceImp service;

    public SupplierController(SupplierServiceImp service) {
        this.service = service;
    }

//    @GetMapping("/")
//    public List<Supplier> getAllSuppliers() {
//        return SupplierService.getAllSuppliers();
//    }

//    @GetMapping("/{id}")
//    public Supplier getSupplier(@PathVariable Long id) {
//        return SupplierService.getSupplier(id);
//    }

//    @PostMapping
//    public Supplier createSupplier(@RequestBody Supplier supplier) {
//        return supplierService.createSupplier(supplier);
//    }
//
//    @PutMapping("/{id}")
//    public Supplier updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
//        return SupplierService.updateSupplier(id, supplier);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteSupplier(@PathVariable Long id) {
//        SupplierService.deleteSupplier(id);
//    }

}
