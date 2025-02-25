package com.abel.investors.records;

import java.util.UUID;

public record AccountRecord(UUID user, UUID accountStock, String description) { }
