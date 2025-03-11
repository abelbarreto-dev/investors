package com.abel.investors.services;

import com.abel.investors.exceptions.AccountStockException;
import com.abel.investors.models.AccountStock;
import com.abel.investors.records.AccountStockRecord;
import com.abel.investors.repositories.AccountStockRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ServiceAccountStock implements IServiceAccountStock {
    private final AccountStockRepository accountStockRepository;

    @Override
    public ResponseEntity<AccountStock> createAccountStock(AccountStockRecord accountStock) {
        AccountStock accStock = this.parseAccountStockRecordToAccountStock(accountStock);

        AccountStock newAccStock = this.accountStockRepository.save(accStock);

        return ResponseEntity.ok().body(newAccStock);
    }

    @Override
    public ResponseEntity<AccountStock> updateAccountStock(AccountStockRecord accountStock, UUID id) {
        AccountStock accStock = this.accountStockRepository.findById(id).orElse(null);

        if (accStock == null) {
            throw new AccountStockException("Account Stock Not Found For Update", 404);
        }

        accStock.setAccount(accountStock.account());
        accStock.setStock(accountStock.stock());

        AccountStock updateAccStock = this.accountStockRepository.save(accStock);

        return ResponseEntity.ok().body(updateAccStock);
    }

    @Override
    public ResponseEntity<AccountStock> deleteAccountStock(UUID id) {
        AccountStock accStock = this.accountStockRepository.findById(id).orElse(null);

        if (accStock == null) {
            throw new AccountStockException("Account Stock Not Found For Delete", 404);
        }

        this.accountStockRepository.delete(accStock);

        return ResponseEntity.ok().body(accStock);
    }

    @Override
    public ResponseEntity<AccountStock> getAccountStockByID(UUID id) {
        AccountStock accStock = this.accountStockRepository.findById(id).orElse(null);

        if (accStock == null) {
            throw new AccountStockException("Account Stock Not Found", 404);
        }

        return ResponseEntity.ok().body(accStock);
    }

    protected AccountStock parseAccountStockRecordToAccountStock(AccountStockRecord accountStockRecord) {
        AccountStock accountStock = new AccountStock();

        accountStock.setAccount(accountStockRecord.account());
        accountStock.setStock(accountStockRecord.stock());

        return accountStock;
    }
}
