package com.nullhawk.inventory.controller;

import com.nullhawk.inventory.dtos.SupplierDto;
import com.nullhawk.inventory.exceptions.UnauthorizedAccessExcpetion;
import com.nullhawk.inventory.models.Supplier;
import com.nullhawk.inventory.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService service;

    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<SupplierDto> getAllSuppliers() {
        List<Supplier> suppliers = this.service.getAllSuppliers();
        List<SupplierDto> supplierDtos = convertToSupplierDtos(suppliers);
        return supplierDtos;
    }

    @GetMapping("/{id}")
    public SupplierDto getSupplier(@PathVariable Long id) {
        Supplier supplier = this.service.getSupplier(id);
        SupplierDto supplierDto = convertToSupplierDto(supplier);
        return supplierDto;
    }

    @PostMapping
    public SupplierDto createSupplier(@RequestBody SupplierDto supplierDto) {
        try {
            Supplier supplier = convertToSupplier(supplierDto);
            Supplier createdSupplier;
            createdSupplier = this.service.createSupplier(supplierDto.getUser(),supplier);
            SupplierDto createdSupplierDto = convertToSupplierDto(createdSupplier);
            return createdSupplierDto;
        } catch (UnauthorizedAccessExcpetion e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unauthorized Access", e);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating item", e);
        }
    }

    @PutMapping("/{id}")
    public SupplierDto updateSupplier(@PathVariable Long id, @RequestBody SupplierDto supplierDto) {
        try {
            Supplier supplier = convertToSupplier(supplierDto);
            Supplier updatedSupplier = this.service.updateSupplier(supplierDto.getUser(), id, supplier);
            return convertToSupplierDto(updatedSupplier);
        } catch (UnauthorizedAccessExcpetion e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unauthorized Access", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating item", e);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable Long id, @RequestBody SupplierDto supplierDto) {
        try{
            this.service.deleteSupplier(supplierDto.getUser(),id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UnauthorizedAccessExcpetion e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unauthorized Access", e);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating item", e);
        }
    }

    private List<SupplierDto> convertToSupplierDtos(List<Supplier> suppliers) {
        List<SupplierDto> supplierDtos = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            SupplierDto supplierDto = convertToSupplierDto(supplier);
            supplierDtos.add(supplierDto);
        }
        return supplierDtos;
    }

    private SupplierDto convertToSupplierDto(Supplier supplier) {
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setId(supplier.getId());
        supplierDto.setName(supplier.getName());
        supplierDto.setContactInfo(supplier.getContactInfo());
        supplierDto.setDescription(supplier.getDescription());
        return supplierDto;
    }

    private Supplier convertToSupplier(SupplierDto supplierDto) {
        Supplier supplier = new Supplier();
        supplier.setName(supplierDto.getName());
        supplier.setContactInfo(supplierDto.getContactInfo());
        supplier.setDescription(supplierDto.getDescription());
        return supplier;
    }

}
