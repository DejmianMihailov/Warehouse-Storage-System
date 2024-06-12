package org.warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.warehouse.persistence.Client;
import org.warehouse.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAllClient() {
        return clientService.getAllClient();
    }

    @GetMapping("/{id}")
    public Client getCustomerById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public Client createCustomer(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}

