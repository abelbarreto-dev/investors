package com.abel.investors.services;

import com.abel.investors.models.Account;
import com.abel.investors.records.AccountRecord;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface IServiceAccount {
    public ResponseEntity<Account> createAccount(AccountRecord account);
    public ResponseEntity<Account> updateAccount(AccountRecord account);
    public ResponseEntity<Account> deleteAccount(UUID id);
    public ResponseEntity<Account> getAccountByID(UUID id);
    public ResponseEntity<List<Account>> findAllAccounts();
}
