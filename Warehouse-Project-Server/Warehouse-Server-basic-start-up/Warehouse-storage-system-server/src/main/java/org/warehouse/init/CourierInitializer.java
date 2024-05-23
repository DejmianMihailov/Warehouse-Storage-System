package org.warehouse.init;

import org.warehouse.persistence.Courier;
import org.warehouse.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourierInitializer implements CommandLineRunner {
    private final CourierRepository courierRepository;
    @Autowired
    public CourierInitializer(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }




    @Override
    public void run(String... args) throws Exception {
        Courier courier = new Courier(1l, "Ekont");
        courierRepository.save(courier);

    }
}
