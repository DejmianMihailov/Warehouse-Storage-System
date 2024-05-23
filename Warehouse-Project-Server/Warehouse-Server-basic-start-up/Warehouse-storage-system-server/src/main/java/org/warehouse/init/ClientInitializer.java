package org.warehouse.init;

import org.warehouse.persistence.Client;
import org.warehouse.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClientInitializer implements CommandLineRunner {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientInitializer(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Client client = new Client(1l,"Martin");
        clientRepository.save(client);


    }
}
