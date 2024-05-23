package org.warehouse.init;

import org.warehouse.persistence.Address;
import org.warehouse.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component

public class AddressInitializer implements CommandLineRunner {
    private final AddressRepository addressRepository;
    @Autowired
    public AddressInitializer(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Address address = new Address(1l,"Varna","Ul.Dobrovnik 18");
        addressRepository.save(address);

    }
}
