package com.abel.investors.controllers;

import com.abel.investors.models.BillingAddress;
import com.abel.investors.records.BillingAddressRecord;
import com.abel.investors.services.IServiceBillingAddress;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/billing-address")
@AllArgsConstructor
public class BillingAddressController {
    private final IServiceBillingAddress serviceBillingAddress;

    @PostMapping("/new")
    public ResponseEntity<BillingAddress> createBillingAddress(@RequestBody BillingAddressRecord billingAddress) {
        return this.serviceBillingAddress.createBillingAddress(billingAddress);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BillingAddress> updateBillingAddress(
            @RequestBody BillingAddressRecord billingAddress,
            @PathVariable UUID id
    ) {
        return this.serviceBillingAddress.updateBillingAddress(billingAddress, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BillingAddress> deleteBillingAddressByID(@PathVariable UUID id) {
        return this.serviceBillingAddress.deleteBillingAddressByID(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillingAddress> getBillingAddressByID(@PathVariable UUID id) {
        return this.serviceBillingAddress.getBillingAddressByID(id);
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<BillingAddress>> getBillingsAddressesByAccountID(@PathVariable UUID accountId) {
        return this.serviceBillingAddress.getBillingsAddressesByAccountID(accountId);
    }
}
