package com.abel.investors.controllers;

import com.abel.investors.models.Stock;
import com.abel.investors.records.StockRecord;
import com.abel.investors.services.IServiceStock;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/stock")
@AllArgsConstructor
public class StockController {
    private final IServiceStock serviceStock;

    @PostMapping("/new")
    public ResponseEntity<Stock> createStock(@RequestBody StockRecord stock) {
        return this.serviceStock.createStock(stock);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Stock> updateStock(@RequestBody StockRecord stock, @PathVariable UUID id) {
        return this.serviceStock.updateStock(stock, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Stock> deleteStock(@PathVariable UUID id) {
        return this.serviceStock.deleteStock(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockByID(@PathVariable UUID id) {
        return this.serviceStock.getStockByID(id);
    }

    @GetMapping("/account-stock/{id}")
    public ResponseEntity<Stock> getStockByAccountStockID(@PathVariable UUID id) {
        return this.serviceStock.getStockByAccountStockID(id);
    }
}
