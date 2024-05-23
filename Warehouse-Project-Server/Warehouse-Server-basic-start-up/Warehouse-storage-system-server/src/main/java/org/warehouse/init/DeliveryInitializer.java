package org.warehouse.init;

import org.warehouse.persistence.Delivery;
import org.warehouse.persistence.Stock;
import org.warehouse.persistence.StockDelivery;
import org.warehouse.repository.DeliveryRepository;
import org.warehouse.repository.StockDeliveryRepository;
import org.warehouse.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DeliveryInitializer implements CommandLineRunner {
    private final DeliveryRepository deliveryRepository;
    private final StockDeliveryRepository stockDeliveryRepository;
    private final StockRepository stockRepository;
    @Autowired
    public DeliveryInitializer(DeliveryRepository deliveryRepository, StockDeliveryRepository stockDeliveryRepository, StockRepository stockRepository) {
        this.deliveryRepository = deliveryRepository;
        this.stockDeliveryRepository = stockDeliveryRepository;
        this.stockRepository = stockRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Delivery delivery = new Delivery(1l,1l,1l,1l,1l,1l);
        deliveryRepository.save(delivery);
        Stock stock = stockRepository.getReferenceById(1l);
        StockDelivery stockDelivery = new StockDelivery(1l,stock,delivery);
        stockDeliveryRepository.save(stockDelivery);
    }
}
