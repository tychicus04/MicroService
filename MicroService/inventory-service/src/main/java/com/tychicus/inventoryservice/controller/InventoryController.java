package com.tychicus.inventoryservice.controller;

import com.tychicus.inventoryservice.dto.InventoryResponse;
import com.tychicus.inventoryservice.service.inventoryService.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private  final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCodes) {
        log.info("Checking inventory for skuCodes: {}", skuCodes);

        return inventoryService.isInStock(skuCodes);
    }
}
