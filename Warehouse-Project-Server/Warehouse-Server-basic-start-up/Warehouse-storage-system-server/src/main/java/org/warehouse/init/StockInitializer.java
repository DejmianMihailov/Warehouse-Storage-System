package org.warehouse.init;

import org.warehouse.persistence.Stock;
import org.warehouse.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StockInitializer implements CommandLineRunner {
    private final StockRepository stockRepository; {
}
@Autowired
    public StockInitializer(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public void run(String... args) throws Exception {
    Stock stock = new Stock(1l, "B-58");
    stockRepository.save(stock);

    }
}
