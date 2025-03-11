package com.abel.investors.controllers;

import com.abel.investors.models.AccountStock;
import com.abel.investors.records.AccountStockRecord;
import com.abel.investors.services.IServiceAccountStock;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/account-stock")
@AllArgsConstructor
public class AccountStockController {
    private final IServiceAccountStock serviceAccountStock;

    @PostMapping("/new")
    public ResponseEntity<AccountStock> createAccountStock(@RequestBody AccountStockRecord accountStock) {
        return this.serviceAccountStock.createAccountStock(accountStock);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AccountStock> updateAccountStock(
            @RequestBody AccountStockRecord accountStock,
            @PathVariable UUID id
    ) {
        return this.serviceAccountStock.updateAccountStock(accountStock, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AccountStock> deleteAccountStock(@PathVariable UUID id) {
        return this.serviceAccountStock.deleteAccountStock(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountStock> getAccountStockByID(@PathVariable UUID id) {
        return this.serviceAccountStock.getAccountStockByID(id);
    }
}
