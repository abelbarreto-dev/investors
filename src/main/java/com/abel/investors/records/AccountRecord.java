package com.abel.investors.records;

import com.abel.investors.models.AccountStock;
import com.abel.investors.models.User;

public record AccountRecord(User user, AccountStock accountStock, String description) { }
