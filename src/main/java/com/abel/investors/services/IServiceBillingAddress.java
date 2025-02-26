package com.abel.investors.services;

import com.abel.investors.models.BillingAddress;
import com.abel.investors.records.BillingAddressRecord;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface IServiceBillingAddress {
    public ResponseEntity<BillingAddress> createBillingAddress(BillingAddressRecord billingAddress);
    public ResponseEntity<BillingAddress> updateBillingAddress(BillingAddressRecord billingAddress, UUID id);
    public ResponseEntity<BillingAddress> deleteBillingAddressByID(UUID id);
    public ResponseEntity<BillingAddress> getBillingAddressByID(UUID id);
    public ResponseEntity<List<BillingAddress>> getBillingsAddressesByAccountID(UUID accountId);
}
