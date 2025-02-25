package com.abel.investors.records;

import java.util.UUID;

public record BillingAddressRecord(UUID account, String street, Long number) { }
