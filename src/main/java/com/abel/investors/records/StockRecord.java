package com.abel.investors.records;

import com.abel.investors.models.AccountStock;

public record StockRecord(AccountStock accountStock, String description, String ticket) { }
