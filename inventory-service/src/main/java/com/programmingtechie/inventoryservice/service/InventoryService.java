package com.programmingtechie.inventoryservice.service;

import com.programmingtechie.inventoryservice.repository.InventoryRepositary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepositary inventoryRepositary;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode){
        return inventoryRepositary.findBySkuCode(skuCode).isPresent();
    }
}
