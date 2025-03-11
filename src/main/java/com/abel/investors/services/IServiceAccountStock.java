package com.abel.investors.services;

import com.abel.investors.models.AccountStock;
import com.abel.investors.records.AccountStockRecord;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface IServiceAccountStock {
    public ResponseEntity<AccountStock> createAccountStock(AccountStockRecord accountStock);
    public ResponseEntity<AccountStock> updateAccountStock(AccountStockRecord accountStock, UUID id);
    public ResponseEntity<AccountStock> deleteAccountStock(UUID id);
    public ResponseEntity<AccountStock> getAccountStockByID(UUID id);
}
