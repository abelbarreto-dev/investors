package com.abel.investors.services;

import com.abel.investors.exceptions.AccountNotFoundException;
import com.abel.investors.models.Account;
import com.abel.investors.records.AccountRecord;
import com.abel.investors.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ServiceAccount implements IServiceAccount{
    private final AccountRepository accountRepository;

    @Override
    public ResponseEntity<Account> createAccount(AccountRecord account) {
        Account accountNew = this.parseAccountRecordToAccount(account);

        Account accountSaved = this.accountRepository.save(accountNew);

        return ResponseEntity.ok(accountSaved);
    }

    @Override
    public ResponseEntity<Account> updateAccount(AccountRecord account, UUID id) {
        Account accountToUpdate = this.accountRepository.findById(id).orElseThrow(AccountNotFoundException::new);

        accountToUpdate.setUser(account.user());
        accountToUpdate.setAccountStock(account.accountStock());
        accountToUpdate.setDescription(account.description());

        Account accountUpdated = this.accountRepository.save(accountToUpdate);

        return ResponseEntity.ok(accountUpdated);
    }

    @Override
    public ResponseEntity<Account> deleteAccount(UUID id) {
        Account account = this.accountRepository.findById(id).orElseThrow(AccountNotFoundException::new);

        this.accountRepository.delete(account);

        return ResponseEntity.ok(account);
    }

    @Override
    public ResponseEntity<Account> getAccountByID(UUID id) {
        Account account = this.accountRepository.findById(id).orElseThrow(AccountNotFoundException::new);

        return ResponseEntity.ok(account);
    }

    @Override
    public ResponseEntity<List<Account>> findAllAccounts() {
        List<Account> accounts = this.accountRepository.findAll();

        return ResponseEntity.ok(accounts);
    }

    protected Account parseAccountRecordToAccount(AccountRecord accountRecord) {
        Account account = new Account();

        account.setUser(accountRecord.user());
        account.setAccountStock(accountRecord.accountStock());
        account.setDescription(accountRecord.description());

        return account;
    }
}
