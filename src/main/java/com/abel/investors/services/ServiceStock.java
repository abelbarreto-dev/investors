package com.abel.investors.services;

import com.abel.investors.models.Stock;
import com.abel.investors.records.StockRecord;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ServiceStock implements IServiceStock {
    @Override
    public ResponseEntity<Stock> createStock(StockRecord stock) {
        return null;
    }

    @Override
    public ResponseEntity<Stock> updateStock(StockRecord stock, UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<Stock> deleteStock(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<Stock> getStockByID(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<Stock> getStockByAccountStockID(UUID id) {
        return null;
    }
}
