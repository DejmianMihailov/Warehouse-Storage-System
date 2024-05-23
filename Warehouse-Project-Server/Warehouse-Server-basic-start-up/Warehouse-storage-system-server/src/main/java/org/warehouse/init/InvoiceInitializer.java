package org.warehouse.init;

import org.warehouse.persistence.Address;
import org.warehouse.persistence.Client;
import org.warehouse.persistence.Delivery;
import org.warehouse.persistence.Invoice;
import org.warehouse.repository.AddressRepository;
import org.warehouse.repository.ClientRepository;
import org.warehouse.repository.DeliveryRepository;
import org.warehouse.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class InvoiceInitializer implements CommandLineRunner {
    private final InvoiceRepository invoiceRepository;
    private final AddressRepository addressRepository;
    private final ClientRepository clientRepository;
    private final DeliveryRepository deliveryRepository;
@Autowired
    public InvoiceInitializer(InvoiceRepository invoiceRepository, AddressRepository addressRepository, ClientRepository clientRepository, DeliveryRepository deliveryRepository) {
        this.invoiceRepository = invoiceRepository;
    this.addressRepository = addressRepository;
    this.clientRepository = clientRepository;
    this.deliveryRepository = deliveryRepository;
}

    @Override
    public void run(String... args) throws Exception {
        Address address = new Address(2l,"Varna","Ul.Struga 8");
        addressRepository.save(address);

        Client client = new Client(2l,"Teodor");
        clientRepository.save(client);

        Delivery delivery = new Delivery(1l,1l,1l,1l,1l,1l);
        deliveryRepository.save(delivery);


        Invoice invoice = new Invoice(1l, BigDecimal.valueOf(3000),address,"Card",client,delivery);
    invoiceRepository.save(invoice);

    }
}
