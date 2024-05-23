package org.warehouse.init;

import org.warehouse.repository.StockDeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StockDeliveryInitializer implements CommandLineRunner {
    private final StockDeliveryRepository stockDeliveryRepository;

    {
    }

    @Autowired
    public StockDeliveryInitializer(StockDeliveryRepository stockDeliveryRepository) {
        this.stockDeliveryRepository = stockDeliveryRepository;
    }

    @Override
    public void run(String... args) throws Exception {



    }
}
