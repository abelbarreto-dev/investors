package com.abel.investors.controllers;

import com.abel.investors.models.Account;
import com.abel.investors.records.AccountRecord;
import com.abel.investors.services.IServiceAccount;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/account")
@AllArgsConstructor
public class AccountController {
    private final IServiceAccount serviceAccount;

    @PostMapping("/new")
    public ResponseEntity<Account> createAccount(@RequestBody AccountRecord account) {
        return serviceAccount.createAccount(account);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Account> updateAccount(@RequestBody AccountRecord account, @PathVariable UUID id) {
        return serviceAccount.updateAccount(account, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable UUID id) {
        return serviceAccount.deleteAccount(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountByID(UUID id) {
        return serviceAccount.getAccountByID(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> findAllAccounts() {
        return serviceAccount.findAllAccounts();
    }
}
