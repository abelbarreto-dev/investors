package com.abel.investors.services;

import com.abel.investors.models.Account;
import com.abel.investors.records.AccountRecord;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ServiceAccount implements IServiceAccount{
    @Override
    public ResponseEntity<Account> createAccount(AccountRecord account) {
        return null;
    }

    @Override
    public ResponseEntity<Account> updateAccount(AccountRecord account) {
        return null;
    }

    @Override
    public ResponseEntity<Account> deleteAccount(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<Account> getAccountByID(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Account>> findAllAccounts() {
        return null;
    }
}
