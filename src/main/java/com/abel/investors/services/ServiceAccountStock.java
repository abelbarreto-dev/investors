package com.abel.investors.services;

import com.abel.investors.models.AccountStock;
import com.abel.investors.records.AccountStockRecord;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ServiceAccountStock implements IServiceAccountStock {
    @Override
    public ResponseEntity<AccountStock> createAccountStock(AccountStockRecord accountStock) {
        return null;
    }

    @Override
    public ResponseEntity<AccountStock> updateAccountStock(AccountStock accountStock, UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<AccountStock> deleteAccountStock(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<AccountStock> getAccountStockByID(UUID id) {
        return null;
    }
}
