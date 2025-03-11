package com.abel.investors.records;

import com.abel.investors.models.Account;
import com.abel.investors.models.Stock;

public record AccountStockRecord(Account account, Stock stock) { }
