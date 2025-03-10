package com.abel.investors.records;

import com.abel.investors.models.Account;

public record BillingAddressRecord(Account account, String street, Long number) { }
