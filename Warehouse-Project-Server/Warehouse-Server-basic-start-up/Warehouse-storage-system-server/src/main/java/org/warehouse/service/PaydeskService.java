package org.warehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.warehouse.repository.PaydeskRepository;
import org.warehouse.persistence.Paydesk;
import java.util.List;

@Service
public class PaydeskService {

    @Autowired
    private PaydeskRepository paydeskRepository;

    public List<Paydesk> getAllPaydesks() {
        return paydeskRepository.findAll();
    }

    public Paydesk getPaydeskById(Long id) {
        return paydeskRepository.findById(id).orElse(null);
    }

    public Paydesk savePaydesk(Paydesk paydesk) {
        return paydeskRepository.save(paydesk);
    }

    public void deletePaydesk(Long id) {
        paydeskRepository.deleteById(id);
    }
}
