package org.warehouse.init;

import org.warehouse.repository.StockHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StockHistoryInitializer implements CommandLineRunner {
    private final StockHistoryRepository stockHistoryRepository;
    @Autowired
    public StockHistoryInitializer(StockHistoryRepository stockHistoryRepository) {
        this.stockHistoryRepository = stockHistoryRepository;
    }



    @Override
    public void run(String... args) throws Exception {

    }
}

