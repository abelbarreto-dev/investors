package com.abel.investors.services;

import com.abel.investors.models.Stock;
import com.abel.investors.records.StockRecord;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface IServiceStock {
    public ResponseEntity<Stock> createStock(StockRecord stock);
    public ResponseEntity<Stock> updateStock(StockRecord stock, UUID id);
    public ResponseEntity<Stock> deleteStock(UUID id);
    public ResponseEntity<Stock> getStockByID(UUID id);
    public ResponseEntity<Stock> getStockByAccountStockID(UUID id);
}
