package com.abel.investors.services;

import com.abel.investors.exceptions.AccountNotFoundException;
import com.abel.investors.exceptions.BillingAddressException;
import com.abel.investors.models.Account;
import com.abel.investors.models.BillingAddress;
import com.abel.investors.records.BillingAddressRecord;
import com.abel.investors.repositories.AccountRepository;
import com.abel.investors.repositories.BillingAddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ServiceBillingAddress implements IServiceBillingAddress {
    private final BillingAddressRepository billingAddressRepository;
    private final AccountRepository accountRepository;

    @Override
    public ResponseEntity<BillingAddress> createBillingAddress(BillingAddressRecord billingAddress) {
        BillingAddress billing = this.parseBillingAddressRecordToBillingAddress(billingAddress);

        BillingAddress saved = this.billingAddressRepository.save(billing);

        return ResponseEntity.ok().body(saved);
    }

    @Override
    public ResponseEntity<BillingAddress> updateBillingAddress(BillingAddressRecord billingAddress, UUID id) {
        BillingAddress billing = this.billingAddressRepository.findById(id).orElseThrow(BillingAddressException::new);

        billing.setAccount(billingAddress.account());
        billing.setStreet(billingAddress.street());
        billing.setNumber(billingAddress.number());

        BillingAddress updated = this.billingAddressRepository.save(billing);

        return ResponseEntity.ok().body(updated);
    }

    @Override
    public ResponseEntity<BillingAddress> deleteBillingAddressByID(UUID id) {
        BillingAddress deleted = this.billingAddressRepository.findById(id).orElseThrow(BillingAddressException::new);

        this.billingAddressRepository.delete(deleted);

        return ResponseEntity.ok().body(deleted);
    }

    @Override
    public ResponseEntity<BillingAddress> getBillingAddressByID(UUID id) {
        BillingAddress found = this.billingAddressRepository.findById(id).orElseThrow(BillingAddressException::new);

        return ResponseEntity.ok().body(found);
    }

    @Override
    public ResponseEntity<List<BillingAddress>> getBillingsAddressesByAccountID(UUID accountId) {
        Account account = this.accountRepository.findById(accountId).orElseThrow(AccountNotFoundException::new);

        List<BillingAddress> billingAddresses = this.billingAddressRepository.findAllByAccount(account);

        return ResponseEntity.ok().body(billingAddresses);
    }

    protected BillingAddress parseBillingAddressRecordToBillingAddress(BillingAddressRecord billingAddressRecord) {
        BillingAddress billingAddress = new BillingAddress();

        billingAddress.setAccount(billingAddressRecord.account());
        billingAddress.setStreet(billingAddressRecord.street());
        billingAddress.setNumber(billingAddressRecord.number());

        return billingAddress;
    }
}
