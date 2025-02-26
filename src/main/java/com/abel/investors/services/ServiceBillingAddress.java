package com.abel.investors.services;

import com.abel.investors.models.BillingAddress;
import com.abel.investors.records.BillingAddressRecord;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ServiceBillingAddress implements IServiceBillingAddress {
    @Override
    public ResponseEntity<BillingAddress> createBillingAddress(BillingAddressRecord billingAddress) {
        return null;
    }

    @Override
    public ResponseEntity<BillingAddress> updateBillingAddress(BillingAddressRecord billingAddress, UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<BillingAddress> deleteBillingAddressByID(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<BillingAddress> getBillingAddressByID(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<List<BillingAddress>> getBillingsAddressesByAccountID(UUID accountId) {
        return null;
    }
}
