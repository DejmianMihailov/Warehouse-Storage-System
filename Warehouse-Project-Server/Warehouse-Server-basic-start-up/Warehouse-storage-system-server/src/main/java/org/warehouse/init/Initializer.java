package org.warehouse.init;

import org.warehouse.persistence.*;
import org.warehouse.repository.*;
import org.warehouse.type.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

@Component
public class Initializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final StockRepository stockRepository;
    private final PaydeskRepository paydeskRepository;
    private final InvoiceRepository invoiceRepository;
    private final AddressRepository addressRepository;
    private final ClientRepository clientRepository;
    private final DeliveryRepository deliveryRepository;
    private final StockDeliveryRepository stockDeliveryRepository;
    private final CourierRepository courierRepository;


    @Autowired
    public Initializer(UserRepository userRepository, PasswordEncoder passwordEncoder, StockRepository stockRepository, PaydeskRepository paydeskRepository, InvoiceRepository invoiceRepository, AddressRepository addressRepository, ClientRepository clientRepository, DeliveryRepository deliveryRepository, StockDeliveryRepository stockDeliveryRepository, CourierRepository courierRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.stockRepository = stockRepository;
        this.paydeskRepository = paydeskRepository;
        this.invoiceRepository = invoiceRepository;
        this.addressRepository = addressRepository;
        this.clientRepository = clientRepository;
        this.deliveryRepository = deliveryRepository;
        this.stockDeliveryRepository = stockDeliveryRepository;
        this.courierRepository = courierRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setEmail("damyanmihailov@mail.com");
        user.setPassword(passwordEncoder.encode("damyan123456789"));
        user.setRole(Role.USER);
        user.setFirstname("Damyan");
        userRepository.save(user);

        User userAdmin = new User();
        userAdmin.setEmail("DamyanAdmin@mail.com");
        userAdmin.setPassword(passwordEncoder.encode("12345678"));
        userAdmin.setRole(Role.ADMIN);
        userAdmin.setFirstname("DamyanAdmin");
        userRepository.save(userAdmin);

        User userSuperAdmin = new User();
        userSuperAdmin.setEmail("DamyanSuperAdmin@mail.com");
        userSuperAdmin.setPassword(passwordEncoder.encode("12345678"));
        userSuperAdmin.setRole(Role.SUPERADMIN);
        userSuperAdmin.setFirstname("DamyanSupperAdmin");
        userRepository.save(userSuperAdmin);

        Stock stock = new Stock(1l, "B-58");
        stockRepository.save(stock);

        Paydesk paydesk = new Paydesk(1l, Timestamp.from(Instant.now()),1l, BigDecimal.valueOf(100000));
        paydeskRepository.save(paydesk);

        Address address = new Address(1l,"Varna","Ul.Struga 8");
        addressRepository.save(address);

        Client client = new Client(2l,"Teodor");
        clientRepository.save(client);

        Delivery delivery = new Delivery(1l,1l,1l,1l,1l,1l);
        deliveryRepository.save(delivery);


        Invoice invoice = new Invoice(1l, BigDecimal.valueOf(3000),address,"Card",client,delivery);
        invoiceRepository.save(invoice);

        deliveryRepository.save(delivery);
        StockDelivery stockDelivery = new StockDelivery(1l,stock,delivery);
        stockDeliveryRepository.save(stockDelivery);

        Courier courier = new Courier(1l, "Ekont");
        courierRepository.save(courier);
        Client client1 = new Client(1l,"Martin");
        clientRepository.save(client1);
        //Address address1 = new Address(1l,"Varna","Ul.Dobrovnik 18");
        addressRepository.save(address);
    }
}
