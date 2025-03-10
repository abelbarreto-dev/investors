package com.abel.investors.repositories;

import com.abel.investors.models.AccountStock;
import com.abel.investors.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StockRepository extends JpaRepository<Stock, UUID> {
    Stock findByAccountStock(AccountStock accountStock);
}
