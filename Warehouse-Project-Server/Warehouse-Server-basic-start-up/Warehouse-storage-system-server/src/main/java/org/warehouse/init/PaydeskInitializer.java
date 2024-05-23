package org.warehouse.init;

import org.warehouse.persistence.Paydesk;
import org.warehouse.repository.PaydeskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

@Component
public class PaydeskInitializer implements CommandLineRunner {
    private final PaydeskRepository paydeskRepository; {
}
@Autowired
    public PaydeskInitializer(PaydeskRepository paydeskRepository) {
    this.paydeskRepository = paydeskRepository;
}

    @Override
    public void run(String... args) throws Exception {
        Paydesk paydesk = new Paydesk(1l, Timestamp.from(Instant.now()),1l, BigDecimal.valueOf(100000));
        paydeskRepository.save(paydesk);

    }
}

