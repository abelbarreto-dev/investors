package com.abel.investors.services;

import com.abel.investors.exceptions.StockNotFoundException;
import com.abel.investors.models.AccountStock;
import com.abel.investors.models.Stock;
import com.abel.investors.records.StockRecord;
import com.abel.investors.repositories.AccountStockRepository;
import com.abel.investors.repositories.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ServiceStock implements IServiceStock {
    private final StockRepository stockRepository;
    private final AccountStockRepository accountStockRepository;

    @Override
    public ResponseEntity<Stock> createStock(StockRecord stock) {
        Stock stockToCreate = this.parseStockRecordToStock(stock);

        Stock newStock = this.stockRepository.save(stockToCreate);

        return ResponseEntity.ok().body(newStock);
    }

    @Override
    public ResponseEntity<Stock> updateStock(StockRecord stock, UUID id) {
        Stock stockToUpdate = this.stockRepository.findById(id).orElseThrow(StockNotFoundException::new);

        stockToUpdate.setAccountStock(stock.accountStock());
        stockToUpdate.setDescription(stock.description());
        stockToUpdate.setTicket(stock.ticket());

        Stock updatedStock = this.stockRepository.save(stockToUpdate);

        return ResponseEntity.ok().body(updatedStock);
    }

    @Override
    public ResponseEntity<Stock> deleteStock(UUID id) {
        Stock stockToDelete = this.stockRepository.findById(id).orElseThrow(StockNotFoundException::new);

        this.stockRepository.delete(stockToDelete);

        return ResponseEntity.ok().body(stockToDelete);
    }

    @Override
    public ResponseEntity<Stock> getStockByID(UUID id) {
        Stock stock = this.stockRepository.findById(id).orElseThrow(StockNotFoundException::new);

        return ResponseEntity.ok().body(stock);
    }

    @Override
    public ResponseEntity<Stock> getStockByAccountStockID(UUID id) {
        AccountStock accountStock = this.accountStockRepository.findById(id).orElse(null);

        if (accountStock == null) {
            throw new StockNotFoundException("Account Stock Not Found");
        }

        Stock stock = this.stockRepository.findByAccountStock(accountStock);

        if (stock == null) {
            throw new StockNotFoundException();
        }

        return ResponseEntity.ok().body(stock);
    }

    protected Stock parseStockRecordToStock(StockRecord stockRecord) {
        Stock stock = new Stock();

        stock.setAccountStock(stockRecord.accountStock());
        stock.setDescription(stockRecord.description());
        stock.setTicket(stockRecord.ticket());

        return stock;
    }
}
